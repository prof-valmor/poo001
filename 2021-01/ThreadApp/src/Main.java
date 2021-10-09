public class Main {
    public static void main(String args[]) {
        System.out.println("Teste 123");

        long initialTime = System.currentTimeMillis();

        ContagemThread t1, t2, t3;

        t1 = new ContagemThread("Contador A");
        t2 = new ContagemThread("Contador B");
        t3 = new ContagemThread("Contador C");

        t1.start();
        t2.start();
        t3.start();

//        fazerContagem("Contador A");
//        fazerContagem("Contador B");
//        fazerContagem("Contador C");

        long demora = System.currentTimeMillis() - initialTime;
        System.out.println("Main Demorou: " + demora + " ms");
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("A Demorou: " + t1.demora + " ms");
//        System.out.println("B Demorou: " + t2.demora + " ms");
//        System.out.println("C Demorou: " + t3.demora + " ms");
    }

    private static void fazerContagem(String nome) {
        int contador = 0;
        for(int i = 0; i < 1000000; i++) {
            contador++;
            System.out.println(nome + ") Contando: " + contador);
        }
    }
}
