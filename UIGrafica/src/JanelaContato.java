import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JanelaContato extends JanelaMae {
    private ActionListener tratadorEventos;

    public JanelaContato(ActionListener tratadorEventos) {
        super(tratadorEventos);
        setTitle("Janela de Contatos...");
        //
        setLayout(new GridLayout(4, 1));
        add(new JLabel("Nome"));
        add(new JLabel("Idade"));
        add(new JLabel("Cidade"));
        //
        JButton voltar = new JButton("Voltar");
        voltar.setActionCommand("VOLTAR");
        voltar.addActionListener(super.tratadorEventos);
        //
        add(voltar);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
}
