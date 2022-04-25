-- Database: dbrrhh

-- DROP DATABASE dbrrhh;

CREATE DATABASE dbrrhh
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'es_EC.UTF-8'
    LC_CTYPE = 'es_EC.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;





-- Table: public.area

-- DROP TABLE public.area;

CREATE TABLE public.area
(
    carea integer NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT area_pkey PRIMARY KEY (carea)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.area
    OWNER to root;




-- Table: public.pais

-- DROP TABLE public.pais;

CREATE TABLE public.pais
(
    cpais integer NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default",
    dominio character varying(3) COLLATE pg_catalog."default",
    CONSTRAINT pais_pkey PRIMARY KEY (cpais)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pais
    OWNER to root;




-- Table: public.tipoidentificacion

-- DROP TABLE public.tipoidentificacion;

CREATE TABLE public.tipoidentificacion
(
    ctipoidentificacion integer NOT NULL,
    descripcion character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT tipoidentificacion_pkey PRIMARY KEY (ctipoidentificacion)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tipoidentificacion
    OWNER to root;





-- Table: public.persona

-- DROP TABLE public.persona;

CREATE TABLE public.persona
(
    cpersona integer NOT NULL,
    fhasta timestamp without time zone NOT NULL,
    otronombre character varying(50) COLLATE pg_catalog."default",
    primerapellido character varying(20) COLLATE pg_catalog."default",
    primernombre character varying(20) COLLATE pg_catalog."default",
    segundoapellido character varying(20) COLLATE pg_catalog."default",
    ctipoidentificacion integer NOT NULL,
    identificacion character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT persona_pkey PRIMARY KEY (cpersona, fhasta),
    CONSTRAINT fkchl2jo2t3132wxxs79p2k9ss FOREIGN KEY (ctipoidentificacion)
        REFERENCES public.tipoidentificacion (ctipoidentificacion) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.persona
    OWNER to root;




-- Table: public.empleado

-- DROP TABLE public.empleado;

CREATE TABLE public.empleado
(
    correo character varying(300) COLLATE pg_catalog."default",
    estado boolean,
    fingreso date,
    fmodificacion timestamp without time zone,
    fregistro timestamp without time zone,
    cpersona integer NOT NULL,
    fhasta timestamp without time zone NOT NULL,
    carea integer NOT NULL,
    cpais integer NOT NULL,
    CONSTRAINT empleado_pkey PRIMARY KEY (cpersona, fhasta),
    CONSTRAINT fkdn058jl5tr2o9p3hu2mjiydj2 FOREIGN KEY (cpais)
        REFERENCES public.pais (cpais) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkdqxenkww52ux0xr3tnyvo3ig8 FOREIGN KEY (carea)
        REFERENCES public.area (carea) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkqba0qodvx3xv3349tqmlfx5pk FOREIGN KEY (cpersona, fhasta)
        REFERENCES public.persona (cpersona, fhasta) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.empleado
    OWNER to root;




-- Table: public.parametrossistema

-- DROP TABLE public.parametrossistema;

CREATE TABLE public.parametrossistema
(
    cparametro character varying(50) COLLATE pg_catalog."default" NOT NULL,
    valortexto character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT parametrossistema_pkey PRIMARY KEY (cparametro)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.parametrossistema
    OWNER to root;