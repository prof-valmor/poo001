import model.OmDBHelper;
import model.OmDBHelperListener;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String args[]){
        OmDBHelper helper = new OmDBHelper();

        helper.setListener(new OmDBHelperListener() {
            @Override
            public void chegaramOsDadosDoFilme(String dadosDoFilme) {
                System.out.println(dadosDoFilme);
            }
        });
        helper.requestFilmeByName("Guardians of the Galaxy");
        System.out.println("Terminando o MAIN!");
    }
}
