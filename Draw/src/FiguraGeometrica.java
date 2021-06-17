public abstract class FiguraGeometrica {
    private int X;
    private int Y;
    private int corDeFundo;
    private int corDaBorda;

    public FiguraGeometrica(int x, int y) {
        X = x;
        Y = y;
        corDeFundo = 0x0000FF; //cor azul.
        corDaBorda = 0x0000FF;
    }
    // podemos adicionar setters and getters para os atributos...
    // criar o metodo abstrato.
    public abstract int calcularArea();
}
