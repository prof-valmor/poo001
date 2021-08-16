package model;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Requisitar os dados do filme.
 *
 *   type: 'GET',
 *                 dataType: 'text',
 *                 url: '/?' + c + '&token=' + t,
 */
public class OmDBHelper {
    private String nomeDoFilme;
    private OmDBHelperListener listener;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(nomeDoFilme != null) {
                String dadosDoFilme = pedirDadosDoFilmeUsandoConnectionManager(nomeDoFilme);
                if(listener != null)
                    listener.chegaramOsDadosDoFilme(dadosDoFilme);
            }
            System.out.println("Final do Runnable");
        }
    };

    public OmDBHelper() {
        nomeDoFilme = null;
    }

    public void setListener(OmDBHelperListener listener) {
        this.listener = listener;
    }

    /**
     * Metodo que dispara a thread para solicitar os dados do filme ao servidor.
     * @param nome nome do filme.
     */
    public void requestFilmeByName(String nome) {
        this.nomeDoFilme = nome;
        (new Thread(runnable)).start();
    }

    private String pedirDadosDoFilmeUsandoConnectionManager(String nomeDoFilme) {
        List<String> requisicao = montarRequisicao(nomeDoFilme);
        String response = chamandoOConnectionManager(requisicao);
        return limparCabecalho(response);
    }

    private String limparCabecalho(String response) {
        int posicaoDaChave = response.indexOf('{');
        response = response.substring(posicaoDaChave);
        return response;
    }

    private String chamandoOConnectionManager(List<String> requisicao) {
        String response = null;
        OmDBConnectionManager manager = new OmDBConnectionManager();
        try {
            response = manager.requisitarDados(requisicao);
        } catch (IOException e) {
            System.out.println("Excessao: " + e.getMessage());
        }

        return response;
    }

    private List<String> montarRequisicao(String nomeDoFilme) {
        ArrayList<String> requisicao = new ArrayList<>(1);
        // trocando espacos por +
        nomeDoFilme = nomeDoFilme.replace(' ', '+');
        // montando a requisicao.
        requisicao.add("GET /?t=" + nomeDoFilme + "&apikey=130637f6 HTTP/1.0");
        requisicao.add("Host: www.omdbapi.com");
        return requisicao;
    }

}
