package model;

//POJO - plain old java object.
public class Filme {
    public String titulo;
    public String direcao;
    public String ano;
    public byte[] poster;

    public String toString() {
        return titulo + "\n" + direcao + "\n" + ano + "\n";
    }
}
