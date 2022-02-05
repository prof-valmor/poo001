package com.example.filmeapp.model;

public class Cinefilo {
    CinefiloObserver observer;

    public Cinefilo() {

    }
    //RestAPI
    public void buscar(String nome) {
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//
//        Request request = new Request.Builder()
//                .url("http://www.omdbapi.com/?apikey=[]&t=the+matrix")
//                .method("GET", null)
//                .build();
//        Response response = client.newCall(request).execute();
        String json = "{\"Title\":\"The Matrix\",\"Year\":\"1999\",\"Rated\":\"R\",\"Released\":\"31 Mar 1999\",\"Runtime\":\"136 min\",\"Genre\":\"Action, Sci-Fi\",\"Director\":\"Lana Wachowski, Lilly Wachowski\",\"Writer\":\"Lilly Wachowski, Lana Wachowski\",\"Actors\":\"Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss\",\"Plot\":\"When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.\",\"Language\":\"English\",\"Country\":\"United States, Australia\",\"Awards\":\"Won 4 Oscars. 42 wins & 51 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.7/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"88%\"},{\"Source\":\"Metacritic\",\"Value\":\"73/100\"}],\"Metascore\":\"73\",\"imdbRating\":\"8.7\",\"imdbVotes\":\"1,819,156\",\"imdbID\":\"tt0133093\",\"Type\":\"movie\",\"DVD\":\"15 May 2007\",\"BoxOffice\":\"$171,479,930\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
        if(observer != null) {
            observer.acheiOFilme(FilmeParser.parse(json));
        }
    }

    public void setObserver(CinefiloObserver cinefiloObserver) {
        observer = cinefiloObserver;
    }
}
