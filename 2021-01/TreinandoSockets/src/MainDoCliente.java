import java.io.*;
import java.net.Socket;

public class MainDoCliente {
    public static void main(String args[]) {
        try {
            Socket conexao = new Socket("localhost", 2984);
            InputStream lerDoServidor = conexao.getInputStream();
            OutputStream escreverParaOServidor = conexao.getOutputStream();
            //
            System.out.println("Escrevendo para o Server.");
            PrintStream ps = new PrintStream(escreverParaOServidor);
            ps.println("getDate");
            //
            System.out.println("Lendo do Server.");
            BufferedReader br = new BufferedReader(new InputStreamReader(lerDoServidor));
            String texto = br.readLine();
            System.out.println("O servidor respondeu: " + texto);
        } catch (IOException e) {
            System.out.println("Erro no Client: " + e.getMessage());
        }


    }

}
