/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.model;

/**
 *
 * @author a1402072
 */
public class Endereco {

    private int idPessoa;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
    private String estadoEndereco;
    private String CEPEndereco;

    private Endereco(Builder builder) {
        this.idPessoa = builder.idPessoa;
        this.logradouroEndereco = builder.logradouroEndereco;
        this.numeroEndereco = builder.numeroEndereco;
        this.complementoEndereco = builder.complementoEndereco;
        this.bairroEndereco = builder.bairroEndereco;
        this.cidadeEndereco = builder.cidadeEndereco;
        this.estadoEndereco = builder.estadoEndereco;
        this.CEPEndereco = builder.CEPEndereco;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
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

    public String getEstadoEndereco() {
        return estadoEndereco;
    }

    public void setEstadoEndereco(String estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }

    public String getCEPEndereco() {
        return CEPEndereco;
    }

    public void setCEPEndereco(String CEPEndereco) {
        this.CEPEndereco = CEPEndereco;
    }

    public static class Builder {

        private int idPessoa;
        private String logradouroEndereco;
        private String numeroEndereco;
        private String complementoEndereco;
        private String bairroEndereco;
        private String cidadeEndereco;
        private String estadoEndereco;
        private String CEPEndereco;

        public Builder idPessoa(int idPessoa) {
            this.idPessoa = idPessoa;
            return this;
        }

        public Builder logradouroEndereco(String logradouroEndereco) {
            this.logradouroEndereco = logradouroEndereco;
            return this;
        }

        public Builder numeroEndereco(String numeroEndereco) {
            this.numeroEndereco = numeroEndereco;
            return this;
        }

        public Builder complementoEndereco(String complementoEndereco) {
            this.complementoEndereco = complementoEndereco;
            return this;
        }

        public Builder bairroEndereco(String bairroEndereco) {
            this.bairroEndereco = bairroEndereco;
            return this;
        }

        public Builder cidadeEndereco(String cidadeEndereco) {
            this.cidadeEndereco = cidadeEndereco;
            return this;
        }
        
        public Builder estadoEndereco(String estadoEndereco) {
            this.estadoEndereco = estadoEndereco;
            return this;
        }

        public Builder CEPEndereco(String CEPEndereco) {
            this.CEPEndereco = CEPEndereco;
            return this;
        }

        public Endereco construir() {
            return new Endereco(this);
        }
    }

}
