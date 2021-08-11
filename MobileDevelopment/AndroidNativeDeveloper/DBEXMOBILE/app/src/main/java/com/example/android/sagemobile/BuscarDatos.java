package com.example.android.sagemobile;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.content.ContentValues;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;




public class BuscarDatos extends AppCompatActivity {



    //Definimos todas las vistas para luego poder trabajar con ellas

    Button botonBuscar, botonActualizar, botonBorrar;

    EditText NumeroOperario, NombreOperario, NumeroProyecto, MunicipioProyecto, TipoMaterial;
    EditText MunicipioAlmacen, ImporteCompra, FechaCompra, BuscarOperacion;
    EditText Dieta, ProvinciaProyecto, AlmacenCompra, BuscarOperario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_datos);


        //Instanciamos la base de datos
        final ComandosDB helper = new ComandosDB(this);


        //Creamos todas las views para trabajar con ellas

        botonBuscar = (Button) findViewById(R.id.botonBuscarDatos);
        botonActualizar = (Button) findViewById(R.id.botonActualizarDatos);
        botonBorrar = (Button) findViewById(R.id.botonBorrarDatos);

        NumeroOperario = (EditText) findViewById(R.id.EtextIdOperario);
        NombreOperario = (EditText) findViewById(R.id.EtextNombreOperario);
        NumeroProyecto = (EditText) findViewById(R.id.EtextIdProyecto);
        MunicipioProyecto = (EditText) findViewById(R.id.EtextMunicipioProyecto);
        TipoMaterial = (EditText) findViewById(R.id.EtextTipoMaterial);
        MunicipioAlmacen = (EditText) findViewById(R.id.EtextMunicipioAlmacen);
        ImporteCompra = (EditText) findViewById(R.id.EtextImporteCompra);
        FechaCompra = (EditText) findViewById(R.id.EtextFechaCompra);
        BuscarOperacion = (EditText) findViewById(R.id.EtextBuscarOperario);
        Dieta = (EditText) findViewById(R.id.EtextDietas);
        ProvinciaProyecto = (EditText) findViewById(R.id.EtextProvinciaProyecto);
        AlmacenCompra = (EditText) findViewById(R.id.EtextAlmacenCompra);
        BuscarOperario = (EditText) findViewById(R.id.EtextBuscarOperario);


        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = helper.getReadableDatabase();


                //Creamos los string de consultas
                String seleccion = Tablas_BBDD.TOperarios.idOperario + " LIKE ?";
                String seleccion2 = Tablas_BBDD.TProyectos.idProyecto + " = ?";
                String seleccion3 = Tablas_BBDD.TAlmacenes.idAlmacen + " = ?";
                String seleccion4 = Tablas_BBDD.TMateriales.idNumeroPedido + " = ?";

                String[] seleccionArg = {BuscarOperacion.getText().toString()};

                //Hacemos la operación de borrado
                db.delete(Tablas_BBDD.TOperarios.nombreTabla1, seleccion, seleccionArg);
                db.delete(Tablas_BBDD.TProyectos.nombreTabla2, seleccion2, seleccionArg);
                db.delete(Tablas_BBDD.TAlmacenes.nombreTabla3, seleccion3, seleccionArg);
                db.delete(Tablas_BBDD.TMateriales.nombreTabla4, seleccion4, seleccionArg);

                Toast.makeText(getApplicationContext(), "Se borró el registro con clave: "
                        + BuscarOperacion.getText().toString(), Toast.LENGTH_LONG).show();


                limpiarPantalla();

                db.close();


            }
        });




        botonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SQLiteDatabase db = helper.getWritableDatabase();

                //Guardamos la información de las vistas en cadenas para poder trabajar con ellas mejor

                final String IdOperarioT = NumeroOperario.getText().toString();
                final String NombreOperarioT = NombreOperario.getText().toString();
                final String DietaT = Dieta.getText().toString();

                final String IdProyectoT = NumeroProyecto.getText().toString();
                final String ProvinciaProyectoT = ProvinciaProyecto.getText().toString();
                final String MunicipioProyectoT = MunicipioProyecto.getText().toString();

                final String AlmacenCompraT = AlmacenCompra.getText().toString();
                final String MunicipioAlmacenT = MunicipioAlmacen.getText().toString();
                final String ImporteCompraT = ImporteCompra.getText().toString();
                final String FechaCompraT = FechaCompra.getText().toString();

                final String TipoMaterialT = TipoMaterial.getText().toString();


                //Creamos los contentvalues para pasar los valores a las tablas de la DB

                ContentValues values = new ContentValues();


                values.put(Tablas_BBDD.TOperarios.numeroOperario, IdOperarioT);
                values.put(Tablas_BBDD.TOperarios.nombreOperario, NombreOperarioT);
                values.put(Tablas_BBDD.TOperarios.dieta, DietaT);
                db.insert(Tablas_BBDD.TOperarios.nombreTabla1, null, values);


                ContentValues values1 = new ContentValues();

                values1.put(Tablas_BBDD.TProyectos.numeroProyecto, IdProyectoT);
                values1.put(Tablas_BBDD.TProyectos.idDelOperario, IdOperarioT);
                values1.put(Tablas_BBDD.TProyectos.provinciaProyecto, ProvinciaProyectoT);
                values1.put(Tablas_BBDD.TProyectos.municipioProyecto, MunicipioProyectoT);


                db.insert(Tablas_BBDD.TProyectos.nombreTabla2, null, values1);


                ContentValues values2 = new ContentValues();
                values2.put(Tablas_BBDD.TAlmacenes.almacenCompra, AlmacenCompraT);
                values2.put(Tablas_BBDD.TAlmacenes.municipioAlmacen, MunicipioAlmacenT);
                values2.put(Tablas_BBDD.TAlmacenes.importeCompra, ImporteCompraT);
                values2.put(Tablas_BBDD.TAlmacenes.fechaCompra, FechaCompraT);
                db.insert(Tablas_BBDD.TAlmacenes.nombreTabla3, null, values2);


                ContentValues values3 = new ContentValues();
                values3.put(Tablas_BBDD.TMateriales.idDelProyecto, IdProyectoT);
                values3.put(Tablas_BBDD.TMateriales.tipoMaterial, TipoMaterialT);
                values3.put(Tablas_BBDD.TMateriales.almacenco, AlmacenCompraT);
                db.insert(Tablas_BBDD.TMateriales.nombreTabla4, null, values3);


                String seleccion = Tablas_BBDD.TOperarios.idOperario + " LIKE ?";
                String seleccion2 = Tablas_BBDD.TProyectos.idProyecto + " = ?";
                String seleccion3 = Tablas_BBDD.TAlmacenes.idAlmacen + " = ?";
                String seleccion4 = Tablas_BBDD.TMateriales.idNumeroPedido + " = ?";

                String[] seleccionArg = {BuscarOperacion.getText().toString()};


                //Se hacen los updates
                int count = db.update(
                        Tablas_BBDD.TOperarios.nombreTabla1,
                        values,
                        seleccion,
                        seleccionArg);


                int count1 = db.update(
                        Tablas_BBDD.TProyectos.nombreTabla2,
                        values1,
                        seleccion2,
                        seleccionArg);


                int count2 = db.update(
                        Tablas_BBDD.TAlmacenes.nombreTabla3,
                        values2,
                        seleccion3,
                        seleccionArg);


                int count3 = db.update(
                        Tablas_BBDD.TMateriales.nombreTabla4,
                        values3,
                        seleccion4,
                        seleccionArg);


                Toast.makeText(getApplicationContext(), "Se actualizó el registro con clave: "
                        + BuscarOperacion.getText().toString(), Toast.LENGTH_LONG).show();

                limpiarPantalla();

                db.close();

            }


        });


        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SQLiteDatabase db = helper.getReadableDatabase();


                try {


                    //Se crean los Strings para la búsqueda


                    String[] Busquedas = {
                            Tablas_BBDD.TOperarios.numeroOperario,
                            Tablas_BBDD.TOperarios.nombreOperario,
                            Tablas_BBDD.TOperarios.dieta,


                    };

                    String[] Busquedas2 = {

                            Tablas_BBDD.TProyectos.numeroProyecto,
                            Tablas_BBDD.TProyectos.idDelOperario,
                            Tablas_BBDD.TProyectos.provinciaProyecto,
                            Tablas_BBDD.TProyectos.municipioProyecto,


                    };


                    String[] Busquedas3 = {


                            Tablas_BBDD.TAlmacenes.almacenCompra,
                            Tablas_BBDD.TAlmacenes.municipioAlmacen,
                            Tablas_BBDD.TAlmacenes.importeCompra,
                            Tablas_BBDD.TAlmacenes.fechaCompra,


                    };


                    String[] Busquedas4 = {

                            Tablas_BBDD.TMateriales.idDelProyecto,
                            Tablas_BBDD.TMateriales.tipoMaterial,
                            Tablas_BBDD.TMateriales.almacenco


                    };


                    //Se crean los String para seleccionar las tablas donde buscar

                    String seleccion = Tablas_BBDD.TOperarios.idOperario + " = ?";
                    String seleccion2 = Tablas_BBDD.TProyectos.idProyecto + " = ?";
                    String seleccion3 = Tablas_BBDD.TAlmacenes.idAlmacen + " = ?";
                    String seleccion4 = Tablas_BBDD.TMateriales.idNumeroPedido + " = ?";
                    String[] seleccionArgu = {BuscarOperacion.getText().toString()};


                    //Se crean los diferentes cursores para movernos por diferentes tablas

                    Cursor cursor = db.query(
                            Tablas_BBDD.TOperarios.nombreTabla1,
                            Busquedas,
                            seleccion,
                            seleccionArgu,
                            null,
                            null,
                            null
                    );


                    Cursor cursor2 = db.query(
                            Tablas_BBDD.TProyectos.nombreTabla2,
                            Busquedas2,
                            seleccion2,
                            seleccionArgu,
                            null,
                            null,
                            null
                    );

                    Cursor cursor3 = db.query(
                            Tablas_BBDD.TAlmacenes.nombreTabla3,
                            Busquedas3,
                            seleccion3,
                            seleccionArgu,
                            null,
                            null,
                            null
                    );

                    Cursor cursor4 = db.query(
                            Tablas_BBDD.TMateriales.nombreTabla4,
                            Busquedas4,
                            seleccion4,
                            seleccionArgu,
                            null,
                            null,
                            null
                    );


                    //Se envian los cursores al principio de la tabla

                    cursor.moveToFirst();
                    cursor2.moveToFirst();
                    cursor3.moveToFirst();
                    cursor4.moveToFirst();


                    //Se envía la información de los cursores a los campos de texto
                    NumeroOperario.setText(cursor.getString(0));
                    NombreOperario.setText(cursor.getString(1));
                    Dieta.setText(cursor.getString(2));
                    NumeroProyecto.setText(cursor2.getString(0));
                    ProvinciaProyecto.setText(cursor2.getString(2));
                    MunicipioProyecto.setText(cursor2.getString(3));
                    AlmacenCompra.setText(cursor3.getString(0));
                    MunicipioAlmacen.setText(cursor3.getString(1));
                    ImporteCompra.setText(cursor3.getString(2));
                    FechaCompra.setText(cursor3.getString(3));
                    TipoMaterial.setText(cursor4.getString(1));


                    db.close();

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "No se encuentra el registro buscado",
                            Toast.LENGTH_LONG).show();

                }


            }
        });


    }



    //Botón de salir para mandarnos a la pantalla de inicio

    public void salirBuscarDatos (View view){

        finish();
        Intent salgo = new Intent(this, Menu.class);
        startActivity(salgo);
    }



    //Con este método limpiamos la pantalla de datos


    public void limpiarPantalla(){

        //Ponemos los campos a cero
        NumeroOperario.setText("");
        NombreOperario.setText("");
        NumeroProyecto.setText("");
        MunicipioProyecto.setText("");
        TipoMaterial.setText("");
        MunicipioAlmacen.setText("");
        ImporteCompra.setText("");
        FechaCompra.setText("");
        Dieta.setText("");
        ProvinciaProyecto.setText("");
        AlmacenCompra.setText("");
        BuscarOperario.setText("");

    }





    /*Con esté método evitamos que se pueda ir hacia la pantalla de atrás manualmente,
    por elección en el diseño se hace mediante el botón salir
     */
    @Override


    public void onBackPressed() {

    }
}
