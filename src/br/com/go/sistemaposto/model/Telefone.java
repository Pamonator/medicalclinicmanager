/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemaposto.model;

/**
 *
 * @author a1402072
 */
public class Telefone {

    private int idTelefone;
    private String telefoneResidencial;
    private String telefoneComercial;
    private String telefoneCelular;

    public Telefone() {

    }

    public Telefone(String telefoneResidencial, String telefoneCelular) {
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneComercial = null;
        this.telefoneCelular = telefoneCelular;
    }

    public Telefone(String telefoneResidencial, String telefoneComercial, String telefoneCelular) {
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneComercial = telefoneComercial;
        this.telefoneCelular = telefoneCelular;
    }

    public Telefone(int idTelefone, String telefoneResidencial, String telefoneComercial, String telefoneCelular) {
        this.idTelefone = idTelefone;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneComercial = telefoneComercial;
        this.telefoneCelular = telefoneCelular;
    }
    
    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

}
