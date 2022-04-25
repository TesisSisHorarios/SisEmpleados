package com.cidenet.rrhh.controller;

import com.cidenet.rrhh.models.Area;
import com.cidenet.rrhh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/area/")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/all")
    public ArrayList<Area> getAll(){
        return areaService.getAll();
    }
}
