package com.example.android.sagemobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    //Método asociado al botón cerrar para finalizar la APP

    public void salirApli (View view){

        finish();
    }


    //Método asociado al botón entrar para entrar a la pantalla del menú

    public void entrarApp(View view) {

        //Definimos un campo de texto y cogemos lo que hay en el para guardarlo en un String

        EditText Contraseña = (EditText) findViewById(R.id.EtextContraseña);
        String pantallaContraseña = Contraseña.getText().toString();

        //LLamamos al SharedPreferences y guardamos los datos en un String para realizar la comparación

        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        String clave = datos.getString("Contraseña", "2222");


        /*Si la clave guardada es datos es igual que la introducida nos deja entrar, si no nos manda
        el mensaje de error
         */


        if (pantallaContraseña.equals(clave)) {

            Intent entrar = new Intent(this, Menu.class);
            startActivity(entrar);
            finish();

        } else {

            Toast.makeText(getApplicationContext(), "La contraseña introducida no es correcta",
                    Toast.LENGTH_SHORT).show();

        }
    }
}
