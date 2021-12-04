package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    ArrayList<Client> clients = new ArrayList<>();
    ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private void cadastrarClient(Socket client) throws IOException {
        InputStream is = client.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String clientId = reader.readLine();
        clients.add(clientId);
        //
        System.out.println();
        System.out.println("=====IDS=====");
        for(String id : clients) {
            System.out.println(id);
        }
    }

    public void run() {
        try {
            do {
                Socket client = serverSocket.accept();
                System.out.println("IP: " + client.getInetAddress().getHostAddress());
                cadastrarClient(client);
            }while(true);
        }catch(IOException exception) {
            System.out.println(exception);
        }
    }
}
