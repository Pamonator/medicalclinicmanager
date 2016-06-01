/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.dao;

import br.com.caraguataappz.mcm.model.Email;
import br.com.caraguataappz.mcm.model.Endereco;
import br.com.caraguataappz.mcm.model.Medico;
import br.com.caraguataappz.mcm.model.Pessoa;
import br.com.caraguataappz.mcm.model.Telefone;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MedicoDAO extends QueryHelper {

    public String gerarQueryCadastrarMedico(Medico medico) throws SQLException {
        this.query = "INSERT INTO medico (idPessoa, crmMedico, especialidadeMedico) "
                + "VALUES (" + medico.getPessoa().getIdPessoa() + ", "
                + "'" + medico.getCrmMedico() + "', "
                + "'" + medico.getEspecialidadeMedico() + "'); ";

        return this.query;
    }
    
    public String gerarQueryAtualizarMedico(Medico medico) throws SQLException {
        this.query = "UPDATE medico SET idPessoa = " +  medico.getPessoa().getIdPessoa() + ", "
                + "crmMedico = '" + medico.getCrmMedico() + "', "
                + "especialidadeMedico = '" + medico.getEspecialidadeMedico() + "', "
                + "statusMedico = '" + medico.getStatusMedico() + "' "
                + "WHERE crmMedico = '" + medico.getCrmMedico() + "'; ";

        return this.query;
    }

    public boolean cadastrarMedico(Medico medico) throws SQLException {
        this.query = "INSERT INTO medico(crmMedico, idPessoa, especialidadeMedico) "
                + "VALUES (?, ?, ?,)";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);

        this.prepStatement.setString(1, medico.getCrmMedico());
        this.prepStatement.setInt(2, medico.getPessoa().getIdPessoa());
        this.prepStatement.setString(3, medico.getEspecialidadeMedico());

        return this.executeUpdate();
    }

    public boolean atualizarMedico(Medico medico) throws SQLException {
        this.query = "UPDATE medico SET crmMedico = ?, "
                + "especialidadeMedico = ?, "
                + "statusMedico = ? "
                + "WHERE crmMedico = ?";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);

        this.prepStatement.setString(1, medico.getEspecialidadeMedico());

        return this.executeUpdate();
    }

    public PreparedStatement prepStatementAtualizarMedico(Medico medico) throws SQLException {
        this.query = "UPDATE medico SET especialidadeMedico = ?, "
                + "WHERE crmMedico = ?";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);

        this.prepStatement.setString(1, medico.getEspecialidadeMedico());
        this.prepStatement.setString(2, medico.getCrmMedico());

        return this.prepStatement;
    }

    public Medico buscarMedico(String nomeMedico) throws SQLException {
        
        this.query = this.query = "SELECT * FROM medico "
                + "NATURAL JOIN pessoa p "
                + "NATURAL JOIN endereco "
                + "NATURAL JOIN telefone "
                + "NATURAL JOIN email "
                + "WHERE p.nomePessoa = '" + nomeMedico + "'";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        this.resultSet = this.executeQuerySelect();
        
        Medico medico = null;
        
        if (resultSet.next()) {
            //começando pelo endereco do paciente
            //this.resultSet.get + o tipo de dado, int, string, date
            // + o nome da coluna que contém o dado na tabela
            Endereco endereco = new Endereco.Builder()
                    .idPessoa(this.resultSet.getInt("idPessoa"))
                    .logradouroEndereco(this.resultSet.getString("logradouroEndereco"))
                    .numeroEndereco(this.resultSet.getString("numeroEndereco"))
                    .complementoEndereco(this.resultSet.getString("complementoEndereco") + "")
                    .bairroEndereco(this.resultSet.getString("bairroEndereco"))
                    .cidadeEndereco(this.resultSet.getString("cidadeEndereco"))
                    .estadoEndereco(this.resultSet.getString("estadoEndereco"))
                    .CEPEndereco(this.resultSet.getString("cepEndereco"))
                    .construir(); 
            
            //instanciando o telefone
            Telefone telefone = new Telefone(this.resultSet.getInt("idPessoa"),
                    this.resultSet.getString("telefoneResidencial"),
                    this.resultSet.getString("telefoneComercial"),
                    this.resultSet.getString("telefoneCelular"));
            
            //instanciuand o email
            Email email = new Email(this.resultSet.getInt("idPessoa"), 
                    this.resultSet.getString("enderecoEmail"));
            
            //instanciand a pessoa
            Pessoa pessoa = new Pessoa.Builder()
                    .idPessoa(this.resultSet.getInt("idPessoa"))
                    .enderecoPessoa(endereco)
                    .telefonePessoa(telefone)
                    .emailPessoa(email)
                    .dataCadastroPessoa(this.resultSet.getDate("dataCadastroPessoa"))
                    .nomePessoa(this.resultSet.getString("nomePessoa"))
                    .sexoPessoa(this.resultSet.getString("sexoPessoa").charAt(0))
                    .rgPessoa(this.resultSet.getString("rgPessoa"))
                    .orgaoEmissorRGPessoa(this.resultSet.getString("orgaoEmissorRgPessoa"))
                    .cpfPessoa(this.resultSet.getString("cpfPessoa"))
                    .dataNacimentoPessoa(this.resultSet.getDate("dataNascimentoPessoa"))
                    .contruir();
            
            //e finalmente, instanciando o medico
            medico = new Medico(this.resultSet.getString("crmMedico"),
                    this.resultSet.getString("especialidadeMedico"),
                    pessoa,
                    this.resultSet.getString("statusMedico").charAt(0)
            );           
            
        } 
        
        return medico;
    }

    public ArrayList<Medico> listarMedico() throws SQLException {
        this.query = "SELECT * FROM medico "
                + "NATURAL JOIN pessoa "
                + "NATURAL JOIN endereco "
                + "NATURAL JOIN telefone "
                + "NATURAL JOIN email";                   
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);
        
        this.resultSet = this.executeQuerySelect();
        
        ArrayList<Medico> listaMedico = new ArrayList();
        
        while (resultSet.next()) {
            //começando pelo endereco do paciente
            //this.resultSet.get + o tipo de dado, int, string, date
            // + o nome da coluna que contém o dado na tabela
            Endereco endereco = new Endereco.Builder()
                    .idPessoa(this.resultSet.getInt("idPessoa"))
                    .logradouroEndereco(this.resultSet.getString("logradouroEndereco"))
                    .numeroEndereco(this.resultSet.getString("numeroEndereco"))
                    .complementoEndereco(this.resultSet.getString("complementoEndereco") + "")
                    .bairroEndereco(this.resultSet.getString("bairroEndereco"))
                    .cidadeEndereco(this.resultSet.getString("cidadeEndereco"))
                    .estadoEndereco(this.resultSet.getString("estadoEndereco"))
                    .CEPEndereco(this.resultSet.getString("cepEndereco"))
                    .construir(); 
            
            //instanciando o telefone
            Telefone telefone = new Telefone(this.resultSet.getInt("idPessoa"),
                    this.resultSet.getString("telefoneResidencial"),
                    this.resultSet.getString("telefoneComercial"),
                    this.resultSet.getString("telefoneCelular"));
            
            //instanciuand o email
            Email email = new Email(this.resultSet.getInt("idPessoa"), 
                    this.resultSet.getString("enderecoEmail"));
            
            //instanciand a pessoa
            Pessoa pessoa = new Pessoa.Builder()
                    .idPessoa(this.resultSet.getInt("idPessoa"))
                    .enderecoPessoa(endereco)
                    .telefonePessoa(telefone)
                    .emailPessoa(email)
                    .dataCadastroPessoa(this.resultSet.getDate("dataCadastroPessoa"))
                    .nomePessoa(this.resultSet.getString("nomePessoa"))
                    .sexoPessoa(this.resultSet.getString("sexoPessoa").charAt(0))
                    .rgPessoa(this.resultSet.getString("rgPessoa"))
                    .orgaoEmissorRGPessoa(this.resultSet.getString("orgaoEmissorRgPessoa"))
                    .cpfPessoa(this.resultSet.getString("cpfPessoa"))
                    .dataNacimentoPessoa(this.resultSet.getDate("dataNascimentoPessoa"))
                    .contruir();
            
            //e finalmente, instanciando o medico
            Medico medico = new Medico(this.resultSet.getString("crmMedico"),
                    this.resultSet.getString("especialidadeMedico"),
                    pessoa,
                    this.resultSet.getString("statusMedico").charAt(0)
            );
            
            listaMedico.add(medico);
        } 
        
        return listaMedico;
        
    }

}
