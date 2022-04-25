import { Component, OnInit } from '@angular/core';
import {Empleado,Pais,TipoIdentificacion, Area, Respuesta} from './empleado';
import {EmpleadoService} from './empleadoservice';
import {MessageService} from 'primeng/api';
import {ConfirmationService} from 'primeng/api';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styles: [`
        :host ::ng-deep .p-dialog .product-image {
            width: 150px;
            margin: 0 auto 2rem auto;
            display: block;
        }
    `],
  styleUrls: ['./empleado.component.css']
})

export class EmpleadoComponent  implements OnInit{
  
  empleados: Empleado[] = [];
  empleado: Empleado = {};
  empleadoSeleccionado: Empleado = {};
  empleadoDialogo: boolean = false;
  empleadoDialogoEditar: boolean = false;
  paises: Pais[] = [];
  paisSeleccionado: Pais = {};
  tiposId: TipoIdentificacion[] = [];
  tipoIdSeleccionado: TipoIdentificacion = {};
  areas: Area[] = [];
  areaSeleccionada: Area = {};
  respuesta:Respuesta = {};
  submit: boolean = false;
  today: Date = new Date();
  fecha: Date = new Date();
  
  
  constructor(
    private empleadoService: EmpleadoService, private messageService: MessageService, private confirmationService: ConfirmationService
  ) {
  }

  ngOnInit() {
    this.empleadoService.getPaises().subscribe(response =>{this.paises=response;},);
    this.empleadoService.getTipodIdentificacion().subscribe(response =>{this.tiposId=response;},);
    this.empleadoService.getArea().subscribe(response =>{this.areas=response;},);
    this.empleadoService.getEmpleados().subscribe(response =>{this.empleados=response;},);
  }

  cargarEmpleados(){
    this.empleadoService.getEmpleados().subscribe(response =>{this.empleados=response;},);
  }

  getTipoIdentifiacion(respuesta: Respuesta){

  }

  nuevoEmpleado() {
    this.empleado = {};
    this.empleadoDialogo = true;
    
  }

  hideDialogo(){
    this.empleadoDialogo = false;
    this.empleadoDialogoEditar = false;
    this.submit = false;
  }

  async guardarEmpleado(){    
    this.submit = true;
    
  
    if(this.empleado && this.empleado.primernombre && this.empleado.primerapellido &&
    this.empleado.fingreso && this.empleado.area && this.empleado.pais && this.empleado.tipoIdentificacion){
      await this.servicioGuardar (); 
    }
  }

  async servicioGuardar(){
    this.empleadoService.guardarEmpleado(this.empleado).subscribe(response =>{
      this.respuesta= response;
      
      if (this.respuesta.correcto){
        this.empleadoDialogo = false;
        this.submit = false;
        this.messageService.add({severity:'success', summary: this.respuesta.titulo, detail: this.respuesta.mensaje, life: 3000});
        this.cargarEmpleados();
      }else{
        this.messageService.add({severity:'error', summary: this.respuesta.titulo, detail: this.respuesta.mensaje});
      }
    },);
  }

  editarEmpleado(empleadoSelec: Empleado){
    
    this.empleado = empleadoSelec;
    this.empleadoDialogoEditar = true;
  }

  guardarEditarEmpleado(){    
    this.submit = true;
    
  
    if(this.empleado && this.empleado.primernombre && this.empleado.primerapellido &&
    this.empleado.fingreso && this.empleado.area && this.empleado.pais && this.empleado.tipoIdentificacion){
      
      this.empleadoService.modificarEmpleado(this.empleado).subscribe(response =>{
        this.respuesta= response;
        
        if (this.respuesta.correcto){
          this.empleadoDialogoEditar = false;
          this.submit = false;
          this.messageService.add({severity:'success', summary: this.respuesta.titulo, detail: this.respuesta.mensaje, life: 3000});
          this.cargarEmpleados();
        }else{
          this.messageService.add({severity:'error', summary: this.respuesta.titulo, detail: this.respuesta.mensaje});
        }
      },);
    }
  }

  eliminarEmpleado(empleadoSelec: Empleado){
    console.log("Eliminar");
    this.confirmationService.confirm({
      message: 'Está seguro de que desea eliminar el empleado?',
      header: 'Confirmación',
      icon: 'pi pi-exclamation-triangle',

      accept: () => {
        this.empleadoService.eliminarEmpleados(empleadoSelec).subscribe(response =>{
          this.respuesta= response;
          
          if (this.respuesta.correcto){
            this.empleadoDialogoEditar = false;
            this.submit = false;
            this.messageService.add({severity:'success', summary: this.respuesta.titulo, detail: this.respuesta.mensaje, life: 3000});
            this.cargarEmpleados();
          }else{
            this.messageService.add({severity:'error', summary: this.respuesta.titulo, detail: this.respuesta.mensaje});
          }
        },);
      }
  });
  }
}
