import java.io.IOException;

public class MainParaOServidor {
    public static void main(String args[]) {
        Servidor s = null;
        try {
            s = new Servidor();
            s.aguardaConexoes();

        }
        catch(IOException e) {
            System.out.println("Exception no Main!");
        }
    }
}
