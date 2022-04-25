package com.cidenet.rrhh.repository;

import com.cidenet.rrhh.models.TipoIdentificacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoIdentificacionRepository extends CrudRepository<TipoIdentificacion, Integer> {
}
