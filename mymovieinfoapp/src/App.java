import model.OmDBHelper;
import model.OmDBHelperListener;
import presenter.Movie;
import presenter.MovieListener;
import presenter.ScreenMoviePresenter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String args[]){
        ScreenMoviePresenter presenter = new ScreenMoviePresenter();
        presenter.setMovieListener(new MovieListener() {
            @Override
            public void onMovieDataReady(Movie movie) {
                System.out.println("Dados do Filme: " + movie.toString());
            }
        });
        presenter.requestMovieData("Guardians of the Galaxy");

        System.out.println("Terminando o MAIN!");
    }
}
