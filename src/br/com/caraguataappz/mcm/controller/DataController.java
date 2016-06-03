/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.controller;

/**
 *
 * @author gilca
 */
public class DataController {

    public boolean isDataValid(String data) throws Exception {

        boolean dataValid = false;

        String replace = data.replace("/", "");

        if (replace.trim().length() > 0) {

            try {

                Integer.parseInt(replace);

                dataValid = true;

            } catch (Exception e) {

                throw new Exception("A data de nascimento só pode conter números.");

            }

        } else {
            
            dataValid = false;
            
            throw new Exception("Informe uma data de nascimento válida");
            
        }    

        return dataValid;

    }

}
