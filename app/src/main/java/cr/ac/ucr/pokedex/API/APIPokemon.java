package cr.ac.ucr.pokedex.API;

import cr.ac.ucr.pokedex.Model.PokemonReponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIPokemon {
    @GET("pokemon")
    Call<PokemonReponse> getPokemons(@Query("limit") int limit,@Query("offset") int offset);
}
