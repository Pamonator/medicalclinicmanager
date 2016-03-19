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

    public static PessoaControle pessoaControle() {
        return new PessoaControle();
    }
    
    public static PacienteControle pacienteControle() {
        return new PacienteControle();
    }
    
    public static EnderecoControle enderecoControle() {
        return new EnderecoControle();
    }
    
    public static TelefoneControle telefoneControle() {
        return new TelefoneControle();
    }
    
    public static EmailControle emailControle() {
        return new EmailControle();
    }
}
