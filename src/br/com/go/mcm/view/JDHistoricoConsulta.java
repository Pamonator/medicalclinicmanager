/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.go.mcm.view;

import br.com.go.mcm.dao.DAOManager;
import br.com.go.mcm.model.Consulta;
import br.com.go.mcm.model.Medico;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gilca
 */
public class JDHistoricoConsulta extends javax.swing.JDialog {

    private final String[] listaHorario;
    Calendar calendar;

    /**
     * Creates new form JDAgendarConsulta
     *
     * @param parent
     * @param modal
     */
    public JDHistoricoConsulta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        listaHorario = new String[]{
            "08:00:00",
            "08:30:00",
            "09:00:00",
            "09:30:00",
            "10:00:00",
            "10:30:00",
            "11:00:00",
            "11:30:00",
            "12:00:00",
            "12:30:00",
            "13:00:00",
            "13:30:00",
            "14:00:00",
            "14:30:00",
            "15:00:00",
            "15:30:00",
            "16:00:00",
            "16:30:00",
            "17:00:00",
            "17:30:00"};

        this.calendar = new GregorianCalendar();

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jLabel58 = new javax.swing.JLabel();
        jcbListaMedico = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserPropertyChange(evt);
            }
        });

        jLabel2.setText("Data da Consulta:");

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Horario", "Paciente", "Celular", "Retorno", "Situação", "paciente", "medico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.setToolTipText("Clique duas vezes no horário que deseja agendar/editar.");
        jTableConsulta.getTableHeader().setReorderingAllowed(false);
        jTableConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableConsulta);
        if (jTableConsulta.getColumnModel().getColumnCount() > 0) {
            jTableConsulta.getColumnModel().getColumn(0).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(1).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(2).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(3).setResizable(false);
            jTableConsulta.getColumnModel().getColumn(5).setMinWidth(0);
            jTableConsulta.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTableConsulta.getColumnModel().getColumn(5).setMaxWidth(0);
            jTableConsulta.getColumnModel().getColumn(6).setMinWidth(0);
            jTableConsulta.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTableConsulta.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel58.setText("Dr(a):");

        jcbListaMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dr." }));
        jcbListaMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbListaMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbListaMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbListaMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel58)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbListaMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbListaMedicoActionPerformed

        if (this.jcbListaMedico.getSelectedIndex() >= 0) {

            String nomeMedico = this.jcbListaMedico.getItemAt(this.jcbListaMedico.getSelectedIndex());

            this.calendar = jDateChooser.getCalendar();

            try {

                //pegar todas as conultas marcadas para determinado médico da data escolhida no jdatachooser
                List<Consulta> listaConsulta = DAOManager.consultaDAO().listarAgendaDiaMedico(nomeMedico,
                        new Date((calendar.get(Calendar.YEAR) - 1900),
                                calendar.get(Calendar.MONDAY),
                                calendar.get(Calendar.DAY_OF_MONTH)));

                this.preencherTabelaConsulta(listaConsulta);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, "Erro de leitura dos dados. Favor entrar em"
                        + "contato com o suporte.\nInformação sobre o erro:" + ex.getMessage());

            }

        }
    }//GEN-LAST:event_jcbListaMedicoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //título da janela
        this.setTitle("Agenda de Consultas");
        //localização da janela (centro do monitor)
        this.setLocationRelativeTo(null);
        //ícone da janela
        URL url = this.getClass().getResource("nurse-16.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);

        this.jDateChooser.setDate(new java.util.Date(calendar.getTimeInMillis()));

        this.preencherListaMedico();

    }//GEN-LAST:event_formWindowOpened

    private void jTableConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaMouseClicked
        
        int clickCount = evt.getClickCount();
        
        if (clickCount > 1) {
            
            Consulta consulta = new Consulta.Builder().construir();
            
            
            
        }
        
    }//GEN-LAST:event_jTableConsultaMouseClicked

    private void jDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserPropertyChange
        System.out.println("success!!");
    }//GEN-LAST:event_jDateChooserPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDHistoricoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            JDHistoricoConsulta dialog = new JDHistoricoConsulta(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JComboBox<String> jcbListaMedico;
    // End of variables declaration//GEN-END:variables

    private void preencherTabelaConsulta(List<Consulta> listaConsulta) {

        //System.out.println(listaConsulta.isEmpty());

        if (!listaConsulta.isEmpty()) {

            DefaultTableModel tabelaConsulta = (DefaultTableModel) this.jTableConsulta.getModel();

            tabelaConsulta.setNumRows(0);

            for (int i = 0; i < listaHorario.length; i++) {

                tabelaConsulta.addRow(new Object[]{listaHorario[i], "", "", "", null, null});

                for (Consulta consulta : listaConsulta) {

                    if (consulta.getHorarioConsulta().toString().equalsIgnoreCase(this.listaHorario[i])) {

                        tabelaConsulta.removeRow(i);

                        tabelaConsulta.insertRow(i, new Object[]{
                            consulta.getHorarioConsulta(),
                            consulta.getPaciente().getPessoa().getNomePessoa(),
                            consulta.getPaciente().getPessoa().getTelefonePessoa().getTelefoneCelular(),
                            consulta.getIsRetorno(),
                            consulta.getPaciente(),
                            consulta.getMedico()
                        });

                    }

                }

            }

            //Consulta consulta = listaConsulta.get(i);
            this.jTableConsulta.setModel(tabelaConsulta);

            this.jTableConsulta.setRowSelectionAllowed(true);

            this.jTableConsulta.setColumnSelectionAllowed(false);

        }

    }

    private void preencherListaMedico() {

        List<Medico> listaMedico;

        this.jcbListaMedico.removeAllItems();

        try {

            listaMedico = DAOManager.medicoDAO().listarMedico();

            if (!listaMedico.isEmpty()) {

                listaMedico.stream().forEach((Medico medico) -> {

                    JDHistoricoConsulta.this.jcbListaMedico.addItem(medico.getPessoa().getNomePessoa());

                });

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this, "Erro de leitura dos dados. Favor entrar em"
                    + "contato com o suporte.\nInformação sobre o erro:" + ex.getMessage());

        }

    }
}
