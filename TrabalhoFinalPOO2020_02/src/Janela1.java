import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Janela1 extends JFrame {
    private final Janela1_List janelaLista;

    public Janela1(Janela1_List janelaLista) {
        super("Pastas");
        setLayout(new BorderLayout());
        this.janelaLista = janelaLista;
        //
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
                    janelaLista.updateLista(new String[]{"mensagem 1", "mensagem 2", "mensagem 3"});
                }
                else {
                    janelaLista.updateLista(new String[]{"ccacaacaacaa", "nbnbnbnbnbnbnb", "nnonononono 3"});
                }
            }
        });

        pack();
    }
}
