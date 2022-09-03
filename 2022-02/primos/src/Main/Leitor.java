package Main;

import java.util.Scanner;

public class Leitor {
    public int[] lerDoisNumerosInteiros() {
        Scanner scan = new Scanner(System.in);
        int [] retorno = new int[2];
        retorno[0] = scan.nextInt();
        retorno[1] = scan.nextInt();
        return retorno;
    }
}
