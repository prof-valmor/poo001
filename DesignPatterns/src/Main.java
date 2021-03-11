import java.io.IOException;

public class Main {

    public static void main (String args[]) {
        //usandoSingleton();
        //
        FiguraGeometrica mae = FiguraGeometricaFactory.get("quadrado", new int[]{1,2,3});
        int area = mae.calcularArea();
        System.out.println("Area do quadrado " + area);

        mae = FiguraGeometricaFactory.get("retangulo", new int[]{4,5,6,7});
        area = mae.calcularArea();
        System.out.println("Area do retangulo " + area);
    }




    public static void usandoSingleton() {
        GerenciadorDeArquivo g4 = GerenciadorDeArquivo.getInstancia();
        GerenciadorDeArquivo g5 = GerenciadorDeArquivo.getInstancia();

        //
        try {
            GerenciadorDeArquivo.getInstancia().escreverNoArquivo("G4 escrevendo...");
            g5.escreverNoArquivo("G5 escrevendo...");
            String mensagem = GerenciadorDeArquivo.getInstancia().lerDoArquivo();
            System.out.println("Mensagem: " + mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
