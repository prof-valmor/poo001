import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Criando o socket...");
            Socket socket = new Socket("10.0.0.108", 7070);
            System.out.println("Conectado... " + socket.isConnected());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
