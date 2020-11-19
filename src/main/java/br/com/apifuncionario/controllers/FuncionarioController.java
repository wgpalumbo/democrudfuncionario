/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apifuncionario.controllers;

import br.com.apifuncionario.entity.Funcionario;
import br.com.apifuncionario.entity.Funcionario_Departamento;
import br.com.apifuncionario.repository.ICargo;
import br.com.apifuncionario.repository.IDepartamento;
import br.com.apifuncionario.repository.IFuncionario;
import br.com.apifuncionario.repository.IFuncionario_Departamento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Walter
 */
@RestController
@RequestMapping("/v1/funcionario")
@Api(value = "API CRUD-Rest Funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    @Autowired
    private IFuncionario _funcionario;
    @Autowired
    private IDepartamento _departamento;
    @Autowired
    private ICargo _cargo;
    @Autowired
    private IFuncionario_Departamento _funcionario_departamento;

   
    @GetMapping(path = "/listar", produces = "application/json")
    @ApiOperation(value = "Listagem de Funcionarios")
    public List<Funcionario> listarFuncionarios() {
        return _funcionario.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ApiOperation(value = "Obter Um Funcionario")
    public ResponseEntity obterFuncionario(@PathVariable int id) {
        String mensagem = "";
        try {
            mensagem = _funcionario.findById(id).toString();
        } catch (Exception e) {
            mensagem = "Funcionario nao Localizado !";
        }
        return ResponseEntity.ok(mensagem);

    }

    @PostMapping(path = "/", consumes = "application/json")
    @ApiOperation(value = "Adicionar Um Funcionario")
    public ResponseEntity adicionarFuncionario(@RequestBody Funcionario funcionario) {
        String mensagem = "", mensagem1 = "";
        try {
            //----
            boolean podeAdd = true;
            if (_departamento.findById(funcionario.getDepartamento_id()) == null) {
                podeAdd = false;
                mensagem1 = "Departamento Nao Localizado !";
            }
            if (_cargo.findById(funcionario.getCargo_id()) == null) {
                podeAdd = false;
                mensagem1 = "Cargo Nao Localizado !";
            }
            //----
            if (podeAdd) {
                funcionario.setId(0);
                _funcionario.save(funcionario);
                //------
                //Adicionando tabela historico departamento
                Funcionario_Departamento funcionariodepartamento = new Funcionario_Departamento();
                funcionariodepartamento.setDepartamento_id(funcionario.getDepartamento_id());
                funcionariodepartamento.setFuncionario_id(funcionario.getId());
                _funcionario_departamento.save(funcionariodepartamento);
                funcionariodepartamento = null;
                //------
                mensagem = "Funcionario " + funcionario.getName() + "  Adicionado Corretamente.";
            } else {
                mensagem = "Funcionario " + funcionario.getName() + " Nao Foi Incluido Por Erro(s) no(s) Dado(s)!";
            }
        } catch (Exception e) {
            mensagem = "Erro ao Adicionar Funcionario ";
            //mensagem = e.getMessage();
        }
        return ResponseEntity.ok(mensagem + " " + mensagem1);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Excluir Um Funcionario")
    public ResponseEntity removerFuncionario(@PathVariable int id) {
        String mensagem = "";
        try {
            _funcionario.deleteById(id);
            mensagem = "Funcionario " + String.valueOf(id) + " Excluido Corretamente !";
        } catch (Exception e) {
            mensagem = "Erro ao Remover Funcionario " + String.valueOf(id);
            //mensagem = e.getMessage();
        }
        return ResponseEntity.ok(mensagem);
    }

    @PutMapping(path = "/", consumes = "application/json")
    @ApiOperation(value = "Atualizar Dados de Um Funcionario")
    public ResponseEntity alterarFuncionario(@RequestBody Funcionario funcionario) {
        String mensagem = "", mensagem1 = "";
        try {

            if (_funcionario.findById(funcionario.getId()) != null) {
                boolean podeAdd = true;
                if (_departamento.findById(funcionario.getDepartamento_id()) == null) {
                    podeAdd = false;
                    mensagem1 = "Departamento Nao Localizado !";
                }
                if (_cargo.findById(funcionario.getCargo_id()) == null) {
                    podeAdd = false;
                    mensagem1 = "Cargo Nao Localizado !";
                }
                //----
                if (podeAdd) {
                    //------
                    //tabela historico departamento
                    Funcionario funcionariotemp = _funcionario.findById(funcionario.getId());
                    if (funcionariotemp.getDepartamento_id() != funcionario.getDepartamento_id()) {
                        Funcionario_Departamento funcionariodepartamento = new Funcionario_Departamento();
                        funcionariodepartamento.setDepartamento_id(funcionario.getDepartamento_id());
                        funcionariodepartamento.setFuncionario_id(funcionario.getId());
                        _funcionario_departamento.save(funcionariodepartamento);
                        funcionariodepartamento = null;
                    }
                    funcionariotemp = null;
                    //------
                    _funcionario.save(funcionario);
                    mensagem = "Funcionario " + funcionario.getName() + " Alterado Corretamente ";
                } else {
                    mensagem = "Funcionario " + funcionario.getName() + " Nao Foi Alterado Por Erro(s) no(s) Dado(s)!";
                }
            } else {
                mensagem = "Funcionario Nao Localizado !";
            }

        } catch (Exception e) {
            mensagem = "Erro ao Alterar Funcionario ";
            //mensagem = e.getMessage();
        }
        return ResponseEntity.ok(mensagem + " " + mensagem1);
    }

}
