package com.cidenet.rrhh.service;

import com.cidenet.rrhh.Utils.CidenetHelper;
import com.cidenet.rrhh.models.Empleado;
import com.cidenet.rrhh.models.PersonaId;
import com.cidenet.rrhh.models.Respuesta;
import com.cidenet.rrhh.repository.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;


@Service
public class EmpleadoService {

    private static Logger log = LoggerFactory.getLogger(EmpleadoService.class.getName());

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Respuesta save(Empleado empleado){
        Respuesta resp = new Respuesta();
        try{
            if (empleado != null) {
                PersonaId pk = new PersonaId();
                pk.setFhasta(CidenetHelper.getFhasta());
                pk.setCpersona(empleadoRepository.getCpersona(CidenetHelper.getFhasta()));
                empleado.setId(pk);
                empleado.setFregistro(Timestamp.valueOf(LocalDateTime.now()));
                empleado.setEstado(true);
                empleado.setFmodificacion(Timestamp.valueOf(LocalDateTime.now()));
                empleado.setPrimerapellido(empleado.getPrimerapellido().toUpperCase());
                empleado.setSegundoapellido(empleado.getSegundoapellido().toUpperCase());
                empleado.setPrimernombre(empleado.getPrimernombre().toUpperCase());
                empleado.setOtronombre(empleado.getOtronombre().toUpperCase());
                empleado.setCorreo(generarCorreo(empleado.getPrimernombre().toLowerCase(),empleado.getPrimerapellido().toLowerCase(),empleado.getPais().getDominio(),false,pk.getCpersona()));

                //empleado.setFingreso(new java.sql.Date(empleado.getFingreso().getTime()));
                Long diifDias = validarFechas(empleado.getFingreso());
                resp.setCorrecto(true);
                if (diifDias>0){
                    resp.setCorrecto(false);
                    resp.setTitulo("Operacion Incorrecta");
                    resp.setMensaje("Fecha de ingreso no puede ser mayor, a la fecha actual");
                }else{
                    diifDias = diifDias*(-1);
                    if (diifDias>30){
                        resp.setCorrecto(false);
                        resp.setTitulo("Operacion Incorrecta");
                        resp.setMensaje("Fecha de ingreso no puede ser menor a mas de un mes a la fecha actual");
                    }
                }
                if (validaIdentificacion(empleado.getTipoIdentificacion().getCtipoidentificacion(), empleado.getIdentificacion(),false,0)>0){
                    resp.setCorrecto(false);
                    resp.setTitulo("Operacion Incorrecta");
                    resp.setMensaje("Empleado ya existe con la misma identificacion");
                }
                if (resp.isCorrecto()){
                    empleadoRepository.save(empleado);
                    resp.setCorrecto(true);
                    resp.setTitulo("Operacion Correcta");
                    resp.setMensaje("Empleado guardado");
                }
            }else{
                resp.setCorrecto(false);
                resp.setTitulo("Operacion Incorrecta");
                resp.setMensaje("Empleado null");
            }
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp.setCorrecto(false);
            resp.setTitulo("Operacion Incorrecta");
            resp.setMensaje("No se pudo guardar al Empleado");
        }

        return resp;
    }

    private String generarCorreo (String nombre, String apellido, String pais, boolean modificar, Integer cpersona){
        Integer numcorreo = 0;
        if (modificar){
            numcorreo = empleadoRepository.countCorreosModificar(nombre.toUpperCase(),apellido.toUpperCase(),cpersona);
        }else{
            numcorreo = empleadoRepository.countCorreos(nombre.toUpperCase(),apellido.toUpperCase());
        }
        String dominio = empleadoRepository.getDominioCorreo("dominio");
        String correo= nombre.concat(".").concat(apellido);
        if (numcorreo>0){
            correo = correo.concat(numcorreo.toString());
        }
        correo = correo.concat(dominio).concat(".").concat(pais);
        return correo;
    }
    private Integer validaIdentificacion(Integer tipoid, String id, boolean modificar,Integer cpersona){
        if (modificar){
            return empleadoRepository.validaIdentificacionModificar(tipoid,id, CidenetHelper.getFhasta(),cpersona);
        }else{
            return empleadoRepository.validaIdentificacion(tipoid,id, CidenetHelper.getFhasta());
        }
    }

    public Long validarFechas(Date fingreso){
        Date hoy = new Date();
        new java.sql.Date(hoy.getTime()).toLocalDate();
        LocalDate dBefore = new java.sql.Date(hoy.getTime()).toLocalDate();
        LocalDate dAfter = new java.sql.Date(fingreso.getTime()).toLocalDate();

        return dBefore.until(dAfter, ChronoUnit.DAYS);
    }

