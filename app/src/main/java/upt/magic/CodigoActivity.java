package upt.magic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import upt.magic.Interfaz.PeticionUsuario;
import upt.magic.Model.Usuario;

public class CodigoActivity extends AppCompatActivity {
    public static Retrofit varRetro;
    public String status;
    public Button btn_continuar;
    public TextInputEditText txtCodigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo);
        btn_continuar = (Button) findViewById(R.id.btn_continuar);
        txtCodigo = (TextInputEditText) findViewById(R.id.in_codigo);
        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtCodigo.getText().toString().equals(null)){
                    Toast.makeText(getApplicationContext(), "Llena los campos", Toast.LENGTH_LONG).show();
                }else{
                    varRetro = new Retrofit.Builder()
                            .baseUrl("https://jnmlvuvn.lucusvirtual.es/api/auth/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    PeticionUsuario peticion = varRetro.create(PeticionUsuario.class);
                    Call<Usuario> login = peticion.codigo(txtCodigo.getText().toString());
                    login.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            if (!response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Error intentalo de nuevo", Toast.LENGTH_LONG).show();
                            }else{
                                Usuario user = response.body();
                                if(user.getEstatus().equals("success")) {
                                    Intent i = new Intent(CodigoActivity.this, ContraseniaActivity.class);
                                    i.putExtra("codigo","557680");
                                    startActivity(i);
                                }else{
                                    Toast.makeText(getApplicationContext(), "Error intentalo de nuevo 2", Toast.LENGTH_LONG).show();
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
}