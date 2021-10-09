public class Carro {
    public String placa;
    private int km;

    public void incrementarKm() {
        km++;
    }
    public int qualAKm() {
        return km;
    }

    public String toString() {
        return placa + " km:" + km;
    }
}
