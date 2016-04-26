package pe.edu.ulima.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import pe.edu.ulima.loginapp.beans.Usuario;

public class LoginActivity extends AppCompatActivity {

    EditText eteUsuario, etePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eteUsuario = (EditText) findViewById(R.id.eteUsuario);
        etePassword = (EditText) findViewById(R.id.etePassword);
    }

    /*
     * Para poder ejecutarse dando un evento, este método debe retornar void y tener como único
     * parámetro una clase de tipo View.
     */
    public void onLoginClicked(View view){
        String username = eteUsuario.getText().toString();
        String password = etePassword.getText().toString();

        if (username.equals("android") &&
                password.equals("123")){
            // Login correcto
            Usuario usuario = new Usuario(username, password);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("usuario", usuario);

            startActivity(intent);
        }else{
            finish();
        }


    }
}
