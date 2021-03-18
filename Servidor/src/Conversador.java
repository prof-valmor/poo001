import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Conversador extends Thread {
    private Socket cliente;
    private boolean isRunning = false;
    private BufferedReader reader;

    public Conversador(Socket alguem) {
        cliente = alguem;
        System.out.println("Conversador" + this.getName());
        isRunning = true;
    }
    // Aqui vamos fazer a leitura e a escrita... a conversa acontece aqui.
    public void run() {
        try {
            conversar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void conversar() throws Exception {
        String mensagem = "";
        reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        int contador = 0;
        while(isRunning) {
            mensagem = reader.readLine();
            System.out.println("Mensagem " + (++contador) + " eh: " + mensagem);
            //
            if(mensagem.equalsIgnoreCase("sair")){
                isRunning = false;
            }
        }
        //
        System.out.println("Conversador fechando..." + this.getName());
        //
        cliente.close();
    }
}
