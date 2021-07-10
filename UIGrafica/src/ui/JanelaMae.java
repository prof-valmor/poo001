package ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JanelaMae extends JFrame {
    protected ActionListener tratadorEventos;
    public JanelaMae(ActionListener tratadorEventos) {
        this.tratadorEventos = tratadorEventos;
    }
}
