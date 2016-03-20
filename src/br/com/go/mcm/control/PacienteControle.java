/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

import br.com.go.mcm.model.Paciente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author a1402072
 */
public class PacienteControle extends QueryHelper {

    public String gerarQuerycadastrarPaciente(Paciente paciente) throws SQLException {
        
        this.query = "INSERT INTO paciente VALUES ("
                + paciente.getProntuarioPaciente() + ", "
                + paciente.getPessoa().getIdPessoa() + ", "
                + "'" + paciente.getEstadoCivilPaciente() + "', "
                + "'" + paciente.getProfissaoPaciente() + "', "
                + "'" + paciente.getEscolaridadePaciente() + "'); ";

        return this.query;
    }
    
    public boolean cadastrarPaciente(Paciente paciente) throws SQLException {
        
        this.query = "INSERT INTO paciente (prontuarioPaciente, idPessoa, "
                + "estadoCivilPaciente, profissaoPaciente, escolaridadePaciente) "
                + "VALUES (?, ?, ?, ?, ?)";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);

        this.prepStatement.setInt(1, paciente.getProntuarioPaciente());
        this.prepStatement.setInt(2, paciente.getPessoa().getIdPessoa());
        this.prepStatement.setString(3, paciente.getEstadoCivilPaciente());        
        this.prepStatement.setString(4, paciente.getProfissaoPaciente());
        this.prepStatement.setString(5, paciente.getEscolaridadePaciente());

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
