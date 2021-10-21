import java.util.ArrayList;

public class EncontradorDePrimos {
    public ArrayList<Integer> encontrarPrimos(int a, int b) {
        ArrayList<Integer> lista = new ArrayList<>();
        for(int numero = a; numero <= b; numero++) {
            if(ehPrimo(numero)) {
                lista.add(numero);
            }
        }
        return lista;
    }

    private int[] converterParaVetor(ArrayList<Integer> lista) {
        int [] resposta = new int[lista.size()];
        int index = 0;
        for(Integer i : lista) {
            resposta[index] = i;
            index++;
        }
        return resposta;
    }

    private boolean ehPrimo(int numero) {
        if(numero == 1) return false;
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0) {
                return false;
            }
        }
        return true;
    }
}
