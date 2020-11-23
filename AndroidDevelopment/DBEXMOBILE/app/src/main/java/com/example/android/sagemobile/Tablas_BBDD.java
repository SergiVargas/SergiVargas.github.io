package com.example.android.sagemobile;

import android.provider.BaseColumns;

public final class Tablas_BBDD {


    // Creación de la estructura de las tablas de la base de datos


    private Tablas_BBDD(){}





    //Creamos una clase abstracta por cada tabla de la base de datos

    public abstract class TOperarios implements BaseColumns {

        //Nombre de la tabla

        public static final String nombreTabla1 = "Operarios";

        //Columnas tabla Operarios


        public static final String idOperario = "ID";
        public static final String numeroOperario = "NUMEROOPERARIO";
        public static final String nombreOperario = "NOMBRE";
        public static final String dieta = "DIETA";
    }





    public abstract class TProyectos implements BaseColumns {


        //Nombre de las tabla

        public static final String nombreTabla2 = "Proyectos";

        //Columnas tabla Proyectos


        public static final String idProyecto = "ID";
        public static final String numeroProyecto = "NUMEROPROYECTO";
        public static final String idDelOperario = "IDDELOPERARIO";
        public static final String provinciaProyecto = "PROVINCIA";
        public static final String municipioProyecto = "MUNICIPIO";





    }




    public abstract class TAlmacenes implements BaseColumns{



        //Nombre de la tabla

        public static final String nombreTabla3 = "Almacenes";


        //Columnas tabla Almacenes

        public static final String idAlmacen = "IDALMACEN";
        public static final String almacenCompra = "ALMACENCOM";
        public static final String municipioAlmacen = "MUNICIPIO";
        public static final String importeCompra = "IMPORTE";
        public static final String fechaCompra = "FECHA";}





    public abstract class TMateriales implements BaseColumns{


        //Nombre de la tabla

        public static final String nombreTabla4 = "Materiales";


        //Columnas tabla Materiales

        public static final String idNumeroPedido = "IDNUPEDIDO";
        public static final String idDelProyecto = "IDDELPROYECTO";
        public static final String tipoMaterial = "TIMATERIAL";
        public static final String almacenco = "ALMACENCO";


    }








     //SENTENCIAS DE LA CREACIÓN DE LAS TABLAS


    //TABLA OPERARIOS

    public static final String crearOperarios = "CREATE TABLE " + TOperarios.nombreTabla1 +
            "(" + TOperarios.idOperario +  " INTEGER PRIMARY KEY, " + TOperarios.numeroOperario +
        " INTEGER, " + TOperarios.nombreOperario + " TEXT, " + TOperarios.dieta + " INTEGER);";





    //TABLA PROYECTOS

    public static final String crearProyectos = "CREATE TABLE " + TProyectos.nombreTabla2 + "(" +
              TProyectos.idProyecto + " INTEGER PRIMARY KEY, " + TProyectos.numeroProyecto +
            " INTEGER, " + TProyectos.idDelOperario + " INTEGER, " + TProyectos.provinciaProyecto
            +  " TEXT, " + TProyectos.municipioProyecto + " TEXT, FOREIGN KEY("
            + TProyectos.idDelOperario + ") REFERENCES " + TOperarios.nombreTabla1+ "(" + TOperarios.idOperario +"));";



    //TABLA ALMACENES

    public static final String crearAlmacenes = "CREATE TABLE " + TAlmacenes.nombreTabla3 + "("+
            TAlmacenes.idAlmacen + " INTEGER PRIMARY KEY, " + TAlmacenes.almacenCompra + " TEXT, "
            + TAlmacenes.municipioAlmacen + " TEXT, " +  TAlmacenes.importeCompra + " REAL, " +
            TAlmacenes.fechaCompra + " TEXT);";



    //TABLA MATERIALES

    public static final String crearMateriales = "CREATE TABLE " +  TMateriales.nombreTabla4 + "(" +
            TMateriales.idNumeroPedido   + " INTEGER PRIMARY KEY, " + TMateriales.idDelProyecto  +
            " INTEGER, " + TMateriales.tipoMaterial +  " TEXT, " + TMateriales.almacenco +
            " TEXT, FOREIGN KEY(" + TMateriales.idDelProyecto  + ") REFERENCES " + TProyectos.nombreTabla2 +
            "(" + TProyectos.idProyecto + "));";







    //SENTENCIAS BORRAR TABLAS

    public static final String borrarTablaOperarios = "DROP TABLE IF EXISTS " + Tablas_BBDD.TOperarios.nombreTabla1;
    public static final String borrarTablaProyectos = "DROP TABLE IF EXISTS " + Tablas_BBDD.TProyectos.nombreTabla2;
    public static final String borrarTablaAlmacenes = "DROP TABLE IF EXISTS " + Tablas_BBDD.TAlmacenes.nombreTabla3;
    public static final String borrarTablaMateriales = "DROP TABLE IF EXISTS " + Tablas_BBDD.TMateriales.nombreTabla4;




}
