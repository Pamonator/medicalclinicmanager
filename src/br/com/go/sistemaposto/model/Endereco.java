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
public class Endereco {

    private int idEndereco;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
    private String CEPEndereco;

    private Endereco(Builder builder) {
        this.idEndereco = builder.idEndereco;
        this.logradouroEndereco = builder.logradouroEndPaciente;
        this.numeroEndereco = builder.numeroEndPaciente;
        this.complementoEndereco = builder.complementoEndPaciente;
        this.bairroEndereco = builder.bairroEndPaciente;
        this.cidadeEndereco = builder.cidadeEndPaciente;
        this.CEPEndereco = builder.CEPEndPaciente;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getCEPEndereco() {
        return CEPEndereco;
    }

    public void setCEPEndereco(String CEPEndereco) {
        this.CEPEndereco = CEPEndereco;
    }

    public static class Builder {

        private int idEndereco;
        private String logradouroEndPaciente;
        private String numeroEndPaciente;
        private String complementoEndPaciente;
        private String bairroEndPaciente;
        private String cidadeEndPaciente;
        private String CEPEndPaciente;
        
        public Builder idEndereco(int idEndereco) {
            this.idEndereco = idEndereco;
            return this;
        }
        
        public Builder logradouroEndPaciente(String logradouroEndPaciente) {
            this.logradouroEndPaciente = logradouroEndPaciente;
            return this;
        }
        
        public Builder numeroEndPaciente(String numeroEndPaciente) {
            this.numeroEndPaciente = numeroEndPaciente;
            return this;
        }
        
        public Builder complementoEndPaciente(String complementoEndPaciente) {
            this.complementoEndPaciente = complementoEndPaciente;
            return this;
        }
        
        public Builder bairroEndPaciente(String bairroEndPaciente) {
            this.bairroEndPaciente = bairroEndPaciente;
            return this;
        }
        
        public Builder cidadeEndPaciente(String cidadeEndPaciente) {
            this.cidadeEndPaciente = cidadeEndPaciente;
            return this;
        }
        
        public Builder CEPEndPaciente(String CEPEndPaciente) {
            this.CEPEndPaciente = CEPEndPaciente;
            return this;
        }      
        
        public Endereco construir() {
            return new Endereco(this);
        }
    }

}
