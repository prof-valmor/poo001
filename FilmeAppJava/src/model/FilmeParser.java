package model;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
}
