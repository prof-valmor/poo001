package model;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
// Helper
public class FilmeParser {
    public static Filme parse(String json) {
        Filme filme = new Filme();
        JsonElement elm = JsonParser.parseString(json);
        if(elm.isJsonObject()) {
            JsonObject obj = elm.getAsJsonObject();
            filme.titulo = obj.get("Title").getAsString();
            filme.direcao = obj.get("Director").getAsString();
            filme.ano = obj.get("Year").getAsString();
        }

        return filme;
    }

    /**
     * @param json on the omdb format.
     * @return null or an url for the poster.
     */
    public static String getUrlPoster(String json) {
        String url = null;
        JsonElement elm = JsonParser.parseString(json);
        if(elm.isJsonObject()) {
            JsonObject obj = elm.getAsJsonObject();
            url = obj.get("Poster").getAsString();
        }
        return url;
    }
}
