import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>APP PARA ENCONTRAR NRS PRIMOS<<");
        System.out.println("DIGITE 2 NUMEROS.");
        //
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Vc digitou: " + a + " e " + b);
        //
        EncontradorDePrimos encontrador = new EncontradorDePrimos();
        ArrayList<Integer> numerosPrimos = encontrador.encontrarPrimos(a, b);
        //
        System.out.println("Os numeros primos encontrados foram:");
        //foreach
        for(int numero : numerosPrimos) {
            System.out.println(numero);
        }
    }
}
