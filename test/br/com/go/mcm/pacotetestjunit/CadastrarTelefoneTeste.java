/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.pacotetestjunit;

import br.com.go.mcm.control.SistemaControle;
import br.com.go.mcm.model.Telefone;
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
public class CadastrarTelefoneTeste {

    public CadastrarTelefoneTeste() {
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
    public void inserirTelefone() throws SQLException {
        Telefone telefone = new Telefone("12-3883-0890", null, "(12)98888-7777");

        assertTrue(SistemaControle.telefoneControle().cadastrarTelefone(telefone));
    }
}
