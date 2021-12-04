package model;

import java.io.*;
import java.net.Socket;

public class Navegador extends Thread {     // ATENCAO: o Navegador virou uma Thread.
    Socket clientSocket;
    InputStream is;
    OutputStream os;
    String url;
    private NavegadorListener listener;

    public Navegador(String url) {
        this.url = url;
    }

    public void setListener(NavegadorListener listener) {
        this.listener = listener;
    }

    private String ler() throws IOException {
        String cabecalho = "GET / HTTP/1.1";
        String response = "";
        // Escrevendo para o servidor sobre o que eu quero.
        PrintStream pw = new PrintStream(os);
        pw.println(cabecalho);
        pw.println();
        //Lendo a resposta.
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader breader = new BufferedReader(reader);
        String linha;
        do {
            linha = breader.readLine();
            if(linha != null) {
                response = response + linha;
                response += "\n";
            }
            else {
                response = "time-out";
            }
        } while(linha != null);

        pw.close();
        reader.close();
        return response;
    }
    // ATENCAO: o run() eh executado depois que o start() foi chamado. Quando a leitura termina, chamamos o listener.
    public void run() {
        // nosso codigo.
        try {
            clientSocket = new Socket(url, 80); // 80 = http. 443 https
            is = clientSocket.getInputStream();
            os = clientSocket.getOutputStream();

            String response = this.ler();

            if(this.listener != null) {
                listener.aRespostaChegou(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
