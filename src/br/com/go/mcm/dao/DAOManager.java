/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.dao;

/**
 *
 * @author gilca
 */
public class DAOManager {

    /**
     * Este método retorna uma instância de um objeto do tipo PessoaDAO
     * @return um objeto do tipo PessoaDAO
     */
    public static PessoaDAO pessoaControle() {
        return new PessoaDAO();
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo PacienteDAO
     * @return um objeto do tipo PacienteDAO
     */
    public static PacienteDAO pacienteControle() {
        return new PacienteDAO();
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo EnderecoDAO
     * @return um objeto do tipo EnderecoDAO
     */
    public static EnderecoDAO enderecoControle() {
        return new EnderecoDAO();
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo TelefoneDAO
     * @return um objeto do tipo TelefoneDAO
     */
    public static TelefoneDAO telefoneControle() {
        return new TelefoneDAO();
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo EmailDAO
     * @return um objeto do tipo EmailDAO
     */
    public static EmailDAO emailControle() {
        return new EmailDAO();
    }
        
    /**
     *
     * @return
     */
    public static MedicoDAO medicoControle() {
        return new MedicoDAO();
    }
    
    public static FuncionarioDAO funcionarioControle() {
        return new FuncionarioDAO();
    }
}
