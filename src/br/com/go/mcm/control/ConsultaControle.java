/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

import br.com.go.mcm.model.Consulta;
import br.com.go.mcm.model.Medico;
import br.com.go.mcm.model.Paciente;
import br.com.go.mcm.model.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a1402293
 */
public class ConsultaControle extends QueryHelper {

    public String gerarQueryAgendarConsulta(Consulta consulta) {
        this.query = "INSERT INTO consulta (prontuarioPaciente, crmMedico, dataConsulta, "
                + "diagnosticoConsulta, exameSolicitado, isRetorno) VALUES ("
                + consulta.getPaciente().getProntuarioPaciente() + ", '"
                + consulta.getMedico().getCrmMedico() + "', '"
                + consulta.getDataConsulta() + "', '" + consulta.getDiagnostico() + "', '"
                + consulta.getExamesSolicitados() + "', '"
                +consulta.getIsRetorno() + "');";

        return this.query;
    }

    public String gerarQueryAtualizarAgendarConsulta(Consulta consulta) {
        this.query = "UPDATE consulta SET prontuarioPaciente = " + consulta.getPaciente().getProntuarioPaciente() + ", "
                + "crmMedico = '" + consulta.getMedico() + "', dataConsulta = '" + consulta.getDataConsulta() + "', "
                + "diagnosticoConsulta = '" + consulta.getDiagnostico() + "', "
                + "exameSolicitado = '" + consulta.getExamesSolicitados() + "', "
                + "statusConsulta = '" + consulta.getStatusConsulta() + "', "
                + "isRetorno = '" + consulta.getIsRetorno() + "', ";

        return this.query;
    }

    public Consulta buscarConsulta(int idConsulta) throws SQLException {
         
        return null;
    }

    public List<Consulta> listarConsulta() throws SQLException {
        
        List<Consulta> listaConsulta = new ArrayList<>();       
        
        this.query = "SELECT idConsulta, statusConsulta, dataConsulta, diagnostico, examesSolicitados, isRetorno"
                + " FROM consulta NATURAL JOIN"
                + "("
                + "SELECT idPessoa, nomePessoa "
                + "FROM Pessoa pes NATURAL JOIN  paciente paci"
                + ")"
                + "("
                + "SELECT nomePessoa AS nomeMedico "
                + "FROM Pessoa NATURAL JOIN Medico "
                + ")"
                + ")"
                + "SELECT logradouroEndereco, numeroEndereco, complementoEndereco, bairroEndereco, cidadeEndereco, estadoEndereco, CEPEndereco"
                + "FROM Endereco NATURAL JOIN Paciente"
                + ")"
                + "("
                + "SELECT telefoneResidencial, telefoneComercial, telefoneCelular"
                + "FROM Telefone NATRURAL JOIN Paciente"
                + ")"
                + "("
                + "SELECT  telefoneResidencial AS telefoneResidencialMedico, telefoneComercial AS telefoneComercialMedico, telefoneCelular AS telefoneCelularMedico"
                + "FROM Telefone NATURAL JOIN Medico "
                + ")"
              
                 ;
        
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);
        
        this.resultSet = this.prepStatement.executeQuery();
        
        while (this.resultSet.next()) {
            Pessoa pessoa = new Pessoa.Builder().contruir();          
            Medico medico = new Medico();
            Paciente paciente = new Paciente.Builder().contruir();
            Consulta consulta = new Consulta.Builder()
                    .idConsulta(this.resultSet.getInt("idConsulta"))
                    .statusConsulta(this.resultSet.getString("statusConsulta"))
                    .dataConsulta(this.resultSet.getDate("dataConsulta"))
                    .examesSolicitados(this.resultSet.getString("examesSolicitados"))
                    .diagnostico(this.resultSet.getString("diagnostico"))
                    .isRetorno(this.resultSet.getString("isRetorno").charAt(0))
                    .paciente(paciente)
                    .medico(medico)
                    .construir();
                    
           listaConsulta.add(consulta);
                    
        }

        return listaConsulta;

    }

}
