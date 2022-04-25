package com.cidenet.rrhh.service;

import com.cidenet.rrhh.models.Area;
import com.cidenet.rrhh.repository.AreaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AreaService {

    private static Logger log = LoggerFactory.getLogger(AreaService.class.getName());

    @Autowired
    private AreaRepository areaRepository;

    public ArrayList<Area> getAll(){

        ArrayList<Area> lista = new ArrayList<>();
        try{
            lista = (ArrayList<Area>)areaRepository.findAll();
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return lista;

    }
}
