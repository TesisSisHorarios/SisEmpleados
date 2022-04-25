package com.cidenet.rrhh.controller;

import com.cidenet.rrhh.models.Empleado;
import com.cidenet.rrhh.models.Respuesta;
import com.cidenet.rrhh.models.TipoIdentificacion;
import com.cidenet.rrhh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/empleado/")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping(value = "/save")
    public Respuesta save(@RequestBody Empleado empleado){ return empleadoService.save(empleado);}

    @GetMapping(value = "/all")
    public ArrayList<Empleado> getAll(){
        return empleadoService.getAll();
    }

    @PostMapping(value = "/modificar")
    public Respuesta modificar(@RequestBody Empleado empleado){ return empleadoService.modificar(empleado);}

    @PostMapping(value = "/delete")
    public Respuesta delete(@RequestBody Empleado empleado){ return empleadoService.delete(empleado);}
}
