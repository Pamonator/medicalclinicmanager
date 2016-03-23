/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

import br.com.go.mcm.model.Endereco;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class EnderecoControle extends QueryHelper {

    public String gerarQueryCadastrarEndereco(Endereco endereco) throws SQLException {
        this.query = "INSERT INTO endereco VALUES("
                + endereco.getIdPessoa() + ", "
                + "'" + endereco.getLogradouroEndereco() + "', "
                + "'" + endereco.getNumeroEndereco() + "', "
                + "'" + endereco.getComplementoEndereco() + "', "
                + "'" + endereco.getBairroEndereco() + "', "
                + "'" + endereco.getCidadeEndereco() + "', "
                + "'" + endereco.getEstadoEndereco() + "', "
                + "'" + endereco.getCEPEndereco() + "'); ";

        return this.query;
    }

    public boolean cadastrarEndereco(Endereco endereco) throws SQLException {
        this.query = "INSERT INTO endereco VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);

        this.prepStatement.setInt(1, endereco.getIdPessoa());
        this.prepStatement.setString(2, endereco.getLogradouroEndereco());
        this.prepStatement.setString(3, endereco.getNumeroEndereco());
        this.prepStatement.setString(4, endereco.getComplementoEndereco());
        this.prepStatement.setString(5, endereco.getBairroEndereco());
        this.prepStatement.setString(6, endereco.getCidadeEndereco());
        this.prepStatement.setString(7, endereco.getEstadoEndereco());
        this.prepStatement.setString(8, endereco.getCEPEndereco());

        return this.executeUpdate();
    }

    public boolean apagarEndereco(int idEndereco) throws SQLException {

        return this.executeUpdate();
    }

    public String gerarQueryAtualizarEndereco(Endereco endereco) {
        this.query = "UPDATE endereco SET logradouroEndereco = '"
                + endereco.getLogradouroEndereco() + "', "
                + "numeroEndereco = '" + endereco.getNumeroEndereco() + "', "
                + "complementoEndereco = '" + endereco.getComplementoEndereco() + "', "
                + "bairroEndereco = '" + endereco.getBairroEndereco() + "', "
                + "cidadeEndereco = '" + endereco.getCidadeEndereco() + "', "
                + "estadoEndereco = '" + endereco.getEstadoEndereco() + "', "
                + "cepEndereco = '" + endereco.getCEPEndereco() + "' "
                + "WHERE idPessoa = " + endereco.getIdPessoa() + ";";        
        
        return this.query;
    }
}
