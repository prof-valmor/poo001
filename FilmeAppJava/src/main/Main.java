package main;

import model.Cinefilo;
import model.CinefiloObserver;
import model.Filme;
import ui.JanelaInicial;

public class Main {
    public static void main(String[] args) {
        System.out.println(">> Main.java");
        (new JanelaInicial()).setVisible(true);
    }
}
