package ui;

import model.Cinefilo;
import model.CinefiloObserver;
import model.Filme;

import javax.swing.*;
import java.awt.*;

public class JanelaFilme extends JFrame implements CinefiloObserver {
    JLabel lbTitulo;
    JLabel lbDiretor;
    JLabel lbAno;
    public JanelaFilme(String nomeFilme) {
        super(nomeFilme);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(510, 0, 600, 700);
        setLayout(new BorderLayout());
        lbTitulo = new JLabel("titulo");
        lbDiretor = new JLabel("diretor");
        lbAno = new JLabel("ano");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout( panel, BoxLayout.Y_AXIS));
        panel.add(lbTitulo);
        panel.add(lbDiretor);
        panel.add(lbAno);
        add(panel, BorderLayout.CENTER);
        //
        Cinefilo cn = new Cinefilo();
        cn.setObserver(this);
        cn.buscar(nomeFilme);
    }

    @Override
    public void acheiOFilme(Filme f) {
        lbTitulo.setText(f.titulo);
        lbDiretor.setText(f.direcao);
        lbAno.setText(f.ano);
        add(new JLabel(new ImageIcon(f.poster)), BorderLayout.NORTH);
        this.pack();
    }
}
