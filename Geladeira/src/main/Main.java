package main;

import modelo.Geladeira;
import ui.HomeScreen;

public class Main {
    public static void main(String args[]) {
        HomeScreen home = new HomeScreen();
        home.setVisible(true);
        //
        Geladeira g = new Geladeira();
        //0 - min, 1 - med, 2 - max
        g.mudarTemperatura(1); //
        System.out.println("FIM DO MAIN");
    }
}
