import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame{ 
    private JButton   btCarregar;
    private JButton   btArmazenar;
    private JTextArea areaDeTexto;
    
    public JanelaPrincipal() {
        setTitle("Notepad");
        setLayout(new BorderLayout());
        //Adicionar os demais componentes.
        areaDeTexto = new JTextArea();
        areaDeTexto.setRows(20);
        add(areaDeTexto, BorderLayout.NORTH);
        
        btCarregar = new JButton("Carregar");
        add(btCarregar, BorderLayout.CENTER);
        
        btArmazenar = new JButton("Armazenar");
        add(btArmazenar, BorderLayout.SOUTH);
        
        pack();
    }
}
