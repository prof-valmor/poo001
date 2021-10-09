package views;

import main.Main;
import presenter.Movie;
import presenter.MovieListener;
import presenter.ScreenMoviePresenter;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenMovie extends JFrame implements ActionListener, MovieListener {
    JTextArea area;
    JLabel poster;
    private ScreenMoviePresenter screenMoviePresenter = new ScreenMoviePresenter();
    public ScreenMoviePresenter getScreenMoviePresenter() {
        return screenMoviePresenter;
    }

    public ScreenMovie() {
        setTitle("Os dados do filme sao: ");
        //
        screenMoviePresenter.setMovieListener(this);
        //
        area = new JTextArea();
        area.setName("informacoes");

        JButton btVoltar = new JButton("Voltar");
        btVoltar.addActionListener(this);
        //
        setLayout(new BorderLayout());
        add(area, BorderLayout.NORTH);
        add(poster = new JLabel(), BorderLayout.CENTER);
        add(btVoltar, BorderLayout.SOUTH);

        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.navegarParaSearch();
        area.setText("");
    }

    @Override
    public void onMovieDataReady(Movie movie) {
        area.setText(movie.toString());
        poster.setIcon(new ImageIcon(movie.poster));
    }
}
