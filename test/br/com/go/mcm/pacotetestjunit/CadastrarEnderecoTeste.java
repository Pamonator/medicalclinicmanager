/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.pacotetestjunit;

import br.com.go.mcm.dao.DAOManager;
import br.com.go.mcm.model.Endereco;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilca
 */
public class CadastrarEnderecoTeste {
    
    public CadastrarEnderecoTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void inserirEndereco() throws SQLException {
        int idPessoa = DAOManager.pessoaControle().getUltimoIdCadastrado("pessoa", "idPessoa");
        
        Endereco endereco = new Endereco.Builder()
                .idPessoa(idPessoa)
                .logradouroEndereco("blabla")
                .numeroEndereco("0B")
                .complementoEndereco(null)
                .bairroEndereco("CEntro")
                .cidadeEndereco("Caraguatachuva")
                .estadoEndereco("SP")
                .CEPEndereco("11660-001")
                .construir();

        assertTrue(DAOManager.enderecoControle().cadastrarEndereco(endereco));
    }
}
