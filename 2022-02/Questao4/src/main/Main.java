package main;

public class Main {
    public static void main(String[] args) {
        ClasseLeitor leitor = new ClasseLeitor();
        ClasseRemovedor removedor = new ClasseRemovedor();
        ClasseImpressor impressor = new ClasseImpressor();
//        Escreva um programa em que o usuário entra com uma String e escolhe se deseja
//        remover apenas as vogais ou apenas as consoantes dessa String. Apresente a String
//        resultante na tela.
        String word = leitor.lerPalavra();
        String opcao = leitor.escolharOpcao("1", "2", "3", "4");
        if(opcao.equalsIgnoreCase("1")){
            word = removedor.removerConsoante(word);
        }
        else{
            word = removedor.removerVogal(word);
        }
        impressor.imprimir(word);
    }
}
