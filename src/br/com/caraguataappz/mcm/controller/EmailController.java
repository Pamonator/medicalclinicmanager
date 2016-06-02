/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

import br.com.caraguataappz.mcm.model.Email;

/**
 *
 * @author gilca
 */
public class EmailController {
    
    
    public boolean isEmailValid(Email email) throws Exception {
        
        boolean emailValid = false;
        
        String emailPaciente = email.getEnderecoEmail();

        if (emailPaciente.trim().equals("")) {

            throw new Exception("Favor informar um endereço de email.");

        } else {

            emailValid = this.isEnderecoEmailValid(emailPaciente);

            if (!emailValid) {

                throw new Exception("Favor informar um email válido!");

            }
        }
        
        return emailValid;
        
    }

    private boolean isEnderecoEmailValid(String enderecoEmail) {

        boolean enderecoEmailValid = false;

        if (enderecoEmail.contains("@") && enderecoEmail.contains(".com")) {

            enderecoEmailValid = true;

        }

        return enderecoEmailValid;

    }    
    
}
