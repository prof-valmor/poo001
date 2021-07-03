import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaJanela extends JanelaMae {
    public MinhaJanela(ActionListener quemTrataOsEventos) {
        super(quemTrataOsEventos);
        setTitle("Minha Janela inicial...");
        iniciaComponentes();
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciaComponentes() {
        JLabel label;
        JButton botao;
        JButton botao2;
        label  = new JLabel("Este eh um Label...");
        botao = new JButton("OKAY");
        botao.setActionCommand("OKAY");
        botao2 = new JButton("Novo Botao");

        botao.setBackground(Color.BLUE);
        //
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(botao, BorderLayout.EAST);
        add(botao2, BorderLayout.WEST);
        //Listeners or Observers.
        botao.addActionListener(super.tratadorEventos);
        pack();
    }
}
