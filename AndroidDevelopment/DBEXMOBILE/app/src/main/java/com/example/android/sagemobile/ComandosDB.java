package com.example.android.sagemobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ComandosDB extends SQLiteOpenHelper {

    public static final int VERSION_BBDD = 1;
    public static final String NOMBRE_BBDD = "BASEDEDATOSSAGE";


    //Constructor de la BD

    public ComandosDB(Context context) {
        super(context, NOMBRE_BBDD, null, VERSION_BBDD);
    }


    //Métodos hay que implementar obligatóriamente por la clase heredada

    public void onCreate(SQLiteDatabase db) {


        db.execSQL(Tablas_BBDD.crearOperarios);
        db.execSQL(Tablas_BBDD.crearProyectos);
        db.execSQL(Tablas_BBDD.crearAlmacenes);
        db.execSQL(Tablas_BBDD.crearMateriales);



    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL(Tablas_BBDD.borrarTablaOperarios);
        db.execSQL(Tablas_BBDD.borrarTablaAlmacenes);
        db.execSQL(Tablas_BBDD.borrarTablaMateriales);
        db.execSQL(Tablas_BBDD.borrarTablaProyectos);
        onCreate(db);


    }


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
