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
            escreverParaOServidor(mensagem);
            resposta = lerRespostaDoServidor();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposta;
    }

    public String getMensagens(String user) {
        String mensagem = "{ \"get\": { \"user-id\": \"" + user +"\" } }";
        String resposta = null;
        System.out.println(mensagem);
        try {
            abrirSocket();
            escreverParaOServidor(mensagem);
            resposta = lerRespostaDoServidor();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposta;
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
        String resposta = "";
//        abrirSocket();
//        escrever(mensagem);
//        String resposta = ler();
        return resposta;
    }

    private void escreverParaOServidor(String mensagem) throws IOException {
        PrintStream printer = new PrintStream(socket.getOutputStream());
        printer.println(mensagem);
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
        reader.close();
        System.out.println("termino da leitura");
        return resposta;
    }
}
