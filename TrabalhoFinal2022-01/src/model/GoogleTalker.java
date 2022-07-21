package model;

import java.io.IOException;
import java.net.Socket;

public class GoogleTalker implements ListenerDoGReader {
    private GReader reader;
    private GWriter writer;
    private Socket socket;      // precisamos do socket para conectar a um servidor.

    public GoogleTalker() {
        System.out.println(">> Criando um objeto GoogleTalker.");
    }

    /**
     * vamos usar este método para iniciar a conexão e se nao ocorrer excessao,
     * criaremos o reader e o writer.
     * @throws IOException
     */
    public void conectarNoGoogle() throws IOException {
        socket = new Socket("google.com", 80);
        // ^ a linha acima tenta realizar operacoes que podem falhar, por isso ...
        // ... precisamos usar um try-catch em torno dela, ou usar o throws na ...
        // ...declaração do método para que a excessao seja tratada por quem usa nosso ...
        // ...metodo.
        // Abaixo vamos criar as classes q vao escrever para o google e ler a resposta.
        writer = new GWriter(socket.getOutputStream());
        reader = new GReader(socket.getInputStream());
        // as linhas abaixo são uma dica...
        writer.start();
        reader.start();
        // Criando um listener para resposta e atribuindo ao reader
        reader.setListener(this);
        //Aqui podemos usar o HttpHelper para nos dizer o q escrever para o google...
        writer.escrevaParaOGoogle(HttpHelper.oQueEscrever());
    }

    @Override
    public void chegouAResposta(String s) {
        System.out.println(s);
    }
}
