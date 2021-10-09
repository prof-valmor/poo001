import modelo.Pessoa;
import modelo.PessoaListener;
import ui.GerenciadorJanelas;
import ui.JanelaContato;
import ui.MinhaJanela;

public class Main {
    public static void main(String args[]) {
        System.out.println("Iniciando o Main...");

        Pessoa p = new Pessoa("Valmor");
        System.out.println("Pessoa criada: " + p.getNome());
        //
        (new MinhaJanela(null, p)).setVisible(true);

        JanelaContato j = new JanelaContato(null);
        j.setVisible(true);

        p.addListener(j);

        p.addListener(new PessoaListener() {
            @Override
            public void onChange(Pessoa pessoa) {
                System.out.println("Nome  : " + pessoa.getNome());
                System.out.println("Idade : " + pessoa.getIdade());
                System.out.println("Cidade: " + pessoa.getCidade());
            }
        });

        //ui.GerenciadorJanelas.mostrarJanela(ui.GerenciadorJanelas.JANELA1);
//        GerenciadorJanelas gerenciador = new GerenciadorJanelas();
//        gerenciador.mostrarJanela(GerenciadorJanelas.JANELA1);

        System.out.println("Terminando o Main...");
        System.out.println("Testando Pessoa...");
    }
}
