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
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a1402293
 */
public class ConsultaDAO extends QueryHelper {

    public String gerarQueryAgendarConsulta(Consulta consulta) {
        
        this.query = "INSERT INTO consulta (dataConsulta, horarioConsulta, "
                + "prontuarioPaciente, crmMedico, dataConsulta, isRetorno) VALUES ('"
                + consulta.getDataConsulta() + "', '"
                + consulta.getHorarioConsulta() + "', "
                + consulta.getPaciente().getProntuarioPaciente() + ", '"
                + consulta.getMedico().getCrmMedico() + "', '"
                + consulta.getDataConsulta() + "', '" 
                + consulta.getIsRetorno() + "');";

        return this.query;
    }

    public String gerarQueryAtualizarAgendarConsulta(Consulta consulta) {
        
        this.query = "UPDATE consulta SET prontuarioPaciente = " + consulta.getPaciente().getProntuarioPaciente() + ", "
                + "statusConsulta = '" + consulta.getStatusConsulta() + "', "
                + "isRetorno = '" + consulta.getIsRetorno() + "', "
                + "WHERE dataConsulta = '" + consulta.getDataConsulta() + "' "
                + "AND horarioConsulta = '" + consulta.getHorarioConsulta() + "' "
                + "AND crmMedico = '" + consulta.getMedico().getCrmMedico() + "'";

        return this.query;
    }

    public boolean agendarConsulta(Consulta consulta) throws SQLException {
        
        this.query = "INSERT INTO consulta (dataConsulta, horarioConsulta,"
                + " prontuarioPaciente, crmMedico, isRetorno) VALUES (?, ? ,? ,? ,?)";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareCall(this.query);
        
        this.prepStatement.setDate(1, (Date) consulta.getDataConsulta());
        this.prepStatement.setTime(2, consulta.getHorarioConsulta());
        this.prepStatement.setInt(3, consulta.getPaciente().getProntuarioPaciente());
        this.prepStatement.setString(4, consulta.getMedico().getCrmMedico());
        this.prepStatement.setString(5, String.valueOf(consulta.getIsRetorno()));       
        
        return this.prepStatement.executeUpdate() > 0;
        
    }    
    
    public Consulta buscarConsulta(Date dataConsulta, Time horarioConsulta) throws SQLException {
         
        Consulta consulta = null;       
        
        this.query = "SELECT * FROM consulta c " 
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
                + "WHERE dataConsulta = ? AND horarioConsulta = ?";  
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        this.prepStatement.setDate(1, dataConsulta);
        this.prepStatement.setTime(2, horarioConsulta);
        
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
                    .dataConsulta(this.resultSet.getDate("dataConsulta"))
                    .horarioConsulta(this.resultSet.getTime("horarioConsulta"))
                    .statusConsulta(this.resultSet.getString("statusConsulta"))                    
                    .isRetorno(this.resultSet.getString("isRetorno").charAt(0))
                    .paciente(paciente)
                    .medico(medico)
                    .construir();       
           
        }
        
        return consulta;
    }

    public List<Consulta> listarConsultaAgendada() throws SQLException {
        
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
        
        return this.listarConsulta();

    }
    
    public List<Consulta> listarHistoricoConsulta() throws SQLException {
        
        this.query = "SELECT * FROM historicoConsulta c" 
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
        
        return this.listarConsulta();

    }
    
    private List<Consulta> listarConsulta() throws SQLException {
        
        List<Consulta> listaConsulta = new ArrayList<>();
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        //System.out.println(this.prepStatement.toString());
        
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
                    .dataConsulta(this.resultSet.getDate("dataConsulta"))
                    .horarioConsulta(this.resultSet.getTime("horarioConsulta"))
                    .statusConsulta(this.resultSet.getString("statusConsulta"))                    
                    .isRetorno(this.resultSet.getString("isRetorno").charAt(0))
                    .paciente(paciente)
                    .medico(medico)
                    .construir();   
                    
           listaConsulta.add(consulta);
                    
        }

        return listaConsulta;
        
    }
    
    public List<Consulta> listarAgendaMedico(String nomeMedico) throws SQLException {
        
        this.query = "SELECT * FROM consultaAgendada c " 
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
                + "WHERE nomeMedico = '" + nomeMedico + "'";
               
        return this.listarConsulta();
        
    }
    
     public List<Consulta> listarAgendaDiaMedico(String nomeMedico, Date data) throws SQLException {
         
         this.query = "SELECT * FROM consultaAgendada c " 
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
                + "WHERE nomeMedico = '" + nomeMedico + "' "
                + "AND dataConsulta = '" + data + "'";
               
        return this.listarConsulta();
         
     }
             
}
