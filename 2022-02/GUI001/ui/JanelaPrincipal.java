package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JanelaPrincipal extends JFrame implements ActionListener {
    public JanelaPrincipal(ActionListener navegador) {
        super("Titulo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        montarOLayout(navegador);
    }

    private void montarOLayout(ActionListener navegador) {
        getContentPane().setBackground(Color.CYAN);
        setLayout(new FlowLayout());
        JButton bt = new JButton("Botao 1");
        bt.setActionCommand("MudarTitulo1");
        bt.addActionListener(this);
        add(bt);
        bt = new JButton("|Ir para Notepad|");
        bt.setActionCommand("navegarNotepad");
        bt.addActionListener(navegador);
        add(bt);
       // pack();
        setSize(500, 300);
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
