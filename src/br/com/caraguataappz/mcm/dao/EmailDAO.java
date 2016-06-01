/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.dao;

import br.com.caraguataappz.mcm.model.Email;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class EmailDAO extends QueryHelper {
    
    /**
     * Método que prepara uma query SQL para o cadastro de um email
     * junto ao banco de dados.
     * @param email - o objeto do tipo email a ser gravado no banco
     * @return uma String contendo a query SQL
     */
    public String gerarQueryCadastrarEmail(Email email) {
        this.query = "INSERT INTO email VALUES (" + email.getIdPessoa()
                + ", '" +email.getEnderecoEmail() + "'); ";     
        
        return this.query;
    }    
    
    /**
     * Método responsável pela persistência de um objeto do tipo Email
     * junto ao banco de dados.
     * @param email - o objeto do tipo email a ser gravado no banco
     * @return True se os dados foram gravados corretamente ou 
     * False se a gravação falhar
     * @throws SQLException
     */
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
    
    /**
     * Método que prepara uma query SQL para a atualização(edição)
     * de um email previamente cadastrado no banco de dados.
     * @param email - o objeto do tipo email a ser atualizado no banco
     * @return uma String contendo a query SQL
     */
    public String gerarQueryAtualizarEmail(Email email) {
        this.query = "UPDATE email SET enderecoEmail = '" + email.getEnderecoEmail()
                + "' WHERE idPessoa = " + email.getIdPessoa() + ";";
        
        return this.query;
    }
}
