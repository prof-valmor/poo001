/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.oprofvalmor.conceitosdeoo;

/**
 * Utilizamos a Heranca para criar esta classe que representara'
 * Veiculos Esporte, que sao uma especializacao da Classe Veiculo.
 * Perceba que nao vamos reescrever os atributos e operacoes que jah 
 * existem em Veiculo, mas vamos apenas adicionar o que vai existir apenas num 
 * Veiculo Esporte.
 * 
 * @author prof-valmor.
 */
public class VeiculoEsporte extends Veiculo {
    //atributos
    // tipo do Motor eh um atributo que apenas o carro esporte vai ter.
    private String  tipoDoMotor;
    // Setter para o tipo do motor.
    public void setTipoMotor(String tipoMotor) {
        tipoDoMotor = tipoMotor;
    }
    //getter para o tipo do motor.
    public String getTipoMotor() {
        return tipoDoMotor;
    }
    /**
     * POLIMORFISMO: Especializamos o metodo da classe pai.
     * Aqui a KM sempre vai valer o dobro.
     */
    public void atualizarKm(int km_) {
        super.atualizarKm(km_ * 2); // usando o setter da classe pai.
    }
    
}
