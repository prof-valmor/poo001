public class FiguraGeometricaFactory {
    public static FiguraGeometrica get(String tipo, int [] args) {
        if(tipo.equalsIgnoreCase("triangulo"))
            return new Triangulo(args[0], args[1]);
        if(tipo.equalsIgnoreCase("retangulo"))
            return new Retangulo(args[0], args[1], args[2], args[3]);
        if(tipo.equalsIgnoreCase("quadrado"))
            return new Quadrado(args[0], args[1], args[2]);

        return null;
    }
}
