/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.pacotetestjunit;

import br.com.go.mcm.control.SistemaControle;
import br.com.go.mcm.model.Email;
import br.com.go.mcm.model.Endereco;
import br.com.go.mcm.model.Paciente;
import br.com.go.mcm.model.Pessoa;
import br.com.go.mcm.model.Telefone;
import java.sql.SQLException;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilca
 */
public class CadastrarPacienteTeste {

    private Paciente paciente;
    private Endereco endereco;
    private Telefone telefone;
    private Email email;

    public CadastrarPacienteTeste() {
    }

    @Test
    public void inserirPaciente() throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 10, 10);

        endereco.setIdEndereco(SistemaControle
                .enderecoControle()
                .getUltimoIdCadastrado("endereco", "idEndereco")
        );

        telefone.setIdTelefone(SistemaControle
                .telefoneControle()
                .getUltimoIdCadastrado("telefone", "idTelefone")
        );

        email.setIdEmail(SistemaControle
                .emailControle()
                .getUltimoIdCadastrado("email", "idEmail")
        );

        paciente = new Paciente.Builder()
                .prontuarioPaciente(001)
                .pessoa(new Pessoa.Builder().contruir())
                .estadoCivilPaciente("casado")
                .profissaoPaciente("aspone")
                .escolaridadePaciente("Ensino Médio Completo")
                .contruir();

        paciente.getPessoa().setIdPessoa(SistemaControle
                .pessoaControle()
                .getUltimoIdCadastrado("pessoa", "idPessoa")
        );
        assertTrue(SistemaControle.pacienteControle().cadastrarPaciente(paciente));
    }
}
