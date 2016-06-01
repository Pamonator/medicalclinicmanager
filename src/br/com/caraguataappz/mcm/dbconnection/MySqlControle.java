
package br.com.caraguataappz.mcm.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Caraguatá
 */
public class MySqlControle {   
    
    private Connection connection;
    
    public MySqlControle() {}
   
    /**
     * Método que  cria uma conexão com o banco de dados
     * @return uma conexão com o banco de dados
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException {
        try {
            
            Class.forName("org.gjt.mm.mysql.Driver");
            
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/MedicalClinicManager", "root", "");            
            
            return this.connection;
            
        } catch (ClassNotFoundException ex) {
            
            throw new SQLException(ex.getMessage());
            
        }
    }

    /**
     * Método que encerra uma conexão com o banco de dados
     * @throws java.sql.SQLException
     */
    public void closeConnection() throws SQLException {
        
        this.connection.close();
        
    }     
    
}
