/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.model;

/**
 *
 * @author gilca
 */
public class Funcionario {
    
    private int idFuncionario;
    private Pessoa pessoa;
    private String cargoFuncionario;
    private char statusFuncionario;    

    public Funcionario() {
    }

    public Funcionario(Pessoa pessoa, String cargoFuncionario) {
        this.pessoa = pessoa;
        this.cargoFuncionario = cargoFuncionario;
    }

    public Funcionario(int idFuncionario, Pessoa pessoa, String cargoFuncionario, char statusFuncionario) {
        this.idFuncionario = idFuncionario;
        this.pessoa = pessoa;
        this.cargoFuncionario = cargoFuncionario;
        this.statusFuncionario = statusFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public char getStatusFuncionario() {
        return statusFuncionario;
    }

    public void setStatusFuncionario(char statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }
    
}
