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
        varRetro = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        PeticionUsuario consApi = varRetro.create(PeticionUsuario.class);
        Usuario usu=new Usuario("Alfred","Lopez","Bautista","sorrow2287@gmail.com","Alfredo1234$","Alfredo1234$","2001-08-13");
        Call<Usuario> call = consApi.registrar(usu);
            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    try {
                        if (response.isSuccessful()) {
                            Usuario m = response.body();
                            System.out.println(call);
                            System.out.println(m.getNombre());
                            System.out.println(m.getCorreo());

                        }
                    } catch (Exception ex) {
                        System.out.println("UWUn't " + ex);
                    }
               /* Usuario usu=response.body();
                String content="";
                content+="Nombre: "+usuario.getNombre()+"\n";
                content+="Apellido Paterno: "+usuario.getApellidoPaterno()+"\n";
                content+="Apellido Materno: "+usuario.getApellidoMaterno()+"\n";
                content+="Correo: "+usuario.getCorreo()+"\n";
                content+="Contraseña: "+usuario.getContrasenia()+"\n";
                content+="Fecha: nacimiento"+usuario.getFechaNacimiento()+"\n";*/
                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    error="¡Falló!";
                }
            });

    }
}