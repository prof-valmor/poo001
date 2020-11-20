
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
public class Main {
   public static void main(String[] args) {
       Quadrado q = new Quadrado(3, 4, 10);
       Quadrado q1 = new Quadrado(10, 5, 50);
       
       Retangulo r = new Retangulo(10, 10, 20, 30);
       
       Triangulo t = new Triangulo(45, 45);     
//       Generics
       ArrayList<FiguraGeometrica> lista = new ArrayList<FiguraGeometrica>();
       lista.add(q);
       lista.add(q1);
       lista.add(r);
       lista.add(t);
       //foreach
       for(FiguraGeometrica g : lista) {
           System.out.println("--> Area da figura[" + g + "]: " + g.calcularArea());
        }
       //
       //for(int i = 0; i < lista.size(); i++) {
       //    FiguraGeometrica g = lista.get(i);
       //    System.out.println("Area da figura[" + i + "]: " + g.calcularArea());
       // }
        
        
       //System.out.println("Area do q: " + q.calcularArea());
       //System.out.println("Area do q1: " + q1.calcularArea());
       //System.out.println("Area do r: " + r.calcularArea());
       //System.out.println("Area do t: " + t.calcularArea());
   }
}
