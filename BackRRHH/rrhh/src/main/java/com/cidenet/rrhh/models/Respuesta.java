package com.cidenet.rrhh.models;

import java.util.ArrayList;

public class Respuesta<E> {

    private String titulo;
    private boolean correcto;
    private String mensaje;
    private E object;
    private ArrayList<E> listObject;

    public Respuesta() {
        super();
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }

    public ArrayList<E> getListObject() {
        return listObject;
    }

    public void setListObject(ArrayList<E> listObject) {
        this.listObject = listObject;
    }
}

