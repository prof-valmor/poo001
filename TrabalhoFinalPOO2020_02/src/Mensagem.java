public class Mensagem {
    String remetente;
    String destinatario;
    String assunto;
    String texto;

    public Mensagem(String rementente, String destinatario, String assunto, String texto) {
        this.remetente    = rementente;
        this.destinatario = destinatario;
        this.assunto      = assunto;
        this.texto        = texto;
    }
}
