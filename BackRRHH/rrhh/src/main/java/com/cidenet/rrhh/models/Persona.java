package com.cidenet.rrhh.models;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @EmbeddedId
    private PersonaId id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "ctipoidentificacion")
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "identificacion", length = 20)
    private String identificacion;

    @Column(name = "primernombre", length = 20)
    private String primernombre;

    @Column(name = "otronombre", length = 50)
    private String otronombre;

    @Column(name = "primerapellido", length = 20)
    private String primerapellido;

    @Column(name = "segundoapellido", length = 20)
    private String segundoapellido;

    public PersonaId getId() {
        return id;
    }

    public void setId(PersonaId id) {
        this.id = id;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getOtronombre() {
        return otronombre;
    }

    public void setOtronombre(String otronombre) {
        this.otronombre = otronombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }
}
