package ui;

import modelo.Aluno;

import java.util.Scanner;

public class Menu {
    public int mostrarOpcoesPrincipais() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Add Aluno");
        System.out.println("2.Add Professor");
        System.out.println("3.Listar Alunos");
        System.out.println("4.Listar Professores");
        System.out.println("5.Sair");
        //
        int opcao;
        do {
            System.out.println("Qual a opcao desejada?");
            opcao = scan.nextInt();
        }while(opcao <= 0 || opcao > 5);

        return opcao;
    }
    public Aluno coletarDadosDoAlunoECriarUmAluno() {
        String n, f, c;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome:");
        n = scan.nextLine();
        System.out.println("Digite o fone:");
        f = scan.nextLine();
        System.out.println("Digite o curso:");
        c = scan.nextLine();
        return new Aluno(n, f, c);
    }
}
