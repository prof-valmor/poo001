import java.net.Socket;

public class Conversador extends Thread {
    private Socket cliente;
    boolean isRunning = false;

    public Conversador(Socket alguem) {
        cliente = alguem;
        System.out.println("Conversador" + this.getName());
        isRunning = true;
    }
    // Aqui vamos fazer a leitura e a escrita... a conversa acontece aqui.
    public void run() {
        String mensagem = "";
        while(isRunning) {

            //
            if(mensagem.equalsIgnoreCase("sair")){
                isRunning = false;
            }
        }
    }
}
