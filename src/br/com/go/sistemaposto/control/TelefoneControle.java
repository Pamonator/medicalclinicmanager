/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemaposto.control;

import br.com.go.sistemaposto.model.Telefone;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class TelefoneControle extends QueryHelper {
    
    public boolean cadastrarTelefone(Telefone telefone) throws SQLException {
        this.query = "INSERT INTO telefone (telefoneResidencial, telefoneComercial, "
                + "telefoneCelular) VALUES (?, ?, ?)";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);        
        
        this.prepStatement.setString(1, telefone.getTelefoneResidencial());       
        this.prepStatement.setString(2, telefone.getTelefoneComercial());       
        this.prepStatement.setString(3, telefone.getTelefoneCelular());       
        
        return this.executeUpdate();
    }

    public boolean apagarTelefone(int idTelefone) throws SQLException{
        
        
        return this.executeUpdate();
    }
    
}
