/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.model;

import java.util.Date;

/**
 *
 * @author a1402072
 */
public class Pessoa {

    private int idPessoa;
    private Date dataCadastroPessoa;
    private Endereco enderecoPessoa;
    private Telefone telefonePessoa;
    private Email emailPessoa;    
    private String nomePessoa;
    private char sexoPessoa;
    private String rgPessoa;
    private String orgaoEmissorRGPessoa;
    private String cpfPessoa;
    private Date dataNacimentoPessoa;

    private Pessoa(Builder builder) {
        this.idPessoa = builder.idPessoa;
        this.enderecoPessoa = builder.enderecoPessoa;
        this.telefonePessoa = builder.telefonePessoa;
        this.emailPessoa = builder.emailPessoa;
        this.dataCadastroPessoa = builder.dataCadastroPessoa;
        this.nomePessoa = builder.nomePessoa;
        this.sexoPessoa = builder.sexoPessoa;
        this.rgPessoa = builder.rgPessoa;
        this.orgaoEmissorRGPessoa = builder.orgaoEmissorRGPessoa;
        this.cpfPessoa = builder.cpfPessoa;
        this.dataNacimentoPessoa = builder.dataNacimentoPessoa;
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

    public String getRgPessoa() {
        return rgPessoa;
    }

    public void setRgPessoa(String rgPessoa) {
        this.rgPessoa = rgPessoa;
    }

    public String getOrgaoEmissorRGPessoa() {
        return orgaoEmissorRGPessoa;
    }

    public void setOrgaoEmissorRGPessoa(String orgaoEmissorRGPessoa) {
        this.orgaoEmissorRGPessoa = orgaoEmissorRGPessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
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
        private String rgPessoa;
        private String orgaoEmissorRGPessoa;
        private String cpfPessoa;
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
        
        public Builder dataCadastroPessoa(Date dataCadastroPessoa) {
            this.dataCadastroPessoa = dataCadastroPessoa;
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

        public Builder rgPessoa(String rgPessoa) {
            this.rgPessoa = rgPessoa;
            return this;
        }

        public Builder orgaoEmissorRGPessoa(String orgaoEmissorRGPessoa) {
            this.orgaoEmissorRGPessoa = orgaoEmissorRGPessoa;
            return this;
        }

        public Builder cpfPessoa(String cpfPessoa) {
            this.cpfPessoa = cpfPessoa;
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
