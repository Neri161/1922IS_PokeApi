package upt.magic;
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
    public static String URL = "https://viqoxwhm.lucusvirtual.es/public/api/";
    public static Retrofit varRetro;
    public void registrar(Usuario usuario) {
        PeticionUsuario consApi = varRetro.create(PeticionUsuario.class);
        Call<Usuario> call = consApi.registrar(usuario.getNombre(), usuario.getApellidoPaterno(), usuario.getApellidoMaterno(), usuario.getCorreo(), usuario.getContrasenia(), usuario.getContrasenia2(), usuario.getFechaNacimiento());
            varRetro = new Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(!response.isSuccessful()){
                    error="No fue exitoso";
                    return;
                }
                Usuario usu=response.body();
                String content="";
                content+="Nombre: "+usuario.getNombre()+"\n";
                content+="Apellido Paterno: "+usuario.getApellidoPaterno()+"\n";
                content+="Apellido Materno: "+usuario.getApellidoMaterno()+"\n";
                content+="Correo: "+usuario.getCorreo()+"\n";
                content+="Contraseña: "+usuario.getContrasenia()+"\n";
                content+="Fecha: nacimiento"+usuario.getFechaNacimiento()+"\n";
                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    error="¡Falló!";
                }
            });

    }
}