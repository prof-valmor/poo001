package ui;

import model.Arquivista;
import model.Navegador;
import model.NavegadorListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HomeScreen extends JFrame implements ActionListener {
    private JTextArea area;
    private JTextField endereco;

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

        endereco = new JTextField();
        area = new JTextArea();

        JButton btArmazenar = new JButton("ARMAZENAR");
        JButton btCarregar = new JButton("CARREGAR");

        area.setAlignmentX(CENTER_ALIGNMENT);
        endereco.setAlignmentX(LEFT_ALIGNMENT);
        btArmazenar.setAlignmentX(CENTER_ALIGNMENT);
        btCarregar.setAlignmentX(CENTER_ALIGNMENT);

        area.setSize(this.getWidth(), this.getHeight() - btArmazenar.getHeight());
        add(endereco);
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
            // ATENCAO: mudamos o Navegador para usar Thread e nao travar a Janela.
            Navegador navegador = new Navegador(endereco.getText());
            // ATENCAO: quando a Thread conseguir ler os dados, vai chamar o ...
            // ... listener que estamos criando abaixo.
            navegador.setListener(new NavegadorListener() {
                @Override
                public void aRespostaChegou(String response) {
                    area.setText(response);
                }
            });
            // ATENCAO: na linha abaixo, inicializamos a nova thread. Olhem o Navegador.class
            navegador.start();
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