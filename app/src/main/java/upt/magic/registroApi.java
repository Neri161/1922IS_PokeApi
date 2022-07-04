package upt.magic;
import android.widget.Toast;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import upt.magic.Interfaz.PeticionUsuario;
import upt.magic.Model.Usuario;

public class registroApi {
    public String error;
    public static String URL = "https://jnmlvuvn.lucusvirtual.es/api/auth/";
    public static Retrofit varRetro;

    public void registrar(String Nombre, String ApellidoPaterno, String ApellidoMaterno, String Correo, String Contrasenia, String Contrasenia2, String FechaNacimiento) {
        varRetro = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        PeticionUsuario consApi = varRetro.create(PeticionUsuario.class);
        Usuario usu=new Usuario(Nombre, ApellidoPaterno, ApellidoMaterno, Correo,Contrasenia, Contrasenia2, FechaNacimiento);
        Call<Usuario> call = consApi.registrar(usu);
            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    try {
                        if (response.isSuccessful()) {
                            Usuario m = response.body();
                            if(m.getEstatus().equals("Error")){

                            }
                            System.out.println(call);
                            System.out.println(m.getNombre());
                            System.out.println(m.getCorreo());

                        }
                    } catch (Exception ex) {
                        System.out.println("UWUn't " + ex);
                    }
                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    error="¡Falló!";
                }
            });

    }
}