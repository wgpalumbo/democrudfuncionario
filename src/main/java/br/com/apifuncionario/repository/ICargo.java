/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apifuncionario.repository;

import br.com.apifuncionario.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Walter
 */
public interface ICargo extends JpaRepository<Cargo, Integer> {

    Cargo findById(int id);

}