/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apifuncionario.repository;

import br.com.apifuncionario.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Walter
 */
public interface IDepartamento extends JpaRepository<Departamento, Integer> {

    Departamento findById(int id);

}
