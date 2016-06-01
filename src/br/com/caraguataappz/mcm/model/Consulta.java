/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author a1402293
 */
public class Consulta {

    //private int idConsulta;
    private Date dataConsulta;
    private Time horarioConsulta;
    private Paciente paciente;
    private Medico medico;
    private String statusConsulta;    
    private char isRetorno;

    private Consulta(Builder builder) {
        //this.idConsulta = builder.idConsulta;
        this.dataConsulta = builder.dataConsulta;
        this.horarioConsulta = builder.horarioConsulta;
        this.paciente = builder.paciente;
        this.medico = builder.medico;
        this.statusConsulta = builder.statusConsulta;        
        this.isRetorno = builder.isRetorno;

    }

//    public int getIdConsulta() {
//        return idConsulta;
//    }
//
//    public void setIdConsulta(int idConsulta) {
//        this.idConsulta = idConsulta;
//    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Time getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(Time horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public char getIsRetorno() {
        return isRetorno;
    }

    public void setIsRetorno(char isRetorno) {
        this.isRetorno = isRetorno;
    }

    public static class Builder {

        //private int idConsulta;
        private Date dataConsulta;
        private Time horarioConsulta;
        private Paciente paciente;
        private Medico medico;
        private String statusConsulta;      
        private char isRetorno;

//    public Builder idConsulta(int idConsulta){
//        this.idConsulta = idConsulta;
//        return this;
//    }
        
         public Builder dataConsulta(Date dataConsulta) {
            this.dataConsulta = dataConsulta;
            return this;
        }

        public Builder horarioConsulta(Time horarioConsulta) {
            this.horarioConsulta = horarioConsulta;
            return this;
        }
        
        public Builder paciente(Paciente paciente) {
            this.paciente = paciente;
            return this;
        }

        public Builder medico(Medico medico) {
            this.medico = medico;
            return this;
        }

        public Builder statusConsulta(String statusConsulta) {
            this.statusConsulta = statusConsulta;
            return this;
        }
    
        public Builder isRetorno(char isRetorno) {
            this.isRetorno = isRetorno;
            return this;
        }

        public Consulta construir() {
            return new Consulta(this);
        }

    }

}
