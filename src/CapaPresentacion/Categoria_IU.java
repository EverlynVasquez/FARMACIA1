package CapaPresentacion;

import CapaDatos.Categoria;
import CapaNegocio.CategoriaBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Categoria_IU extends javax.swing.JInternalFrame {

    public Categoria_IU() {
        initComponents();
        reporte_categoria();
    }

    private void reporte_categoria() {
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        try {
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal = (DefaultTableModel) this.tabla_reporte_categorias.getModel();
            CategoriaBD oCategoriaBD = new CategoriaBD();
            List<Categoria> lista_categoria = oCategoriaBD.reportarCategoria();

            for (int i = 0; i < lista_categoria.size(); i++) {
                int idcategoria = lista_categoria.get(i).getIdCategoria();
                String maNombre = lista_categoria.get(i).getCatNombre();
                Object[] data = {idcategoria, maNombre};
                int cant = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cant);
                tabla_temporal.addRow(data);
            }
            tabla_reporte_categorias.setModel(tabla_temporal);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_categorias = (DefaultTableModel) tabla_reporte_categorias.getModel();
        tabla_temporal_categorias.setRowCount(0);
    }

    private void limpiar() {
        txtID.setText("");
        txtCantidad.setText("");
        txtNombre.setText("");
        reporte_categoria();
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

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscarCategorias = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_categorias = new javax.swing.JTable();
        bntCerrrar = new javax.swing.JButton();
        bntRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setTitle("CATEGORIA");

        jLabel1.setText("ID");

        txtID.setEditable(false);
        txtID.setEnabled(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setText("NOMBRE");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(153, 0, 153)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(153, 0, 204))); // NOI18N

        jLabel3.setText("CATEGORIA");

        txtBuscarCategorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarCategoriasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCategoriasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarCategorias)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBuscarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("CANTIDAD");

        txtCantidad.setEditable(false);
        txtCantidad.setEnabled(false);

        tabla_reporte_categorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE"
            }
        ));
        tabla_reporte_categorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_categoriasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_categorias);
        if (tabla_reporte_categorias.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_categorias.getColumnModel().getColumn(0).setMinWidth(100);
            tabla_reporte_categorias.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla_reporte_categorias.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        bntCerrrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cancel.png"))); // NOI18N
        bntCerrrar.setText("CERRAR");
        bntCerrrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCerrrarActionPerformed(evt);
            }
        });

        bntRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/guardar.png"))); // NOI18N
        bntRegistrar.setText("REGISTRAR");
        bntRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRegistrarActionPerformed(evt);
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

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bntRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(bntCerrrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(bntCerrrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntCerrrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCerrrarActionPerformed
        dispose();
    }//GEN-LAST:event_bntCerrrarActionPerformed

    private void bntRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRegistrarActionPerformed

        if (txtID.getText().length() == 0) {
            if (txtNombre.getText().length() > 0) {
                Categoria oCategoria = new Categoria();
                CategoriaBD oCategoriaBD = new CategoriaBD();
                oCategoria.setCatNombre(txtNombre.getText().toUpperCase().trim());

                boolean rpta = oCategoriaBD.registrarCategoria(oCategoria);
                if (rpta) {
                    exito("Se registro con exito");
                    reporte_categoria();
                    limpiar();
                    txtNombre.requestFocus();
                } else {
                    error("Tienes peoblemas al registrar");
                }
            } else {
                advertencia("Ingrese nombre");
                txtNombre.requestFocus();
            }
        } else {
            advertencia("No puedes registrar por ya existe...");
        }


    }//GEN-LAST:event_bntRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtID.getText().length() > 0) {
            if (txtNombre.getText().length() > 0) {
                Categoria oCategoria = new Categoria();
                CategoriaBD oCategoriaBD = new CategoriaBD();
                oCategoria.setIdCategoria(Integer.parseInt(txtID.getText().toUpperCase().trim()));
                oCategoria.setCatNombre(txtNombre.getText().toUpperCase().trim());
                boolean rpta = oCategoriaBD.modificarCategoria(oCategoria);
                if (rpta) {
                    exito("Se midifico con exito");
                    reporte_categoria();
                    limpiar();

                } else {
                    error("Tienes problemas al modificar");
                }
            } else {
                advertencia("Ingrese el nombre");
                txtNombre.requestFocus();
            }
        } else {
            advertencia("No puedes modificar por que ya existe...");
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtID.getText().length() > 0) {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de elminar");
            if (aviso == 0) {
                int idmarca = Integer.parseInt(txtID.getText().trim());
                Categoria oCategoria = new Categoria();
                CategoriaBD oCategoriaBD = new CategoriaBD();
                oCategoria.setIdCategoria(idmarca);
                boolean rpta = oCategoriaBD.eliminarCategoria(oCategoria);

                if (rpta) {
                    exito("Se eliminò con exito");
                    reporte_categoria();
                    limpiar();
                } else {
                    error("Tienes problemas al eliminar");
                }
            }
        } else {
            advertencia("Ingrese un codigo para eliminar unacategoria....");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
//        limpiar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tabla_reporte_categoriasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_categoriasMousePressed
        if (evt.getClickCount() == 2) {
            int fila_seleccionada = tabla_reporte_categorias.getSelectedRow();
            txtID.setText(tabla_reporte_categorias.getValueAt(fila_seleccionada, 0).toString());
            txtNombre.setText(tabla_reporte_categorias.getValueAt(fila_seleccionada, 1).toString());
        }

    }//GEN-LAST:event_tabla_reporte_categoriasMousePressed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtBuscarCategoriasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCategoriasKeyPressed
        try {
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal=(DefaultTableModel) this.tabla_reporte_categorias.getModel();
            CategoriaBD oCategoriaBD=new CategoriaBD();
            String valor=txtBuscarCategorias.getText().trim();
            List<Categoria> lista_categoria=oCategoriaBD.buscarCategoria(valor);
            for (int i = 0; i < lista_categoria.size(); i++) {
              int idcategoria=lista_categoria.get(i).getIdCategoria();
              String maNombre=lista_categoria.get(i).getCatNombre();
              Object[] data={idcategoria,maNombre};
              tabla_temporal.addRow(data);
            }
            tabla_reporte_categorias.setModel(tabla_temporal);
            
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCategoriasKeyPressed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
txtNombre.setBackground(Color.cyan);        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
     char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
  if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           bntRegistrar.requestFocus();
            bntRegistrar.doClick();

        }          // TODO add your handling code here:
                // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtBuscarCategoriasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCategoriasKeyTyped
    char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCategoriasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCerrrar;
    private javax.swing.JButton bntRegistrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_categorias;
    private javax.swing.JTextField txtBuscarCategorias;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
