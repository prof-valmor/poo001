public class Refrigerador {
    protected float temperaturaSelecionada;
    public Carga ventilador;
    private SensorDeTemperatura sensor;

    public Refrigerador() {
        ventilador = new Carga();
        sensor     = new SensorDeTemperatura();
    }

    public void selecionarTemperatura(float temperaturaRefrigerador) {
        temperaturaSelecionada = temperaturaRefrigerador;
    }

    public void controlarTemperatura() {
        if(sensor.getTemperaturaAtual() > temperaturaSelecionada) {
            ventilador.ligar();
        }
        else {
            ventilador.desligar();
        }
    }
}
