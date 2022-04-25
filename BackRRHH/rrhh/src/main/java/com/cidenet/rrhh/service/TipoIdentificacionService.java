package com.cidenet.rrhh.service;

import com.cidenet.rrhh.models.Respuesta;
import com.cidenet.rrhh.models.TipoIdentificacion;
import com.cidenet.rrhh.repository.TipoIdentificacionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoIdentificacionService {

    private static Logger log = LoggerFactory.getLogger(TipoIdentificacionService.class.getName());

    @Autowired
    private TipoIdentificacionRepository tipoIdentificacionRepository;

    public ArrayList<TipoIdentificacion> getAll(){
        ArrayList<TipoIdentificacion> lista = new ArrayList<>();
        try{
            lista = (ArrayList<TipoIdentificacion>)tipoIdentificacionRepository.findAll();
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return lista;
    }
}
