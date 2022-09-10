package main.garagem;

public class Carro {
    protected String marca;
    private boolean ligado;

    public Carro(String marca) {
        this.marca = marca;
    }
    public void ligar(){ ligado = true;}
    public void desligar() { ligado=false;}
    public boolean estahLigado() {return ligado; }
//    public void setMarca(String m) {
//        marca = m;
//    }
    public String getMarca() {return marca;}
}
