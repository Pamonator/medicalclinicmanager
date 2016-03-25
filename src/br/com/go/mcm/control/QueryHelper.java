/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

import br.com.go.mcm.dbconnection.MySqlControle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
     * Método que executa uma qeury SQL do tipo INSERT, UPDATE ou DELETE
     * @return True se a query afetou alguma tulpla do banco ou
     * False se não houve alteração no banco
     * @throws java.sql.SQLException
     */
    public boolean executeUpdate() throws SQLException {
        int aux;
        aux = this.prepStatement.executeUpdate();
        this.mySqlControle.closeConnection();
        return aux > 0;
    }

     /**
     * Método que executa uma query SQL do tipo SELECT
     * @return um Objeto do tipo ResultSet contendo os resultado 
     * da busca gerada pela query SQL executada
     * @throws java.sql.SQLException
     */
    public ResultSet executeQuerySelect() throws SQLException {
        return this.prepStatement.executeQuery();
    }

    /**
     * Método que busca no banco o Id (primary key) da última tulpla
     * inserida em uma tabela pré-determinada
     * @param tabela - o nome da tabela a ser trabalhada
     * @param primaryKeyField - o nome da coluna que contém a chave primária
     * da tabela.
     * @return um inteiro contendo o valor da chave primária da última tulpla
     * inserida na tabela escolhida
     * @throws SQLException
     */
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

    /**
     * Método que executa varias queries SQL contidas em uma lista de Strings
     * @param queryList - um ArrayList<> do tipo String contendo
     * a lista de queries SQL a serem executadas. Os dados só serão salvos no 
     * banco de dados se todas as queries forem executadas com sucesso.
     * @return True se todas e somente todas as instruções forem executadas,
     * ou False se alguma das queries falhar. 
     */
    public boolean excuteTransaction(ArrayList<String> queryList) {
        //instanciando um objeto do tipo Connection (java.sql.Connection >> receberá uma conexão com o banco
        Connection connection;
        
        //tentando executar as instruções, pode lançar uma exceção
        try {
            //abrindo a conexao com o banco
            connection = this.mySqlControle.getConnection();
            
            //desligando o commit automático 
            connection.setAutoCommit(false);
            
            //variável auxiliar, recebe o número de linhas afetadas por cada query
            int executeUpdate = 0;
            
            //preparando o statment e chamando a execução de todas as queries, uma a uma
            for (int i = 0; i < queryList.size(); i++) {
                this.prepStatement = connection.prepareStatement(queryList.get(i));
                executeUpdate += prepStatement.executeUpdate();
            }

            //realizando o commit junto ao banco de dados
            connection.commit();
            
            //fechando a conexão com o banco (very important!!)
            connection.close();
            
            //retornando se alguma linha foi afetada após a execução das queries (caso sim, retorna True)
            return executeUpdate > 0;
        } catch (SQLException ex) {
            //exibindo mesagem de erro caso seja capturada uma exceção
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    //ATENÇÃO, ESTE MÉTODO NÃO FOI TESTADO!!!
    public boolean executeBatch(ArrayList<PreparedStatement> preparedStatementsList){
        Connection connection;
        try {
            connection = this.mySqlControle.getConnection();
            
            connection.setAutoCommit(false);

            int executeUpdate = 0;
            for (int i = 0; i < preparedStatementsList.size(); i++) {
                this.prepStatement = preparedStatementsList.get(i);
                executeUpdate += this.prepStatement.executeUpdate();
            }

            connection.commit();
            connection.close();
            return executeUpdate > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
}
