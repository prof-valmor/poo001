package ui;

import ui.JanelaContato;
import ui.MinhaJanela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciadorJanelas implements ActionListener {
    public static final int JANELA1 = 0;
    public static final int JANELA2 = 1;

    private MinhaJanela janela1;
    private JanelaContato janela2;

    public GerenciadorJanelas(){
        janela1 = new MinhaJanela(this, null);
        janela2 = new JanelaContato(this);
    }

    public void mostrarJanela(int qualJanela) {
        if(qualJanela == JANELA1) {
            janela2.setVisible(false);
            janela1.setVisible(true);
        }
        else if(qualJanela == JANELA2) {
            janela1.setVisible(false);
            janela2.setVisible(true);
        }
        else {
            System.out.println("Janela nao existe!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicando no botao: " + e.getActionCommand());
        if(e.getActionCommand().equalsIgnoreCase("OKAY")) {
            mostrarJanela(JANELA2);
        }
        else if(e.getActionCommand().equalsIgnoreCase("VOLTAR")) {
            mostrarJanela(JANELA1);
        }
    }
}
