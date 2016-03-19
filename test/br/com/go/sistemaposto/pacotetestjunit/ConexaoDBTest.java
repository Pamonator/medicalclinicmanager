package br.com.go.sistemaposto.pacotetestjunit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.go.sistemaposto.dbconnection.MySqlControle;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilca
 */
public class ConexaoDBTest {
    
    MySqlControle mySqlControle;
    
    public ConexaoDBTest() {
        this.mySqlControle = new MySqlControle();
    }
    
   @Test
   public void testaConexao() throws SQLException {
       assertTrue(this.mySqlControle.getConnection() != null);
   }
}
