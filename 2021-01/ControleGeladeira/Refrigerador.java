
/**
 * Write a description of class Refrigerador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Refrigerador {
    protected float temperaturaSelecionada;
    //
    protected Carga ventilador;
    protected SensorDeTemperatura sensorTemperaturaAtual;
    
    public Refrigerador(){
        ventilador = new Carga();
        sensorTemperaturaAtual = new SensorDeTemperatura();
    }
    
    //Setter para temperatura (Celsius).
    public void selecionarTemperatura(float temperatura) {
        temperaturaSelecionada = temperatura;
    }
    
    public void controlarTemperatura() {
        if(sensorTemperaturaAtual.getTemperaturaAtual() > temperaturaSelecionada) {
            ventilador.ligar();
        }
        else {
            ventilador.desligar();
        }
    }
}












