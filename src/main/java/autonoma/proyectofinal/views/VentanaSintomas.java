package autonoma.proyectofinal.views;

import autonoma.proyectofinal.models.DiagnosticoDAO;
import autonoma.proyectofinal.models.Enfermedad;
import autonoma.proyectofinal.models.PacienteDAO;
import autonoma.proyectofinal.models.PrologQueryExecutor;
import autonoma.proyectofinal.models.Sintomas;
import autonoma.proyectofinal.models.SintomasDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class VentanaSintomas extends javax.swing.JDialog {

    private Enfermedad enfermedadDiagnosticada;
    private Enfermedad enfermedadProlog;
    private List<Sintomas> ss;

    public VentanaSintomas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(800, 850);
        panelSintomas.setLayout(new BoxLayout(panelSintomas, BoxLayout.Y_AXIS));
        generarSintomasCheckBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSintomas = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAgregarEnfermedad = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnGenerarPosiblesEnfermedades = new javax.swing.JButton();
        btnCrearDiagnostico = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPosiblesEnfermedades = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSintomasSeleccionados = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombrePaciente = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 850));
        setMinimumSize(new java.awt.Dimension(800, 850));
        setSize(new java.awt.Dimension(800, 850));

        javax.swing.GroupLayout panelSintomasLayout = new javax.swing.GroupLayout(panelSintomas);
        panelSintomas.setLayout(panelSintomasLayout);
        panelSintomasLayout.setHorizontalGroup(
            panelSintomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelSintomasLayout.setVerticalGroup(
            panelSintomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 110));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("¡Sistema experto de diágnosticos!");

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 750));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel1)
                .addContainerGap(207, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarEnfermedad.setBackground(new java.awt.Color(204, 204, 255));
        btnAgregarEnfermedad.setText("Agregar nueva enfermedad");
        btnAgregarEnfermedad.setActionCommand("");
        btnAgregarEnfermedad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarEnfermedadMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Ver tabla diágnosticos");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnGenerarPosiblesEnfermedades.setBackground(new java.awt.Color(204, 204, 255));
        btnGenerarPosiblesEnfermedades.setText("Generar posibles enfermedades");
        btnGenerarPosiblesEnfermedades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarPosiblesEnfermedadesMouseClicked(evt);
            }
        });
        btnGenerarPosiblesEnfermedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPosiblesEnfermedadesActionPerformed(evt);
            }
        });

        btnCrearDiagnostico.setBackground(new java.awt.Color(204, 204, 255));
        btnCrearDiagnostico.setText("Crear diágnostico");
        btnCrearDiagnostico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearDiagnosticoMouseClicked(evt);
            }
        });
        btnCrearDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearDiagnosticoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        txtPosiblesEnfermedades.setColumns(20);
        txtPosiblesEnfermedades.setRows(5);
        jScrollPane2.setViewportView(txtPosiblesEnfermedades);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Posibles enfermedades");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel3)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Sintomas Seleccionados");

        txtSintomasSeleccionados.setColumns(20);
        txtSintomasSeleccionados.setRows(5);
        jScrollPane1.setViewportView(txtSintomasSeleccionados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nombre del paciente:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Id del paciente:");

        txtNombrePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePacienteActionPerformed(evt);
            }
        });

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Por favor, seleccione el nombre del paciente y los síntomas que padece:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Por favor, seleccione alguna funcionalidad:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Si desea generar un reporte, seleccione el botón \"Exportar CSV\":");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Síntomas:");

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Exportar CSV");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(btnAgregarEnfermedad)
                                    .addComponent(jLabel8)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnGenerarPosiblesEnfermedades)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCrearDiagnostico))
                                    .addComponent(jButton2))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelSintomas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenerarPosiblesEnfermedades)
                            .addComponent(btnCrearDiagnostico))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarEnfermedad)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(panelSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarPosiblesEnfermedadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPosiblesEnfermedadesMouseClicked
        this.txtSintomasSeleccionados.setText(null);
        this.txtPosiblesEnfermedades.setText(null);
        this.ss = obtenerSeleccionados();
        for (Sintomas s : ss) {
            this.txtSintomasSeleccionados.append(s.getSintoma_id() + ". " + s.getNombre_sintoma() + "\n");
        }
        String nombre = txtNombrePaciente.getText();
        try {
            PacienteDAO pd = new PacienteDAO();
            int id = pd.obtenerIdPaciente(nombre);

            this.txtId.setText(String.valueOf(id));

        } catch (SQLException e) {
            System.getLogger(PacienteDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        }
        List<Enfermedad> posiblesEnfermedades = pEnfermedades(ss);
        this.enfermedadDiagnosticada = enfermedadMasProbable(posiblesEnfermedades);
        System.out.println(enfermedadDiagnosticada.getNombreEnfermedad());
        this.enfermedadProlog = PrologQueryExecutor.getAtomosEnfermedad("enfermedad(" + enfermedadDiagnosticada.getNombreEnfermedad() + ",sintomas(Sintomas),categoria(Categoria),recomendaciones(Recomendaciones))");
        this.txtPosiblesEnfermedades.setText("Enfermedad  ,  Categoria  ,  Recomendaciones" + "\n" + "\n");
        this.txtPosiblesEnfermedades.append(enfermedadDiagnosticada.getNombreEnfermedad() + "," + enfermedadProlog.getNombreCategoria() + "," + enfermedadProlog.getRecomendacionBasica());
    }//GEN-LAST:event_btnGenerarPosiblesEnfermedadesMouseClicked

    private void btnCrearDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearDiagnosticoActionPerformed


    }//GEN-LAST:event_btnCrearDiagnosticoActionPerformed

    private void btnCrearDiagnosticoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearDiagnosticoMouseClicked
        // Obtener el ID del paciente
        String idTexto = txtId.getText();
        if (idTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero genera las posibles enfermedades");
            return;
        }

        int idPaciente = Integer.parseInt(idTexto);
        String recomendacion = enfermedadProlog.getRecomendacionBasica();
        String enfermedad = enfermedadDiagnosticada.getNombreEnfermedad();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.ss.size(); i++) {
            sb.append(this.ss.get(i).getNombre_sintoma());
            if (i < this.ss.size() - 1) {
                sb.append(",");
            }
            sb.append("]");
        }
        String sintomas = sb.toString();

        try {
            DiagnosticoDAO diagDAO = new DiagnosticoDAO();
            if (diagDAO.insertarDiagnosticoCompleto(idPaciente, sintomas, enfermedad, recomendacion)) {
                JOptionPane.showMessageDialog(this, "Diagnostico agregado con exito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Hubo un error al agregar el diagnostico" + e.getMessage());
        }
    }//GEN-LAST:event_btnCrearDiagnosticoMouseClicked

    private void txtNombrePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePacienteActionPerformed
        txtNombrePaciente.setText("");
    }//GEN-LAST:event_txtNombrePacienteActionPerformed

    private void btnGenerarPosiblesEnfermedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPosiblesEnfermedadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarPosiblesEnfermedadesActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        txtId.setText("");
    }//GEN-LAST:event_txtIdActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        VentanaDiagnostico ventanadiagnostico = new VentanaDiagnostico(null, true);
        ventanadiagnostico.setLocationRelativeTo(null);
        this.dispose();
        ventanadiagnostico.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnAgregarEnfermedadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarEnfermedadMouseClicked
        VentanaAgregarEnfermedad ventanaAgregarEnfermedad = new VentanaAgregarEnfermedad();
        ventanaAgregarEnfermedad.setLocationRelativeTo(null);
        this.dispose();
        ventanaAgregarEnfermedad.setVisible(true);
    }//GEN-LAST:event_btnAgregarEnfermedadMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VentanaCSV ventanaCSV;
        try {
            ventanaCSV = new VentanaCSV(null, true);
            ventanaCSV.setLocationRelativeTo(null);
            this.dispose();
            ventanaCSV.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaSintomas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        VentanaPrincipal ventanaprincipal = new VentanaPrincipal();
        ventanaprincipal.setLocationRelativeTo(null);
        this.dispose();
        ventanaprincipal.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
    private void generarSintomasCheckBox() {
        SintomasDAO sdao = new SintomasDAO();
        try {
            List<Sintomas> lista = sdao.obtenerSintomas();
            for (Sintomas s : lista) {
                JCheckBox cb = new JCheckBox(s.getSintoma_id() + ". " + s.getNombre_sintoma());
                cb.putClientProperty("info", s);
                panelSintomas.add(cb);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar síntomas: " + e.getMessage());
        }
    }

    private List<Sintomas> obtenerSeleccionados() {
        List<Sintomas> seleccionados = new ArrayList<>();
        for (Component c : panelSintomas.getComponents()) {
            if (c instanceof JCheckBox cb) {
                if (cb.isSelected()) {
                    // Obtenemos el sintoma guardado dentro del checkbox
                    Sintomas s = (Sintomas) cb.getClientProperty("info");
                    seleccionados.add(s);
                }
            }
        }
        return seleccionados;
    }

    private List<Enfermedad> pEnfermedades(List<Sintomas> s) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < s.size(); i++) {
            Sintomas si = s.get(i);
            sb.append(si.getNombre_sintoma());
            if (i < s.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        List<Enfermedad> Eexacta = PrologQueryExecutor.getSolutions("coincide_sintomas(" + sb.toString() + ",Nombre)");

        if (!Eexacta.isEmpty()) {
            return Eexacta;
        }

        List<Enfermedad> posiblesEnf = PrologQueryExecutor.getSolutions("diagnostico(" + sb.toString() + ",Nombre)");

        return posiblesEnf;
    }

    private Enfermedad enfermedadMasProbable(List<Enfermedad> lista) {

        Map<String, Integer> contador = new HashMap<>();

        for (Enfermedad e : lista) {
            contador.put(e.getNombreEnfermedad(), contador.getOrDefault(e.getNombreEnfermedad(), 0) + 1);
        }

        String mejor = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > max) {
                mejor = entry.getKey();
                max = entry.getValue();
            }
        }

        for (Enfermedad e : lista) {
            if (e.getNombreEnfermedad().equals(mejor)) {
                return e;
            }
        }

        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEnfermedad;
    private javax.swing.JButton btnCrearDiagnostico;
    private javax.swing.JButton btnGenerarPosiblesEnfermedades;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelSintomas;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextArea txtPosiblesEnfermedades;
    private javax.swing.JTextArea txtSintomasSeleccionados;
    // End of variables declaration//GEN-END:variables
}
