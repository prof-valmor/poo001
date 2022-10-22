package modelo;

public class Aluno extends Pessoa {
    private String curso;
    public Aluno(String nome, String fone, String curso) {
        super(nome, fone);
        this.curso = curso;
    }
    public String getCurso() {
        return curso;
    }
}
