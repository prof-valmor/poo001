package modelo;

public class Congelador extends Refrigerador {
    private Compressor meuCompressor;

    public Congelador() {
        meuCompressor = new Compressor();
    }
    @Override
    public void controlarTemperatura() {
        if(meuSensor.getTemperaturaAtual() > temperaturaDeControle) {
            meuCompressor.ligar();
            meuVentilador.ligar();
        }
        else {
            meuCompressor.desligar();
            meuVentilador.desligar();
        }
    }
}
