/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemaposto.control;

import br.com.go.sistemaposto.model.Email;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class EmailControle extends QueryHelper {
    
    public boolean cadastrarEmail(Email email) throws SQLException {
        this.query = "INSERT INTO email (enderecoEmail) VALUES (?)";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        this.prepStatement.setString(1, email.getEnderecoEmail());
        
        return this.executeUpdate();
    }
    
    public boolean apagarEmail(int idEmail) throws SQLException {
        
        return this.executeUpdate();
    }
    
}
