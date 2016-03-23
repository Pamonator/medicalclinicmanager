/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

import br.com.go.mcm.model.Email;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class EmailControle extends QueryHelper {
    
    public String gerarQueryCadastrarEmail(Email email) throws SQLException {
        this.query = "INSERT INTO email VALUES (" + email.getIdPessoa()
                + ", '" +email.getEnderecoEmail() + "'); ";     
        
        return this.query;
    }    
    
    public boolean cadastrarEmail(Email email) throws SQLException {
        this.query = "INSERT INTO email VALUES (?, ?)";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        this.prepStatement.setInt(1, email.getIdPessoa());
        this.prepStatement.setString(2, email.getEnderecoEmail());
        
        return this.executeUpdate();
    }
    
    public boolean apagarEmail(int idEmail) throws SQLException {
        
        return this.executeUpdate();
    }
    
    public String gerarQueryAtualizarEmail(Email email) throws SQLException {
        this.query = "UPDATE email SET enderecoEmail = '" + email.getEnderecoEmail()
                + "' WHERE idPessoa = " + email.getIdPessoa() + ";";
        
        return this.query;
    }
}
