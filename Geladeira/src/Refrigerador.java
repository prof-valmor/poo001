public class Refrigerador {
    private float temperaturaDeControle;

    public void setTemperatura(float temperaturaDeControle) {
        this.temperaturaDeControle = temperaturaDeControle;
    }

    public void controlarTemperatura() {
        if(meuSensor.getTemperaturaAtual() > temperaturaDeControle) {
            meuVentilador.ligar();
        }
        else {
            meuVentilador.desligar();
        }
    }
}
