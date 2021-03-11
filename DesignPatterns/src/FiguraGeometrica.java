
/**
 * Write a description of class FiguraGeometrica here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class FiguraGeometrica{
    protected int x;
    protected int y;
    
    public FiguraGeometrica(int x_, int y_){
        x = x_;
        y = y_;
    }
    
    public abstract int calcularArea();
    
}
