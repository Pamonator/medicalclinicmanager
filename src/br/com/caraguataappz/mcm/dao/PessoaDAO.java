/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.dao;

import br.com.caraguataappz.mcm.model.Pessoa;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class PessoaDAO extends QueryHelper {

    /**
     * Método responsável pela persistência de um objeto do tipo Pessoa
     * junto ao banco de dados.
     * @param pessoa - o objeto do tipo Pessoa a ser gravado no banco
     * @return True se os dados foram gravados corretamente ou 
     * False se a gravação falhar
     * @throws SQLException
     */
    public boolean cadastrarPessoa(Pessoa pessoa) throws SQLException {
        this.query = "INSERT INTO pessoa (nomePessoa, sexoPessoa, rgPessoa, "
                + "orgaoEmissorRgPessoa, cpfPessoa, dataNascimentoPessoa)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);

        this.prepStatement.setString(1, pessoa.getNomePessoa());
        this.prepStatement.setString(2, String.valueOf(pessoa.getSexoPessoa()));
        this.prepStatement.setString(3, pessoa.getRgPessoa());
        this.prepStatement.setString(4, pessoa.getOrgaoEmissorRGPessoa());
        this.prepStatement.setString(5, pessoa.getCpfPessoa());
        this.prepStatement.setDate(6, (Date) pessoa.getDataNacimentoPessoa());       

        return this.executeUpdate();
    }

    /**
     * Método responsável pela atualização dos
     * dados de uma pessoa previamente cadastrada no banco de dados.
     * @param pessoa - o objeto do tipo Pessoa a ser gravado no banco
     * @return True se os dados foram gravados corretamente ou 
     * False se a gravação falhar
     * @throws SQLException
     */
    public boolean atualizarPessoa(Pessoa pessoa) throws SQLException {
        this.query = "UPDATE pessoa SET nomePessoa = ?, sexoPessoa = ?, "
                + "rgPessoa = ?, orgaoEmissorRgPessoa = ?, cpfPessoa = ?, "
                + "dataNascimentoPessoa = ? WHERE idPessoa = ?";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        this.prepStatement.setString(1, pessoa.getNomePessoa());
        this.prepStatement.setString(2, String.valueOf(pessoa.getSexoPessoa()));
        this.prepStatement.setString(3, pessoa.getRgPessoa());
        this.prepStatement.setString(4, pessoa.getOrgaoEmissorRGPessoa());
        this.prepStatement.setString(5, pessoa.getCpfPessoa());
        this.prepStatement.setDate(6, (Date) pessoa.getDataNacimentoPessoa());
        this.prepStatement.setInt(7, pessoa.getIdPessoa());

        return this.executeUpdate();
    }

    /**
     * Método que remove uma pessoa cadastrada no banco de dados do sistema
     * @param idPessoa - o ID da pessoa que será apagada
     * @return True se algum registro do banco foi apagado, ou False caso a 
     * pessoa não esteja cadastrada no banco.
     * @throws SQLException
     */
    public boolean apagarPessoa(int idPessoa) throws SQLException {
        this.query = "DELETE FROM pessoa WHERE idPessoa = ?";

        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);

        this.prepStatement.setInt(1, idPessoa);

        return this.executeUpdate();
    }
}
