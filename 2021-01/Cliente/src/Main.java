import java.io.*;
import java.net.Socket;

public class Main {
    private static PrintStream printer;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            System.out.println("Criando o socket...");
            socket = new Socket("www.google.com", 80);
            System.out.println("Conectado... " + socket.isConnected());
            escreverParaOGoogle();
            lerDoGoogle();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escreverParaOGoogle() throws IOException {
        String mensagem = "GET / HTTP/1.1";
        PrintStream printer = new PrintStream(socket.getOutputStream());
        printer.println(mensagem);
        printer.println();
        System.out.println("Passou no escrever");
    }

    private static void enviarLogin() throws IOException {
//        String mensagem = "GET / HTTP/1.1";
        String mensagem = "{ \"login\": { \"user-id\": \"colocar aqui o nome do usuario\" } }";
        PrintStream printer = new PrintStream(socket.getOutputStream());
        printer.println(mensagem);
        printer.println();
        System.out.println("Passou no escrever");
    }

    private static void lerDoGoogle() throws IOException {
        if(socket.isConnected()) {
            System.out.println("Lendo do google.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensagem = reader.readLine();
            while (mensagem != null) {
                System.out.println(mensagem);
                mensagem = reader.readLine();
            }
            reader.close();
            System.out.println("termino da leitura");
        }
    }

    private static void escrever(String s) {
        printer.println(s);
    }
}
