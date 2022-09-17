package entidades;

public class Geladeira {
    private Refrigerador refri;
    private Congelador cong;
    //private Congelador congelador;
    private int nivelDaTemperatura;
    public Geladeira() {
        refri = new Refrigerador();
        cong  = new Congelador();
        refri.selecionarTemperatura(3.0f);
    }
    public void selecionarTemperatura(int n) {
        if(n == 0 || n == 1 || n == 2)
            nivelDaTemperatura = n;
        else
            nivelDaTemperatura = 0;
        //MIN = mais gelado.
        if(n == 0) refri.selecionarTemperatura(3.0f);
        if(n == 1) refri.selecionarTemperatura(5.75f);
        if(n == 2) refri.selecionarTemperatura(9.0f);
    }
    public void controlarTemperatura() {
        refri.controlarTemperatura();
        cong.controlarTemperatura();
    }
}
