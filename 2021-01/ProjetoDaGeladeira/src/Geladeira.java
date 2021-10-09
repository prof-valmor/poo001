public class Geladeira {
    private int nivelDaTemperatura;
    private Congelador meuCongelador;
    private Refrigerador meuRefrigerador;

    public Geladeira() {
        meuCongelador   = new Congelador();
        meuRefrigerador = new Refrigerador();
    }
    // 0 - min, 1 - med, 2 - max
    public void selecionarTemperatura(int nivel) {
        nivelDaTemperatura = nivel;
        float temperaturaRefrigerador = 0f;
        float temperaturaCongelador   = 0f;
        //
        switch(nivel) {
            case 0:
                temperaturaCongelador   = -28.0f;
                temperaturaRefrigerador = 2.5f;
                break;
            case 1:
                temperaturaCongelador   = -22.25f;
                temperaturaRefrigerador = 5f;
                break;
            case 2:
                temperaturaCongelador   = -18.0f;
                temperaturaRefrigerador = 9.0f;
                break;
        }
        //
        meuRefrigerador.selecionarTemperatura(temperaturaRefrigerador);
        meuCongelador.selecionarTemperatura(temperaturaCongelador);
    }

    public void controlarTemperatura() {
        meuCongelador.controlarTemperatura();
        meuRefrigerador.controlarTemperatura();
    }
}
