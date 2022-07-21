package model;

import java.io.OutputStream;
import java.io.PrintStream;

public class GWriter extends Thread {
    private final OutputStream output;
    private String mensagemParaEscrever = "";   // iniciando com mensagem em branco.
    public GWriter(OutputStream outputStream) {
        this.output = outputStream;
    }

    public void escrevaParaOGoogle(String oQueEscrever) {
        mensagemParaEscrever = oQueEscrever;
    }

    @Override
    public void run() {
        try {
            esperarParaEscrever();
        } catch (InterruptedException e) {
            System.out.println("Erro esperando para escrever.");
        }
        escrever();
        mensagemParaEscrever = "";
    }

    private void escrever() {
        if(mensagemParaEscrever != null && !mensagemParaEscrever.isEmpty()) {
            PrintStream ps = new PrintStream(output);
            String[] linhas = mensagemParaEscrever.split("/n");
            for(String s : linhas){
                ps.println(s);
            }
        }
    }

    private void esperarParaEscrever() throws InterruptedException {
        while(mensagemParaEscrever.isEmpty()) {
            sleep(1000);
        }
    }
}
