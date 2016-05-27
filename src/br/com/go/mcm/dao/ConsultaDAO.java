/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.dao;

import br.com.go.mcm.model.Consulta;
import br.com.go.mcm.model.Medico;
import br.com.go.mcm.model.Paciente;
import br.com.go.mcm.model.Pessoa;
import br.com.go.mcm.model.Telefone;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a1402293
 */
public class ConsultaDAO extends QueryHelper {

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

    public boolean agendarConsulta(Consulta consulta) throws SQLException {
        
        this.query = "INSERT INTO consulta (prontuarioPaciente, crmMedico, dataConsulta, "
                + "diagnosticoConsulta, exameSolicitado, isRetorno) VALUES (?, ? ,? ,? ,? ,?)";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareCall(query);
        
        this.prepStatement.setInt(1, consulta.getPaciente().getProntuarioPaciente());
        this.prepStatement.setString(2, consulta.getMedico().getCrmMedico());
        this.prepStatement.setDate(3, (Date) consulta.getDataConsulta());
               
        
        
        return this.prepStatement.executeUpdate() > 0;
        
    }
    
    
    public Consulta buscarConsulta() throws SQLException {
         
        Consulta consulta = null;       
        
        this.query = "SELECT * FROM consulta c" 
                + "JOIN (SELECT pe.idPessoa as idPaciente, pe.nomePessoa as nomePaciente, p.prontuarioPaciente, "
                + "t.telefoneResidencial, t.telefoneComercial, t.telefoneCelular FROM telefone t " 
                + "NATURAL JOIN pessoa pe " 
                + "NATURAL JOIN paciente p) as pesquisaPaciente " 
                + "ON pesquisaPaciente.prontuarioPaciente = c.prontuarioPaciente " 
                + "JOIN (SELECT pes.idPessoa as idMedico, pes.nomePessoa as nomeMedico, m.crmMedico, "
                + "m.especialidadeMedico, t.telefoneResidencial as trMedico, t.telefoneComercial as tcmMedico, " 
                + "t.telefoneCelular as tclMedico FROM telefone t " 
                + "NATURAL JOIN pessoa pes " 
                + "NATURAL JOIN medico m) as pesquisaMedico " 
                + "ON pesquisaMedico.crmMedico = c.crmMedico "
                + "WHERE ? = ";  
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);
        
        this.resultSet = this.prepStatement.executeQuery();
        
        if (this.resultSet.next()) {
            
            Telefone telefonePaciente = new Telefone();
            
            telefonePaciente.setTelefoneResidencial(this.resultSet.getString("telefoneResidencial"));
            telefonePaciente.setTelefoneComercial(this.resultSet.getString("telefoneComercial"));
            telefonePaciente.setTelefoneCelular(this.resultSet.getString("telefoneCelular"));
            
            Pessoa pessoaPaciente = new Pessoa.Builder()
                    .idPessoa(this.resultSet.getInt("idPaciente"))
                    .nomePessoa(this.resultSet.getString("nomePaciente"))
                    .telefonePessoa(telefonePaciente)
                    .contruir();  
            
            Paciente paciente = new Paciente.Builder()
                    .pessoa(pessoaPaciente)
                    .contruir();
            
            Telefone telefoneMedico = new Telefone();
            
            telefoneMedico.setTelefoneResidencial(this.resultSet.getString("trMedico"));
            telefoneMedico.setTelefoneComercial(this.resultSet.getString("tcmMedico"));
            telefoneMedico.setTelefoneCelular(this.resultSet.getString("tclMedico"));
            
            Pessoa pessoaMedico = new Pessoa.Builder()
                    .idPessoa(this.resultSet.getInt("idMedico"))
                    .nomePessoa(this.resultSet.getString("nomeMedico"))
                    .telefonePessoa(telefoneMedico)
                    .contruir();              
            
            Medico medico = new Medico();
            
            medico.setCrmMedico(this.resultSet.getString("crmMedico"));
            medico.setEspecialidadeMedico(this.resultSet.getString("especialidadeMedico"));
            medico.setPessoa(pessoaMedico);
            
            consulta = new Consulta.Builder()
                    //.idConsulta(this.resultSet.getInt("idConsulta"))
                    .statusConsulta(this.resultSet.getString("statusConsulta"))
                    .dataConsulta(this.resultSet.getDate("dataConsulta"))
                    .examesSolicitados(this.resultSet.getString("examesSolicitados"))
                    .anotacoesConsulta(this.resultSet.getString("diagnostico"))
                    .isRetorno(this.resultSet.getString("isRetorno").charAt(0))
                    .paciente(paciente)
                    .medico(medico)
                    .construir();       
           
        }
        
