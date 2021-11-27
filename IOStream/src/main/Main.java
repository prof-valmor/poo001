package main;

import ui.HomeScreen;

/**
 * TODO: Como alterar esse projeto para que nao haja dependencia do modelo nas classes de UI?
 * TODO: sem alterar a funcionalidade.
 * TODO: como escolher o nome do arquivo?
 * TODO: como adicionar um Menu? para salvar e recuperar do arquivo tb.
 */
public class Main {
    public static void main(String args[]) {
        HomeScreen home = new HomeScreen();
        home.setVisible(true);

    }
}
