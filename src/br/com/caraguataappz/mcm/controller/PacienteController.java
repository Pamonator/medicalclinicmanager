/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

import br.com.caraguataappz.mcm.dao.DAOManager;
import br.com.caraguataappz.mcm.helper.CPFValidator;
import br.com.caraguataappz.mcm.model.Paciente;
import javax.swing.JTable;

/**
 *
 * @author gilca
 */
public class PacienteController {

    private final Paciente paciente = null;
    private final JTable tabelaPaciente = null;
    private final CPFValidator cPFValidator;

    public PacienteController() {

        this.cPFValidator = new CPFValidator();

    }

    public boolean cadastraPaciente(Paciente paciente) throws Exception {

        boolean cadastrarPaciente = false;

        if (this.isPacienteValid(paciente)) {

            cadastrarPaciente = DAOManager.pacienteDAO().cadastrarPaciente(paciente);

        }

        return cadastrarPaciente;

    }

    private boolean isPacienteValid(Paciente paciente) throws Exception {

        boolean pacienteCpfValid = this.isPacienteCpfValid(
                paciente.getPessoa().getCpfPessoa());

        if (!pacienteCpfValid) {

            throw new Exception("O CPF informado não é válido!");

        }

        boolean nomePessoa = paciente.getPessoa().getNomePessoa().equals("");

        if (!nomePessoa) {

            throw new Exception("Favor preencher o nome do "
                    + "paciente que deseja cadastrar.");

        }

        boolean profissaoPaciente = paciente.getProfissaoPaciente().equals("");

        if (!profissaoPaciente) {

            throw new Exception("Favor preencher a profissão do "
                    + "paciente que deseja cadastrar.");

        }

        return true;

    }

    private boolean isPacienteCpfValid(String cpfPessoa) {

        return this.cPFValidator.isCpfValid(cpfPessoa);

    }

}
