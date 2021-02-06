
/**
 * Write a description of class Pessoa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Pessoa {
    private int idade;
    private ArrayList<PessoaListener> listaDeListeners = new ArrayList<>(1);
    
    public int getIdade() {
        return idade;
    }
    
    public void incrementarIdade() {
        idade++;
        if(listaDeListeners.size() > 0) {
            for(PessoaListener listener : listaDeListeners) {
                listener.onIdadeEvent(idade);
            }
        }
    }
    
    public void addListener(PessoaListener listener) {
        listaDeListeners.add(listener);
    }
    public void removeListener(PessoaListener listener) {
        listaDeListeners.remove(listener);
    }
}
