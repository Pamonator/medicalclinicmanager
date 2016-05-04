/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.model;

import java.util.Date;
import java.util.List;

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
    private String diagnostico;
    private List<String> examesSolicitado;
    
    private Consulta(Builder builder){
        this.idConsulta = builder.idConsulta;
        this.paciente = builder.paciente;
        this.medico = builder.medico;
        this.statusConsulta = builder.statusConsulta;
        this.dataConsulta = builder.dataConsulta;
        this.diagnostico = builder.diagnostico;
        this.examesSolicitado = builder.examesSolicitado;
        
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

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<String> getExamesSolicitado() {
        return examesSolicitado;
    }

    public void setExamesSolicitado(List<String> examesSolicitado) {
        this.examesSolicitado = examesSolicitado;
    }

    public static class Builder {
        private int idConsulta;
        private Paciente paciente;
        private Medico medico;
        private String statusConsulta;
        private Date dataConsulta;
        private String diagnostico;
        private List<String> examesSolicitado;
    
    
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
    public Builder diagnostico(String diagnostico){
        this.diagnostico = diagnostico;
        return this;
    }
    public Builder examesSolicitados(List<String> examesSolicitado){
        this.examesSolicitado = examesSolicitado;
        return this;
    }
    public Consulta construir(){
        return new Consulta(this);
    }

}
}