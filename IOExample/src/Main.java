import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        File f = new File("meulog.txt");
        try{
           leituraTecladoGerandoLog(f);
        } catch (FileNotFoundException e) {
            System.out.println("-> Exception");
        }
        //
        System.out.println("-> FIM");
    }

    private static void leituraTecladoGerandoLog(File f) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        FileOutputStream fout = new FileOutputStream(f);
        PrintStream ps = new PrintStream(fout);

        loopDeLeituraEEscrita(scan, ps);

        ps.close();
        scan.close();
    }

    private static void loopDeLeituraEEscrita(Scanner scan, PrintStream ps) {
        String linha = scan.nextLine();
        while(!linha.equalsIgnoreCase("sair")) {
            ps.println(linha);
            linha = scan.nextLine();
        }
    }
}

