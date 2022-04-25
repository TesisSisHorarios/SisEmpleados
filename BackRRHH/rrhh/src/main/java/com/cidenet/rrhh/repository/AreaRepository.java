package com.cidenet.rrhh.repository;

import com.cidenet.rrhh.models.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {
}
