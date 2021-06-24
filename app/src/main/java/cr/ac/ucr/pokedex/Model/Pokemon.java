package cr.ac.ucr.pokedex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    private int number;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlPieces = url.split("/");
        return Integer.parseInt(urlPieces[urlPieces.length - 1]);
    }




}
