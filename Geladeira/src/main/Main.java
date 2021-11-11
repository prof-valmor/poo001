package main;

import modelo.Geladeira;
import ui.HomeScreen;

public class Main {
    public static Geladeira aGeladeira;

    public static void main(String args[]) {
        aGeladeira = new Geladeira();
        //
        HomeScreen home = new HomeScreen();
        home.setVisible(true);
        //
        System.out.println("FIM DO MAIN");
    }
}
