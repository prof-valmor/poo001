
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um valor maior do que 2: ");
        int a = scanner.nextInt();
        System.out.print("Digite outro valor maior do que o primeiro: ");
        int b = scanner.nextInt();
        //Criando o objeto da classe Primo para achar os nrs primos no intervalo
        // informado.
        Primo p = new Primo(a, b);  
        // Usando o getter para obter a lista de numeros encontrados pelo objeto.
        ArrayList<Integer> lista = p.getNumerosNoIntervalo();
        //Imprimindo os valores
        for(Integer i : lista) {
           System.out.println("$ " + i); 
        }
    }
}






