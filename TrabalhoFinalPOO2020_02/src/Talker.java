import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Fala com o Servidor. Suas responsabilidades sao:
 *
 *  - criar o socket
 *  - saber o que precisa ser escrito.
 *  - fazer a leitura da resposta.
 *  - disponibilizar a resposta para o resto da aplicação.
 *
 *  Ela sera Singleton para evitar multiplas instancias e tb concorrencia de acessos ao Socket.
 */
public class Talker {
    // ------------------------
    // Fazendo a classe Singleton.
    private static Talker instance;
    private Socket socket;

    public static Talker getInstance() {
        if(instance == null) {
            instance = new Talker();
        }
        return instance;
    }

    private Talker() {
    }
    //----------------
    public String login(String user) {
        String mensagem = "{ \"login\": { \"user-id\": \"" + user +"\" } }";
        String resposta = null;
        System.out.println(mensagem);
        try {
            abrirSocket();
            escreverParaOServidor("login", mensagem);
            resposta = lerRespostaDoServidor();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposta;
    }

    public Mensagem[] getMensagens(String user) {
        String mensagem = "{ \"get\": { \"user-id\": \"" + user +"\" } }";
        String resposta = null;
        System.out.println(mensagem);
        try {
            abrirSocket();
            escreverParaOServidor("get", mensagem);
            resposta = lerRespostaDoServidor();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Array: " + resposta);
        //

        //TODO converter resposta para o Array.
        Mensagem m1 = new Mensagem("aluno1","aluno2","prova","adaddadasdas");
        Mensagem m2 = new Mensagem("aluno2","aluno1","re:prova","adaddadasdas");
        Mensagem m3 = new Mensagem("aluno1","aluno2","prova","teste123");
//        Mensagem[] array = new Mensagem[]{m1, m2, m3};
        Mensagem[] array = converterRespostaEmMensagens(resposta);
        return array;
    }

    private Mensagem[] converterRespostaEmMensagens(String resposta) {

        /**
         * {
         *   "mensagens": [
         *     {
         *       "_id": "3d1e6c9c17eceb2397bfe7c85ef6141f",
         *       "_rev": "1-c2ff1ef129907abd73f2e61c8f3e65b3",
         *       "remetente": "Usuario1",
         *       "destinatario": "Valmor",
         *       "assunto": "exemplo",
         *       "texto": "enviandoumamensagem"
         *     },
         *     {
         *       "_id": "ae029ba8f19e5cdf947d398ffe736e15",
         *       "_rev": "1-d3c92bdcdd30c40fcd75f5e16615e5bb",
         *       "remetente": "Usuario1",
         *       "destinatario": "Valmor",
         *       "assunto": "exemplo",
         *       "texto": "enviando uma mensagem"
         *     }
         *   ]
         * }
         */

    }

    private void abrirSocket() throws IOException {
        System.out.println("Criando o socket...");
        socket = new Socket("catolicasc-bigdata-valmor123.mybluemix.net", 80);
        System.out.println("Conectado... " + socket.isConnected());
    }
    /**
     *
     * @param user eh o usuario da aplicacao, ou seja o rementente.
     * @param destinatario
     * @param assunto
     * @param texto
     * @return
     */
    public String enviarMensagem(String user, String destinatario, String assunto, String texto) {
        String mensagem = "{ \"send\": { \"remetente\": \"" + user + "\", \"destinatario\": \""+ destinatario +"\", \"assunto\": \""+assunto+"\", \"texto\": \""+texto+"\" } }";
        String resposta = null;
        try {
            abrirSocket();
            escreverParaOServidor("send", mensagem);
            resposta = lerRespostaDoServidor();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposta;
    }

    private void escreverParaOServidor(String what, String mensagem) throws IOException {
        PrintStream printer = new PrintStream(socket.getOutputStream());
        mensagem = mensagem.replace(" ", "%20");

        printer.println("GET /" + what + "?json="+mensagem+ " HTTP/1.1");
        System.out.println("GET /" + what + "?json="+mensagem+" HTTP/1.1");
        printer.println("Host: catolicasc-bigdata-valmor123.mybluemix.net");
        printer.println("Accept: */*");
        printer.println("Connection: Close");

        printer.println();
        System.out.println("Passou no escrever");
    }
    private String lerRespostaDoServidor() throws IOException {
        String resposta = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String linha = reader.readLine();
        while (linha != null) {
            resposta += linha;
            System.out.println(linha);
            linha = reader.readLine();
        }
        //TODO tratar a mensagem e devolver apenas o json.
        reader.close();
        System.out.println("termino da leitura");
        return resposta;
    }
}
