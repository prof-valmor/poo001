import java.lang.StringBuilder;

public class Inversor {
    public static String inverterString(String texto) {
        StringBuilder sb = new StringBuilder(texto);
        return sb.reverse().toString();
       /* char []letras = texto.toCharArray();
        char []invertido = new char[letras.length]; //o que eh criado aqui??
        int index = letras.length - 1;
        for(char letra : letras) {
            invertido[index] = letra;
            index--; 
        }
        return new String(invertido); */
    }
}