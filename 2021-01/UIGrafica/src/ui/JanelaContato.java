package ui;

import modelo.Pessoa;
import modelo.PessoaListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JanelaContato extends JanelaMae implements PessoaListener {
    private ActionListener tratadorEventos;
    private JLabel lbNome, lbIdade, lbCidade;

    public JanelaContato(ActionListener tratadorEventos) {
        super(tratadorEventos);
        setTitle("Janela de Contatos...");
        setSize(300, 300);
        //
        setLayout(new GridLayout(4, 1));
        add(lbNome   = new JLabel("Nome"));
        add(lbIdade  = new JLabel("Idade"));
        add(lbCidade = new JLabel("Cidade"));
        //
        JButton voltar = new JButton("Voltar");
        voltar.setActionCommand("VOLTAR");
        voltar.addActionListener(super.tratadorEventos);
        //
        add(voltar);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void onChange(Pessoa pessoa) {
        lbNome.setText(pessoa.getNome());
        lbIdade.setText(pessoa.getIdade() + ""); //convertendo o int do getter para String.
        lbCidade.setText(pessoa.getCidade());
    }
}
