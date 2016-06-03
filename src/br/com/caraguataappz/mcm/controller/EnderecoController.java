/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

import br.com.caraguataappz.mcm.dao.EnderecoDAO;
import br.com.caraguataappz.mcm.model.Endereco;
import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class EnderecoController {
    
    private final EnderecoDAO enderecoDAO;
    
    public EnderecoController() throws SQLException {
        
        this.enderecoDAO = new EnderecoDAO();
        
    }
    
    public boolean cadastrarEndereco(Endereco endereco) throws Exception {
        
        boolean cadastrarEndereco = false;
        
        

            cadastrarEndereco = enderecoDAO.cadastrarEndereco(endereco);
            
       
        return cadastrarEndereco;
        
    }
    
    public boolean isEnderecoValid(Endereco endereco) throws Exception {
        
        boolean isNotValid = endereco.getLogradouroEndereco().trim().equals("");
        
        if (isNotValid) {
            
            throw new Exception("Favor informar o logradouro do endereço "
                    + "que deseja cadastrar.");
            
        }
        
        isNotValid = endereco.getNumeroEndereco().trim().equals("");
        
        if (isNotValid) {
            
            throw new Exception("Favor informar o número do endereço "
                    + "que deseja cadastrar.");
            
        }
        
        isNotValid = endereco.getBairroEndereco().trim().equals("");
        
        if (isNotValid) {
            
            throw new Exception("Favor informar o bairro do endereço "
                    + "que deseja cadastrar.");
            
        }
        
        isNotValid = endereco.getCidadeEndereco().trim().equals("");
        
        if (isNotValid) {
            
            throw new Exception("Favor informar a cidade do "
                    + "endereço que deseja cadastrar");
            
        }
        
        isNotValid = endereco.getCEPEndereco().trim().equals("");
        
        if (isNotValid) {
            
            throw new Exception("Favor informar o CEP do "
                    + "endereço que deseja cadastrar");
            
        }       
        
        return true;
        
    }
    
    
}
