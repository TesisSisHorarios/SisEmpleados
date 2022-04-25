package com.cidenet.rrhh.service;

import com.cidenet.rrhh.models.Pais;
import com.cidenet.rrhh.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public ArrayList<Pais> getAll(){
        return (ArrayList<Pais>) paisRepository.findAll();
    }
}
