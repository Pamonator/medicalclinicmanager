/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

import br.com.caraguataappz.mcm.dao.TelefoneDAO;
import br.com.caraguataappz.mcm.model.Telefone;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class TelefoneController {
    
    private final TelefoneDAO telefoneDAO;
    
    public TelefoneController() throws SQLException {
        
        this.telefoneDAO = new TelefoneDAO();
        
    }
    
    public boolean cadastrarTelefone(Telefone telefone) throws Exception {
        
        boolean cadastrarTelefone = false;
        
        
            
            cadastrarTelefone = this.telefoneDAO.cadastrarTelefone(telefone);
            
        
        
        return cadastrarTelefone;
        
    }

    public boolean isTelefoneValid(Telefone telefone) throws Exception {
        
        boolean isNotValid = telefone.getTelefoneResidencial().trim().equals("");
        
        if (isNotValid) {
            
            throw new Exception("Informe um telefone residêncial para o cadastro.");
            
        }
        
        isNotValid = telefone.getTelefoneCelular().trim().equals("");
        
        if (isNotValid) {
            
            throw new Exception("Informe um telefone celular para o cadastro.");
            
        }
        
        return true;
        
    }
    
    
    
}
