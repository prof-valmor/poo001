
/**
 * Write a description of class Primo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Primo {

    private ArrayList<Integer> lista;
    /**
     * o valor de 'a' serah sempre menor do que o de 'b'.
     */
    public Primo(int a, int b) {
        // numeros divisiveis por 1 e por ele mesmo.
        lista = new ArrayList<Integer>(1);
        boolean ePrimo = false;

        for(int valor = a; valor <= b ; valor++) {
            ePrimo = verificaSeEhPrimo(valor);         
            if(ePrimo) {
                lista.add(valor);
            }
        }
    }

    private boolean verificaSeEhPrimo(int valor) {
        for(int divisor = 2; divisor < valor; divisor++) {
            int resto = valor%divisor;
            // Se o valor for divisivel por algum outro antes dele, ele nao eh primo.
            if(resto == 0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getNumerosNoIntervalo() {
        return lista;
    }
}
