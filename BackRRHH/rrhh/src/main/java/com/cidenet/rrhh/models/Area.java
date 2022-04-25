package com.cidenet.rrhh.models;

import javax.persistence.*;

@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "carea")
    private Integer carea;

    @Column(name = "nombre", length = 100)
    private String nombre;

    public Integer getCarea() {
        return carea;
    }

    public void setCarea(Integer carea) {
        this.carea = carea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
