package Main;

public class Impressora {
    public void imprimir(int[] listaDeNumerosPrimos) {
        for(int i : listaDeNumerosPrimos) {
            if(i != 0)
                System.out.println(i);
        }
    }
}
