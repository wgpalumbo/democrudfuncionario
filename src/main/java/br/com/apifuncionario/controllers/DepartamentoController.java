/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apifuncionario.controllers;

import br.com.apifuncionario.entity.Departamento;
import br.com.apifuncionario.repository.IDepartamento;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
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
@RequestMapping("/v1/departamento")
@CrossOrigin(origins = "*")
public class DepartamentoController {
     @Autowired
    private IDepartamento _departamento;

    @GetMapping(path = "/listar", produces = "application/json")
    @ApiOperation(value = "Listagem de Departamentos")
    @Async
    public List<Departamento> listarDepartamentos() {
        return _departamento.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ApiOperation(value = "Obter Um Departamento")
    @Async
    public ResponseEntity obterDepartamento(@PathVariable int id) {
        String mensagem = "";
        try {
            mensagem = _departamento.findById(id).toString();
        } catch (Exception e) {
            mensagem = "Departamento nao Localizado !";
        }
        return ResponseEntity.ok(mensagem);

    }

    @PostMapping(path = "/", consumes = "application/json")
    @ApiOperation(value = "Adicionar Um Departamento")
    @Async
    public ResponseEntity adicionarDepartamento(@RequestBody Departamento funcionario) {
        String mensagem = "";
        try {
            _departamento.save(funcionario);
            mensagem = "Departamento " + funcionario.getName() + "  Adicionado Corretamente.";
        } catch (Exception e) {
            mensagem = "Erro ao Adicionar Departamento ";
        }
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Excluir Um Departamento")
    @Async
    public ResponseEntity removerDepartamento(@PathVariable int id) {
        String mensagem = "";
        try {
            _departamento.deleteById(id);
            mensagem = "Departamento " + String.valueOf(id) + " Excluido Corretamente !";
        } catch (Exception e) {
            mensagem = "Erro ao Remover Departamento " + String.valueOf(id);
        }
        return ResponseEntity.ok(mensagem);
    }

    @PutMapping(path = "/", consumes = "application/json")
    @ApiOperation(value = "Atualizar Dados de Um Departamento")
    @Async
    public ResponseEntity alterarDepartamento(@RequestBody Departamento funcionario) {
        String mensagem = "";
        try {

            if (_departamento.findById(funcionario.getId()) != null) {
                _departamento.save(funcionario);
                mensagem = "Departamento Alterado Corretamente ";
            } else {
                mensagem = "Departamento Nao Localizado !";
            }

        } catch (Exception e) {
            mensagem = "Erro ao Alterar Departamento ";
        }
        return ResponseEntity.ok(mensagem);
    }
}