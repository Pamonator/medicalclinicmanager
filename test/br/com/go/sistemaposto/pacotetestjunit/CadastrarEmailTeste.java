/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.sistemaposto.pacotetestjunit;

import br.com.go.sistemaposto.control.SistemaControle;
import br.com.go.sistemaposto.model.Email;
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
public class CadastrarEmailTeste {

    public CadastrarEmailTeste() {
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
    public void inserirEmail() throws SQLException {
        Email email = new Email("blablabla@blablabla.com");

        assertTrue(SistemaControle.emailControle().cadastrarEmail(email));
    }
}
