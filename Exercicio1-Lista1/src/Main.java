import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        System.out.println("Digite o 1o numero: ");
        a = scanner.nextInt();
        System.out.println("Digite o 2o numero: ");
        b = scanner.nextInt();
        // Processamento
        NumeroPrimo primo = new NumeroPrimo();
        List <Integer> listaDeNumeros = primo.getPrimosEntre(a,b);
        // Impressao do resultado.
        System.out.println("Os numeros primos sao: ");
        //for-each
        for(Integer i : listaDeNumeros) {
            System.out.println(i);
        }
    }
}
