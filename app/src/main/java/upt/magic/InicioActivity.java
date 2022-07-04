package upt.magic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import upt.magic.Interfaz.PeticionPokemon;
import upt.magic.Interfaz.PeticionUsuario;
import upt.magic.Model.Poke.Pokemon;
import upt.magic.Model.Usuario;

public class InicioActivity extends AppCompatActivity {
    public static Retrofit varRetro;
    public Button btn_inicio;
    public TextInputEditText txtID;
    public TextView txtpoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btn_inicio = (Button) findViewById(R.id.btn_id);
        txtID = (TextInputEditText) findViewById(R.id.in_id);
        txtpoke = (TextView) findViewById(R.id.txt_pokemon);

        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtID.getText().toString().equals(null)){
                    Toast.makeText(getApplicationContext(), "Llena los campos", Toast.LENGTH_LONG).show();
                    return;
                }else{
                    int id = Integer.parseInt(txtID.getText().toString());
                    if(id<0 || id>906){
                        Toast.makeText(getApplicationContext(), "Introduce un ID de 1-905", Toast.LENGTH_LONG).show();
                        return;
                    }
                    varRetro = new Retrofit.Builder()
                            .baseUrl("https://pokeapi.co/api/v2/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    PeticionPokemon apipoke = varRetro.create(PeticionPokemon.class);
                    Call<Pokemon> consulta = apipoke.pokemonId(id);
                    consulta.enqueue(new Callback<Pokemon>() {
                        @Override
                        public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                            if (!response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Error intentalo de nuevo", Toast.LENGTH_LONG).show();
                            }else{
                                Pokemon poke =  response.body();
                                String datos = "";
                                datos+="Nombre: "+ poke.getName()+"\n";
                                datos+="experioencia Base: "+ poke.getBase_experience()+"\n";
                                datos+="Altura: "+ poke.getHeight()+"\n";
                                txtpoke.setText(datos);
                                txtID.setText("");
                            }

                        }

                        @Override
                        public void onFailure(Call<Pokemon> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error algo salio mal", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });


    }
}