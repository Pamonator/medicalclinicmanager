/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.helper;

/**
 *
 * @author gilca
 */
public class CPFValidator {

    private String cpfPessoa;

    private String calcDigVerif(String num) {
        
        Integer primDig;
        
        Integer segDig;
        
        int soma = 0, peso = 10;
        
        for (int i = 0; i < num.length(); i++) {
            
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
            
        }
        
        if (soma % 11 == 0 | soma % 11 == 1) {
            
            primDig = 0;
            
        } else {
            
            primDig = 11 - (soma % 11);
            
        }
        
        soma = 0;
        
        peso = 11;
        
        for (int i = 0; i < num.length(); i++) {
            
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
            
        }
        
        soma += primDig * 2;
        
        if (soma % 11 == 0 | soma % 11 == 1) {
            
            segDig = 0;
            
        } else {
            
            segDig = 11 - (soma % 11);
            
        }
        
        return primDig.toString() + segDig.toString();
        
    }

    public boolean isCpfValid(String cpfPessoa) {
        
        this.cpfPessoa = cpfPessoa;

        this.removerCaracteres();

        if(!this.isCpfTamanhoValido() || this.isCpfDigitosIguais()) {
            
            return false;
            
        }        

        String numDig = this.cpfPessoa.substring(0, 9);

        return calcDigVerif(numDig).equals(this.cpfPessoa.substring(9, 11));
    }

    private void removerCaracteres() {

        if (this.cpfPessoa != null) {

            this.cpfPessoa = this.cpfPessoa.replace("-", "");

            this.cpfPessoa = this.cpfPessoa.replace(".", "");

        }

    }

    private boolean isCpfTamanhoValido() {

        boolean isCpfValid = false;

        if (this.cpfPessoa != null) {

            if (this.cpfPessoa.length() == 11) {

                isCpfValid = true;

            }

        }

        return isCpfValid;

    }

    private boolean isCpfDigitosIguais() {

        boolean isCpfDigitosIguais = true;

        if (this.cpfPessoa != null) {

            char firstDigit = cpfPessoa.charAt(0);

            char[] cpfChar = cpfPessoa.toCharArray();

            for (char c : cpfChar) {

                if (c != firstDigit) {

                    isCpfDigitosIguais = false;

                }

            }

        }

        return isCpfDigitosIguais;

    }

}

//    private String cpfPessoa;
//
//    public boolean isCpfValid(String cpfPessoa) {
//
//        this.cpfPessoa = cpfPessoa;
//
//        boolean isCpfValid;
//
//        String cpfAux;
//
//        this.removerCaracteres();
//
//        isCpfValid = this.isCpfTamanhoValido() && !this.isCpfDigitosIguais();
//
//        return isCpfValid;
//
//    }
//
//

//
//    private String gerarDigitoVerificadorCpf(String cpfPessoa) {
//
//        int digitoGerado = 0;
//
//        int aux = cpfPessoa.length() + 1;
//
//        char[] cpfChar = cpfPessoa.toCharArray();
//
//        for (int i = 0; i < cpfPessoa.length(); i++) {
//
//            digitoGerado += (cpfChar[i] - 48) * aux--;
//
//            if (digitoGerado % 11 < 2) {
//
//                digitoGerado = 0;
//
//            } else {
//
//                digitoGerado = 11 - (digitoGerado % 11);
//
//            }
//
//        }
//
//        return String.valueOf(digitoGerado);
//
//    }
//
//}
