import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

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
        ArrayList<Mensagem> array = converterRespostaEmMensagens(resposta);
        if(array == null) return null;
        Mensagem[] response = new Mensagem[array.size()];
        response = array.toArray(response);
        return response;
    }

    private ArrayList<Mensagem> converterRespostaEmMensagens(String json) {
        ArrayList<Mensagem> mensagens = null;
        json = json.substring(json.indexOf("\"mensagens\""));
        if(json.contains("\"mensagens\":[]")) {
            return null;
        }
        else if(json.contains("\"mensagens\":[")) {
            json = json.substring(json.indexOf('{'));
            json = json.substring(0, json.lastIndexOf('}'));
            json = json.substring(0, json.lastIndexOf(']'));
            String[] array = json.split("},");
            System.out.println("array: " + array.length);
            if(array.length == 0) {
                return null;
            }
            mensagens = new ArrayList<>(array.length);
            String remetente = "";
            String destinatario = "";
            String assunto = "";
            String texto = "";

            for(String s : array) {
                s = s.replace("{","");
                s = s.replace("}","");
                s = s.replace("\"", "");
                String a[] = s.split(",");
                String fields[];
                for(String element : a) {
                    fields = element.split(":");

                    if (fields[0].equalsIgnoreCase("remetente"))   remetente    = fields[1];
                    else if (fields[0].equalsIgnoreCase("destinatario")) destinatario = fields[1];
                    else if (fields[0].equalsIgnoreCase("assunto"))      assunto      = fields[1];
                    else if (fields[0].equalsIgnoreCase("texto"))        texto        = fields[1];
                }
                mensagens.add(new Mensagem(remetente, destinatario, assunto, texto));
            }
        }
        return mensagens;
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
        reader.close();
        System.out.println("termino da leitura");
        return resposta;
    }
}