        return consulta;
    }

    public List<Consulta> listarConsultaAgendada() throws SQLException {
        
        List<Consulta> listaConsulta = new ArrayList<>();       
        
        this.query = "SELECT * FROM consultaAgendada c" 
                + "JOIN (SELECT pe.idPessoa as idPaciente, pe.nomePessoa as nomePaciente, p.prontuarioPaciente, "
                + "t.telefoneResidencial, t.telefoneComercial, t.telefoneCelular FROM telefone t " 
                + "NATURAL JOIN pessoa pe " 
                + "NATURAL JOIN paciente p) as pesquisaPaciente " 
                + "ON pesquisaPaciente.prontuarioPaciente = c.prontuarioPaciente " 
                + "JOIN (SELECT pes.idPessoa as idMedico, pes.nomePessoa as nomeMedico, m.crmMedico, "
                + "m.especialidadeMedico, t.telefoneResidencial as trMedico, t.telefoneComercial as tcmMedico, " 
                + "t.telefoneCelular as tclMedico FROM telefone t " 
                + "NATURAL JOIN pessoa pes " 
                + "NATURAL JOIN medico m) as pesquisaMedico " 
                + "ON pesquisaMedico.crmMedico = c.crmMedico ";    
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);
        
        this.resultSet = this.prepStatement.executeQuery();
        
        while (this.resultSet.next()) {
            
            Telefone telefonePaciente = new Telefone();
            
            telefonePaciente.setTelefoneResidencial(this.resultSet.getString("telefoneResidencial"));
            telefonePaciente.setTelefoneComercial(this.resultSet.getString("telefoneComercial"));
            telefonePaciente.setTelefoneCelular(this.resultSet.getString("telefoneCelular"));
            
            Pessoa pessoaPaciente = new Pessoa.Builder()
                    .idPessoa(this.resultSet.getInt("idPaciente"))
                    .nomePessoa(this.resultSet.getString("nomePaciente"))
                    .telefonePessoa(telefonePaciente)
                    .contruir();  
            
            Paciente paciente = new Paciente.Builder()
                    .pessoa(pessoaPaciente)
                    .contruir();
            
            Telefone telefoneMedico = new Telefone();
            
            telefoneMedico.setTelefoneResidencial(this.resultSet.getString("trMedico"));
            telefoneMedico.setTelefoneComercial(this.resultSet.getString("tcmMedico"));
            telefoneMedico.setTelefoneCelular(this.resultSet.getString("tclMedico"));
            
            Pessoa pessoaMedico = new Pessoa.Builder()
                    .idPessoa(this.resultSet.getInt("idMedico"))
                    .nomePessoa(this.resultSet.getString("nomeMedico"))
                    .telefonePessoa(telefoneMedico)
                    .contruir();              
            
            Medico medico = new Medico();
            
            medico.setCrmMedico(this.resultSet.getString("crmMedico"));
            medico.setEspecialidadeMedico(this.resultSet.getString("especialidadeMedico"));
            medico.setPessoa(pessoaMedico);
            
            Consulta consulta = new Consulta.Builder()
                    //.idConsulta(this.resultSet.getInt("idConsulta"))
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
