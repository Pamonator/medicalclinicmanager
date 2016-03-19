/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemaposto.pacotetestjunit;

import br.com.go.sistemaposto.control.SistemaControle;
import br.com.go.sistemaposto.model.Endereco;
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
        Endereco endereco = new Endereco.Builder()
                .logradouroEndPaciente("blabla")
                .numeroEndPaciente("0B")
                .complementoEndPaciente("fundos")
                .bairroEndPaciente("CEntro")
                .cidadeEndPaciente("Caraguatachuva")
                .CEPEndPaciente("11660-001")
                .construir();

        assertTrue(SistemaControle.enderecoControle().cadastrarEndereco(endereco));
    }
}
