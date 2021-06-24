package cr.ac.ucr.pokedex.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import cr.ac.ucr.pokedex.Model.Pokemon;
import cr.ac.ucr.pokedex.R;

public class PokemonListAdapter extends RecyclerView.Adapter<ItemPokemonViewHolder> {

    private List<Pokemon> listPokemons;
    private Context context;
    private Pokemon p;

    public PokemonListAdapter(Context context){
        this.listPokemons = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ItemPokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemList = inflater.inflate(R.layout.item_pokemon, parent, false);

        return new ItemPokemonViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(ItemPokemonViewHolder holder, int position) {
        p = listPokemons.get(position);
        holder.idPokemon.setText(String.valueOf(p.getNumber()));
        holder.namePokemon.setText(p.getName());

        Glide.with(this.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + p.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.iconPokemon);
        holder.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return listPokemons.size();
    }

    public void addListPokemons(List<Pokemon> list) {
        listPokemons.addAll(list);
        notifyDataSetChanged();
    }


}
