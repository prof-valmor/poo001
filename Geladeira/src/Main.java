import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String args[]) {
        Geladeira g = new Geladeira();
        //0 - min, 1 - med, 2 - max
        g.mudarTemperatura(1); //
        System.out.println("FIM DO MAIN");
    }
}
