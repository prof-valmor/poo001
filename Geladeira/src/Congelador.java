public class Congelador extends Refrigerador {

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
