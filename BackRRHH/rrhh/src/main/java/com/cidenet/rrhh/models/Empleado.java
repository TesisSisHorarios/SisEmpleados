package com.cidenet.rrhh.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "empleado")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "cpersona", referencedColumnName = "cpersona"),
        @PrimaryKeyJoinColumn(name = "fhasta", referencedColumnName = "fhasta")
})
public class Empleado extends Persona {

    @Column(name = "correo", length = 300)
    private String correo;

    @Column(name = "fingreso")
    private Date fingreso;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "carea")
    private Area area;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "cpais")
    private Pais pais;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "fregistro")
    private Timestamp fregistro;

    @Column(name = "fmodificacion")
    private Timestamp fmodificacion;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFingreso() {
        return fingreso;
    }

    public void setFingreso(Date fingreso) {
        this.fingreso = fingreso;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Timestamp getFregistro() {
        return fregistro;
    }

    public void setFregistro(Timestamp fregistro) {
        this.fregistro = fregistro;
    }

    public Timestamp getFmodificacion() {
        return fmodificacion;
    }

    public void setFmodificacion(Timestamp fmodificacion) {
        this.fmodificacion = fmodificacion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
