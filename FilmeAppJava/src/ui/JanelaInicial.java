package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaInicial extends JFrame {
    JTextField text;
    public JanelaInicial() {
        super("Busque info do seu Filme...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());
        JButton busca = new JButton("Buscar");
        JButton limpa = new JButton("Limpar");
        text = new JTextField(20);

        add(busca, BorderLayout.CENTER);
        add(limpa, BorderLayout.PAGE_END);
        add(text, BorderLayout.NORTH);
        //
        busca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = text.getText();
                (new JanelaFilme(nome)).setVisible(true);
            }
        });
        limpa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
            }
        });
    }
}
