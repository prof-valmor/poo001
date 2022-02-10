package main;

import model.Cinefilo;
import model.CinefiloObserver;
import model.Filme;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println(">> Main.java");

        Cinefilo cn = new Cinefilo();

        cn.setObserver(new CinefiloObserver() {
            @Override
            public void acheiOFilme(Filme f) {
                System.out.println(f.toString());
            }
        });
        cn.buscar("space jam2");

    }
}
