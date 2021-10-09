package banco;

import java.util.ArrayList;

public class BancoDeDados {
    private ArrayList<Pessoa> listaDePessoas;
    private DBListener observador; // suporta apenas 1 observador.

    public BancoDeDados() {
        listaDePessoas = new ArrayList<Pessoa>(1);
    }

    public void setObservador(DBListener observador) {
        this.observador = observador;
    }

    public void addPessoa(Pessoa p) {
        listaDePessoas.add(p);
        chamarObservador();
    }

    private void chamarObservador() {
        if(observador != null)
            observador.onChange(listaDePessoas);
    }

    public ArrayList<Pessoa> getPessoas() {
        return this.listaDePessoas;
    }

    public void removePessoa (String nomeRemoverPessoa) {
        boolean chamarListener = false;
        for (int i=0; i<this.listaDePessoas.size(); i++) {
            if (this.listaDePessoas.get(i).nome.equals(nomeRemoverPessoa)) {
                this.listaDePessoas.remove(i);
                chamarListener = true;
            }
        }
        chamarObservador();
    }

}
