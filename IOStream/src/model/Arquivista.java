package model;

import java.io.*;

public class Arquivista {
    public static Arquivista instance;
    //Singleton
    private Arquivista() {

    }
    public static Arquivista getInstance() {
        if(instance == null) instance = new Arquivista();
        return instance;
    }

    public String recuperarConteudoDoArquivo(String nome) throws FileNotFoundException, IOException {
        String response = "";
        FileReader fread = new FileReader(nome);
        BufferedReader breader = new BufferedReader(fread);
        String linha;
        do {
            linha = breader.readLine();
            if(linha != null) {
                response = response + linha;
                response += "\n";
            }
        } while(linha != null);

        return response;
    }

    public void salvarConteudoEmArquivo(String conteudo, String nome) throws FileNotFoundException {
        FileOutputStream fout = new FileOutputStream(nome, false);
        PrintWriter pw = new PrintWriter(fout);
        pw.println(conteudo);
        pw.close();
    }
}
