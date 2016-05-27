/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.dao;

import br.com.go.mcm.model.Telefone;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class TelefoneDAO extends QueryHelper {
    
    /**
     * Método que prepara uma query SQL para o cadastro de um telefone
     * junto ao banco de dados.
     * @param telefone - o objeto do tipo Telefone a ser gravado no banco
     * @return uma String contendo a query SQL
     */
    public String gerarQueryCadastrarTelefone(Telefone telefone) {
        this.query = "INSERT INTO telefone VALUES ("
                + telefone.getIdPessoa() + ", "
                + "'" + telefone.getTelefoneResidencial() + "', "
                + "'" + telefone.getTelefoneComercial()+ "', "
                + "'" + telefone.getTelefoneCelular()+ "'); ";     
        
        return this.query;
    }
    
    /**
     * Método responsável pela persistência de um objeto do tipo Paciente
     * junto ao banco de dados.
     * @param telefone - o objeto do tipo Telefone a ser gravado no banco
     * @return True se os dados foram gravados corretamente ou 
     * False se a gravação falhar
     * @throws SQLException
     */
    public boolean cadastrarTelefone(Telefone telefone) throws SQLException {
        this.query = "INSERT INTO telefone VALUES (?, ?, ?, ?)";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);        
        
        this.prepStatement.setInt(1, telefone.getIdPessoa());       
        this.prepStatement.setString(2, telefone.getTelefoneResidencial());       
        this.prepStatement.setString(3, telefone.getTelefoneComercial());       
        this.prepStatement.setString(4, telefone.getTelefoneCelular());       
        
        return this.executeUpdate();
    }
    
    /**
     * Método que prepara uma query SQL para a edição do cadastro
     * de um paciente previamente cadastrado no banco de dados.
     * @param telefone - o objeto do tipo Telefone que será atualizado no banco
     * @return uma String contendo a query SQL
     */
    public String gerarQueryAtualizarTelefone(Telefone telefone) {
        this.query = "UPDATE telefone SET telefoneResidencial = '"
                + telefone.getTelefoneResidencial() + "', "
                + "telefoneComercial = '" + telefone.getTelefoneComercial() + "', "
                + "telefoneCelular = '" + telefone.getTelefoneCelular() + "' "
                + "WHERE idPessoa = " + telefone.getIdPessoa() + ";";        
        
        return this.query;
    }
   
}
