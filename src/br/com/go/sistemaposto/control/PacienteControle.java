/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemaposto.control;

import br.com.go.sistemaposto.model.Paciente;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author a1402072
 */
public class PacienteControle extends QueryHelper {

    public boolean cadastrarPaciente(Paciente paciente) throws SQLException {
        
        this.query = "INSERT INTO paciente (prontuarioPaciente, idPessoa, "
                + "estadoCivilPaciente, profissaoPaciente, escolaridadePaciente, "
                + "VALUES(?, ?, ?, ?, ?)";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);

        this.prepStatement.setInt(1, paciente.getProntuarioPaciente());
        this.prepStatement.setString(12, paciente.getEstadoCivilPaciente());
        this.prepStatement.setString(13, paciente.getEscolaridadePaciente());
        this.prepStatement.setString(14, paciente.getProfissaoPaciente());

        return this.executeUpdate();
    }

    public boolean atualizarPaciente(Paciente Paciente) throws SQLException {

        return false;
    }

    public Paciente buscarPaciente(String expressaoBusca) throws SQLException {

        return null;
    }

    public ArrayList<Paciente> listarPaciente() throws SQLException {

        return null;
    }

}
