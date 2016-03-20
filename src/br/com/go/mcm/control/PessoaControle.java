/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

import br.com.go.mcm.model.Pessoa;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class PessoaControle extends QueryHelper {
    
    public boolean cadastrarPessoa(Pessoa pessoa) throws SQLException {
        this.query = "INSERT INTO pessoa (nomePessoa, sexoPessoa, rgPessoa, "
                + "dataEmissaoRgPessoa, orgaoEmissorRgPessoa, cpfPessoa, "
                + "dataNascimentoPessoa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(this.query);
        
        this.prepStatement.setString(1, pessoa.getNomePessoa());
        this.prepStatement.setString(2, String.valueOf(pessoa.getSexoPessoa()));
        this.prepStatement.setString(3, pessoa.getRGPessoa());
        this.prepStatement.setDate(4, (Date) pessoa.getDataEmissaoRGPessoa());
        this.prepStatement.setString(5, pessoa.getOrgaoEmissorRGPessoa());
        this.prepStatement.setString(6, pessoa.getCPFPessoa());
        this.prepStatement.setDate(7, (Date) pessoa.getDataNacimentoPessoa());
        
        return this.executeUpdate();
    }
}
