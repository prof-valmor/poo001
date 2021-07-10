package modelo;

import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private int idade;
    private String cidade;
    private ArrayList<PessoaListener> observadores = new ArrayList<>();

    public Pessoa(String nome){
        this.nome = nome;
        this.idade = 0;
        this.cidade = "";
    }
    public void addListener(PessoaListener listener) {
        this.observadores.add(listener);
    }

    public void setNome(String nome) {
        this.nome = nome;
        chamarObservador();
    }
    public String getNome() {
        return nome;
    }
    public void incrementaIdade() {
        idade++;
        chamarObservador();
    }
    public int getIdade() {
        return idade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
        chamarObservador();
    }
    public String getCidade() {
        return cidade;
    }
    private void chamarObservador() {
       for(PessoaListener observador : this.observadores) {
           observador.onChange(this);
       }
    }
}
