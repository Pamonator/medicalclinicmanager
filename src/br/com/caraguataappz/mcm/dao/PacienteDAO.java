/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.dao;

import br.com.caraguataappz.mcm.model.Email;
import br.com.caraguataappz.mcm.model.Endereco;
import br.com.caraguataappz.mcm.model.Paciente;
import br.com.caraguataappz.mcm.model.Pessoa;
import br.com.caraguataappz.mcm.model.Telefone;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author a1402072
 */
public class PacienteDAO extends QueryHelper {

    /**
     * Método que prepara uma query SQL para o cadastro de um endereco
     * junto ao banco de dados.
     * @param paciente - o objeto do tipo Paciente a ser gravado no banco
     * @return uma String contendo a query SQL
     */
    public String gerarQuerycadastrarPaciente(Paciente paciente) {
        /*
            criando a instrução(query) SQL que será executada pelo banco posteriormente
            atenção!!! Se o valor a ser passado for do tipo String, o mesmo devera ser 
            formatado, sendo colocado entre ' ' (aspas simples) ex: profissaoPaciente 
            é uma String >> + "'" + paciente.getProfissaoPaciente() + "', "
        
        */
        this.query = "INSERT INTO paciente VALUES ("
                + paciente.getProntuarioPaciente() + ", "
                + paciente.getPessoa().getIdPessoa() + ", "
                + "'" + paciente.getEstadoCivilPaciente() + "', "
                + "'" + paciente.getProfissaoPaciente() + "', "
                + "'" + paciente.getEscolaridadePaciente() + "'); ";

        //retornando a String contendo a query SQL
        return this.query;
    }

    /**
     * Método responsável pela persistência de um objeto do tipo Paciente
     * junto ao banco de dados.
     * @param paciente - o objeto do tipo Paciente a ser gravado no banco
     * @return True se os dados foram gravados corretamente ou 
     * False se a gravação falhar
     * @throws SQLException
     */
    public boolean cadastrarPaciente(Paciente paciente) throws SQLException {
        //gerando a query SQL, é configurado o número de parametros (?)
        //que serão substituidos abaixo pelo valores correspondentes        
        this.query = "INSERT INTO paciente (prontuarioPaciente, idPessoa, "
                + "estadoCivilPaciente, profissaoPaciente, escolaridadePaciente) "
                + "VALUES (?, ?, ?, ?, ?)";

        //preparando o statement que chamará a execução da query SQL junto ao banco
        // this.mySqlControle.getConnection()  >> abre a conexao com o banco
        // .prepareStatement(this.query); >> prepara o statment com a query criada acima
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);

        //substitui os parametros(?) pelos valores que realmente serão gravados no banco
        this.prepStatement.setInt(1, paciente.getProntuarioPaciente());
        this.prepStatement.setInt(2, paciente.getPessoa().getIdPessoa());
        this.prepStatement.setString(3, paciente.getEstadoCivilPaciente());
        this.prepStatement.setString(4, paciente.getProfissaoPaciente());
        this.prepStatement.setString(5, paciente.getEscolaridadePaciente());

        //mandando executar a instrução SQL
        return this.executeUpdate();
    }

    /**
     * Método que prepara uma query SQL para a edição do cadastro
     * de um paciente previamente cadastrado no banco de dados.
     * @param paciente - o objeto do tipo Paciente que será atualizado no banco
     * @return uma String contendo a query SQL
     */
    public String gerarQueryAtualizarPaciente(Paciente paciente) {
        this.query = "UPDATE paciente SET estadoCivilPaciente = '"
                + paciente.getEstadoCivilPaciente() + "', "
                + "profissaoPaciente = '" + paciente.getProfissaoPaciente() + "', "
                + "escolaridadePaciente = '" + paciente.getEscolaridadePaciente() + "' "
                + "WHERE prontuarioPaciente = " + paciente.getProntuarioPaciente() + ";";
        
        return this.query;
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

    /**
     * Método que busca junto ao banco de dados uma lista de todos os pacientes
     * cadastrados no sistema
     * @return um ArrayList contendo todos os registros encontrados no banco
     * @throws SQLException
     */
    public ArrayList<Paciente> listarPaciente() throws SQLException {
        //criando a query que busca as informações desejadas
        //no caso ja buscamos todas as informações pertinentes a um paciente em 
        //uma mesma query utilizando junção(JOIN) das tabelas no banco
        this.query = "SELECT * FROM paciente "
                + "NATURAL JOIN pessoa "
                + "NATURAL JOIN endereco "
                + "NATURAL JOIN telefone "
                + "NATURAL JOIN email";
        
        //preparando o statement que chamará a execução da query SQL junto ao banco
        // this.mySqlControle.getConnection()  >> abre a conexao com o banco
        // .prepareStatement(this.query); >> prepara o statment com a query criada acima
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        //instanciando a lista que receberá os dados da busca
        ArrayList<Paciente> listaPaciente = new ArrayList();
        
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
            
            //e finalmente instanciando o paciente
            Paciente paciente = new Paciente.Builder()
                    .prontuarioPaciente(this.resultSet.getInt("prontuarioPaciente"))
                    .pessoa(pessoa)
                    .estadoCivilPaciente(this.resultSet.getString("estadoCivilPaciente"))
                    .profissaoPaciente(this.resultSet.getString("profissaoPaciente"))
                    .escolaridadePaciente(this.resultSet.getString("escolaridadePaciente"))
                    .contruir();
            
            //adicionando o paciente à lista        
            listaPaciente.add(paciente);
        }
        
        //retornando a lista de pacientes cadastrados no banco
        return listaPaciente;
    }

}
