/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemaposto.control;

import br.com.go.sistemaposto.dbconnection.MySqlControle;
import br.com.go.sistemaposto.model.Endereco;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class EnderecoControle extends QueryHelper {
    
    public boolean cadastrarEndereco(Endereco endereco) throws SQLException {
        this.query = "INSERT INTO endereco (logradouroEndereco, numeroEndereco, complementoEndereco, "
                + "bairroEndereco, cidadeEndereco, CEPEndereco) VALUES(?, ?, ?, ?, ?, ?)";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);
        
        this.prepStatement.setString(1, endereco.getLogradouroEndereco());
        this.prepStatement.setString(2, endereco.getNumeroEndereco());
        this.prepStatement.setString(3, endereco.getComplementoEndereco());
        this.prepStatement.setString(4, endereco.getBairroEndereco());
        this.prepStatement.setString(5, endereco.getCidadeEndereco());
        this.prepStatement.setString(6, endereco.getCEPEndereco());
        
        return this.executeUpdate();
    }

    public boolean apagarEndereco(int idEndereco) throws SQLException {
        
        
        return this.executeUpdate();
    }
}
