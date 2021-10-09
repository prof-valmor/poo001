package banco;
// POJO - plain old java object.
public class Pessoa {
    public String nome;
    public Integer idade;
    public String cidade;

    public String toString() {
        return nome + " " + idade + " " + cidade;
    }
}
