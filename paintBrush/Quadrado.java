
/**
 * Write a description of class Quadrado here.
 *
 * @author adamiv
 * @version (a version number or a date)
 */
public class Quadrado extends FiguraGeometrica{
    protected int lado;   // dimensao
    // metodo contrutor 
    public Quadrado(int x_, int y_, int lado_) {
      super(x_, y_);
      lado = lado_;  
    }
    
    public int calcularArea() {
        return lado * lado;
    }
    // getter.
    public int getX() {
        return x;
    }
}
