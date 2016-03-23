/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

import br.com.go.mcm.model.Telefone;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class TelefoneControle extends QueryHelper {
    
    public String gerarQuerycadastrarTelefone(Telefone telefone) throws SQLException {
        this.query = "INSERT INTO telefone VALUES ("
                + telefone.getIdPessoa() + ", "
                + "'" + telefone.getTelefoneResidencial() + "', "
                + "'" + telefone.getTelefoneComercial()+ "', "
                + "'" + telefone.getTelefoneCelular()+ "'); ";     
        
        return this.query;
    }
    
    public boolean cadastrarTelefone(Telefone telefone) throws SQLException {
        this.query = "INSERT INTO telefone VALUES (?, ?, ?, ?)";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);        
        
        this.prepStatement.setInt(1, telefone.getIdPessoa());       
        this.prepStatement.setString(2, telefone.getTelefoneResidencial());       
        this.prepStatement.setString(3, telefone.getTelefoneComercial());       
        this.prepStatement.setString(4, telefone.getTelefoneCelular());       
        
        return this.executeUpdate();
    }
    
    public String gerarQueryAtualizarTelefone(Telefone telefone) throws SQLException {
        this.query = "UPDATE telefone SET telefoneResidencial = '"
                + telefone.getTelefoneResidencial() + "', "
                + "telefoneComercial = '" + telefone.getTelefoneComercial() + "', "
                + "telefoneCelular = '" + telefone.getTelefoneCelular() + "' "
                + "WHERE idPessoa = " + telefone.getIdPessoa() + ";";        
        
        return this.query;
    }

    public boolean apagarTelefone(int idTelefone) throws SQLException{
        
        
        return this.executeUpdate();
    }
    
}
