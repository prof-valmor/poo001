package ui;

import javax.swing.*;
import java.awt.*;

public class FragmentBottom extends JPanel {
    public FragmentBottom() {
        setLayout(new GridLayout(4, 1));
        JLabel lb1 = new JLabel("refrigerador");
        lb1.setFont(new Font("Arial", Font.BOLD, 40 ));
        add(lb1); // TODO como mudar a font.
        add(new JLabel("temperatura"));
        add(new JButton("SEL"));  // TODO como colocar um icone.
        add(new JLabel("frost free"));
   }
}
