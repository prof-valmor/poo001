package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 1. Fazer Conexao.
 * 2. Escrever a requisicao.
 * 3. Ler a resposta.
 * 4. Fechar a Conexao.
 */
public class OmDBManager {
    private Socket socket;

    public void fazerConexao() throws IOException {
        socket = new Socket("https://www.omdbapi.com", 80);
    }

    public void fecharConexao() throws IOException {
        socket.close();
    }

    public void escreverARequisicao(String requisicao) throws IOException {
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println(requisicao);
    }

    public String lerAResposta() {
        String response = null;
        try {
           response = lendoDoSocketUsandoBufferedReader();
        } catch (IOException e) {
            System.out.println("Erro na leitura da resposta: " + e.getMessage());
        }
        return response;
    }

    private String lendoDoSocketUsandoBufferedReader() throws IOException {
        InputStreamReader ir = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(ir);
        String response = br.readLine();
        return response;
    }
}
