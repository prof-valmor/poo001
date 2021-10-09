import java.util.Calendar;

public class ProcessadorDeRequisicoes {
    // Recebe a requisicao e devolve a resposta.
    public static synchronized String processaRequest(String request) {
        String response = "invalid";
        if(request.equalsIgnoreCase("getName")) {
            response = "valmor";
        }
        if(request.equalsIgnoreCase("getDate")) {
            response = "13/10/2020";
        }
        return response;
    }
}
