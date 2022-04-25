package com.cidenet.rrhh.models;

import javax.persistence.*;

@Entity
@Table(name = "tipoidentificacion")
public class TipoIdentificacion {

    @Id
    @Column(name = "ctipoidentificacion")
    private Integer ctipoidentificacion;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    public Integer getCtipoidentificacion() {
        return ctipoidentificacion;
    }

    public void setCtipoidentificacion(Integer ctipoidentificacion) {
        this.ctipoidentificacion = ctipoidentificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
