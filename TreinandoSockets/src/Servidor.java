import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    ServerSocket serverSocket;

    public Servidor() throws IOException {
        serverSocket = new ServerSocket(2984);
    }

    public void run() throws IOException {
        Socket client = serverSocket.accept();
        InputStream lerDoClient = client.getInputStream();
        OutputStream escreverParaOClient = client.getOutputStream();
        // Lendo o que o cliente quer
        BufferedReader br = new BufferedReader(new InputStreamReader(lerDoClient));
        String request  = br.readLine();
        //  processando o que o cliente pediu.
        String response = "invalid";
        if(request.equalsIgnoreCase("getName")) {
            response = "valmor";
        }
        // responder para o cliente.
        PrintStream printStream = new PrintStream(escreverParaOClient);
        printStream.println(response);
    }
}
