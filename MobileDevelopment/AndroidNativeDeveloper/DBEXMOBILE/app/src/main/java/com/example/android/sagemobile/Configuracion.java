package com.example.android.sagemobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Configuracion extends AppCompatActivity {

     //Se crean los dos EditText para poder accederlos desde todos los métodos
    EditText nuevaContrasena, repetirContrasena;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);


        final ComandosDB helper = new ComandosDB(this);

        nuevaContrasena = (EditText) findViewById(R.id.editTextNuevaContraseña);
        repetirContrasena = (EditText) findViewById(R.id.editTextRepetirContraseña);



    }


       //Método para salir y volver a la página del menú

       public void salirConfig(View view){


           //Cogemos los EditText de los campos de las contraseñas y los guardamos en un String
           nuevaContrasena = (EditText) findViewById(R.id.editTextNuevaContraseña);
           repetirContrasena = (EditText) findViewById(R.id.editTextRepetirContraseña);
           final String nuevaContrasenaC = nuevaContrasena.getText().toString();
           final String repetirContrasenaC = repetirContrasena.getText().toString();
           String vacio = "";


           /*Con este condicional nos aseguramos de que si hay algún dato en los campos de la contraseña,
           el usuario se de cuenta, porque al salir no se va a guardar. Para ello se lanza un mensaje de
           alerta*/

           if(!nuevaContrasenaC.equals(vacio)  || !repetirContrasenaC.equals(vacio)){

           final CharSequence [] Opciones = {"SALIR", "SEGUIR AQUÍ"};
           final AlertDialog.Builder alertaOpciones = new AlertDialog.Builder(  Configuracion.this);
           alertaOpciones.setTitle("Hay datos sin guardar en algún campo, ¿desea salir?");
           alertaOpciones.setItems(Opciones, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   if (Opciones[which].equals( "SALIR")) {
                       finish();
                   } else {
                       dialog.dismiss();
                   }
               }
           });
               alertaOpciones.show();
           }else{

               finish();
           }

       }






         /*Con esté método evitamos que se pueda ir hacia la pantalla de atrás manualmente,
         por elección en el diseño se hace mediante el botón salir
          */
        @Override


        public void onBackPressed() {

        }





        //Con este método se cambia la contraseña por defecto y se guarda la nueva
         public void guardarContrasena(View view){


            nuevaContrasena = (EditText) findViewById(R.id.editTextNuevaContraseña);
            repetirContrasena = (EditText) findViewById(R.id.editTextRepetirContraseña);
            final String nuevaContrasenaC = nuevaContrasena.getText().toString();
            final String repetirContrasenaC = repetirContrasena.getText().toString();
            String vacio = "";

             final SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
             final SharedPreferences.Editor miEditor = datos.edit();



             //Guardar los datos de configuración en el Sharedpreference creado anteriormente



             if (nuevaContrasenaC.equals(repetirContrasenaC) && !repetirContrasenaC.equals(vacio)) {

                  miEditor.putString("Contraseña", nuevaContrasenaC);
                  miEditor.apply();

                  Toast.makeText(getApplicationContext(), "Se guardó correctamente la nueva contraseña"
                    , Toast.LENGTH_SHORT).show();

                 finish();}

                else{

                 Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden o alguno de los campos" +
                            " está vacio. No se ha podido guardar la contraseña"
                    , Toast.LENGTH_SHORT).show();

                  }

             }




}
