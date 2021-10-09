
public class ContagemThread extends Thread {
    private String nomeDaThread;
    public long demora = 0;

    public ContagemThread(String nome) {
        super();
        nomeDaThread = nome;
    }

    public void run() {
        long initialTime = System.currentTimeMillis();

        int contador = 0;

        for(int i = 0; i < 1000000; i++) {
            contador++;
           System.out.println(nomeDaThread + ") Contando: " + contador);
            try {
                sleep(0, 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        demora = System.currentTimeMillis() - initialTime;
        System.out.println(nomeDaThread + " Demorou: " + demora + " ms");
    }
}
