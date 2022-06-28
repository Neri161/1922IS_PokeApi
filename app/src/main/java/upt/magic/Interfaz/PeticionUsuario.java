package upt.magic.Interfaz;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import upt.magic.Model.Usuario;

public interface PeticionUsuario {
    @POST("registroForm")
    Call<List<Usuario>> registrar(@Query("nombre") String nombre,
                                  @Query("apellidoPaterno") String paterno,
                                  @Query("apellidoMaterno") String materno,
                                  @Query("correo") String correo,
                                  @Query("contrasenia") String contrasenia,
                                  @Query("contrasenia2") String contrasenia2,
                                  @Query("fechaNacimiento") String fecha_Nacimiento);
    @POST("verificarCredenciales")
    Call<List<Usuario>> verificar(@Query("correo") String correo,
                                  @Query("contrasenia") String contrasenia);
    @POST("recuperarContrasenia")
    Call<List<Usuario>> recuperar(@Query("correo") String correo);
    @POST("codigo")
    Call<List<Usuario>> codigo(@Query("codigo") String codigo);
    @POST("cambio/codigo")
    Call<List<Usuario>> cambio(@Query("codigo") String codigo,
                               @Query("contrasenia") String contrasenia,
                               @Query("contrasenia2") String contrasenia2);
}
