package cr.ac.ucr.pokedex.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ListPokemonReponse {

    @SerializedName("results")
    @Expose
    private List<Pokemon> results = null;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

}
