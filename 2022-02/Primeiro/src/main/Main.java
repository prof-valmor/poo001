package main;

import main.garagem.Carro;
import main.garagem.CarroEsporte;

public class Main {
    public static void main(String[] args) {
        Carro primeiro = new Carro("Fiat");
        CarroEsporte segundo  = new CarroEsporte("Ferrari");

        primeiro.ligar();
        segundo.ligar();
        segundo.aLuzInternaEstahLigada();
        System.out.println("FIM " + primeiro.getMarca());
    }
}
