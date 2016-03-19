/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemaposto.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author a1402072
 */
public class Paciente {

    private int prontuarioPaciente;
    private Pessoa pessoa;
    private String estadoCivilPaciente;
    private String escolaridadePaciente;
    private String profissaoPaciente;
    private int idadePaciente;

    private Paciente(Builder builder) {
        this.prontuarioPaciente = builder.prontuarioPaciente;
        this.estadoCivilPaciente = builder.estadoCivilPaciente;
        this.escolaridadePaciente = builder.escolaridadePaciente;
        this.profissaoPaciente = builder.profissaoPaciente;
    }

    public int getProntuarioPaciente() {
        return prontuarioPaciente;
    }

    public void setProntuarioPaciente(int prontuarioPaciente) {
        this.prontuarioPaciente = prontuarioPaciente;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getEstadoCivilPaciente() {
        return estadoCivilPaciente;
    }

    public void setEstadoCivilPaciente(String estadoCivilPaciente) {
        this.estadoCivilPaciente = estadoCivilPaciente;
    }

    public String getEscolaridadePaciente() {
        return escolaridadePaciente;
    }

    public void setEscolaridadePaciente(String escolaridadePaciente) {
        this.escolaridadePaciente = escolaridadePaciente;
    }

    public String getProfissaoPaciente() {
        return profissaoPaciente;
    }

    public void setProfissaoPaciente(String profissaoPaciente) {
        this.profissaoPaciente = profissaoPaciente;
    }

    public int getIdadePaciente() {
        return idadePaciente;
    }

    public void setIdadePaciente(int idadePaciente) {
        this.idadePaciente = idadePaciente;
    }

    private int calcularIdadePaciente() {
        int anoNascimento = this.getPessoa().getDataNacimentoPessoa().getYear();
        int mesNascimento = this.getPessoa().getDataNacimentoPessoa().getMonth();
        Calendar calendar = GregorianCalendar.getInstance();
        Date time = calendar.getTime();
        int aux = time.getYear() - anoNascimento;
        if (mesNascimento > time.getMonth()) {
            aux--;
        }
        return aux;
    }

    public static class Builder {

        private int prontuarioPaciente;
        private Pessoa pessoa;
        private String estadoCivilPaciente;
        private String escolaridadePaciente;
        private String profissaoPaciente;
        private int idadePaciente;

        public Builder prontuarioPaciente(int prontuarioPaciente) {
            this.prontuarioPaciente = prontuarioPaciente;
            return this;
        }

        public Builder pessoa(Pessoa pessoa) {
            this.pessoa = pessoa;
            return this;
        }
        
        public Builder estadoCivilPaciente(String estadoCivilPaciente) {
            this.estadoCivilPaciente = estadoCivilPaciente;
            return this;
        }

        public Builder escolaridadePaciente(String escolaridadePaciente) {
            this.escolaridadePaciente = escolaridadePaciente;
            return this;
        }

        public Builder profissaoPaciente(String profissaoPaciente) {
            this.profissaoPaciente = profissaoPaciente;
            return this;
        }

        public Paciente contruir() {
            return new Paciente(this);
        }
    }
}
