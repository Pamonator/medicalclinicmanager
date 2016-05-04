/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.control;

import br.com.go.mcm.model.Consulta;
import br.com.go.mcm.model.Medico;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a1402293
 */
public class ConsultaControle extends QueryHelper {

    public String gerarQueryAgendarConsulta(Consulta consulta) {
        this.query = "INSERT INTO consulta (prontuarioPaciente, crmMedico, dataConsulta, "
                + "diagnosticoConsulta, exameSolicitado) VALUES ("
                + consulta.getPaciente().getProntuarioPaciente() + ", '"
                + consulta.getMedico().getCrmMedico() + "', '"
                + consulta.getDataConsulta() + "', '" + consulta.getDiagnostico() + "', '"
                + consulta.getExamesSolicitado() + "');";

        return this.query;
    }

    public String gerarQueryAtualizarAgendarConsulta(Consulta consulta) {
        this.query = "UPDATE consulta SET prontuarioPaciente = " + consulta.getPaciente().getProntuarioPaciente() + ", "
                + "crmMedico = '" + consulta.getMedico() + "', dataConsulta = '" + consulta.getDataConsulta() + "', "
                + "diagnosticoConsulta = '" + consulta.getDiagnostico() + "', "
                + "exameSolicitado = '" + consulta.getExamesSolicitado() + "', "
                + "statusConsulta = '" + consulta.getStatusConsulta() + "';";

        return this.query;
    }

    public Consulta buscarConsulta(int idConsulta) throws SQLException {
         
        return null;
    }

    public List<Consulta> listarConsulta() throws SQLException {
        List<Consulta> listaConsulta = null;
       
        
        this.query = "SELECT * FROM consulta "
                + "NATURAL JOIN medico m"
                + "NATURAL JOIN paciente paci "
                ;
        
        
        this.prepStatement = this.mySqlControle.getConnection().prepareStatement(query);
        
        this.resultSet = this.prepStatement.executeQuery();
        
        while (this.resultSet.next()) {
             //Medico medico = new Medico()
            Consulta consulta = new Consulta.Builder()
                    .idConsulta(this.resultSet.getInt("idConsulta"))
                    .statusConsulta("")
                    .construir();
        }

        return listaConsulta;

    }

}
