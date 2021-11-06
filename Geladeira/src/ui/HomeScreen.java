package ui;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JFrame {
    FragmentTop topPanel = new FragmentTop();
    FragmentBottom bottomPanel = new FragmentBottom();

    public HomeScreen() {
        setTitle("Painel de Controle");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //
        initLayout();
    }

    private void initLayout() {
        // TODO como centralizar os componentes.
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);
    }
}
