public class Main {
    public static void main(String args[]) {
        System.out.println("Iniciando o Main...");

        //GerenciadorJanelas.mostrarJanela(GerenciadorJanelas.JANELA1);
        GerenciadorJanelas gerenciador = new GerenciadorJanelas();
        gerenciador.mostrarJanela(GerenciadorJanelas.JANELA1);

        System.out.println("Terminando o Main...");
    }
}
