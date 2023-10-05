package CapaPresentacion;

import CapaDatos.DetalleCuentaBancarias;
import CapaNegocio.DetalleCuentaBancariasBD;
import CapaNegocio.ProveedorBD;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CuentaBancariaProveedor_IU extends javax.swing.JInternalFrame {
    
    DefaultTableModel tabla_temporal_detalle_cuenta, tabla_temporal_proveedor;
    int idcuentas;
    
    public CuentaBancariaProveedor_IU() {
        initComponents();
        ;
    }
    
    private void limpiar_formulario() {
        tabla_temporal_detalle_cuenta = (DefaultTableModel) tabla_reporte_bancarias.getModel();
        tabla_temporal_detalle_cuenta.setRowCount(0);
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
    
    private void limpiar() {
        txtBanco.setText("");
        txtCuenta.setText("");
        txtNroCuenta.setText("");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNroCuenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBanco = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_bancarias = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setTitle("CUENTAS BANCARIAS DEL PROVEEDOR");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 0, 204))); // NOI18N

        jLabel1.setText("RUC");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/buscar_proveedor.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("RAZON SOCIAL");

        txtRazonSocial.setEditable(false);
        txtRazonSocial.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtRazonSocial))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel3.setText("CUENTA");

        jLabel4.setText("NRO CUENTA");

        jLabel5.setText("BANCO");

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/guardar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        tabla_reporte_bancarias.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_reporte_bancarias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_bancariasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_bancarias);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cancel.png"))); // NOI18N
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

        txtCantidad.setEditable(false);
        txtCantidad.setEnabled(false);

        jLabel6.setText("Cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrar))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnEliminar)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtRuc.getText().length() > 0) {
            DetalleCuentaBancariasBD oDetalleCuentaBancariasBD = new DetalleCuentaBancariasBD();
            ProveedorBD oProveedorBD = new ProveedorBD();
            tabla_temporal_proveedor = oProveedorBD.buscarProveedor(txtRuc.getText().trim());
            if (tabla_temporal_proveedor.getRowCount() > 0) {
                txtRazonSocial.setText(tabla_temporal_proveedor.getValueAt(0, 1).toString());
                tabla_temporal_detalle_cuenta = oDetalleCuentaBancariasBD.buscarDetalleCuentaBancarias(txtRuc.getText().trim());
                tabla_reporte_bancarias.setModel(tabla_temporal_detalle_cuenta);
                
            } else {
                error("No se encontro al proveedor, tienes que registrarlo ");
                txtRuc.requestFocus();
                txtRuc.setText("");
                txtRuc.setText("");
                tabla_temporal_detalle_cuenta = oDetalleCuentaBancariasBD.buscarDetalleCuentaBancarias(txtRazonSocial.getText().trim());
                tabla_reporte_bancarias.setModel(tabla_temporal_detalle_cuenta);
            }
        } else {
            advertencia("Ingrese el ruc para buscar el proveedor");
            txtRuc.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtBanco.getText().length() > 0) {
            if (txtNroCuenta.getText().length() > 0) {
                if (txtCuenta.getText().length() > 0) {
                    DetalleCuentaBancarias detalle = new DetalleCuentaBancarias();
                    DetalleCuentaBancariasBD detalleBD = new DetalleCuentaBancariasBD();
                    detalle.setBanco(txtBanco.getText().toLowerCase().trim());
                    detalle.setNroCuenta(txtNroCuenta.getText().toLowerCase().trim());
                    detalle.setCuenta(txtCuenta.getText().toLowerCase().trim());
                    detalle.setProvRuc(txtRuc.getText().trim());
                    
                    boolean rpta = detalleBD.registrarDetalleCuentaBancaria(detalle);
                    if (rpta) {
                        exito("Todo OK...");
                        DefaultTableModel tabla_temporal;
                        DetalleCuentaBancariasBD cuentasBD = new DetalleCuentaBancariasBD();
                        tabla_temporal = cuentasBD.buscarDetalleCuentaBancarias(txtRuc.getText().trim());
                        
                        tabla_reporte_bancarias.setModel(tabla_temporal);
                    } else {
                        error("Tienes problemas al registrar");
                    }
                } else {
                    advertencia("Ingrese la cuenta por favor");
                    txtCuenta.requestFocus();
                }
            } else {
                advertencia("Ingrese el nro de cuenta");
                txtNroCuenta.requestFocus();
            }
        } else {
            advertencia("Ingrese el nombre del banco");
            txtBanco.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tabla_reporte_bancariasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_bancariasMousePressed
        int filas_seleccionada = tabla_reporte_bancarias.getSelectedRow();
        idcuentas = Integer.parseInt(tabla_reporte_bancarias.getValueAt(filas_seleccionada, 0).toString());

// TODO add your handling code here:
    }//GEN-LAST:event_tabla_reporte_bancariasMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar es cuenta");        
        if (aviso == 0) {
            DetalleCuentaBancariasBD cuentaBD = new DetalleCuentaBancariasBD();
            boolean rpta = cuentaBD.eliminarDetalleCuentaBan(idcuentas);
            if (rpta) {
                exito("Se elimino correctamente");
                limpiar();
                limpiar_formulario();
            } else {
                error("Tines problemas al eliminar ");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_bancarias;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtNroCuenta;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables

}
