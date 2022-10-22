package main;

import modelo.Aluno;
import modelo.Cadastro;
import ui.Menu;

import java.util.List;

public class Main {
    static Menu menu = new Menu();
    static Cadastro cadastro = new Cadastro();

    public static void main(String[] args) {
        int op;
        do {
            op = menu.mostrarOpcoesPrincipais();
            tratarASelecaoDoUsuario(op);
        }while(op != 5);
    }
    private static void tratarASelecaoDoUsuario(int opcao) {
        if(opcao == 1) {
            Aluno novoAluno = menu.coletarDadosDoAlunoECriarUmAluno();
            cadastro.addAluno(novoAluno);
        }
        if(opcao == 3) {
            imprimirListaAlunos();
        }
    }

    private static void imprimirListaAlunos() {
        List<Aluno> lista = cadastro.getListaDeAlunos();
        for(Aluno a : lista) {
            System.out.println(a.getNome());
            System.out.println(a.getFone());
            System.out.println(a.getCurso());
        }
    }
}
