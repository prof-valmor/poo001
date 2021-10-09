import java.io.*;
import java.net.Socket;

/**
 * MyThread = eh o Antendente. Ouve o client, processa a requisicao e depois
 * responde.
 */
public class MyThread extends Thread {
    private Socket client;
    public MyThread(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        try{
            this.falarComClient();
        }catch(IOException e) {
            System.out.println("Exception na Thread.");
        }
    }
    private void falarComClient() throws IOException {
        InputStream lerDoClient = client.getInputStream();
        OutputStream escreverParaOClient = client.getOutputStream();
        // Lendo o que o cliente quer
        BufferedReader br = new BufferedReader(new InputStreamReader(lerDoClient));
        String request  = br.readLine();
        //  processando o que o cliente pediu.
        String response = ProcessadorDeRequisicoes.processaRequest(request);
        // responder para o cliente.
        PrintStream printStream = new PrintStream(escreverParaOClient);
        printStream.println(response);
        // fechar os streams e o socket.
        br.close();
        printStream.close();
        client.close();
    }

}
