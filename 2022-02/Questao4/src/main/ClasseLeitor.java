package main;

import java.util.Scanner;

public class ClasseLeitor {
    public String lerPalavra() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public String escolharOpcao(String ...opcoes) {
        System.out.println("Escolha uma das opcoes: ");
        for(String s : opcoes) {
            System.out.println(s);
        }
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
