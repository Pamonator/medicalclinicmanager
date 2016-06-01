/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caraguataappz.mcm.pacotetestjunit;

import br.com.caraguataappz.mcm.dao.DAOManager;
import br.com.caraguataappz.mcm.model.Email;
import br.com.caraguataappz.mcm.model.Endereco;
import br.com.caraguataappz.mcm.model.Paciente;
import br.com.caraguataappz.mcm.model.Pessoa;
import br.com.caraguataappz.mcm.model.Telefone;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author gilca
 */
public class CadastrarPacienteTeste {

    private Pessoa pessoa;
    private Paciente paciente;
    private Endereco endereco;
    private Telefone telefone;
    private Email email;

    public CadastrarPacienteTeste() {
    }

    @Before
    public void setUp() {

        endereco = new Endereco.Builder().construir();
        telefone = new Telefone();
        email = new Email();
    }

    @Test
    public void inserirPaciente() throws SQLException {
        Calendar calendar = new GregorianCalendar(1990, 9, 10);

        Date dataNascimentoPessoa = new Date(calendar.getTimeInMillis());

        pessoa = new Pessoa.Builder()
                .nomePessoa("Gil")
                .sexoPessoa('M')
                .rgPessoa("123456789")
                .orgaoEmissorRGPessoa("SSP-SP")
                .cpfPessoa("12345678907")
                .dataNacimentoPessoa(dataNascimentoPessoa)
                .contruir();

        boolean cadastrarPessoa = DAOManager.pessoaDAO().cadastrarPessoa(pessoa);

        pessoa.setIdPessoa(DAOManager
                .pessoaDAO()
                .getUltimoIdCadastrado("pessoa", "idPessoa")
        );
        
        endereco = new Endereco.Builder()
                .idPessoa(pessoa.getIdPessoa())
                .logradouroEndereco("rua sem nome")
                .numeroEndereco("0")
                .complementoEndereco("recanto ana")
                .bairroEndereco("centro")
                .cidadeEndereco("caragua")
                .estadoEndereco("SP")
                .CEPEndereco("11660-000")
                .construir();

        telefone = new Telefone(pessoa.getIdPessoa(), "3882-1798", "3882-1798", "98888-8888");
        
        email = new Email(pessoa.getIdPessoa(), "gmcarelli@gmail.com");
        
        paciente = new Paciente.Builder()
                .prontuarioPaciente(001)
                .pessoa(pessoa)
                .estadoCivilPaciente("casado")
                .profissaoPaciente("aspone")
                .escolaridadePaciente("Ensino Médio Completo")
                .contruir();
        
        ArrayList<String> queryList = new ArrayList<>();
        
        queryList.add(DAOManager.enderecoDAO().gerarQueryCadastrarEndereco(endereco));
        queryList.add(DAOManager.telefoneDAO().gerarQueryCadastrarTelefone(telefone));
        queryList.add(DAOManager.emailDAO().gerarQueryCadastrarEmail(email));
        queryList.add(DAOManager.pacienteDAO().gerarQuerycadastrarPaciente(paciente));

        assertTrue(DAOManager.pacienteDAO().excuteTransaction(queryList));
    }
}
