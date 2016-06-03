/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

import br.com.caraguataappz.mcm.dao.DAOManager;
import br.com.caraguataappz.mcm.model.Paciente;

/**
 *
 * @author gilca
 */
public class PacienteController {

    private final DAOManager daoManager;

    public PacienteController() {

        this.daoManager = new DAOManager();

    }

//    public boolean cadastrarPaciente(Paciente paciente) throws Exception {
//
//        boolean cadastrarPaciente = false;
//
//        
//
//            cadastrarPaciente = this.daoManager.cadastrar(paciente);
//
//      
//
//        return cadastrarPaciente;
//
//    }
//
//    public boolean atualizarPaciente(Paciente paciente) throws Exception {
//
//        boolean atualizarPaciente = false;
//
//        if (this.isPacienteValid(paciente)) {
//
//            atualizarPaciente = this.daoManager.atualizar(paciente);
//
//        }
//
//        return atualizarPaciente;
//
//    }

    public boolean isPacienteValid(Paciente paciente) throws Exception {

        boolean isNotValid = paciente.getProfissaoPaciente().trim().equals("");

        if (isNotValid) {

            throw new Exception("Favor informar a profissão do "
                    + "paciente que deseja cadastrar.");

        }

        return true;

    }

}
