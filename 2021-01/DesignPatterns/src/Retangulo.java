
/**
 * Write a description of class Retangulo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Retangulo extends Quadrado {
    private int comprimento;
    
    public Retangulo(int x_, int y_, int altura_, int comprimento_) {
       super(x_, y_, altura_);
       comprimento = comprimento_;
    }
    
    public int calcularArea() {
        return lado * comprimento;
    }
}
