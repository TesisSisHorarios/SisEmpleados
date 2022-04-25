package com.cidenet.rrhh.repository;

import com.cidenet.rrhh.models.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer> {
}
