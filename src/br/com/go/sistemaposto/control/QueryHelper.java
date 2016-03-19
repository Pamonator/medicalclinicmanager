/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemaposto.control;

import br.com.go.sistemaposto.dbconnection.MySqlControle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Caraguatá
 */
public abstract class QueryHelper {
    
    protected MySqlControle mySqlControle;
    protected PreparedStatement prepStatement;
    protected ResultSet resultSet;
    protected String query;

    public QueryHelper() {
        this.mySqlControle = new MySqlControle();
    }
    
    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
    public boolean executeUpdate() throws SQLException {
        int aux;
        aux = this.prepStatement.executeUpdate();
        this.mySqlControle.closeConnection();
        return aux > 0;
    }

    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet executeQuerySelect() throws SQLException {
        return this.prepStatement.executeQuery();
    }  

    public int getUltimoIdCadastrado(String tabela, String primaryKeyField) throws SQLException {
        this.query = "SELECT " + primaryKeyField  
                + " FROM " + tabela
                + " ORDER BY " + primaryKeyField
                + " DESC LIMIT 1";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);

        this.resultSet = executeQuerySelect();

        if (resultSet.next()) {
            return resultSet.getInt(primaryKeyField);
        }

        return 0;
    }
}
