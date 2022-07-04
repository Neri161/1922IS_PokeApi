package upt.magic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import upt.magic.Interfaz.PeticionUsuario;
import upt.magic.Model.Usuario;

public class RestablecerActivity extends AppCompatActivity {

    public static Retrofit varRetro;
    public String status;
    public Button btn_recuperar;
    public Button btn_regresar;
    public TextInputEditText txtCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer);
        btn_recuperar = (Button) findViewById(R.id.btn_continuar);
        btn_regresar = (Button) findViewById(R.id.btn_Regresar);
        txtCorreo = (TextInputEditText) findViewById(R.id.in_correo);
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RestablecerActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        btn_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtCorreo.getText().toString().equals(null)){
                    Toast.makeText(getApplicationContext(), "Llena los campos", Toast.LENGTH_LONG).show();
                }else{
                    varRetro = new Retrofit.Builder()
                            .baseUrl("https://jnmlvuvn.lucusvirtual.es/api/auth/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    PeticionUsuario peticion = varRetro.create(PeticionUsuario.class);
                    Call<Usuario> login = peticion.recuperar(txtCorreo.getText().toString());
                    login.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            if (!response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Error intentalo de nuevo", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(getApplicationContext(),"Correo enviado",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(RestablecerActivity.this,CodigoActivity.class);
                                startActivity(i);
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
}