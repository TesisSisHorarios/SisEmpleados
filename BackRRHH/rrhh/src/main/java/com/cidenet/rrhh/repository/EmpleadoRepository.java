package com.cidenet.rrhh.repository;

import com.cidenet.rrhh.models.Empleado;
import com.cidenet.rrhh.models.PersonaId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, PersonaId> {

    @Query("select case when (max(p.id.cpersona) is null) then 1 else (max(p.id.cpersona)+1) end as id from Persona p where p.id.fhasta = ?1 ")
    Integer getCpersona(Timestamp fhasta);

    @Query(value = "select count(distinct p.cpersona) from public.persona p  where p.primernombre = ?1 and p.primerapellido = ?2 ", nativeQuery = true)
    Integer countCorreos (String nombre, String apellido);

    @Query(value = "select count(p) from Persona p  where p.tipoIdentificacion.ctipoidentificacion = ?1 and p.identificacion = ?2 and p.id.fhasta = ?3 ")
    Integer validaIdentificacion (Integer tipoidentificacion, String identificacion, Timestamp fhasta);

    @Query(value = "select valortexto from public.parametrossistema where cparametro = ?1", nativeQuery = true)
    String getDominioCorreo(String parametro);

    @Query(value = "select count(distinct p.cpersona) from public.persona p  where p.primernombre = ?1 and p.primerapellido = ?2 and p.cpersona <> ?3", nativeQuery = true)
    Integer countCorreosModificar (String nombre, String apellido, Integer cpersona);

    @Query(value = "select count(p) from Persona p  where p.tipoIdentificacion.ctipoidentificacion = ?1 and p.identificacion = ?2 and p.id.fhasta = ?3 and p.id.cpersona <> ?4 ")
    Integer validaIdentificacionModificar (Integer tipoidentificacion, String identificacion, Timestamp fhasta, Integer cpersona);

    @Query(value = "select e from Empleado e  where e.id.fhasta = ?1 ")
    ArrayList<Empleado> getAllEmpleadosVigentes (Timestamp fhasta);
}
