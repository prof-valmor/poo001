package model;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Cinefilo {
    private CinefiloObserver observer;
    private static final String apiKeyPrefix = "&apikey=130637f6";
    private static final String baseUrl = "https://www.omdbapi.com/?t=";
    private OkHttpClient client;

    public Cinefilo() {
        client = new OkHttpClient().newBuilder().build();
    }
    //RestAPI
    public void buscar(String titulo) {
        String url = baseUrl + titulo + apiKeyPrefix;
        //
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        // Criando a thread de busca.
        Thread t = new Thread() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    String json = "";

                    if(response.isSuccessful()) {
                        json = response.body().string();
                    }
                    if(observer != null) { // se tem alguem observando...
                        Filme filme = FilmeParser.parse(json);
                        // baixar o poster da internet...
                        String urlDoPoster = FilmeParser.getUrlPoster(json);
                        Request requestPoster = new Request.Builder()
                                .url(urlDoPoster)
                                .method("GET", null)
                                .build();
                        response = client.newCall(requestPoster).execute();
                        if(response.isSuccessful()) {
                            filme.poster = response.body().bytes();
                        }
                        // depois chamamos o observer.
                        observer.acheiOFilme(filme);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public void setObserver(CinefiloObserver cinefiloObserver) {
        observer = cinefiloObserver;
    }
}
