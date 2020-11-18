/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apifuncionario.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Walter
 */
@Entity
@Table(name = "funcionario_departamento")
public class Funcionario_Departamento implements Serializable {
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sequencial_id")
    private int sequencia_id;
    
    @Basic
    @Column(name = "funcionario_id")
    private int funcionario_id;

    @Basic
    @Column(name = "departamento_id")
    private int departamento_id;

    /**
     * @return the sequencia_id
     */
    public int getSequencia_id() {
        return sequencia_id;
    }

    /**
     * @param sequencia_id the sequencia_id to set
     */
    public void setSequencia_id(int sequencia_id) {
        this.sequencia_id = sequencia_id;
    }

    /**
     * @return the funcionario_id
     */
    public int getFuncionario_id() {
        return funcionario_id;
    }

    /**
     * @param funcionario_id the funcionario_id to set
     */
    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    /**
     * @return the departamento_id
     */
    public int getDepartamento_id() {
        return departamento_id;
    }

    /**
     * @param departamento_id the departamento_id to set
     */
    public void setDepartamento_id(int departamento_id) {
        this.departamento_id = departamento_id;
    }
    
}
