import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        int x = 11;
        String nome;
        // esta linha eh um comentario.
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        nome = scan.next();
        System.out.println("Hello World " + nome);
    }
}
