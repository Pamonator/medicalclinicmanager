/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

/**
 *
 * @author gilca
 */
public class SistemaControle {

    /**
     * Este método retorna uma instância de um objeto do tipo PessoaControle
     * @return um objeto do tipo PessoaControle
     */
    public static PessoaControle pessoaControle() {
        return new PessoaControle();
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo PacienteControle
     * @return um objeto do tipo PacienteControle
     */
    public static PacienteControle pacienteControle() {
        return new PacienteControle();
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo EnderecoControle
     * @return um objeto do tipo EnderecoControle
     */
    public static EnderecoControle enderecoControle() {
        return new EnderecoControle();
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo TelefoneControle
     * @return um objeto do tipo TelefoneControle
     */
    public static TelefoneControle telefoneControle() {
        return new TelefoneControle();
    }
    
    /**
     * Este método retorna uma instância de um objeto do tipo EmailControle
     * @return um objeto do tipo EmailControle
     */
    public static EmailControle emailControle() {
        return new EmailControle();
    }
        
}
