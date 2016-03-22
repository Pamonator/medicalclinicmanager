/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

import br.com.go.mcm.model.Email;
import br.com.go.mcm.model.Endereco;
import br.com.go.mcm.model.Paciente;
import br.com.go.mcm.model.Pessoa;
import br.com.go.mcm.model.Telefone;
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

    public boolean atualizarPaciente(Paciente paciente) throws SQLException {
        this.query = "UPDATE paciente SET estadoCivilPaciente = ?, "
                + "profissaoPaciente = ?, escolaridadePaciente = ? "
                + "WHERE prontuarioPaciente = ?";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        this.prepStatement.setString(1, paciente.getEstadoCivilPaciente());
        this.prepStatement.setString(2, paciente.getProfissaoPaciente());
        this.prepStatement.setString(3, paciente.getEscolaridadePaciente());
        this.prepStatement.setInt(4, paciente.getProntuarioPaciente());
        
        return this.executeUpdate();
    }
    
    public PreparedStatement prepStatmentAtualizarPaciente(Paciente paciente) throws SQLException {
        this.query = "UPDATE paciente SET estadoCivilPaciente = ?, "
                + "profissaoPaciente = ?, escolaridadePaciente = ? "
                + "WHERE prontuarioPaciente = ?";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        this.prepStatement.setString(1, paciente.getEstadoCivilPaciente());
        this.prepStatement.setString(2, paciente.getProfissaoPaciente());
        this.prepStatement.setString(3, paciente.getEscolaridadePaciente());
        this.prepStatement.setInt(4, paciente.getProntuarioPaciente());
        
        return this.prepStatement;
    }

    public Paciente buscarPaciente(String expressaoBusca) throws SQLException {

        return null;
    }

    public ArrayList<Paciente> listarPaciente() throws SQLException {
        this.query = "SELECT * FROM paciente pac "
                + "NATURAL JOIN pessoa pes "
                + "LEFT OUTER JOIN telefone tel "
                + "ON tel.idpessoa = pac.idpessoa "
                + "LEFT OUTER JOIN email e "
                + "ON e.idpessoa = pac.idpessoa "
                + "LEFT OUTER JOIN endereco en "
                + "ON en.idpessoa = pac.idpessoa";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        ArrayList<Paciente> listaPaciente = new ArrayList();
        
        this.resultSet = this.executeQuerySelect();
        
        while (this.resultSet.next()) {
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
            
            Telefone telefone = new Telefone(this.resultSet.getInt("idPessoa"),
                    this.resultSet.getString("telefoneResidencial"),
                    this.resultSet.getString("telefoneComercial"),
                    this.resultSet.getString("telefoneCelular"));
            
            Email email = new Email(this.resultSet.getInt("idPessoa"), 
                    this.resultSet.getString("enderecoEmail"));
            
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
            
            Paciente paciente = new Paciente.Builder()
                    .prontuarioPaciente(this.resultSet.getInt("prontuarioPaciente"))
                    .pessoa(pessoa)
                    .estadoCivilPaciente(this.resultSet.getString("estadoCivilPaciente"))
                    .profissaoPaciente(this.resultSet.getString("profissaoPaciente"))
                    .escolaridadePaciente(this.resultSet.getString("escolaridadePaciente"))
                    .contruir();
                    
            listaPaciente.add(paciente);
        }
             
        return listaPaciente;
    }

}
