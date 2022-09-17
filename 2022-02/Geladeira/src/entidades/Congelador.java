package entidades;

public class Congelador extends Refrigerador{
    public Carga compressor = new Carga();
    @Override
    public void controlarTemperatura() {
        super.controlarTemperatura();
        if(sensor.getTemperaturaAtual() > temperaturaSelecionada)
            compressor.ligar();
        else
            compressor.desligar();
    }
}
