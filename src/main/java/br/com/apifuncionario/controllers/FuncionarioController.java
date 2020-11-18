/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apifuncionario.controllers;

import br.com.apifuncionario.entity.Funcionario;
import br.com.apifuncionario.repository.IFuncionario;
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
        String mensagem = "";
        try {
            _funcionario.save(funcionario);
            mensagem = "Funcionario " + funcionario.getName() + "  Adicionado Corretamente.";
        } catch (Exception e) {
            mensagem = "Erro ao Adicionar Funcionario ";
        }
        return ResponseEntity.ok(mensagem);
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
        }
        return ResponseEntity.ok(mensagem);
    }

    @PutMapping(path = "/", consumes = "application/json")
    @ApiOperation(value = "Atualizar Dados de Um Funcionario")
    public ResponseEntity alterarFuncionario(@RequestBody Funcionario funcionario) {
        String mensagem = "";
        try {

            if (_funcionario.findById(funcionario.getId()) != null) {
                _funcionario.save(funcionario);
                mensagem = "Funcionario Alterado Corretamente ";
            } else {
                mensagem = "Funcionario Nao Localizado !";
            }

        } catch (Exception e) {
            mensagem = "Erro ao Alterar Funcionario ";
        }
        return ResponseEntity.ok(mensagem);
    }
    
   
}
