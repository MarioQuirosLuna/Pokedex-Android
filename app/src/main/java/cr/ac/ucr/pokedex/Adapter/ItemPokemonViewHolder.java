package cr.ac.ucr.pokedex.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import cr.ac.ucr.pokedex.R;

public class ItemPokemonViewHolder extends RecyclerView.ViewHolder {

    ImageView iconPokemon;
    TextView namePokemon;

    public ItemPokemonViewHolder(View itemView) {
        super(itemView);

        iconPokemon = (ImageView) itemView.findViewById(R.id.item_pokemon_icon);
        namePokemon = (TextView) itemView.findViewById(R.id.item_pokemon_name);
    }
}
