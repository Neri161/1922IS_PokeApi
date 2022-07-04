package upt.magic.Interfaz;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import upt.magic.Model.Poke.Pokemon;

public interface PeticionPokemon {
    @GET("pokemon/{id}")
    Call<Pokemon> pokemonId (@Path("id") int id);
}
