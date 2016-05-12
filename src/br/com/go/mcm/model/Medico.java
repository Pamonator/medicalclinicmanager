/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.model;

/**
 *
 * @author User
 */
public class Medico {

    private String crmMedico;
    private String especialidadeMedico;
    private Pessoa pessoa;
    private char statusMedico;   

    public Medico(String crmMedico, String especialidadeMedico, Pessoa pessoa) {
        this.crmMedico = crmMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.pessoa = pessoa;
    }

    public Medico(String crmMedico, String especialidadeMedico, Pessoa pessoa, char statusMedico) {
        this.crmMedico = crmMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.pessoa = pessoa;
        this.statusMedico = statusMedico;
    }
    
    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public char getStatusMedico() {
        return statusMedico;
    }

    public void setStatusMedico(char statusMedico) {
        this.statusMedico = statusMedico;
    }
    
}
