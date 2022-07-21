import model.GoogleTalker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GoogleTalker talker = new GoogleTalker();
        try {
            talker.conectarNoGoogle();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
