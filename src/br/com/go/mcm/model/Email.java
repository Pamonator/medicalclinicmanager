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
public class Email {

    private int idPessoa;
    private String enderecoEmail;

    public Email() {
    }

    public Email(int idPessoa, String enderecoEmail) {
        this.idPessoa = idPessoa;
        this.enderecoEmail = enderecoEmail;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public boolean isEmailValid() {

        return false;
    }
}
