/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

import br.com.caraguataappz.mcm.dao.PacienteDAO;
import br.com.caraguataappz.mcm.model.Paciente;

/**
 *
 * @author gilca
 */
public class PacienteController {

    private final PacienteDAO pacienteDAO;
    
    public PacienteController() {
        
        this.pacienteDAO = new PacienteDAO();
        
    }

    public boolean cadastraPaciente(Paciente paciente) throws Exception {

        boolean cadastrarPaciente = false;

        if (this.isPacienteValid(paciente)) {

            cadastrarPaciente = this.pacienteDAO.cadastrarPaciente(paciente);

        }

        return cadastrarPaciente;

    }

    private boolean isPacienteValid(Paciente paciente) throws Exception {        

        boolean profissaoPaciente = paciente.getProfissaoPaciente().trim().equals("");

        if (!profissaoPaciente) {

            throw new Exception("Favor preencher a profissão do "
                    + "paciente que deseja cadastrar.");

        }

        
        
        
        
        return true;

    }   

}
