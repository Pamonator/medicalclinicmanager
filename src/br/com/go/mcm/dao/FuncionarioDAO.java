/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.dao;

import br.com.go.mcm.model.Email;
import br.com.go.mcm.model.Endereco;
import br.com.go.mcm.model.Funcionario;
import br.com.go.mcm.model.Pessoa;
import br.com.go.mcm.model.Telefone;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gilca
 */
public class FuncionarioDAO extends QueryHelper {
    
    /**
     *
     * @param funcionario
     * @return
     */
    public String gerarQueryCadastrarFuncionario(Funcionario funcionario) {
       return "INSERT INTO funcionario (idPessoa, cargoFuncionario) "
                + "VALUES (" + funcionario.getPessoa().getIdPessoa() + ", "
                + "'" + funcionario.getCargoFuncionario() + "');";  
    }
    
    /**
     *
     * @param funcionario
     * @return
     */
    public String gerarQueryAtualizarFuncionario(Funcionario funcionario) {
        return "UPDATE funcionario SET cargoFuncionario = '"
                + funcionario.getCargoFuncionario() + "', statusFuncionario = '"
                + funcionario.getStatusFuncionario() + "' "
                + "WHERE idFuncionario = " + funcionario.getIdFuncionario()+ ";";       
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Funcionario> listarFuncionario() throws SQLException {
        //criando a query que busca as informações desejadas
        //no caso ja buscamos todas as informações sobre todos os funcionarios em 
        //uma mesma query utilizando junção(JOIN) das tabelas no banco
        this.query = "SELECT * FROM funcionario f "
                + "NATURAL JOIN pessoa pes "
                + "NATURAL JOIN endereco "
                + "NATURAL JOIN telefone "
                + "NATURAL JOIN email";
        
        //preparando o statement que chamará a execução da query SQL junto ao banco
        // this.mySqlControle.getConnection()  >> abre a conexao com o banco
        // .prepareStatement(this.query); >> prepara o statment com a query criada acima
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        //instanciando a lista que receberá os dados da busca
        ArrayList<Funcionario> listaFuncionario = new ArrayList();
        
        //executando a busca
        this.resultSet = this.executeQuerySelect();
        
        //percorrendo os dados da busca, instanciando os objetos necessário e adicionando à lista
        while (this.resultSet.next()) {
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
            
            //e finalmente instanciando o funcionario
            Funcionario funcionario = new Funcionario(
                    this.resultSet.getInt("idFuncionario"),
                    pessoa,
                    this.resultSet.getString("cargoFuncionario"),
                    this.resultSet.getString("statusFuncionario").charAt(0));
            
            //adicionando o funcionario à lista        
            listaFuncionario.add(funcionario);
        }
        
        //retornando a lista de funcionarios cadastrados no banco
        return listaFuncionario;
    }
    
}
