package entidades;

public class Carga {
    private boolean ligado;
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
