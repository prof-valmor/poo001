package main;

import views.ScreenMovie;
import views.ScreenSearch;

public class Main {
    public static ScreenSearch screenSearch;
    public static ScreenMovie screenMovie;
    //
    public static void main(String args[]){
        screenSearch = new ScreenSearch();
        screenSearch.setVisible(true);
        //
        screenMovie = new ScreenMovie();
    }

    public static void navegarParaMovie() {
        screenSearch.setVisible(false);
        screenMovie.setVisible(true);
    }
    public static void navegarParaSearch() {
        screenMovie.setVisible(false);
        screenSearch.clean();
        screenSearch.setVisible(true);

    }
}
