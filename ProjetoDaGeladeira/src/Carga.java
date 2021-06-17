public class Carga {
    private boolean ligado = false;

    public void ligar() {
        ligado = true;
    }

    public void desligar() {
        ligado = false;
    }

    public boolean estahLigado() {
        return ligado;
    }
}
