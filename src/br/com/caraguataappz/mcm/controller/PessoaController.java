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

        cadastrarPessoa = this.pessoaDAO.cadastrarPessoa(pessoa);

        return cadastrarPessoa;
    }

    public boolean atualizarPessoa(Pessoa pessoa) throws Exception {

        boolean atualizarPessoa = false;

        if (this.isPessoaValid(pessoa)) {
//
            atualizarPessoa = this.pessoaDAO.atualizarPessoa(pessoa);

        }

        return atualizarPessoa;
    }

    public boolean isPessoaValid(Pessoa pessoa) throws Exception {

        boolean isNotValid = pessoa.getNomePessoa().trim().equals("");

        if (isNotValid) {

            throw new Exception("Favor preencher o nome da "
                    + "pessoa que deseja cadastrar.");

        }

//        isNotValid = !(pessoa.getDataNacimentoPessoa().getTime() > 0);
//
//        if (isNotValid) {
//
//            throw new Exception("Favor informar a data de nascimento.");
//
//        }

        isNotValid = pessoa.getRgPessoa().trim().equals("");

        if (isNotValid) {

            throw new Exception("Favor informar um número de RG.");

        }

        isNotValid = pessoa.getOrgaoEmissorRGPessoa()
                .trim().equals("");

        if (isNotValid) {

            throw new Exception("Favor informar o Órgão Emissor do RG.");

        }

        isNotValid = cPFValidator.isCpfValid(pessoa.getCpfPessoa());

        if (!isNotValid) {

            throw new Exception("O CPF informado não é válido!");

        }

        return true;

    }

}
