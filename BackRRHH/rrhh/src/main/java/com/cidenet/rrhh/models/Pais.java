package com.cidenet.rrhh.models;

import javax.persistence.*;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "cpais")
    private Integer cpais;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "dominio", length = 3)
    private String dominio;

    public Integer getCpais() {
        return cpais;
    }

    public void setCpais(Integer cpais) {
        this.cpais = cpais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }
}
