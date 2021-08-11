package com.example.android.sagemobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



    }



    //Escribrimos los tres métodos para ir a las diferentes pantallas de la App

    public void irConfiguracion(View view){

        Intent mostrarconfiguracion = new Intent(this,Configuracion.class );
        startActivity(mostrarconfiguracion);

    }


    public void irProyecto (View view){

        Intent mostraractividades= new Intent (this, DatosProyecto.class);
        startActivity(mostraractividades);
    }



    public void irActualizar (View view){

        Intent mostraractividades= new Intent (this, BuscarDatos.class);
        startActivity(mostraractividades);
    }





    /*Con esté método evitamos que se pueda ir hacia la pantalla de atrás manualmente,
    por elección en el diseño se hace mediante el botón salir
     */
    @Override


    public void onBackPressed() {

    }



    //Botón de salir para mandarnos a la pantalla de inicio

    public void salirMenu (View view){

        finish();
        Intent salgo = new Intent(this, MainActivity.class);
        startActivity(salgo);
    }


}
