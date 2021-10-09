
/**
 * Write a description of class TratadorDeEventos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.event.*;

public class TratadorDeEventos implements ActionListener, PessoaListener {
    int counter = 0;
    String nome;
    
    public TratadorDeEventos(String nome) {
        this.nome = nome;
    }
    
    
    public void actionPerformed(ActionEvent e){
        System.out.println(nome + "- Botao PRESSIONADO!!" + counter++);
    }
    
    public void onIdadeEvent(int novaIdade) {
        System.out.println("PARABENS por " + novaIdade + " anos de vida");
    }
}
