package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GReader extends Thread {
    private final InputStream input;
    private ArrayList <ListenerDoGReader> arrayDeListeners;

    public GReader(InputStream inputStream) {
        this.input = inputStream;
        arrayDeListeners = new ArrayList<>(1);
    }

    public void setListener(ListenerDoGReader listener) {
        if(!arrayDeListeners.contains(listener)){
            arrayDeListeners.add(listener);
        }
    }

    @Override
    public void run() {
        try {
            String resposta = lerAResposta();
            for (ListenerDoGReader g : arrayDeListeners) {
                g.chegouAResposta(resposta);
            }
        } catch (IOException e) {
            System.out.println("...Erro ao ler a resposta...");
        }
    }

    private String lerAResposta() throws IOException {
        InputStreamReader ir = new InputStreamReader(this.input);
        BufferedReader br = new BufferedReader(ir);
        String resposta = "";
        String linha = br.readLine();
        while (linha != null) {
            resposta += (linha + "\n");
            linha = br.readLine();
        }
        return(resposta);
    }
}
