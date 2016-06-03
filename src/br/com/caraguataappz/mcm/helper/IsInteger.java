/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.helper;

/**
 *
 * @author gilca
 */
public class IsInteger {
    
    public static boolean isInteger(String string) throws Exception {
        
        try {
            
            Integer.parseInt(string);
            
            return true;
            
        } catch (Exception e) {
            
            throw new Exception("O prontuário do paciente só pode conter números!");
            
        }
        
    }
    
}
