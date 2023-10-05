package CapaPresentacion;

import CapaDatos.Medida;
import CapaNegocio.MedidaBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Medida_IU extends javax.swing.JInternalFrame {
    
    public Medida_IU() {
        initComponents();
        reporte_medida();
    }
    
    private void limpiar() {
        txtCodigo.setText("");
        txtPresentacion.setText("");
        txtEquivalencia.setText("");
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
    
    private void reporte_medida() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tabla_temporal;
            MedidaBD oMedidaBD = new MedidaBD();
            tabla_temporal = oMedidaBD.reportarMedida();
            
            tabla_reporte_medida.setModel(tabla_temporal);
            int cant = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cant);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(null, e, "Problemas la reportar Medida_IU", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPresentacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEquivalencia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_medida = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        jLabel1.setText("CODIGO");

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);

        jLabel2.setText("CANTIDAD");

        txtCantidad.setEditable(false);
        txtCantidad.setEnabled(false);

        jLabel3.setText("PRESENTACION");

        txtPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPresentacionFocusLost(evt);
            }
        });
        txtPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPresentacionActionPerformed(evt);
            }
        });
        txtPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPresentacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresentacionKeyTyped(evt);
            }
        });

        jLabel4.setText("EQUIVALENCIA");

        txtEquivalencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEquivalenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEquivalenciaFocusLost(evt);
            }
        });
        txtEquivalencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEquivalenciaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEquivalenciaKeyTyped(evt);
            }
        });

        tabla_reporte_medida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_reporte_medida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_medidaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_medida);

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/guardar.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/lapiz.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/eliminar2.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/limpiar.png"))); // NOI18N
        txtLimpiar.setText("LIMPIAR");
        txtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLimpiarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cancel.png"))); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEquivalencia)
                            .addComponent(txtPresentacion))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(txtLimpiar)
                    .addComponent(btnCerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtPresentacion.getText().length() > 0) {
            if (txtEquivalencia.getText().length() > 0) {
                if (txtCodigo.getText().length() >= 0) {
                    
                    Medida oMedida = new Medida();
                    MedidaBD oMedidaBD = new MedidaBD();
                    
                    oMedida.setmPresentacion(txtPresentacion.getText().toUpperCase().trim());
                    oMedida.setmEquivalencia(txtEquivalencia.getText().toUpperCase().trim());
                    
                    boolean rpta = oMedidaBD.registrarMedida(oMedida);
                    if (rpta) {
                        exito("Se registro con exito");
                        reporte_medida();
                        limpiar();
                        txtPresentacion.requestFocus();
                        
                    } else {
                        error("Tienes problemas al registrar medida");
                    }
                } else {
                    advertencia("Ya existe esta medida");
                }
            } else {
                advertencia("Ingrese equivalencia");
                txtEquivalencia.requestFocus();
            }
        } else {
            advertencia("Ingrese la presentacion");
            txtPresentacion.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtPresentacion.getText().length() > 0) {
            if (txtEquivalencia.getText().length() > 0) {
                if (txtCodigo.getText().length() > 0) {
                    
                    Medida oMedida = new Medida();
                    MedidaBD oMedidaBD = new MedidaBD();
                    
                    oMedida.setIdmedida(Integer.parseInt(txtCodigo.getText().trim()));
                    oMedida.setmPresentacion(txtPresentacion.getText().toUpperCase().trim());
                    oMedida.setmEquivalencia(txtEquivalencia.getText().toUpperCase().trim());
                    
                    boolean rpta = oMedidaBD.modidficarMedida(oMedida);
                    
                    if (rpta) {
                        exito("Se modificò con exito");
                        reporte_medida();
                        limpiar();
                        txtPresentacion.requestFocus();
                        
                    } else {
                        error("Hay problemas con el registro");
                    }
                } else {
                    advertencia("Tienes que seleccionar la medida a modificar...");
                }
            } else {
                advertencia("Ingrese equivalencia");
                txtEquivalencia.requestFocus();
            }
        } else {
            advertencia("Ingrese la presentacion");
            txtPresentacion.requestFocus();
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPresentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresentacionActionPerformed

    private void tabla_reporte_medidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_medidaMousePressed
        if (evt.getClickCount() == 2) {
            limpiar();
            int filas_seleccionadas = tabla_reporte_medida.getSelectedRow();
            txtCodigo.setText(tabla_reporte_medida.getValueAt(filas_seleccionadas, 0).toString());
            txtPresentacion.setText(tabla_reporte_medida.getValueAt(filas_seleccionadas, 1).toString());
            txtEquivalencia.setText(tabla_reporte_medida.getValueAt(filas_seleccionadas, 2).toString());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_reporte_medidaMousePressed

    private void txtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimpiarActionPerformed
        
limpiar();
    }//GEN-LAST:event_txtLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
if (txtCodigo.getText().length() > 0) {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "¿ ESTÀS SEGURO DE ELIMINAR? ");
            if (aviso == 0) {
                int codigo = Integer.parseInt(txtCodigo.getText().trim());
                Medida oMedida = new Medida();
                MedidaBD oMedidaBD = new MedidaBD();
                
                oMedida.setIdmedida(codigo);
                
                boolean rpta = oMedidaBD.eliminarMedida(codigo);
                if (rpta) {
                    exito("Se eliminò correctamente");
                    reporte_medida();
                    limpiar();
                } else {
                    error("Hay problemas al eliminar ");
                }
            }
        } else {
            advertencia("Ingrese un codigo...");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtPresentacionKeyTyped

    private void txtPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyPressed
  if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           txtEquivalencia.requestFocus();
     

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtPresentacionKeyPressed

    private void txtEquivalenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquivalenciaKeyPressed
  if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           btnRegistrar.requestFocus();
            btnRegistrar.doClick();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtEquivalenciaKeyPressed

    private void txtPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusGained
txtPresentacion.setBackground(Color.cyan);        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresentacionFocusGained

    private void txtPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusLost
    txtPresentacion.setBackground(Color.white);      // TODO add your handling code here:
    }//GEN-LAST:event_txtPresentacionFocusLost

    private void txtEquivalenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEquivalenciaFocusGained
      txtEquivalencia.setBackground(Color.cyan);   // TODO add your handling code here:
    }//GEN-LAST:event_txtEquivalenciaFocusGained

    private void txtEquivalenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEquivalenciaFocusLost
   txtEquivalencia.setBackground(Color.white);         // TODO add your handling code here:
    }//GEN-LAST:event_txtEquivalenciaFocusLost

    private void txtEquivalenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquivalenciaKeyTyped
     char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtEquivalenciaKeyTyped

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_medida;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEquivalencia;
    private javax.swing.JButton txtLimpiar;
    private javax.swing.JTextField txtPresentacion;
    // End of variables declaration//GEN-END:variables
}
