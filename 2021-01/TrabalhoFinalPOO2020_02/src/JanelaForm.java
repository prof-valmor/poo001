import javax.swing.*;
import java.awt.*;

public class JanelaForm extends JFrame {

    public JanelaForm() {
        setTitle("Testando os Paineis...");
        setLayout(new FlowLayout());
        add(new PainelTree());
        add(new PainelMensagens());
        pack();
        setResizable(false);
        setVisible(true);
    }
}
