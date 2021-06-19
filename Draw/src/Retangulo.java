public class Retangulo extends Quadrado {
    private int base;
    public Retangulo(int x, int y) {
        super(x, y);
        base = 50;
    }
    @Override
    public int calcularArea() {
        return base * super.getLado();
    }
}
