package com.cidenet.rrhh.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class PersonaId implements Serializable {

    private static final long serialVersionUID = 4302501501307084037L;
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Integer cpersona;
    @Column(nullable = false)
    private Timestamp fhasta;

    public Integer getCpersona() {
        return cpersona;
    }

    public void setCpersona(Integer cpersona) {
        this.cpersona = cpersona;
    }

    public Timestamp getFhasta() {
        return fhasta;
    }

    public void setFhasta(Timestamp fhasta) {
        this.fhasta = fhasta;
    }
}
