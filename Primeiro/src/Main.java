import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome.");
        String s = scanner.next();
        System.out.println("Oi " + s);
	System.out.println("Bye Bye " + s);
    }
}
