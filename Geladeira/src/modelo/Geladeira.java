package modelo;

import java.util.Timer;
import java.util.TimerTask;

public class Geladeira {
    private int temperaturaSelecionada;
    private Congelador meuCongelador;
    private Refrigerador meuRefrigerador;
    private Timer timer;

    // metodo construtor
    public Geladeira() {
        meuCongelador = new Congelador();
        meuRefrigerador = new Refrigerador();
        mudarTemperatura(0);
        //
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                controlarTemperatura();
                System.out.println("CONTROLANDO TEMPERATURA");
            }
        }, 0, 1000);
    }

    public void mudarTemperatura(int novaTemperatura) {
        temperaturaSelecionada = novaTemperatura;
        //convertendo a temperaturaSelecionada para valores reais.
        float temperaturaDeControle = novaTemperatura * -10;
        meuCongelador.setTemperatura(temperaturaDeControle);
        temperaturaDeControle = novaTemperatura + 3;
        meuRefrigerador.setTemperatura(temperaturaDeControle);
    }
    public int getTemperaturaSelecionada(){
        return temperaturaSelecionada;
    }
    public void controlarTemperatura() {
        meuRefrigerador.controlarTemperatura();
        meuCongelador.controlarTemperatura();
    }
}
