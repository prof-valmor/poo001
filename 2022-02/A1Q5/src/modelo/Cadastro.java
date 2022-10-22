package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private ArrayList<Aluno> listaDeAlunos = new ArrayList<>(1);

    public void addAluno(Aluno novoAluno) {
        listaDeAlunos.add(novoAluno);
    }
    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }
}
