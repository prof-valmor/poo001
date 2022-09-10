package main;

public class ClasseRemovedor {
    public String removerConsoante(String palavra) {
        palavra = palavra.replaceAll("[bcdfghjklmnpqrstvwxyz]", "");
        return palavra;
    }

    public String removerVogal(String palavra) {
        palavra = palavra.replaceAll("[AEIOUaeiou]", "");
        return palavra;
    }
}
