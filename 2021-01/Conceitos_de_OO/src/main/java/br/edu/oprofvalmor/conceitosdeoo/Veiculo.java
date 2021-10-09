/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.oprofvalmor.conceitosdeoo;

/**
 * Utilizamos o Encapsulamento para criar uma classe Veiculo para ser utilizada por um 
 * app de Aluguel de veiculos.
 * Agrupamos aqui 2 atributos e algumas operacoes que OBJETOS desse tipo vao poder realizar.
 * @author prof-valmor
 */
public class Veiculo {
    //atributos
    private boolean estado = false; // alugado ou nao. false significa nao alugado.
    private int     km;
    //Metodos
    public void alugar() {
        estado = true;
    }
    public void atualizarKm(int novaKm) {
       km = novaKm; 
    }
    //setter
    public void setKm(int novaKm) {
        km = novaKm;
    }
    //getter
    public int getKm() {
        return km;
    }
    
}
