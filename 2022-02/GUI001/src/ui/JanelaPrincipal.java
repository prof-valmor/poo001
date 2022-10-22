package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame implements ActionListener{
    public JanelaPrincipal() {
        super("Titulo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        montarOLayout();
        setVisible(true);
    }

    private void montarOLayout() {
        getContentPane().setBackground(Color.CYAN);
        setLayout(new FlowLayout());
        JButton bt = new JButton("Botao 1");
        bt.addActionListener((ActionEvent e) -> {
                setTitle("Botao 1 pressionado");
            });
        add(bt);
        bt = new JButton("Botao 2");
        bt.setActionCommand("MudarTitulo2");
        bt.addActionListener((ActionEvent e) -> {
                setTitle("Botao 2 pressionado");
            });
        add(bt);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equalsIgnoreCase("MudarTitulo1"))
            setTitle("Botao 1 pressionado");
        if(command.equalsIgnoreCase("MudarTitulo2"))
            setTitle("Botao 2 pressionado");
    }
}
