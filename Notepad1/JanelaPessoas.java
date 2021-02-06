
/**
 * Write a description of class JanelaPessoas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaPessoas extends JFrame{
    JButton btIdade;
    
    Pessoa valmor = new Pessoa();
    
    public JanelaPessoas() {
        setTitle("Janela de incrementar idades");
        btIdade = new JButton("Incrementar");
        add(btIdade);
        btIdade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valmor.incrementarIdade();
            }
        });
        
        valmor.addListener(new TratadorDeEventos("Pessoa"));
        
        pack();
    }
    
}
