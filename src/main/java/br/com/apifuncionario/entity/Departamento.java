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
@Table(name = "departamento")
public class Departamento implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "departamento_id")
    private int id;

    @Basic
    @Column(name = "departamento_name")
    private String name;
    
     @Basic
    @Column(name = "departamento_leader")
    private int leader;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param xname the name to set
     */
    public void setName(String xname) {
        if (xname == null) {
            xname = "";
        }
        this.name = xname;
    }

    /**
     * @return the leader
     */
    public int getLeader() {
        return leader;
    }

    /**
     * @param leader the leader to set
     */
    public void setLeader(int leader) {
        this.leader = leader;
    }

}
