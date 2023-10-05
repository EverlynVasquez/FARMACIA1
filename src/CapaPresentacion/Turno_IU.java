package CapaPresentacion;

import CapaDatos.Turno;
import CapaNegocio.TurnoBD;
import CapaNegocio.UsuarioBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Turno_IU extends javax.swing.JInternalFrame {

    int Fila_Seleccionda = -1;

    public Turno_IU() {
        initComponents();
        reporte();
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_turno = (DefaultTableModel) tabla_reporte_turno.getModel();
        tabla_temporal_turno.setRowCount(0);

    }

    private void reporte() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal_turno = (DefaultTableModel) tabla_reporte_turno.getModel();
            DefaultTableModel tabla_temporal;
            TurnoBD oTurnoBD = new TurnoBD();
            tabla_temporal = oTurnoBD.reportarTurno();
            int cant = tabla_temporal.getRowCount();
            for (int i = 0; i < cant; i++) {
                int idturno = Integer.parseInt(tabla_temporal.getValueAt(i, 0).toString());
                String descripcion = tabla_temporal.getValueAt(i, 1).toString();
                String inicio = tabla_temporal.getValueAt(i, 2).toString();
                String fin = tabla_temporal.getValueAt(i, 3).toString();
                String dni = tabla_temporal.getValueAt(i, 4).toString();
                Object[] data = {idturno, descripcion, inicio, fin, dni};
                tabla_temporal_turno.addRow(data);

            }
            tabla_reporte_turno.setModel(tabla_temporal_turno);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }
    }

    private void limpiar() {
        txtDni.setText("");
        txtUsuario.setText("");
        txtHorasInicio.setText("");
        txtHorasFinal.setText("");
        cmbTurno.setSelectedItem(0);
        Fila_Seleccionda = -1;

    }

    private void exito(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "MENSAJE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void error(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtHorasInicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHorasFinal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbTurno = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_turno = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TURNO");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Usuario"));

        jLabel1.setText("DNI");

        txtDni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniFocusLost(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/buscar_proveedor.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        jLabel2.setText("USUARIO");

        txtUsuario.setEditable(false);
        txtUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addContainerGap())
                    .addComponent(txtUsuario)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Turno"));

        jLabel3.setText("HORA  DE INICIO");

        txtHorasInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtHorasInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHorasInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHorasInicioFocusLost(evt);
            }
        });
        txtHorasInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHorasInicioKeyPressed(evt);
            }
        });

        jLabel4.setText("HORA FINAL");

        txtHorasFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtHorasFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHorasFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHorasFinalFocusLost(evt);
            }
        });
        txtHorasFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHorasFinalKeyPressed(evt);
            }
        });

        jLabel6.setText("TURNO");

        cmbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Turno", "TURNO 1", "TURNO 2", "TURNO 3", "TURNO 4" }));
        cmbTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTurnoKeyPressed(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/guardar.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cancel.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHorasInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHorasFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHorasInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHorasFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla_reporte_turno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCION", "HORA INICIO", "HORA FINAL", "USUARIO"
            }
        ));
        tabla_reporte_turno.getTableHeader().setReorderingAllowed(false);
        tabla_reporte_turno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_turnoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_turno);
        if (tabla_reporte_turno.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_turno.getColumnModel().getColumn(0).setMinWidth(50);
            tabla_reporte_turno.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla_reporte_turno.getColumnModel().getColumn(0).setMaxWidth(150);
            tabla_reporte_turno.getColumnModel().getColumn(1).setMinWidth(50);
            tabla_reporte_turno.getColumnModel().getColumn(1).setPreferredWidth(555);
            tabla_reporte_turno.getColumnModel().getColumn(1).setMaxWidth(150);
            tabla_reporte_turno.getColumnModel().getColumn(2).setMinWidth(50);
            tabla_reporte_turno.getColumnModel().getColumn(2).setPreferredWidth(555);
            tabla_reporte_turno.getColumnModel().getColumn(2).setMaxWidth(150);
            tabla_reporte_turno.getColumnModel().getColumn(3).setMinWidth(50);
            tabla_reporte_turno.getColumnModel().getColumn(3).setPreferredWidth(555);
            tabla_reporte_turno.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cerrar.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtDni.getText().length() > 0) {
            DefaultTableModel tabla_temporal;
            UsuarioBD oUsuarioBD = new UsuarioBD();
            tabla_temporal = oUsuarioBD.buscarUsuarioXDni(txtDni.getText());
            int cant = tabla_temporal.getRowCount();

            if (cant > 0) {
                String nombre = tabla_temporal.getValueAt(0, 1).toString();
                String apellidos = tabla_temporal.getValueAt(0, 2).toString();
                txtUsuario.setText(apellidos + " " + nombre);

            } else {
                error("No existe este usuario");
            }
        } else {
            advertencia("Tiene que ingresar un dni");
            txtDni.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtDni.getText().length() > 0) {
            if (txtHorasInicio.getText().length() > 0) {
                if (txtHorasFinal.getText().length() > 0) {
                    if (!cmbTurno.getSelectedItem().equals("Seleccione turno")) {

                        Turno oTurno = new Turno();
                        TurnoBD oTurnoBD = new TurnoBD();
                        oTurno.setDescripcion(cmbTurno.getSelectedItem().toString());
                        oTurno.setInicio(txtHorasInicio.getText());
                        oTurno.setFin(txtHorasFinal.getText());
                        oTurno.setuDni(txtDni.getText());

                        boolean rpta = oTurnoBD.reistrarturno(oTurno);
                        if (rpta) {
                            exito("Se registro con exito");
                            reporte();
                            limpiar();
                        } else {
                            error("Tienes problemas al registrar");
                        }

                    } else {
                        advertencia("Seleccione turno");
                    }
                } else {
                    advertencia("Ingrese la hora final");
                }
            } else {
                advertencia("Ingrese la hora de  inicio");
                txtHorasInicio.requestFocus();
            }
        } else {
            advertencia("Ingrese un dni");
            txtDni.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (Fila_Seleccionda > 0) {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar la fila" + Fila_Seleccionda);
            if (aviso == 0) {
                TurnoBD oTurnoBD = new TurnoBD();
                int idturno = Integer.parseInt(tabla_reporte_turno.getValueAt(Fila_Seleccionda, 0).toString());
                boolean rpta = oTurnoBD.eliminarTurno(idturno);
                if (rpta) {
                    exito("Se eliminò con exito");
                    reporte();
                    limpiar();
                } else {
                    error("Tienes problemas al eliminar");
                }
            } else {
                advertencia("Tienes que seleccionar una fila");
            }
        } else {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tabla_reporte_turnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_turnoMousePressed
        Fila_Seleccionda = tabla_reporte_turno.getSelectedRow();
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_reporte_turnoMousePressed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtDni.getText().length() >= 8) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        txtDni.setBackground(Color.WHITE);           // TODO add your handling code here:
    }//GEN-LAST:event_txtDniFocusLost

    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained
        txtDni.setBackground(Color.CYAN);           // TODO add your handling code here:
    }//GEN-LAST:event_txtDniFocusGained

    private void txtHorasInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHorasInicioFocusGained
        txtHorasInicio.setBackground(Color.cyan);           // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasInicioFocusGained

    private void txtHorasInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHorasInicioFocusLost
        txtHorasInicio.setBackground(Color.WHITE);           // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasInicioFocusLost

    private void txtHorasFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHorasFinalFocusGained
 txtHorasFinal.setBackground(Color.cyan);           // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasFinalFocusGained

    private void txtHorasFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHorasFinalFocusLost
 txtHorasFinal.setBackground(Color.WHITE);           // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasFinalFocusLost

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.requestFocus();
            btnBuscar.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniKeyPressed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtHorasInicio.requestFocus();
          
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void txtHorasFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorasFinalKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbTurno.requestFocus();
          
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasFinalKeyPressed

    private void txtHorasInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorasInicioKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtHorasFinal.requestFocus();
          
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasInicioKeyPressed

    private void cmbTurnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTurnoKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
          btnRegistrar.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTurnoKeyPressed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_turno;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtHorasFinal;
    private javax.swing.JTextField txtHorasInicio;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
