package modelo;

public class Refrigerador {
    protected float temperaturaDeControle;
    protected Sensor meuSensor;
    protected Ventilador meuVentilador;

    public Refrigerador() {
        meuSensor = new Sensor();
        meuVentilador = new Ventilador();
    }

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
