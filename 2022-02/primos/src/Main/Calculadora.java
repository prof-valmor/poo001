package Main;

public class Calculadora {
    public int[] encontrarPrimosNo(int[] intervalo) {
        if(intervalo == null || intervalo.length < 2 ||
           intervalo[1] <= intervalo[0]) return intervalo;

        int[] retorno = new int[intervalo[1] - intervalo[0]];
        int posicao = 0;
        for(int numero = intervalo[0]; numero <= intervalo[1];numero++) {
            if(ehPrimo(numero)) {
                retorno[posicao] = numero;
                posicao++;
            }
        }
        return retorno;
    }
    boolean ehPrimo(int numero) {
        int quantidadeDivisores = 0;
        for(int j=1;j<=numero;j++){
            if(numero%j == 0) {
                quantidadeDivisores++;
            }
        }
        if(quantidadeDivisores == 2) {
            return true;
        }
        return false;
    }
}
