/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.pacotetestjunit;

import br.com.go.mcm.control.SistemaControle;
import br.com.go.mcm.dbconnection.RestaurarBackupMYSQL;
import br.com.go.mcm.model.Pessoa;
import java.sql.Date;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author gilca
 */
public class CadastrarPessoaTeste {
    
    
    public CadastrarPessoaTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
                
    }    
    
    @Before
    public void setUp() {
        //RestaurarBackupMYSQL.restoreDB();
    }
    
    @Test
    public void cadastrarPessoa() throws SQLException {
        Pessoa pessoa;
        pessoa = new Pessoa.Builder()
                .nomePessoa("Johnny Hill Billy")
                .sexoPessoa('M')
                .RGPessoa("16789345-0")
                .dataEmissaoRGPessoa(new Date(100, 10, 10))
                .orgaoEmissorRGPessoa("SSP-SP")
                .CPFPessoa("111222333-44")
                .dataNacimentoPessoa(new Date(90, 10, 10))
                .contruir();
        
        Assert.assertTrue(SistemaControle.pessoaControle().cadastrarPessoa(pessoa));
    }
}
