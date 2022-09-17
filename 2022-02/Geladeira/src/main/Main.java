package main;

import entidades.Geladeira;

public class Main {
    public static void main(String[] args) {
        Geladeira g = new Geladeira();

        g.selecionarTemperatura(2);

        while(true) {
            g.controlarTemperatura();
        }
    }
}








