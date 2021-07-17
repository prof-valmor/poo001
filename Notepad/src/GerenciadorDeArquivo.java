import java.io.*;

public class GerenciadorDeArquivo {

    private static String nomeArquivo = "notepad.txt";

    public static void armazenar(String texto) throws FileNotFoundException {
        PrintStream ps = new PrintStream(nomeArquivo);
        ps.println(texto);
        ps.close();
    }

    public static String ler() throws IOException {
        String acc = "";
        FileReader fr = new FileReader(nomeArquivo);
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while(s != null) {
            acc += s;
            s = br.readLine();
        }
        return acc;
    }
}
