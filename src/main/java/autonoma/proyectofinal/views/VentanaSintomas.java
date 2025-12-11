package autonoma.proyectofinal.views;

import autonoma.proyectofinal.models.Enfermedad;
import autonoma.proyectofinal.models.PrologQueryExecutor;
import autonoma.proyectofinal.models.Sintomas;
import autonoma.proyectofinal.models.SintomasDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

public class VentanaSintomas extends javax.swing.JDialog {

    public VentanaSintomas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setBounds(0, 0, 796, 426);
        panelSintomas.setLayout(new BoxLayout(panelSintomas, BoxLayout.Y_AXIS));
        generarSintomasCheckBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelSintomas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSintomasSeleccionados = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPosiblesEnfermedades = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnGenerarDiagnotico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("¡Sistema experto de diágnosticos!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel1)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelSintomasLayout = new javax.swing.GroupLayout(panelSintomas);
        panelSintomas.setLayout(panelSintomasLayout);
        panelSintomasLayout.setHorizontalGroup(
            panelSintomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        panelSintomasLayout.setVerticalGroup(
            panelSintomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

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
                .addGap(113, 113, 113)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        txtPosiblesEnfermedades.setColumns(20);
        txtPosiblesEnfermedades.setRows(5);
        jScrollPane2.setViewportView(txtPosiblesEnfermedades);

        jLabel3.setText("Posibles enfermedades");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
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

        btnGenerarDiagnotico.setBackground(new java.awt.Color(204, 204, 255));
        btnGenerarDiagnotico.setText("Generar Diagnostico");
        btnGenerarDiagnotico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarDiagnoticoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarDiagnotico)
                .addGap(289, 289, 289))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerarDiagnotico)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarDiagnoticoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarDiagnoticoMouseClicked
        this.txtSintomasSeleccionados.setText(null);
        this.txtPosiblesEnfermedades.setText(null);
        List<Sintomas> ss = obtenerSeleccionados();
        for (Sintomas s : ss) {
            this.txtSintomasSeleccionados.append(s.getSintoma_id() + ". " + s.getNombre_sintoma() + "\n");
        }

        List<Enfermedad> pE = pEnfermedades(ss);
        for (Enfermedad e : pE) {
            this.txtPosiblesEnfermedades.append(e.getNombreEnfermedad() + "\n");
        }
    }//GEN-LAST:event_btnGenerarDiagnoticoMouseClicked
    private void generarSintomasCheckBox() {
        SintomasDAO sdao = new SintomasDAO();
        try {
            List<Sintomas> lista = sdao.obtenerSintomas();
            for (Sintomas s : lista) {
                JCheckBox cb = new JCheckBox(s.getSintoma_id() + ". " + s.getNombre_sintoma());
                // Guardamos el síntoma dentro del checkbox para recuperarlo después
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
            
        Set<String> eSinRepetir = new HashSet<>();
        List<Enfermedad> eFinal = new ArrayList<>();
        for (Enfermedad e : posiblesEnf) {
            if (eSinRepetir.add(e.getNombreEnfermedad())) {
                eFinal.add(e);
            }
        }
        return eFinal;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarDiagnotico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelSintomas;
    private javax.swing.JTextArea txtPosiblesEnfermedades;
    private javax.swing.JTextArea txtSintomasSeleccionados;
    // End of variables declaration//GEN-END:variables
}
