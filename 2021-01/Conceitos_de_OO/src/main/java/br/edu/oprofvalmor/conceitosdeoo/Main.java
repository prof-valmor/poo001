/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.oprofvalmor.conceitosdeoo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que vai ser o ponto de partida do nosso app. Os arquivos desse projeto
 * vao explorar os conceitos basicos de OO:
 *
 * 1. Encapsulamento 2. Ocultação de informações e implementações 3. Retenção de
 * estado 4. Identidade de objeto 5. Troca de Mensagens 6. Classes 7. Herança 8.
 * Polimorfismo 9. Generalização 10. Ligação Dinâmica (​dynamic-binding)​
 *
 * @author prof-valmor
 */
public class Main {

    // metodo main padrao. Eh nele que tudo se inicia.
    public static void main(String[] arguments) {
        // Classe padrao para realizar leituras do teclado.
        Scanner scanner = new Scanner(System.in);
        // Vamos pedir para o usuario digitar uma KM para que possamos atualizar os veiculos.
        System.out.println("Digite a nova KM: ");
        int novaKm = scanner.nextInt();         // Aqui o scanner le um inteiro do teclado. Experimente digitar um nome...
        // Aqui criamos um Veiculo.
        Veiculo v1 = new Veiculo(); // lembre que o OBJETO Veiculo eh criado com o commando 'new Veiculo' e que v1 eh como vamos referenciar o objeto no codigo.
        // Aqui criamos um VeiculoEsporte.
        VeiculoEsporte v2 = new VeiculoEsporte();

        v1.atualizarKm(novaKm);     //Estamos trocando mensagens com v1, pedindo para 'atualizarKm'

        v2.atualizarKm(v1.getKm()); //Estamos atualizando KM em v2.
        v2.setTipoMotor("V8");      //Estamos dando um set no TipoDoMotor de v2. Esta operacao existe em Veiculo? (n)

        //System.out.println() eh uma maneira de imprimir mensagens na tela. 
        System.out.println("A km atual de V1 eh: " + v1.getKm());       // O Java converte o int de v1.getKm() para String e concatena com a String inicial para mostrar na tela a informacao.
        System.out.println("A km atual de V2 eh: " + v2.getKm());
        System.out.println("V2 tem um motor: " + v2.getTipoMotor());
        
        if (v2 == v1) { // Testando se as referencias v1 e v2 apontam para o mesmo objeto.
            System.out.println("O objeto eh: " + v2);

        } else { // caso nao estejam apontando para o mesmo objeto, imprime-os.
            System.out.println("O objeto V1 eh: " + v1);
            System.out.println("O objeto V2 eh: " + v2);
        }

        //
        //Veiculo[] lista = new Veiculo[3]; assim se criaria um Vetor em Java.
        // GENERALIZACAO: a classe ArrayList permite informar o tipo de dado que vai ser armazenado.
        ArrayList<Veiculo> lista = new ArrayList<Veiculo>();    // Criando um ArrayList para conter Veiculo(s)
        ArrayList<String> listaStrings = new ArrayList<String>(); // Criando um outro ArrayList para conter Strings. A mesma classe gerencia diferentes tipos.
        listaStrings.add("String");
        //
        lista.add(v1);  //Adicionando v1 ao ArrayList de Veiculos chamado 'lista'
        lista.add(v2);  //Adicionando v2 ao ArrayList...
        System.out.println("O tamanho da lista: " + lista.size());      // Qual o tamanho da lista? quantos elementos ela tem?

        // atualizando a KM de todos os veiculos da lista.
        for (int i = 0; i < lista.size(); i++) {
            Veiculo v = lista.get(i);
            System.out.println("Objeto eh do tipo: " + v);      // Perceba que 'v' referencia Veiculo e VeiculoEsporte eh um Veiculo tb por causa da HERANCA.
            v.atualizarKm(10);    //DYNAMIC-BINDING: em tempo de execucao o Java sabe de qual objeto chamar o 'atualizarKm'.  
        }
        System.out.println("#A km atual de V1 eh: " + v1.getKm());
        System.out.println("#A km atual de V2 eh: " + v2.getKm());
    }
}
