package views;

import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScreenSearch extends JFrame implements ActionListener {
    JTextField txtBuscar;
    public ScreenSearch() {
        setTitle("Digite o nome do Filme");
        //
        setLayout(new GridLayout(2,1));
        txtBuscar = new JTextField();
        add(txtBuscar);

        JButton btBuscar = new JButton("Buscar >>");
        add(btBuscar);
        btBuscar.addActionListener(this);
        btBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    actionPerformed(null);
                }
            }
        });

        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.screenMovie.getScreenMoviePresenter().requestMovieData(txtBuscar.getText());
        Main.navegarParaMovie();
    }

    public void clean() {
        txtBuscar.setText("");
    }
}
