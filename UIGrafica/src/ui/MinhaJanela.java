package ui;

import modelo.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaJanela extends JanelaMae {
    private Pessoa pessoa;

    public MinhaJanela(ActionListener quemTrataOsEventos, Pessoa pessoa) {
        super(quemTrataOsEventos);
        setTitle("Minha Janela inicial...");
        iniciaComponentes();
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        this.pessoa = pessoa;
    }

    private void iniciaComponentes() {
        JLabel label;
        JButton botao;
        JButton botao2;
        label  = new JLabel("Este eh um Label...");
        botao = new JButton("OKAY");
        botao.setActionCommand("OKAY");
        botao2 = new JButton("Novo Botao");

        botao.setBackground(Color.CYAN);
        //
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(botao, BorderLayout.EAST);
        add(botao2, BorderLayout.WEST);
        //Listeners or Observers.
        botao.addActionListener(super.tratadorEventos);
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pessoa.setNome("Valmor " + pessoa.getNome());
                pessoa.setCidade("Joinville" + pessoa.getCidade());
                pessoa.incrementaIdade();
            }
        });
        pack();
    }
}
