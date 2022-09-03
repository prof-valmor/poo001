package Main;

public class Main {
    public static void main(String[] args) {
        Leitor leitor           = new Leitor();
        Calculadora calculadora = new Calculadora();
        Impressora impressora   = new Impressora();

        System.out.println("Digite 2 inteiros");
        int [] intervalo = leitor.lerDoisNumerosInteiros();
        int [] listaDeNumerosPrimos = calculadora.encontrarPrimosNo(intervalo);
        impressora.imprimir(listaDeNumerosPrimos);
    }
}
