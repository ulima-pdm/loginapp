package pe.edu.ulima.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import pe.edu.ulima.loginapp.beans.Usuario;

public class MainActivity extends AppCompatActivity {
    TextView tviMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tviMensaje = (TextView) findViewById(R.id.tviMensaje);

        Intent intentPasado = getIntent();
        Usuario usuario = (Usuario)intentPasado.getSerializableExtra("usuario");
        String username = intentPasado.getStringExtra("username");

        tviMensaje.setText(String.format("Usuario: %s \n Password: %s", usuario.getUsuario(), usuario.getPassword()));
    }
}
