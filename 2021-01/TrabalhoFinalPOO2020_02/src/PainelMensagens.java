import javax.swing.*;
import java.awt.*;

public class PainelMensagens extends JPanel {
    public PainelMensagens() {
        setLayout(new BorderLayout());
        setLayout(new BorderLayout());
        String[] data = {"Assunto: texto rementere: aluno", "Assunto: avaliacao rementere: professor"};
        JList myList = new JList<String>(data);
        add(myList, BorderLayout.CENTER);
    }
}
