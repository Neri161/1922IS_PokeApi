package upt.magic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import upt.magic.Interfaz.PeticionUsuario;
import upt.magic.Model.Usuario;

public class LoginActivity extends AppCompatActivity {
    public static Retrofit varRetro;
    public String status;
    public Button  btn_login;
    public TextInputEditText txtCorreo;
    public TextInputEditText txtContrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button) findViewById(R.id.btn_Registrar);
        txtCorreo = (TextInputEditText) findViewById(R.id.in_correo);
        txtContrasenia = (TextInputEditText) findViewById(R.id.in_contrasenia1);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtCorreo.getText().toString().equals(null) && txtContrasenia.toString().equals(null)){
                    Toast.makeText(getApplicationContext(), "Llena los campos", Toast.LENGTH_LONG).show();
                }else{
                    varRetro = new Retrofit.Builder()
                            .baseUrl("https://jnmlvuvn.lucusvirtual.es/api/auth/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    PeticionUsuario peticion = varRetro.create(PeticionUsuario.class);
                    Call<Usuario> login = peticion.verificar(txtCorreo.getText().toString(), txtContrasenia.getText().toString());
                    login.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            if (!response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Error intentalo de nuevo", Toast.LENGTH_LONG).show();
                            }else{
                                Usuario usuario = response.body();
                                if  (usuario.getEstatus() != null){
                                    if ((usuario.getEstatus() != "error")){
                                        String content = "";
                                        content+= usuario.getMensaje();
                                        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();
                                    }
                                }else{
                                    String content = "";
                                    content+= usuario.getNombre()+" ";
                                    content+= usuario.getApellidoPaterno()+" ";
                                    content+= usuario.getApellidoMaterno()+" ";

                                    Toast.makeText(getApplicationContext(), "Bienvenido "+ content, Toast.LENGTH_LONG).show();
                                    Intent i  = new Intent(LoginActivity.this,InicioActivity.class);
                                    startActivity(i);
                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error algo salio mal", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
    public void registro(View view){
        Intent i = new Intent(LoginActivity.this,RegistroActivity.class);
        startActivity(i);
    }
    public void restablecer(View view){
        Intent i = new Intent(LoginActivity.this,RestablecerActivity.class);
        startActivity(i);
    }
}