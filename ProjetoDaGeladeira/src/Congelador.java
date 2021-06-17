public class Congelador extends Refrigerador {
    public Carga compressor;

    public Congelador() {
        super(); // chamando o construtor da classe mae.
        compressor = new Carga();
    }

    public void controlarTemperatura() {
        super.controlarTemperatura();
        if(ventilador.estahLigado()) {
            compressor.ligar();
        }
        else {
            compressor.desligar();
        }
    }
}
