import java.io.*;
import java.net.Socket;

public class MainDoCliente {
    public static void main(String args[]) {
        try {
            Socket conexao = new Socket("10.0.0.109", 2984);
            InputStream lerDoServidor = conexao.getInputStream();
            OutputStream escreverParaOServidor = conexao.getOutputStream();
            //
            PrintStream ps = new PrintStream(escreverParaOServidor);
            ps.println("getName2");
            //
            BufferedReader br = new BufferedReader(new InputStreamReader(lerDoServidor));
            String texto = br.readLine();
            System.out.println("O servidor respondeu: " + texto);
        } catch (IOException e) {
            System.out.println("Erro no Client: " + e.getMessage());
        }


    }

}
