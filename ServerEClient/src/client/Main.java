package client;

import server.Server;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        try {
            Client c = new Client("valmor","localhost", 4443);
            c = new Client("arthur","localhost", 4443);
            c = new Client("carlos","localhost", 4443);
            c = new Client("eduardo he","localhost", 4443);
            c = new Client("eduardo raf","localhost", 4443);
            c = new Client("gustavo","localhost", 4443);
            c = new Client("wagner","localhost", 4443);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
