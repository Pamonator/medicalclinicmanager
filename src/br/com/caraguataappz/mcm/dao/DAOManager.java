/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.dao;

/**
 *
 * @author gilca
 */
public class DAOManager {

    /**
     * Este método retorna uma instância de um objeto do tipo PessoaDAO
     * @return um objeto do tipo PessoaDAO
     */
    public static PessoaDAO pessoaDAO() {
        
        return new PessoaDAO();
        
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo PacienteDAO
     * @return um objeto do tipo PacienteDAO
     */
    public static PacienteDAO pacienteDAO() {
        
        return new PacienteDAO();
        
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo EnderecoDAO
     * @return um objeto do tipo EnderecoDAO
     */
    public static EnderecoDAO enderecoDAO() {
        
        return new EnderecoDAO();
        
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo TelefoneDAO
     * @return um objeto do tipo TelefoneDAO
     */
    public static TelefoneDAO telefoneDAO() {
        
        return new TelefoneDAO();
        
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo EmailDAO
     * @return um objeto do tipo EmailDAO
     */
    public static EmailDAO emailDAO() {
        
        return new EmailDAO();
        
    }
        
    /**
     *
     * @return
     */
    public static MedicoDAO medicoDAO() {
        
        return new MedicoDAO();
        
    }
    
    
    public static FuncionarioDAO funcionarioDAO() {
        
        return new FuncionarioDAO();
        
    }
    
    public static ConsultaDAO consultaDAO() {
        
        return new ConsultaDAO();
        
    }
}
