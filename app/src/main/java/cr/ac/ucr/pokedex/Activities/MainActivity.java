package cr.ac.ucr.pokedex.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import cr.ac.ucr.pokedex.API.APIPokemon;
import cr.ac.ucr.pokedex.Adapter.PokemonListAdapter;
import cr.ac.ucr.pokedex.Model.Pokemon;
import cr.ac.ucr.pokedex.Model.ListPokemonReponse;
import cr.ac.ucr.pokedex.Model.RetrofitSingleton;
import cr.ac.ucr.pokedex.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKEDEX";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private PokemonListAdapter pokemonListAdapter;

    private int offset;

    private boolean load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        pokemonListAdapter = new PokemonListAdapter(this);
        recyclerView.setAdapter(pokemonListAdapter);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0){
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (load) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            load = false;
                            offset += 20;
                            getPokemons(offset);
                        }
                    }
                }
            }
        });


        retrofit = RetrofitSingleton.getRetrofit();
        load = true;
        offset = 0;
        getPokemons(offset);
    }

    private void getPokemons(int offset){

        APIPokemon apiPokemon = retrofit.create(APIPokemon.class);
        Call<ListPokemonReponse> call = apiPokemon.getPokemons(20,offset);

        call.enqueue(new Callback<ListPokemonReponse>() {
            @Override
            public void onResponse(Call<ListPokemonReponse> call, Response<ListPokemonReponse> response) {
                load = true;
                if(!response.isSuccessful()){
                    Log.e(TAG, " onResponse: "+response.errorBody());
                    return;
                }
                ListPokemonReponse poke = response.body();
                List<Pokemon> list = poke.getResults();

                pokemonListAdapter.addListPokemons(list);
            }

            @Override
            public void onFailure(Call<ListPokemonReponse> call, Throwable t) {
                load = true;
                Log.e(TAG, " onFailure: "+t.getMessage());
            }
        });

    }
}