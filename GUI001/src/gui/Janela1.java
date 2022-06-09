package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela1 extends JFrame {
    JButton btOkay;
    public Janela1() {
        super("JANELA");
        setLayout(new FlowLayout());
        btOkay = new JButton("OK");
        btOkay.setActionCommand("BOTAO_OKAY");
        add("BOTAO1", btOkay);
        add(new JLabel("Exemplo"));
        pack();
        btOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btOkay) System.out.println("FOI o btOkay...");
                System.out.println("Botao pressionado: " + e.getActionCommand());
            }
        });
    }

    public static void main(String[] args) {
        Janela1 gui = new Janela1();
        gui.setVisible(true);
    }
}
