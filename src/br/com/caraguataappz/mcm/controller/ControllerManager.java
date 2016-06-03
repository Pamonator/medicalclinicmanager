/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

import java.sql.SQLException;

/**
 *
 * @author gilca
 */
public class ControllerManager {
    
    public static PessoaController pessoaController() throws SQLException{
        
        return new PessoaController();
        
    }
    
    public static EnderecoController enderecoController() throws SQLException {
        
        return new EnderecoController();
        
    }
    
    
    public static TelefoneController telefoneController() throws SQLException {
        
        return new TelefoneController();
        
    }
    
    
    public static EmailController emailcontroler() {
        
        return new EmailController();
        
    }
    
    public static PacienteController pacienteController() {
        
        return new PacienteController();       
        
    }
    
    public static MedicoController medicoController() {
        
        return new MedicoController();
        
    }
    
    public static ConsultaController consultaController() {
        
        return new ConsultaController();
        
    }
    
    
    public static DataController dataController() {
        
        return new DataController();
        
    }
    
}
