import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Quadrado q, q1;
        q = new Quadrado(4.34);
        System.out.println("area Q " + q.getArea());
        q1 = new Cubo(8);
        System.out.println("area Q1: " + q1.getArea());

    }
}
