/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Proveedor;
import CapaNegocio.ProveedorBD;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Proveedor_IU extends javax.swing.JInternalFrame {

    public Proveedor_IU() {
        initComponents();
        reportar();
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
        txtRuc.setText("");
        txtRepresentante.setText("");
        txtDireccion.setText("");
        txtCelular.setText("");
        txtCorreo.setText("");
        txtRaxonSocial.setText("");
        txtPaginaWeb.setText("");
    }

    private void reportar() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tabla_temporal;
            ProveedorBD oProveedorBD = new ProveedorBD();
            tabla_temporal = oProveedorBD.reportarProveedor();
            tabla_reporte_proveedor.setModel(tabla_temporal);
            int cant = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cant);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRaxonSocial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRepresentante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPaginaWeb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_proveedor = new javax.swing.JTable();
        btnCuentaBancaria = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jLabel1.setText("RUC");

        jLabel2.setText("RAZON SOCIAL");

        txtRaxonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRaxonSocialActionPerformed(evt);
            }
        });

        jLabel3.setText("CORREO");

        jLabel4.setText("REPRESENTANTE");

        jLabel5.setText("PAGINA WEB");

        jLabel6.setText("DIRECCION");

        jLabel7.setText("CELULAR");

        tabla_reporte_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_proveedor);

        btnCuentaBancaria.setText("Cuenta Bancaria");

        jLabel8.setText("Cantidad");

        txtCantidad.setEditable(false);

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/disk.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/report_magnify.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/report_edit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bin_empty.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/application.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/printer.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cerrar2.png"))); // NOI18N
        jButton8.setText("Cerrar");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModificar))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCuentaBancaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(txtRepresentante)
                            .addComponent(txtRaxonSocial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPaginaWeb)
                            .addComponent(txtCorreo)))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRaxonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(btnCuentaBancaria)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRaxonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRaxonSocialActionPerformed

    }//GEN-LAST:event_txtRaxonSocialActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if (txtRuc.getText().length() > 0) {
                if (txtRaxonSocial.getText().length() > 0) {
                    if (txtCorreo.getText().length() > 0) {
                        if (txtDireccion.getText().length() > 0) {
                            if (txtCelular.getText().length() > 0) {
                                if (txtPaginaWeb.getText().length() > 0) {

                                    Proveedor o_Proveedor = new Proveedor();
                                    ProveedorBD o_ProveedorBD = new ProveedorBD();

                                    o_Proveedor.setProvRuc(txtRuc.getText().toUpperCase().trim());
                                    o_Proveedor.setProvRazonSocial(txtRaxonSocial.getText().toUpperCase().trim());
                                    o_Proveedor.setProvRepresentante(txtRepresentante.getText().toUpperCase().trim());
                                    o_Proveedor.setProvDireccion(txtDireccion.getText().toUpperCase().trim());
                                    o_Proveedor.setProvCorreo(txtCorreo.getText().toUpperCase().trim());
                                    o_Proveedor.setProvCelular(txtCelular.getText().trim());
                                    o_Proveedor.setProvWeb(txtPaginaWeb.getText().trim());

                                    boolean rpta = o_ProveedorBD.registrarProveedor(o_Proveedor);
                                    if (rpta) {
                                        exito("Se registro con exito");
                                        reportar();
                                        limpiar();
                                        btnRegistrar.setEnabled(true);
                                        btnModificar.setEnabled(false);
                                        btnEliminar.setEnabled(false);
                                        txtRuc.requestFocus();
                                    } else {
                                        error("Hubo problemas al registrar");
                                    }

                                } else {
                                    advertencia("Ingrese su web");
                                    txtPaginaWeb.requestFocus();
                                }
                            } else {
                                advertencia("Ingrese su celular");
                                txtCelular.requestFocus();
                            }
                        } else {
                            advertencia("Ingrese su direccion");
                            txtDireccion.requestFocus();
                        }

                    } else {
                        advertencia("Ingrese su correo");
                        txtCorreo.requestFocus();
                    }
                } else {
                    advertencia("Ingrese la razon social");
                    txtRaxonSocial.requestFocus();
                }
            } else {
                advertencia("Ingrese ruc");
                txtRuc.requestFocus();
            }
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtRuc.getText().length() > 0) {
            String ruc = txtRuc.getText();
            ProveedorBD oProveedorBD = new ProveedorBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oProveedorBD.buscarProveedor(ruc);
            if (tabla_temporal.getRowCount() > 0) {
                tabla_reporte_proveedor.setModel(tabla_temporal);
                txtRuc.setText(tabla_temporal.getValueAt(0, 0).toString());
                txtRaxonSocial.setText(tabla_temporal.getValueAt(0, 1).toString());
                txtRepresentante.setText(tabla_temporal.getValueAt(0, 2).toString());
                txtDireccion.setText(tabla_temporal.getValueAt(0, 3).toString());
                txtCorreo.setText(tabla_temporal.getValueAt(0, 4).toString());
                txtPaginaWeb.setText(tabla_temporal.getValueAt(0, 5).toString());
                txtCelular.setText(tabla_temporal.getValueAt(0, 6).toString());

                btnRegistrar.setEnabled(false);
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
            } else {
                advertencia("No se encontraron datos");
                txtRuc.requestFocus();
            }
        } else {
            advertencia("Ingrese su ruc");
            txtRuc.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (txtRuc.getText().length() > 0) {
                if (txtRaxonSocial.getText().length() > 0) {
                    if (txtCorreo.getText().length() > 0) {
                        if (txtDireccion.getText().length() > 0) {
                            if (txtCelular.getText().length() > 0) {
                                if (txtPaginaWeb.getText().length() > 0) {

                                    Proveedor o_Proveedor = new Proveedor();
                                    ProveedorBD o_ProveedorBD = new ProveedorBD();

                                    o_Proveedor.setProvRuc(txtRuc.getText().toUpperCase().trim());
                                    o_Proveedor.setProvRazonSocial(txtRaxonSocial.getText().toUpperCase().trim());
                                    o_Proveedor.setProvRepresentante(txtRepresentante.getText().toUpperCase().trim());
                                    o_Proveedor.setProvDireccion(txtDireccion.getText().toUpperCase().trim());
                                    o_Proveedor.setProvCorreo(txtCorreo.getText().toUpperCase().trim());
                                    o_Proveedor.setProvCelular(txtCelular.getText().toUpperCase().trim());
                                    o_Proveedor.setProvWeb(txtPaginaWeb.getText().toUpperCase().trim());

                                    boolean rpta = o_ProveedorBD.modificarProveedor(o_Proveedor);
                                    if (rpta) {
                                        exito("Se modifico con exito");
                                        reportar();
                                        limpiar();
                                        txtRuc.requestFocus();
                                    } else {
                                        error("Hubo problemas al modificar");
                                    }

                                } else {
                                    advertencia("Ingrese su web");
                                    txtPaginaWeb.requestFocus();
                                }
                            } else {
                                advertencia("Ingrese su celular");
                                txtCelular.requestFocus();
                            }
                        } else {
                            advertencia("Ingrese su direccion");
                            txtDireccion.requestFocus();
                        }

                    } else {
                        advertencia("Ingrese su correo");
                        txtCorreo.requestFocus();
                    }
                } else {
                    advertencia("Ingrese la razon social");
                    txtRaxonSocial.requestFocus();
                }
            } else {
                advertencia("Ingrese ruc");
                txtRuc.requestFocus();
            }
        } catch (Exception e) {
        }         // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtRuc.getText().length() > 0) {
                int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar", "CONFIRMACION", JOptionPane.OK_CANCEL_OPTION);
                if (aviso == 0) {
                    ProveedorBD oProveedorBD = new ProveedorBD();
                    String dni = txtRuc.getText();
                    boolean rpta = oProveedorBD.eliminarProveedor(dni);
                    if (rpta) {
                        reportar();
                        limpiar();
                        btnRegistrar.setEnabled(true);
                        btnModificar.setEnabled(false);
                        btnEliminar.setEnabled(false);

                        txtRuc.requestFocus();

                    } else {
                    }
                }
            } else {
            }
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCuentaBancaria;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_proveedor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtPaginaWeb;
    private javax.swing.JTextField txtRaxonSocial;
    private javax.swing.JTextField txtRepresentante;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
