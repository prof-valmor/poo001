public class Main {
    public static void main(String args[]) {
       Carro meuCarro = new Carro();
       System.out.println("primeiro carro: "+ meuCarro);

       System.out.println("A km eh: " + meuCarro.qualAKm());
       meuCarro.incrementarKm();
       meuCarro.incrementarKm();

       System.out.println("A nova km eh: " + meuCarro.qualAKm());
       meuCarro.placa = "mda1830";


       System.out.println("primeiro carro de novo: "+ meuCarro);


    }
}
