/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apifuncionario.controllers;

import br.com.apifuncionario.entity.Funcionario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Walter
 */
@RestController
@RequestMapping("/v1/lista")
@Api(value = "API CRUD-Rest Listagem")
@CrossOrigin(origins = "*")
public class ListaController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(path = "/departamento/{id}", produces = "application/json")
    @ApiOperation(value = "Listar Funcionarios do Departamento")
    public List<Funcionario> obterPorDepartamento(@PathVariable int id) {

        return jdbcTemplate.query("SELECT * FROM FUNCIONARIO WHERE DEPARTAMENTO_ID = " + String.valueOf(id), (resultSet, i) -> {
            return toFuncionario(resultSet);
        });

    }

    private Funcionario toFuncionario(ResultSet rs) throws SQLException {
        Funcionario person = new Funcionario();
        person.setId(rs.getInt("funcionario_id"));
        person.setName(rs.getString("funcionario_name"));
        person.setAge(rs.getInt("funcionario_age"));
        person.setBirthday(rs.getDate("funcionario_birthday"));
        person.setCargo_id(rs.getInt("cargo_id"));
        person.setDocument(rs.getString("funcionario_document"));
        person.setDepartamento_id(rs.getInt("departamento_id"));
        return person;
    }

}
