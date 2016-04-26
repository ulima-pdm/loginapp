package pe.edu.ulima.loginapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    public void onVerMapaClicked(View view){
        Uri location = Uri.parse("geo:0,0?q=Universidad de Lima");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

    public void onMandarCorreo(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        //emailIntent.setData(Uri.parse("mailto:")); // Solo email apps se podrán ejecutar
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"hquintan@ulima.edu.pe"}); // TO
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Titulo del correo");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Contenido del texto");
        // Si es que queremos enviar una imagen en el correo
        //emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));

        startActivity(emailIntent);
    }
}
