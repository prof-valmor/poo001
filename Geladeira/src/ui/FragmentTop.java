package ui;

import javax.swing.*;
import java.awt.*;

public class FragmentTop extends JPanel {
    JCheckBox cbMax;
    JCheckBox cbMed;
    JCheckBox cbMin;

    public FragmentTop() {

        GridLayout grid = new GridLayout(3, 1);
        setLayout(grid);
        cbMax = new JCheckBox("MAX");
        add(cbMax);
        add(cbMed = new JCheckBox("MED"));
        add(cbMin = new JCheckBox("MIN"));
    }

}
