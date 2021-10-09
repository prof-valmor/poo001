package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.util.List;

/**
 * 1. Fazer Conexao.
 * 2. Escrever a requisicao.
 * 3. Ler a resposta.
 * 4. Fechar a Conexao.
 */
public class OmDBConnectionManager {
    private Socket socket;

    public String requisitarDados(List<String> requisicao) throws IOException {
        String response = null;
        fazerConexao();
        escreverARequisicao(requisicao);
        response = lerAResposta();
        fecharConexao();
        return response;
    }

    public void fazerConexao() throws IOException, UnknownHostException {
        socket = new Socket("www.omdbapi.com", 80);
    }

    public void fecharConexao() throws IOException {
        socket.close();
    }

    public void escreverARequisicao(List<String> requisicao) throws IOException {
        PrintStream ps = new PrintStream(socket.getOutputStream());

        for(String item : requisicao) {
            ps.println(item);
        }
        ps.println();
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
        String resposta = "";
        String linha = br.readLine();
        while (linha != null) {
            resposta += (linha + "\n");
            linha = br.readLine();
        }
        return resposta;
    }
}
