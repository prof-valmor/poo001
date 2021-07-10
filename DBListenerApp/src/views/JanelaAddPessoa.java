package views;
import banco.BancoDeDados;
import banco.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JanelaAddPessoa extends JFrame implements ActionListener {
    private JTextField edtNome;

    public JanelaAddPessoa() {
        super("Adicionar Pessoa.");
        iniciaComponentes();
    }

    public void iniciaComponentes(){
        JLabel label = new JLabel("Janela para Adicionar pessoas");
        JButton button1 = new JButton("ADD");
        edtNome = new JTextField();
        button1.setBackground(Color.BLUE);
        button1.addActionListener(this);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(label);
        add(edtNome);
        add(button1);
        pack();
    }

    public void actionPerformed(ActionEvent botaox){
        //add no banco de dados aqui
        Pessoa p = new Pessoa();
        p.nome = edtNome.getText();
        BancoDeDados.getInstance().addPessoa(p);
    }
}
