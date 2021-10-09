package presenter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.OmDBHelper;
import model.OmDBHelperListener;
import model.PosterHelper;
import model.PosterHelperListener;

import java.awt.*;

public class ScreenMoviePresenter implements OmDBHelperListener, PosterHelperListener{
    private OmDBHelper helper;
    private PosterHelper posterHelper;
    // Dado que vai ser passado para a Screen atraves do MovieListener.
    private Movie movie;
    private MovieListener movieListener;

    public ScreenMoviePresenter() {
        helper = new OmDBHelper();
        posterHelper = new PosterHelper();
        helper.setListener(this);
        posterHelper.setListener(this);
    }

    public void setMovieListener(MovieListener movieListener) {
        this.movieListener = movieListener;
    }

    public void requestMovieData(String nomeDoFilme) {
        helper.requestFilmeByName(nomeDoFilme);
    }

    @Override
    public void chegaramOsDadosDoFilme(String dadosDoFilme) {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(dadosDoFilme);
        JsonObject jsonObject = element.getAsJsonObject();
        //
        if(this.movieListener != null) {
            movie = new Movie();
            movie.titulo  = jsonObject.get("Title").getAsString();
            movie.sinopse = jsonObject.get("Plot").getAsString();
            movie.dataDeLancamento = jsonObject.get("Released").getAsString();
            String posterUrl = jsonObject.get("Poster").getAsString();
            System.out.println();
            System.out.println(posterUrl);
            System.out.println();
            posterHelper.requestPoster(posterUrl);  // antes de chamar o listener, precisamos receber o poster.
            //movieListener.onMovieDataReady(movie);
        }

    }

    @Override
    public void chegouOPoster(Image poster) {
        movie.poster = poster;
        if(movieListener != null) movieListener.onMovieDataReady(movie);
    }
}
