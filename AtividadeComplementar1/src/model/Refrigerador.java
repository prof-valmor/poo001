package model;

import java.util.ArrayList;

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
    //
    private RefrigeradorListener listener;
    private float temperaturaAtual;
    private float temperaturaAnterior;
    //
    public Refrigerador(){
        ventilador = new Carga();
        sensorTemperaturaAtual = new SensorDeTemperatura();
    }
    
    //Setter para temperatura (Celsius).
    public void selecionarTemperatura(float temperatura) {
        temperaturaSelecionada = temperatura;
    }

    public void setListener(RefrigeradorListener listener) {
        this.listener = listener;
    }
    public void controlarTemperatura() {
        // verificando se precisamos chamar o listener.
        temperaturaAtual = sensorTemperaturaAtual.getTemperaturaAtual();
        if(temperaturaAtual != temperaturaAnterior) {
            temperaturaAnterior = temperaturaAtual;
            if(listener != null)
                listener.aTemperaturaMudou(temperaturaAtual);
        }
        //Logica de controle.
        if(sensorTemperaturaAtual.getTemperaturaAtual() > temperaturaSelecionada) {
            ventilador.ligar();
        }
        else {
            ventilador.desligar();
        }
    }
}












