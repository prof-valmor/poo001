package entidades;

public class Refrigerador {
    // Objetos que vao compor o refrigerador.
    protected SensorDeTemperatura sensor;
    protected Carga ventilador;
    // Atributos.
    protected float temperaturaSelecionada; //temperatura de controle.
    //Construtor
    public Refrigerador() {
        sensor = new SensorDeTemperatura();
        ventilador = new Carga();
    }
    public void selecionarTemperatura(float temperatura) {
        temperaturaSelecionada = temperatura;
    }
    public void controlarTemperatura() {
        if(sensor.getTemperaturaAtual() > temperaturaSelecionada)
            ventilador.ligar();
        else
            ventilador.desligar();
    }
}
