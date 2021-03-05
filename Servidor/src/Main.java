import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String []args) {
        ArrayList<Conversador> listaDeConversadores = new ArrayList<>(1);
        ServerSocket serverSocket = null;
        try {
            System.out.println("Criando o socket...");
            serverSocket = new ServerSocket(7070);
            System.out.println("Socket criado...");

            while(true) {
                System.out.println("Esperando conexao...");
                Socket maquinaCliente = serverSocket.accept();
                Conversador c = new Conversador(maquinaCliente);
                c.start();
                listaDeConversadores.add(c);
                System.out.println("A maquina que conectou tem o ip: " + maquinaCliente.getInetAddress());
            }
//            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
