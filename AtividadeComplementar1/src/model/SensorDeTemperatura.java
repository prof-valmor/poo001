package model;

import java.util.Random;

/**
 * Representa um componente eletronico que fornece a temperatura
 * ambiente (dentro do compartimento)
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SensorDeTemperatura extends Thread {
    private float temperaturaAtual;

    public SensorDeTemperatura() {
        start();
    }
    
    public float getTemperaturaAtual() {
        return temperaturaAtual;
    }

    public void run() {
        while(true) {
            temperaturaAtual = (new Random()).nextFloat() * 10;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
