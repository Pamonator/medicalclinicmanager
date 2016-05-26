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
                + consulta.getDataConsulta() + "', '" + consulta.getAnotacoesConsulta() + "', '"
                + consulta.getExamesSolicitados() + "', '"
                +consulta.getIsRetorno() + "');";

        return this.query;
    }

    public String gerarQueryAtualizarAgendarConsulta(Consulta consulta) {
        this.query = "UPDATE consulta SET prontuarioPaciente = " + consulta.getPaciente().getProntuarioPaciente() + ", "
                + "crmMedico = '" + consulta.getMedico() + "', dataConsulta = '" + consulta.getDataConsulta() + "', "
                + "diagnosticoConsulta = '" + consulta.getAnotacoesConsulta() + "', "
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
        
        this.query = "SELECT * FROM consulta c" +
                "JOIN (SELECT pe.idPessoa as idPaciente, pe.nomePessoa, p.prontuarioPaciente, t.telefoneResidencial, " +
                "t.telefoneComercial, t.telefoneCelular FROM telefone t " +
                "NATURAL JOIN pessoa pe " +
                "NATURAL JOIN paciente p) as pesquisaPaciente " +
                "ON pesquisaPaciente.prontuarioPaciente = c.prontuarioPaciente " +
                "JOIN (SELECT pes.idPessoa as idMedico, pes.nomePessoa as nomeMedico, m.crmMedico, " +
                "t.telefoneResidencial as trMedico, t.telefoneComercial as tcmMedico, " +
                "t.telefoneCelular as tclMedico FROM telefone t " +
                "NATURAL JOIN pessoa pes " + 
                "NATURAL JOIN medico m) as teste2 " +
                "ON teste2.crmMedico = c.crmMedico";       
        
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
                    .anotacoesConsulta(this.resultSet.getString("diagnostico"))
                    .isRetorno(this.resultSet.getString("isRetorno").charAt(0))
                    .paciente(paciente)
                    .medico(medico)
                    .construir();
                    
           listaConsulta.add(consulta);
                    
        }

        return listaConsulta;

    }

}
