/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.model;

import java.util.Date;

/**
 *
 * @author a1402293
 */
public class Consulta {

    private int idConsulta;
    private Paciente paciente;
    private Medico medico;
    private String statusConsulta;
    private Date dataConsulta;
    private String anotacoesConsulta;
    private String examesSolicitados;
    private char isRetorno;
    
    private Consulta(Builder builder){
        this.idConsulta = builder.idConsulta;
        this.paciente = builder.paciente;
        this.medico = builder.medico;
        this.statusConsulta = builder.statusConsulta;
        this.dataConsulta = builder.dataConsulta;
        this.anotacoesConsulta = builder.anotacoesConsulta;
        this.examesSolicitados = builder.examesSolicitados;
        this.isRetorno = builder.isRetorno;
        
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

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

    public String getAnotacoesConsulta() {
        return anotacoesConsulta;
    }

    public void setAnotacoesConsulta(String anotacoesConsulta) {
        this.anotacoesConsulta = anotacoesConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getExamesSolicitados() {
        return examesSolicitados;
    }

    public void setExamesSolicitados(String examesSolicitados) {
        this.examesSolicitados = examesSolicitados;
    }

    public char getIsRetorno() {
        return isRetorno;
    }

    public void setIsRetorno(char isRetorno) {
        this.isRetorno = isRetorno;
    }

    public static class Builder {
        private int idConsulta;
        private Paciente paciente;
        private Medico medico;
        private String statusConsulta;
        private Date dataConsulta;
        private String anotacoesConsulta;
        private String examesSolicitados;
        private char isRetorno;
    
    
    public Builder idConsulta(int idConsulta){
        this.idConsulta = idConsulta;
        return this;
    }
    public Builder paciente(Paciente paciente) {
        this.paciente = paciente;
        return this;
    }
    public Builder medico(Medico medico){
        this.medico = medico;
        return this;
    }
    public Builder statusConsulta(String statusConsulta){
        this.statusConsulta = statusConsulta;
        return this;
    }
    public Builder dataConsulta(Date dataConsulta){
        this.dataConsulta = dataConsulta;
        return this;
    }
    public Builder anotacoesConsulta(String anotacoesConsulta){
        this.anotacoesConsulta = anotacoesConsulta;
        return this;
    }
    public Builder examesSolicitados(String examesSolicitados){
        this.examesSolicitados = examesSolicitados;
        return this;
    }
    
    public Builder isRetorno(char isRetorno) {
        this.isRetorno = isRetorno;
        return this;
    }
    
    public Consulta construir(){
        return new Consulta(this);
    }

}
}