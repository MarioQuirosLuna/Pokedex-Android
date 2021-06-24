package cr.ac.ucr.pokedex.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
