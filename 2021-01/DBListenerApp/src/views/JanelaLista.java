package views;

import banco.BDSingleton;
import banco.DBListener;
import banco.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JanelaLista extends JFrame implements DBListener {
    JList lista;
    public JanelaLista()  {
        super("Lista de Pessoas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializaComponentes();
        //
        BDSingleton.getInstance().getBancoDeDados().setObservador(this);
    }

    private void inicializaComponentes() {
        setLayout(new GridLayout(2, 1));
        setSize(300,300);

        lista = new JList();
        add(lista);
        JButton bt = new JButton("+");
        add(bt);

        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new JanelaAddPessoa()).setVisible(true);

            }
        });
    }

    public void onChange(ArrayList<Pessoa> lista) {
        this.lista.setListData(lista.toArray());
    }
}
