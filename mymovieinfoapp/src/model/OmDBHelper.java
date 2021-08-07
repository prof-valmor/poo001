package model;

import java.io.IOException;

/**
 * Requisitar os dados do filme.
 *
 *   type: 'GET',
 *                 dataType: 'text',
 *                 url: '/?' + c + '&token=' + t,
 */
public class OmDBHelper {

    public void requisitarDadosDoFilme(String nomeDoFilme) {
        String requisicao = "GET / HTTP/1.1\n" +
                "url: /?t=" + nomeDoFilme + "&apikey=aqui vai a sua key." ;

        OmDBManager manager = new OmDBManager();
        try {
            manager.fazerConexao();
            manager.escreverARequisicao(requisicao);
            String response = manager.lerAResposta();
            manager.fecharConexao();

            System.out.println("TESTE: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
