package main;

import ui.GerenciadorDeJanelas;
import ui.JanelaPrincipal;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        new GerenciadorDeJanelas();
        for(int i = 0; i < 10000; i++) {
            System.out.println("...main...");
        }
        System.out.println("O main acabou!!");
    }
}
