package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JanelaNotepad extends JFrame implements ActionListener{
    public JanelaNotepad(ActionListener navegador) {
        setTitle("notepad");
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        montarOLayout(navegador);
    }

    private void montarOLayout(ActionListener navegador) {
        JButton btVoltar = new JButton("<< VOLTAR");
        add(btVoltar, BorderLayout.NORTH);
        btVoltar.setActionCommand("navegarPrincipal");
        btVoltar.addActionListener(navegador);
        JTextArea area = new JTextArea("Escreva aqui...");
        area.setBackground(Color.DARK_GRAY);
        area.setForeground(Color.white);
        add(area, BorderLayout.CENTER);
        area.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                area.setText("");
            }
        });
        adicionarJPanel();
        setSize(250, 250);
    }

    private void adicionarJPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBackground(Color.BLACK);
        JButton bt = new JButton("Salvar");
        bt.setActionCommand("Salvar");
        bt.addActionListener(this);
        panel.add(bt);
        bt = new JButton("Limpar");
        bt.setActionCommand("Limpar");
        bt.addActionListener(this);
        panel.add(bt);
        add(panel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
