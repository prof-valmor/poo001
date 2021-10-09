import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Servidor {
    ServerSocket serverSocket;
    private boolean ligado = true;
    private int contador = 0;

    public Servidor() throws IOException {
        serverSocket = new ServerSocket(2984);
        // Codigo de exemplo de Timer e TimerTask.
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask: " + contador++);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, 1000);
    }
    public void desligar() {
        ligado = false;
    }
    public void ligar() {
        ligado = true;
    }

    public void aguardaConexoes() throws IOException {
        do {
            Socket client = serverSocket.accept();
            System.out.println("Client conectou: " + client.getInetAddress());
            MyThread atendeClient = new MyThread(client);
            atendeClient.start();
        } while(ligado == true);
    }
}
