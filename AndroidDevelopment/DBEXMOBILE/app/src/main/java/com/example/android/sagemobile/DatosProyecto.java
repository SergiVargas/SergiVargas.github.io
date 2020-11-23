package com.example.android.sagemobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosProyecto extends AppCompatActivity {

    //Definimos todas las vistas para luego poder trabajar con ellas

    Button botonGuardar;

    EditText NumeroOperario, NombreOperario, NumeroProyecto, MunicipioProyecto, TipoMaterial;
    EditText MunicipioAlmacen, ImporteCompra, FechaCompra;
    EditText Dieta, ProvinciaProyecto, AlmacenCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_proyecto);



        //Instanciamos la base de datos
        final ComandosDB helper = new ComandosDB(this);



        //Creamos todas las views para trabajar con ellas

        botonGuardar = (Button) findViewById(R.id.botonGuardarDB);

        NumeroOperario = (EditText)findViewById(R.id.EtextIdOperario);
        NombreOperario = (EditText) findViewById(R.id.EtextNombreOperario);
        NumeroProyecto = (EditText) findViewById(R.id.EtextIdProyecto);
        MunicipioProyecto = (EditText) findViewById(R.id.EtextMunicipioProyecto);
        TipoMaterial = (EditText) findViewById(R.id.EtextTipoMaterial);
        MunicipioAlmacen = (EditText) findViewById(R.id.EtextMunicipioAlmacen);
        ImporteCompra = (EditText) findViewById(R.id.EtextImporteCompra);
        FechaCompra = (EditText) findViewById(R.id.EtextFechaCompra);
        Dieta = (EditText) findViewById(R.id.EtextDietas);
        ProvinciaProyecto = (EditText) findViewById (R.id.EtextProvinciaProyecto);
        AlmacenCompra = (EditText) findViewById(R.id.EtextAlmacenCompra);



        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Abrimos la base e datos en modo escritura
                SQLiteDatabase db = helper.getWritableDatabase();


                //Guardamos la información de las vistas en cadenas para poder trabajar con ellas mejor

                final String IdOperarioT =  NumeroOperario.getText().toString();
                final String NombreOperarioT = NombreOperario.getText().toString();
                final String DietaT = Dieta.getText().toString();

                final String IdProyectoT = NumeroProyecto.getText().toString();
                final String ProvinciaProyectoT = ProvinciaProyecto.getText().toString();
                final String MunicipioProyectoT =  MunicipioProyecto.getText().toString();

                final String AlmacenCompraT =  AlmacenCompra.getText().toString();
                final String MunicipioAlmacenT = MunicipioAlmacen.getText().toString();
                final String ImporteCompraT = ImporteCompra.getText().toString();
                final String FechaCompraT = FechaCompra.getText().toString();

                final String TipoMaterialT = TipoMaterial.getText().toString();



                try {


                    //Creamos los contentvalues para pasar los valores a las tablas de la DB

                    ContentValues values = new ContentValues();


                    values.put(Tablas_BBDD.TOperarios.numeroOperario, IdOperarioT);
                    values.put(Tablas_BBDD.TOperarios.nombreOperario, NombreOperarioT);
                    values.put(Tablas_BBDD.TOperarios.dieta, DietaT);
                    long newRowId = db.insert(Tablas_BBDD.TOperarios.nombreTabla1, null, values);


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



                    //Lanzamos un mensaje para ver que se han guardado los datos correctamente
                    Toast.makeText(getApplicationContext(), "Los datos se han guardado con la clave: "
                          + newRowId  , Toast.LENGTH_LONG).show();



                }catch (Exception e){

                    Toast.makeText(getApplicationContext(), "Ha habido un error y no se" +
                            "han guardado los datos", Toast.LENGTH_LONG).show();

                }

                //Ponemos los campos de la pantalla a cero tras guardar los datos

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



                db.close();

            }
        });







    }



    //Botón de salir para mandarnos a la pantalla de inicio

    public void salirProyecto (View view){

        finish();
        Intent salgo = new Intent(this, Menu.class);
        startActivity(salgo);
    }



    /*Con esté método evitamos que se pueda ir hacia la pantalla de atrás manualmente,
    por elección en el diseño se hace mediante el botón salir
     */
    @Override


    public void onBackPressed() {

    }



}
