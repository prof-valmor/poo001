package ui;

import model.Arquivista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HomeScreen extends JFrame implements ActionListener {
    private JTextArea area;

    public HomeScreen() {
        super("NOTEPAD++");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        addMenu();
    }

    private void addMenu() {
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
    }

    private void initComponents() {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        area = new JTextArea();

        JButton btArmazenar = new JButton("ARMAZENAR");
        JButton btCarregar = new JButton("CARREGAR");

        area.setAlignmentX(CENTER_ALIGNMENT);
        btArmazenar.setAlignmentX(CENTER_ALIGNMENT);
        btCarregar.setAlignmentX(CENTER_ALIGNMENT);

        area.setSize(this.getWidth(), this.getHeight() - btArmazenar.getHeight());

        add(area);
        add(btArmazenar);
        add(btCarregar);
        //
        btArmazenar.setActionCommand("Armazenar");
        btCarregar.setActionCommand("Carregar");

        btArmazenar.addActionListener(this);
        btCarregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Carregar")) {
            System.out.println("Carregando");
            try {
                String text = Arquivista.getInstance().recuperarConteudoDoArquivo("MARIO.txt");
                area.setText(text);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getActionCommand().equalsIgnoreCase("Armazenar")) {
            System.out.println("Armazenando");
            try {
                Arquivista.getInstance().salvarConteudoEmArquivo(area.getText(), "MARIO.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}