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
    
    private int idEmail;
    private String enderecoEmail;

    public Email() {
    }

    public Email(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public Email(int idEmail, String enderecoEmail) {
        this.idEmail = idEmail;
        this.enderecoEmail = enderecoEmail;
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
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
