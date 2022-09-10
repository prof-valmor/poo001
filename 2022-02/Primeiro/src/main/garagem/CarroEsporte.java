package main.garagem;

public class CarroEsporte extends Carro {
    private boolean acelerando = false;
    private boolean luzInternaLigada = false;

    public CarroEsporte(String marca) {
        super(marca);
        ligar();
    }
    public void ligar() {
        boolean test = false;

        super.ligar();
        acelerando = true;
        luzInternaLigada = true;
    }
    public boolean aLuzInternaEstahLigada() {return luzInternaLigada;}
    public void acelerar(){
        acelerando = true;
    }
    public void frear() {
        acelerando = false;
    }
}
