/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.helper;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilca
 */
public class CpfValidatorTest {
    
    public CpfValidatorTest() {
    }
    
      
     @Test
     public void cpfValidatorTest() {
     
         CPFValidator cPFValidator = new CPFValidator();
         
         boolean isValid = cPFValidator.isCpfValid("28425568870");
         
         assertTrue(isValid);
         
         isValid = cPFValidator.isCpfValid("119.762.728-66");        
         
         assertTrue(isValid);
     
     }
}
