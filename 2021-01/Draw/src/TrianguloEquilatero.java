public class TrianguloEquilatero extends Retangulo {
    public TrianguloEquilatero(int x, int y) {
        super(x, y);
    }

    public int calcularArea() {
        return super.calcularArea()/2;
    }
}
