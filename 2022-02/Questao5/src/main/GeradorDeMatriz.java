package main;

import java.util.Random;

public class GeradorDeMatriz {
    public int[][] gerarMatrizDeOrdem(int nrLinhas, int nrColunas) {
        int [][] retorno = new int[nrLinhas][nrColunas];
        Random random = new Random();
        //preencher o retorno.
        for(int linha = 0; linha < nrLinhas; linha++) {
            for(int coluna = 0; coluna < nrColunas; coluna++) {
                retorno[linha][coluna] = random.nextInt(1000);
            }
        }
        return retorno;
    }
}









