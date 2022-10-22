public class Quadrado {
    private double medidaLados;
    public Quadrado(double medidaLados) {
        this.medidaLados = medidaLados;
    }
    public void setMedidaLados(double medida) {
        medidaLados = medida;
    }
    public double getMedidaLados() {
        return medidaLados;
    }
    public double getArea() {
        return (medidaLados * medidaLados);
    }
}
