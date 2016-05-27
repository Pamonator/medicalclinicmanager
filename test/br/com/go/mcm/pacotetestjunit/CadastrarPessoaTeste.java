/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.pacotetestjunit;

import br.com.go.mcm.dao.DAOManager;
import br.com.go.mcm.dbconnection.RestaurarBackupMYSQL;
import br.com.go.mcm.model.Pessoa;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        Calendar calendar = new GregorianCalendar(1990, 9, 10);

        Date dataNascimentoPessoa = new Date(calendar.getTimeInMillis());
        
        Pessoa pessoa;
        pessoa = new Pessoa.Builder()
                .nomePessoa("Johnny Hill Billy")
                .sexoPessoa('M')
                .rgPessoa("16789345-0")
                .orgaoEmissorRGPessoa("SSP-SP")
                .cpfPessoa("111222333-44")
                .dataNacimentoPessoa(dataNascimentoPessoa)
                .contruir();
        
        Assert.assertTrue(DAOManager.pessoaControle().cadastrarPessoa(pessoa));
    }
}
