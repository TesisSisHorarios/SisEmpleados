import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Area,Pais, TipoIdentificacion,Respuesta,Empleado } from './empleado';

@Injectable({
    providedIn: 'root'
  })
export class EmpleadoService {

    constructor(
        private http: HttpClient 
        ) {}

    public getPaises() {
        return this.http.get<Pais[]>('http://localhost:8080/pais/all');
    }
    
    public getTipodIdentificacion() {
        return this.http.get<TipoIdentificacion[]>('http://localhost:8080/tipoidentificacion/all');
    }

    public getArea() {
        return this.http.get<Area[]>('http://localhost:8080/area/all');
    }

    public guardarEmpleado(empleado: Empleado){
        return this.http.post<Respuesta>("http://localhost:8080/empleado/save", empleado);
    }

    public modificarEmpleado(empleado: Empleado){
        return this.http.post<Respuesta>("http://localhost:8080/empleado/modificar", empleado);
    }

    public getEmpleados(){
        return this.http.get<Empleado[]>("http://localhost:8080/empleado/all");
    }

    public eliminarEmpleados(empleado: Empleado){
        return this.http.post<Respuesta>("http://localhost:8080/empleado/delete", empleado);
    }
}