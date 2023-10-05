package CapaPresentacion;

import CapaDatos.Composicion;
import CapaNegocio.ComposicionBD;
import CapaNegocio.ProductoBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Composicion_IU extends javax.swing.JInternalFrame {
    
    public Composicion_IU() {
        initComponents();
        reportarComposicion();
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
    
    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_tempoarl_productos = (DefaultTableModel) tabla_reporte_composicion.getModel();
        tabla_tempoarl_productos.setRowCount(0);
    }
    
    private void limpiar() {
        txtComposicion.setText("");
        txtProducto.setText("");
        txtSerie.setText("");
    }
    
    private void reportarComposicion() {
        try {
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal_composicion = (DefaultTableModel) tabla_reporte_composicion.getModel();
            ComposicionBD oComposicionBD = new ComposicionBD();
            List<Composicion> lista_composicion = oComposicionBD.reportarComposicion();
            int cant = lista_composicion.size();
            for (int i = 0; i < cant; i++) {
                int idcomposicion = lista_composicion.get(i).getIdComposicion();
                String nombre = lista_composicion.get(i).getCoNombre();
                String serie_producto = lista_composicion.get(i).getpSerie();
                
                Object[] data = {idcomposicion, nombre, serie_producto};
                tabla_temporal_composicion.addRow(data);
            }
            tabla_reporte_composicion.setModel(tabla_temporal_composicion);
        } catch (Exception e) {
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtComposicion = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_composicion = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("SERIE");

        txtSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSerieFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerieFocusLost(evt);
            }
        });
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerieKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/barras.png"))); // NOI18N
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        btnBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarProductoKeyPressed(evt);
            }
        });

        jLabel2.setText("PRODUCTO");

        txtProducto.setEditable(false);
        txtProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductoFocusLost(evt);
            }
        });
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
        });

        jLabel3.setText("COMPOSICION");

        txtComposicion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtComposicionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtComposicionFocusLost(evt);
            }
        });
        txtComposicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComposicionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComposicionKeyTyped(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/guardar.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        tabla_reporte_composicion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "COMPOSICION", "SERIE"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_composicion);
        if (tabla_reporte_composicion.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_composicion.getColumnModel().getColumn(0).setMinWidth(50);
            tabla_reporte_composicion.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla_reporte_composicion.getColumnModel().getColumn(0).setMaxWidth(150);
            tabla_reporte_composicion.getColumnModel().getColumn(2).setMinWidth(100);
            tabla_reporte_composicion.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabla_reporte_composicion.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cerrar.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/eliminar2.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtComposicion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegistrar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarProducto)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtProducto))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtComposicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        if (txtSerie.getText().length() > 0) {
            ProductoBD oProductoBD = new ProductoBD();
            DefaultTableModel tabla_temporal;
            String serie = txtSerie.getText();
            tabla_temporal = oProductoBD.buscarProducto(serie);
            
            String producto = tabla_temporal.getValueAt(0, 1).toString();
            txtProducto.setText(producto);
        } else {
            advertencia("Ingrese la serie del producto");
            txtSerie.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtSerie.getText().length() > 0) {
            if (txtComposicion.getText().length() > 0) {
                Composicion oComposicion = new Composicion();
                ComposicionBD oComposicionBD = new ComposicionBD();
                oComposicion.setCoNombre(txtComposicion.getText().toUpperCase());
                oComposicion.setpSerie(txtSerie.getText());
                
                boolean rpta = oComposicionBD.registrarComposicion(oComposicion);
                if (rpta) {
                    exito("Se registrò con exito");
                    reportarComposicion();
                    limpiar();
                } else {
                    error("Tienes problemas al registrar una composicion");
                    txtComposicion.requestFocus();
                }
                
            } else {
                advertencia("Ingrese una composicion");
                txtComposicion.requestFocus();
            }
        } else {
            advertencia("Tiene que agregar una serie");
            txtSerie.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila_seleccionada = tabla_reporte_composicion.getSelectedRow();
        if (fila_seleccionada > -1) {
            int avido = JOptionPane.showConfirmDialog(rootPane, "¿ESTÀS SEGURO DE ELIMINAR?");
            if (avido == 0) {
                int adcomposicion = Integer.parseInt(tabla_reporte_composicion.getValueAt(fila_seleccionada, 0).toString());
                ComposicionBD oComposicionBD = new ComposicionBD();
                boolean rpta = oComposicionBD.eliminarComposicion(adcomposicion);
                if (rpta) {
                    exito("Se eliminò con exito");
                    reportarComposicion();
                    limpiar();
                    txtSerie.requestFocus();
                } else {
                    error("Tienes problemas al eliminar");
                }
            }
        } else {
            advertencia("Tienes que seleccionar una composicion para eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusGained
txtSerie.setBackground(Color.cyan);     
    }//GEN-LAST:event_txtSerieFocusGained

    private void txtSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusLost
txtSerie.setBackground(Color.white);   
    }//GEN-LAST:event_txtSerieFocusLost

    private void txtProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusGained
txtProducto.setBackground(Color.cyan);       
    }//GEN-LAST:event_txtProductoFocusGained

    private void txtProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusLost
txtProducto.setBackground(Color.white);            // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoFocusLost

    private void txtComposicionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtComposicionFocusGained
txtComposicion.setBackground(Color.cyan);            // TODO add your handling code here:
    }//GEN-LAST:event_txtComposicionFocusGained

    private void txtComposicionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtComposicionFocusLost
txtComposicion.setBackground(Color.white);            // TODO add your handling code here:
    }//GEN-LAST:event_txtComposicionFocusLost

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtSerie.getText().length() >= 13) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieKeyTyped

    private void txtSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscarProducto.requestFocus();
            btnBuscarProducto.doClick();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieKeyPressed

    private void btnBuscarProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarProductoKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtComposicion.requestFocus();
           
        }          // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProductoKeyPressed

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtComposicion.requestFocus();
  
        } 
    }//GEN-LAST:event_txtProductoKeyPressed

    private void txtComposicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComposicionKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();
            txtSerie.requestFocus();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtComposicionKeyPressed

    private void txtComposicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComposicionKeyTyped
char c=evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        } 
    }//GEN-LAST:event_txtComposicionKeyTyped

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_composicion;
    private javax.swing.JTextField txtComposicion;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
