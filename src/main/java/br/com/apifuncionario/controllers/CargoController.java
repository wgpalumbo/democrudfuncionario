/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apifuncionario.controllers;

import br.com.apifuncionario.entity.Cargo;
import br.com.apifuncionario.repository.ICargo;
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
@RequestMapping("/v1/cargo")
@CrossOrigin(origins = "*")
public class CargoController {

    @Autowired
    private ICargo _cargo;

    @GetMapping(path = "/listar", produces = "application/json")
    @ApiOperation(value = "Listagem de Cargos")
    @Async
    public List<Cargo> listarCargos() {
        return _cargo.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ApiOperation(value = "Obter Um Cargo")
    @Async
    public ResponseEntity obterCargo(@PathVariable int id) {
        String mensagem = "";
        try {
            mensagem = _cargo.findById(id).toString();
        } catch (Exception e) {
            mensagem = "Cargo nao Localizado !";
        }
        return ResponseEntity.ok(mensagem);

    }

    @PostMapping(path = "/", consumes = "application/json")
    @ApiOperation(value = "Adicionar Um Cargo")
    @Async
    public ResponseEntity adicionarCargo(@RequestBody Cargo cargo) {
        String mensagem = "";
        try {
            _cargo.save(cargo);
            mensagem = "Cargo " + cargo.getName() + "  Adicionado Corretamente.";
        } catch (Exception e) {
            mensagem = "Erro ao Adicionar Cargo ";
        }
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Excluir Um Cargo")
    @Async
    public ResponseEntity removerCargo(@PathVariable int id) {
        String mensagem = "";
        try {
            _cargo.deleteById(id);
            mensagem = "Cargo " + String.valueOf(id) + " Excluido Corretamente !";
        } catch (Exception e) {
            mensagem = "Erro ao Remover Cargo " + String.valueOf(id);
        }
        return ResponseEntity.ok(mensagem);
    }

    @PutMapping(path = "/", consumes = "application/json")
    @ApiOperation(value = "Atualizar Dados de Um Cargo")
    @Async
    public ResponseEntity alterarCargo(@RequestBody Cargo cargo) {
        String mensagem = "";
        try {

            if (_cargo.findById(cargo.getId()) != null) {
                _cargo.save(cargo);
                mensagem = "Cargo Alterado Corretamente ";
            } else {
                mensagem = "Cargo Nao Localizado !";
            }

        } catch (Exception e) {
            mensagem = "Erro ao Alterar Cargo ";
        }
        return ResponseEntity.ok(mensagem);
    }
}
