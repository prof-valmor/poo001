package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public Client(String id, String localhost, int port) throws IOException {
        Socket s = new Socket(localhost, port);
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println(id);
        ps.close();
    }
}
