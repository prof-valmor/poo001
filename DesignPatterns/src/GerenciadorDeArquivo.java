import java.io.*;

public class GerenciadorDeArquivo {
    //1. Metodo construtor precisa ser private.
    //2. guardar uma referencia private para o objeto desta classe.
    //3. Metodo da classe para permitir acesso a instancia.
    private static GerenciadorDeArquivo instancia = null;
    public  static GerenciadorDeArquivo getInstancia() {
        if(instancia == null) {
            instancia = new GerenciadorDeArquivo();
        }
        return instancia;
    }
    //
    private File file;
    private GerenciadorDeArquivo() {
        file = new File("arquivo.txt");
    }

    public void escreverNoArquivo(String texto) throws IOException {
        PrintStream ps = new PrintStream(file);
        ps.println(texto);
        ps.close();
    }

    public String lerDoArquivo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String resposta = "";
        String temp = br.readLine();
        if(temp != null) {
            resposta+= temp;
            temp = br.readLine();
        }
        br.close();
        return resposta;
    }

}