    public ArrayList<Empleado> getAll(){
        return (ArrayList<Empleado>)empleadoRepository.getAllEmpleadosVigentes(CidenetHelper.getFhasta());
    }

    public Respuesta modificar(Empleado empleado){
        Respuesta resp = new Respuesta();
        try{
            if (empleado != null) {
                resp.setCorrecto(true);
                Empleado empleadoUpdate = new Empleado();
                empleadoUpdate.setId(empleado.getId());
                empleadoUpdate.setFingreso(empleado.getFingreso());
                empleadoUpdate.setFregistro(empleado.getFregistro());
                empleadoUpdate.setPrimernombre(empleado.getPrimernombre().toUpperCase());
                empleadoUpdate.setOtronombre(empleado.getOtronombre().toUpperCase());
                empleadoUpdate.setPrimerapellido(empleado.getPrimerapellido().toUpperCase());
                empleadoUpdate.setSegundoapellido(empleado.getSegundoapellido().toUpperCase());
                empleadoUpdate.setEstado(empleado.isEstado());
                empleadoUpdate.setArea(empleado.getArea());
                empleadoUpdate.setPais(empleado.getPais());
                empleadoUpdate.setTipoIdentificacion(empleado.getTipoIdentificacion());
                empleadoUpdate.setIdentificacion(empleado.getIdentificacion());

                empleadoUpdate.setFmodificacion(Timestamp.valueOf(LocalDateTime.now()));

                empleadoUpdate.setCorreo(generarCorreo(empleado.getPrimernombre().toLowerCase(),empleado.getPrimerapellido().toLowerCase(),empleado.getPais().getDominio(),true,empleado.getId().getCpersona()));


                if (validaIdentificacion(empleado.getTipoIdentificacion().getCtipoidentificacion(), empleado.getIdentificacion(),true,empleado.getId().getCpersona())>0){
                    resp.setCorrecto(false);
                    resp.setTitulo("Operacion Incorrecta");
                    resp.setMensaje("Empleado ya existe con la misma identificacion");
                }
                if (resp.isCorrecto()){
                    caducarEmpleado(empleado);
                    empleadoRepository.save(empleadoUpdate);
                    resp.setCorrecto(true);
                    resp.setTitulo("Operacion Correcta");
                    resp.setMensaje("Empleado Modificado");
                }
            }else{
                resp.setCorrecto(false);
                resp.setTitulo("Operacion Incorrecta");
                resp.setMensaje("Empleado null");
            }
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp.setCorrecto(false);
            resp.setTitulo("Operacion Incorrecta");
            resp.setMensaje("No se pudo guardar al Empleado");
        }

        return resp;
    }

    private void caducarEmpleado(Empleado emp){

        PersonaId key = emp.getId();
        Optional<Empleado> caducar = empleadoRepository.findById(key);
        if (caducar.isPresent()){
            Empleado empleado = caducar.get();
            PersonaId id = new PersonaId();
            id.setCpersona(empleado.getId().getCpersona());
            id.setFhasta(Timestamp.valueOf(LocalDateTime.now()));
            Empleado empleadoCaducar = new Empleado();
            empleadoCaducar.setId(id);
            empleadoCaducar.setFingreso(empleado.getFingreso());
            empleadoCaducar.setFregistro(empleado.getFregistro());
            empleadoCaducar.setPrimernombre(empleado.getPrimernombre());
            empleadoCaducar.setOtronombre(empleado.getOtronombre());
            empleadoCaducar.setPrimerapellido(empleado.getPrimerapellido());
            empleadoCaducar.setSegundoapellido(empleado.getSegundoapellido());
            empleadoCaducar.setEstado(empleado.isEstado());
            empleadoCaducar.setArea(empleado.getArea());
            empleadoCaducar.setPais(empleado.getPais());
            empleadoCaducar.setTipoIdentificacion(empleado.getTipoIdentificacion());
            empleadoCaducar.setIdentificacion(empleado.getIdentificacion());
            empleadoCaducar.setFmodificacion(empleado.getFmodificacion());
            empleadoCaducar.setCorreo(empleado.getCorreo());
            empleadoRepository.save(empleadoCaducar);
        }
    }

    public Respuesta delete(Empleado empleado){
        Respuesta resp = new Respuesta();
        try{
            caducarEmpleado(empleado);
            empleadoRepository.delete(empleado);
            resp.setCorrecto(true);
            resp.setTitulo("Operacion Correcta");
            resp.setMensaje("Empleado Eliminado");
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp.setCorrecto(false);
            resp.setTitulo("Operacion Incorrecta");
            resp.setMensaje("Error eliminar al Empleado");
        }
        return resp;
    }
}
