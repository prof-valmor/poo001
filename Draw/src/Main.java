public class Main {
    public static void main(String args[]) {
        AreaDeDesenho area = new AreaDeDesenho();

        area.add(new Quadrado(10, 15));
        Quadrado q = new Quadrado(10, 15);
        q.setLado(40);
        area.add(q);

        area.add(new Retangulo(23, 33));

        area.add(new TrianguloEquilatero(44, 55));

        area.atualizar();

    }
}
