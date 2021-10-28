public class Geladeira {
    private int temperaturaSelecionada;
    private Congelador meuCongelador;
    private Refrigerador meuRefrigerador;
    // metodo construtor
    public Geladeira() {
        meuCongelador = new Congelador();
        meuRefrigerador = new Refrigerador();
        mudarTemperatura(0);
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
