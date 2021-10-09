import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class PainelTree extends JPanel {
    public PainelTree () {
        //
        setLayout(new BorderLayout());
        setSize(200, 200);
        DefaultMutableTreeNode root  = new DefaultMutableTreeNode("Pastas de Email");
        DefaultMutableTreeNode inbox = new DefaultMutableTreeNode("Inbox");
        DefaultMutableTreeNode sent  = new DefaultMutableTreeNode("Sent");

        root.add(inbox);
        root.add(sent);

        JTree tree = new JTree(root);
        add(tree);
        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println("Selecao foi: " + e.getPath());
                if(e.getPath().toString().contains("Inbox")) {
                    System.out.println("SElecionando INBOX...");
                }
                else {
                    System.out.println("SElecionando Sent...");
                }
            }
        });
    }
}
