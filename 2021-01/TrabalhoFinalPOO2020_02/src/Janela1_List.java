import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Janela1_List extends JFrame {
    private JList<String> myList;

    public Janela1_List() {
        super("Com Lista");
        setLayout(new BorderLayout());
        String[] data = {"Inbox", "Sent"};
        myList = new JList<String>(data);
        add(myList);

        myList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Selecao no List foi: " + myList.getSelectedValue());
            }
        });
        pack();
    }

    public void updateLista(String[] strings) {
        myList.removeAll();
        myList.setListData(strings);
    }
}
