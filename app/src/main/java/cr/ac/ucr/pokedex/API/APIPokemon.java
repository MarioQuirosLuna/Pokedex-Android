package cr.ac.ucr.pokedex.API;

import cr.ac.ucr.pokedex.Model.ListPokemonReponse;
import cr.ac.ucr.pokedex.Model.Pokemon;
import cr.ac.ucr.pokedex.Model.PokemonInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIPokemon {
    @GET("pokemon")
    Call<ListPokemonReponse> getPokemons(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}")
    Call<PokemonInfo> getPokemon(@Path("id") int id);
}
