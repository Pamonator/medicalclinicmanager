/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.pacotetestjunit.pacientecontroller;

import br.com.caraguataappz.mcm.helper.IsInteger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilca
 */
public class PacienteControllerTest {
    
    public PacienteControllerTest() {
    }
  
    @Test
    public void isIntegerTest() {
        
        try {
            assertTrue(IsInteger.isInteger("4r56"));
            
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
            
        }
        
    }
}
