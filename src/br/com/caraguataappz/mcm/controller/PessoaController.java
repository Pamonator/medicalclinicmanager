/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

import br.com.caraguataappz.mcm.dao.PessoaDAO;
import br.com.caraguataappz.mcm.helper.CPFValidator;
import br.com.caraguataappz.mcm.model.Pessoa;

/**
 *
 * @author gilca
 */
public class PessoaController {
    
    private final PessoaDAO pessoaDAO;
    private final CPFValidator cPFValidator;
    
    
    public PessoaController() {
        
        this.pessoaDAO = new PessoaDAO();
        
        this.cPFValidator = new CPFValidator();
        
    }
    
    public boolean cadastrarPessoa(Pessoa pessoa) throws Exception {
        
        boolean cadastrarPessoa = false;
        
        if (this.isPessoaValid(pessoa)) {
            
            cadastrarPessoa = this.pessoaDAO.cadastrarPessoa(pessoa);
            
        }
        
        
        return cadastrarPessoa;
    }

    private boolean isPessoaValid(Pessoa pessoa) throws Exception {
        
        boolean pacienteCpfValid = this.isPacienteCpfValid(
                pessoa.getCpfPessoa());

        if (!pacienteCpfValid) {

            throw new Exception("O CPF informado não é válido!");

        }

        boolean nomePessoa = pessoa.getNomePessoa().trim().equals("");

        if (!nomePessoa) {

            throw new Exception("Favor preencher o nome do "
                    + "paciente que deseja cadastrar.");

        }
        
        boolean rgPessoa = pessoa.getRgPessoa().trim().equals("");
        
        if (!rgPessoa) {
            
            throw new Exception("Favor informar um número de RG.");
            
        }
        
        boolean orgaoEmissorRgPessoa = pessoa.getOrgaoEmissorRGPessoa()
                .trim().equals("");
        
        if (!orgaoEmissorRgPessoa) {
            
            throw new Exception("Favor informar o Órgão Emissor do RG.");
            
        }
        
        boolean dataNascimentoPessoa = pessoa.getDataNacimentoPessoa().getTime() > 0;
        
        if (!dataNascimentoPessoa) {
            
            throw new Exception("Favor informar a data de nascimento.");
            
        }  
        
        return true;
        
    }
    
    private boolean isPacienteCpfValid(String cpfPessoa) {

        return this.cPFValidator.isCpfValid(cpfPessoa);

    }

    public boolean isDataValid(String data) throws Exception {
        
        boolean dataValid = false;
        
        if (data.length() > 0 && data.contains("/")) {
            
            String[] split = data.split("/");
            
            for(String s : split) {
                
                try { 
                    
                    Integer.parseInt(s);
                    
                } catch (Exception e) {
                    
                    throw new Exception("A data de nascimento só pode conter números.");
                    
                }
                
            }
            
            dataValid = true;
            
        } else {
            
            throw new Exception("Informe uma data de nascimento válida");
            
        }
        
        return dataValid;
        
    }
    
}
