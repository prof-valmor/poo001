import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JanelaNotepad extends JFrame implements ActionListener {
    JTextArea txtArea;
    public JanelaNotepad() {
        super("Notepad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new JLabel("Digite seu texto:"), BorderLayout.NORTH);
        txtArea = new JTextArea();
        add(txtArea, BorderLayout.CENTER);
        ////
        add(criarPanelBotoes(), BorderLayout.SOUTH);
        pack();
    }

    private JPanel criarPanelBotoes() {
        JPanel panelBotoes = new JPanel();
        JButton botao1 = new JButton("ARMAZENAR");
        JButton botao2 = new JButton("LER");
        botao1.setActionCommand("ARMAZENAR");
        botao2.setActionCommand("LER");

        botao1.addActionListener(this);
        botao2.addActionListener(this);

        panelBotoes.setLayout(new GridLayout(1,2));
        panelBotoes.add(botao1);
        panelBotoes.add(botao2);
        return panelBotoes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("armazenar")) {
            try {
                GerenciadorDeArquivo.armazenar(txtArea.getText());
            }catch(FileNotFoundException q) {}
        } // e se nao houver arquivo pra ler no else?
        else if(e.getActionCommand().equalsIgnoreCase("ler")){
            try {
                txtArea.setText(GerenciadorDeArquivo.ler());
            } catch (IOException ioException) {}
        }
    }
}
