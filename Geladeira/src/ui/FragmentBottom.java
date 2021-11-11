package ui;

import main.Main;
import modelo.Geladeira;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FragmentBottom extends JPanel implements ActionListener {
    private int valor = 0;
    public FragmentBottom() {
        setLayout(new GridLayout(4, 1));
        JLabel lb1 = new JLabel("refrigerador");
        lb1.setFont(new Font("Arial", Font.BOLD, 40 ));
        add(lb1); // TODO como mudar a font.
        add(new JLabel("temperatura"));

        JButton botao = new JButton("SEL");

        botao.addActionListener(this);

        add(botao);  // TODO como colocar um icone.
        add(new JLabel("frost free"));
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("PRESSIONANDO O BOTAO.");
        valor++;
        if(valor > 2) {
            valor = 0;
        }
        //0 - min, 1 - med, 2 - max
        Main.aGeladeira.mudarTemperatura(valor);
    }
}
