import model.Geladeira;
import model.RefrigeradorListener;

import javax.swing.*;
import java.awt.*;

public class JanelaRefrigerador extends JFrame {
    private JLabel lbTemperatura;

    private Geladeira geladeira = new Geladeira();

    public JanelaRefrigerador() {
        setTitle("Temperatura Atual no Refrigerador");
        setSize(200, 200);

        //definir o gerenciador de layout.
        setLayout(new BorderLayout());  // usando border layout por facilidade.
        //
        lbTemperatura = new JLabel("Temperatura Atual: ");
        add(lbTemperatura);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    // definindo o que acontece quando se clica no x da janela.

        // Primeiro precisamos ter acesso ao objeto Refrigerador da Geladeira.
        geladeira.getRefrigerador().setListener(new RefrigeradorListener() {
            @Override
            public void aTemperaturaMudou(float novaTemperatura) {
                lbTemperatura.setText(novaTemperatura+"");
            }
        });
    }
}
