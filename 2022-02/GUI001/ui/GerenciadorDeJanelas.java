package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciadorDeJanelas implements ActionListener {
    private JanelaPrincipal janelaPrincipal;
    private JanelaNotepad   janelaNotepad;
    public GerenciadorDeJanelas() {
        janelaPrincipal = new JanelaPrincipal(this);
        janelaNotepad   = new JanelaNotepad(this);
        navegarParaJanelaPrincipal();
    }
    public void navegarParaJanelaPrincipal() {
        janelaNotepad.setVisible(false);
        janelaPrincipal.setVisible(true);
    }
    public void navegarParaJanelaNotepad() {
        janelaPrincipal.setVisible(false);
        janelaNotepad.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equalsIgnoreCase("navegarPrincipal"))
            navegarParaJanelaPrincipal();
        if(command.equalsIgnoreCase("navegarNotepad"))
            navegarParaJanelaNotepad();
    }
}
