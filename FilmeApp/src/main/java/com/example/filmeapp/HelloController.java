package com.example.filmeapp;

import com.example.filmeapp.model.Cinefilo;
import com.example.filmeapp.model.CinefiloObserver;
import com.example.filmeapp.model.Filme;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
        //
        Cinefilo cinefilo = new Cinefilo();
        cinefilo.setObserver(new CinefiloObserver() {
            @Override
            public void acheiOFilme(Filme f) {
                System.out.println("Achou o Filme: " + f);
                welcomeText.setText(f.toString());
            }
        });
        cinefilo.buscar("teste");
    }
}