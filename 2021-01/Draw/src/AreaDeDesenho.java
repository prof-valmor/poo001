import java.util.ArrayList;

public class AreaDeDesenho {
    //representar a agregacao:
    private ArrayList<FiguraGeometrica> lista = new ArrayList<FiguraGeometrica>();

    public void add(FiguraGeometrica fg) {
        lista.add(fg);
    }
    public void delete(FiguraGeometrica fg) {
        lista.remove(fg);
    }
    //vamos apenas imprimir as areas das figuras geometricas contidas no array.
    public void atualizar() {
        int area;
        for(FiguraGeometrica f : lista) {
            area = f.calcularArea();
            System.out.println("A area de " + f + " eh: " + area);
        }
    }
}
