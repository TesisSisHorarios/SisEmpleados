export interface Area{
    carea?:number;
    nombre?:string;
}

export interface Pais{
    cpais?:number;
    nombre?:string;
    dominio?:string;
}

export interface TipoIdentificacion{
    ctipoidentificacion?:number;
    descripcion?:string;
}

export interface Id{
    cpersona?:number;
    fhasta?:Date;
}

export interface Empleado{
    id?: Id;
    tipoIdentificacion?:TipoIdentificacion;
    identificacion?:string;
    primernombre?:string;
    otronombre?:string;
    primerapellido?:string;
    segundoapellido?:string;
    correo?: string;
    fingreso?:Date;
    area?:Area;
    pais?:Pais;
    estado?:boolean;
    fregistro?:Date;
    fmodificacion?:Date;
}

export interface Respuesta{
    titulo?:string;
    correcto?:boolean;
    mensaje?:string;
    object?:TipoIdentificacion|Pais;
    listObject?:any[];
}