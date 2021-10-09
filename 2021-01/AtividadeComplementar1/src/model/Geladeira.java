package model;
/**
 * Representa uma Geladeira conforme o exercicio #1 da Lista #1.
 *
 * @author adami
 * @version 0.1
 */
public class Geladeira extends Thread {
    private int nivelDaTemperatura;
    private Congelador   congelador;
    private Refrigerador refrigerador; 
    
    public Geladeira() {
        nivelDaTemperatura = 0; //0 eh o minimo.
        //instanciar os componentes.
        congelador = new Congelador();
        refrigerador = new Refrigerador();
        start();
    }
    
    //Setter o valor para o nivelDaTemperatura.
    public void selecionarTemperatura(int nivel) {
        nivelDaTemperatura = nivel;
        refrigerador.selecionarTemperatura((nivel+1) * 5);
        congelador.selecionarTemperatura((nivel+1) * - 10);
    }
    //
    public void run() {
        while(true) {
            controlarTemperatura();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void controlarTemperatura() {
        congelador.controlarTemperatura();
        refrigerador.controlarTemperatura();
    }

    public Refrigerador getRefrigerador() {
        return refrigerador;
    }
}
