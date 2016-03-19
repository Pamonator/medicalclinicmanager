/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.model;

import java.util.Date;

/**
 *
 * @author a1402072
 */
public class Pessoa {

    private int idPessoa;
    private Endereco enderecoPessoa;
    private Telefone telefonePessoa;
    private Email emailPessoa;
    private Date dataCadastroPessoa;
    private String nomePessoa;
    private char sexoPessoa;
    private String RGPessoa;
    private Date dataEmissaoRGPessoa;
    private String orgaoEmissorRGPessoa;
    private String CPFPessoa;
    private Date dataNacimentoPessoa;

    private Pessoa(Builder builder) {

    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Endereco getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(Endereco enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public Telefone getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(Telefone telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public Email getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(Email emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public Date getDataCadastroPessoa() {
        return dataCadastroPessoa;
    }

    public void setDataCadastroPessoa(Date dataCadastroPessoa) {
        this.dataCadastroPessoa = dataCadastroPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public char getSexoPessoa() {
        return sexoPessoa;
    }

    public void setSexoPessoa(char sexoPessoa) {
        this.sexoPessoa = sexoPessoa;
    }

    public String getRGPessoa() {
        return RGPessoa;
    }

    public void setRGPessoa(String RGPessoa) {
        this.RGPessoa = RGPessoa;
    }

    public Date getDataEmissaoRGPessoa() {
        return dataEmissaoRGPessoa;
    }

    public void setDataEmissaoRGPessoa(Date dataEmissaoRGPessoa) {
        this.dataEmissaoRGPessoa = dataEmissaoRGPessoa;
    }

    public String getOrgaoEmissorRGPessoa() {
        return orgaoEmissorRGPessoa;
    }

    public void setOrgaoEmissorRGPessoa(String orgaoEmissorRGPessoa) {
        this.orgaoEmissorRGPessoa = orgaoEmissorRGPessoa;
    }

    public String getCPFPessoa() {
        return CPFPessoa;
    }

    public void setCPFPessoa(String CPFPessoa) {
        this.CPFPessoa = CPFPessoa;
    }

    public Date getDataNacimentoPessoa() {
        return dataNacimentoPessoa;
    }

    public void setDataNacimentoPessoa(Date dataNacimentoPessoa) {
        this.dataNacimentoPessoa = dataNacimentoPessoa;
    }


    public static class Builder {

        private int idPessoa;
        private Endereco enderecoPessoa;
        private Telefone telefonePessoa;
        private Email emailPessoa;
        private Date dataCadastroPessoa;
        private String nomePessoa;
        private char sexoPessoa;
        private String RGPessoa;
        private Date dataEmissaoRGPessoa;
        private String orgaoEmissorRGPessoa;
        private String CPFPessoa;
        private Date dataNacimentoPessoa;

        public Builder idPessoa(int idPessoa) {
            this.idPessoa = idPessoa;
            return this;
        }
        
        public Builder enderecoPessoa(Endereco enderecoPessoa) {
            this.enderecoPessoa = enderecoPessoa;
            return this;
        }

        public Builder emailPessoa(Email emailPessoa) {
            this.emailPessoa = emailPessoa;
            return this;
        }

        public Builder telefonePessoa(Telefone telefonePessoa) {
            this.telefonePessoa = telefonePessoa;
            return this;
        }
        
        public Builder nomePessoa(String nomePessoa) {
            this.nomePessoa = nomePessoa;
            return this;
        }

        public Builder sexoPessoa(char sexoPessoa) {
            this.sexoPessoa = sexoPessoa;
            return this;
        }

        public Builder RGPessoa(String RGPessoa) {
            this.RGPessoa = RGPessoa;
            return this;
        }

        public Builder orgaoEmissorRGPessoa(String orgaoEmissorRGPessoa) {
            this.orgaoEmissorRGPessoa = orgaoEmissorRGPessoa;
            return this;
        }

        public Builder dataEmissaoRGPessoa(Date dataEmissaoRGPessoa) {
            this.dataEmissaoRGPessoa = dataEmissaoRGPessoa;
            return this;
        }

        public Builder CPFPessoa(String CPFPessoa) {
            this.CPFPessoa = CPFPessoa;
            return this;
        }

        public Builder dataNacimentoPessoa(Date dataNacimentoPessoa) {
            this.dataNacimentoPessoa = dataNacimentoPessoa;
            return this;
        }        

        public Pessoa contruir() {
            return new Pessoa(this);
        }
    }
}
