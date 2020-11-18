/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apifuncionario.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "funcionario_id")
    private int id;

    @Basic
    @Column(name = "funcionario_name")
    private String name;

    @Basic
    @Column(name = "funcionario_age")
    private int age;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "funcionario_birthday")
    private Date birthday;

    @Basic
    @Column(name = "funcionario_document")
    private String document;

    @Basic
    @Column(name = "cargo_id")
    private int cargo_id;

    @Basic
    @Column(name = "departamento_id")
    private int departamento_id;

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
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the cargo_id
     */
    public int getCargo_id() {
        return cargo_id;
    }

    /**
     * @param cargo_id the cargo_id to set
     */
    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    /**
     * @return the document
     */
    public String getDocument() {
        return document;
    }

    /**
     * @param xdocument the document to set
     */
    public void setDocument(String xdocument) {
        if (xdocument == null) {
            xdocument = "";
        }
        this.document = xdocument;
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
