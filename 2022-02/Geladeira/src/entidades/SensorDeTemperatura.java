package entidades;

public class SensorDeTemperatura {
    private float temperaturaAtual;
    //atributos para usar no codigo para simular variacao de temperatura
    private float[] temperaturas = {0,5,10,10.5f,8,6,2};
    private int index = 0;
    public float getTemperaturaAtual() {
        temperaturaAtual = temperaturas[index];
        index++;
        if(index == temperaturas.length) index = 0;
        //
        return temperaturaAtual;
    }
}
