package model;

public class HttpHelper {
    public static String oQueEscrever() {
        // a string tem q terminar com uma quebra de linha e
        // tb precisa ter uma linha em branco depois da mensagem.
        return "GET / HTTP/1.0 \n\r\n\r";
    }
}
