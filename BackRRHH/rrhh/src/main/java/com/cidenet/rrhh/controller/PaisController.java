package com.cidenet.rrhh.controller;

import com.cidenet.rrhh.models.Pais;
import com.cidenet.rrhh.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/pais/")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping(value = "/all")
    public ArrayList<Pais> getAll(){
        return paisService.getAll();
    }
}
