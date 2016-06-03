/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

import br.com.caraguataappz.mcm.model.Medico;

/**
 *
 * @author gilca
 */
public class MedicoController {    
    
    public boolean isMedicoValid(Medico medico) throws Exception {
        
         boolean isNotValid = medico.getCrmMedico().trim().equals("");
         
         if (isNotValid) {
            
             throw new Exception("Favor informar o CRM do médico.");
             
        }
        
        isNotValid = medico.getEspecialidadeMedico().trim().equals("");
        
        if (isNotValid) {
            
            throw new Exception("Favor informar a especialidade médica.");
            
        }
        
        return true;
        
    }
    
}
