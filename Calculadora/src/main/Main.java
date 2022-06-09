package main;

import modelo.Calculadora;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        calculadora.setOperador1(30.5);
        calculadora.setOperador2(2.0);
        calculadora.setOperacao(Calculadora.OPERACAO.DIVISAO);
        System.out.println("A resposta eh: " + calculadora.calcular());
    }
}
