package com.cidenet.rrhh.controller;

import com.cidenet.rrhh.models.Respuesta;
import com.cidenet.rrhh.models.TipoIdentificacion;
import com.cidenet.rrhh.service.TipoIdentificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/tipoidentificacion/")
public class TipoIdentificacionController {

    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;

    @GetMapping(value = "/all")
    public ArrayList<TipoIdentificacion> getAll(){
        return tipoIdentificacionService.getAll();
    }
}
