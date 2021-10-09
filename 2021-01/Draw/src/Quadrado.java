public class Quadrado extends FiguraGeometrica {

    private int lado;

    public Quadrado(int x, int y) {
        super(x, y);
        lado = 30;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
    public int getLado() {
        return lado;
    }

    @Override
    public int calcularArea() {
        return lado*lado;
    }
}
