package CapaPresentacion;

import java.awt.Dimension;

public class Menu_IU extends javax.swing.JFrame {

    public Menu_IU() {
        initComponents();

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        btnProductos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCompras = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnIngresos = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnEgresos = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnVentas = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnCajas = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnCerrar = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_mantenimiento_proveedor = new javax.swing.JMenu();
        menu_item_Tipo_Usuario = new javax.swing.JMenuItem();
        menu_item_Usuario = new javax.swing.JMenuItem();
        menu_item_turno = new javax.swing.JMenuItem();
        menu_item_Marca = new javax.swing.JMenuItem();
        menu_item_categoria = new javax.swing.JMenuItem();
        menu_item_medida = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menu_item_composicion = new javax.swing.JMenuItem();
        menu_item_proveedor = new javax.swing.JMenuItem();
        menu_item_cuentas = new javax.swing.JMenuItem();
        menu_compras = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_item_reporte_compra_varios = new javax.swing.JMenuItem();
        menu_inventario = new javax.swing.JMenu();
        menu_ventas = new javax.swing.JMenu();
        menu_caja = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EMPRESAX | CONECTADO COMO: ADMINISTRADOR-USARIO-OSMAR PEREZ-TIENDA: PRONCIPAL");
        setExtendedState(6);

        jToolBar1.setBackground(new java.awt.Color(204, 255, 204));
        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setRollover(true);

        btnProductos.setBackground(new java.awt.Color(204, 255, 204));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/box.png"))); // NOI18N
        btnProductos.setEnabled(false);
        btnProductos.setFocusable(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProductos);
        jToolBar1.add(jSeparator1);

        btnCompras.setBackground(new java.awt.Color(204, 255, 204));
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/compra.png"))); // NOI18N
        btnCompras.setEnabled(false);
        btnCompras.setFocusable(false);
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCompras);
        jToolBar1.add(jSeparator4);

        btnIngresos.setBackground(new java.awt.Color(204, 255, 204));
        btnIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ingresos.png"))); // NOI18N
        btnIngresos.setEnabled(false);
        btnIngresos.setFocusable(false);
        btnIngresos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngresos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnIngresos);
        jToolBar1.add(jSeparator5);

        btnEgresos.setBackground(new java.awt.Color(204, 255, 204));
        btnEgresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/egresos.png"))); // NOI18N
        btnEgresos.setEnabled(false);
        btnEgresos.setFocusable(false);
        btnEgresos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEgresos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEgresos);
        jToolBar1.add(jSeparator6);

        btnVentas.setBackground(new java.awt.Color(204, 255, 204));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/venta1.png"))); // NOI18N
        btnVentas.setEnabled(false);
        btnVentas.setFocusable(false);
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnVentas);
        jToolBar1.add(jSeparator7);

        btnCajas.setBackground(new java.awt.Color(204, 255, 204));
        btnCajas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/caja_1.png"))); // NOI18N
        btnCajas.setEnabled(false);
        btnCajas.setFocusable(false);
        btnCajas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCajas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCajas);
        jToolBar1.add(jSeparator8);

        btnCerrar.setBackground(new java.awt.Color(204, 255, 204));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cerrar2.png"))); // NOI18N
        btnCerrar.setFocusable(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCerrar);
        jToolBar1.add(jSeparator9);

        escritorio.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        menu_mantenimiento_proveedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu_mantenimiento_proveedor.setText("MANTENIMIENTO");

        menu_item_Tipo_Usuario.setText("Tipo de Usuario");
        menu_item_Tipo_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_Tipo_UsuarioActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(menu_item_Tipo_Usuario);

        menu_item_Usuario.setText("Usuario");
        menu_item_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_UsuarioActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(menu_item_Usuario);

        menu_item_turno.setText("Turno");
        menu_item_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_turnoActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(menu_item_turno);

        menu_item_Marca.setText("Marca");
        menu_item_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_MarcaActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(menu_item_Marca);

        menu_item_categoria.setText("Categoria");
        menu_item_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_categoriaActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(menu_item_categoria);

        menu_item_medida.setText("Medida");
        menu_item_medida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_medidaActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(menu_item_medida);

        jMenuItem1.setText("Producto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(jMenuItem1);

        menu_item_composicion.setText("Composicion");
        menu_item_composicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_composicionActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(menu_item_composicion);

        menu_item_proveedor.setText("Proveedor");
        menu_item_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_proveedorActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(menu_item_proveedor);

        menu_item_cuentas.setText("Cuentas Bancarias");
        menu_item_cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_cuentasActionPerformed(evt);
            }
        });
        menu_mantenimiento_proveedor.add(menu_item_cuentas);

        jMenuBar1.add(menu_mantenimiento_proveedor);

        menu_compras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu_compras.setText("COMPRAS");
        menu_compras.setEnabled(false);

        jMenuItem2.setText("Realizar Compras");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_compras.add(jMenuItem2);

        menu_item_reporte_compra_varios.setText("Reporte de Compras Varios");
        menu_item_reporte_compra_varios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_reporte_compra_variosActionPerformed(evt);
            }
        });
        menu_compras.add(menu_item_reporte_compra_varios);

        jMenuBar1.add(menu_compras);

        menu_inventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu_inventario.setText("INVENTARIO");
        menu_inventario.setEnabled(false);
        jMenuBar1.add(menu_inventario);

        menu_ventas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu_ventas.setText("VENTAS");
        menu_ventas.setEnabled(false);
        jMenuBar1.add(menu_ventas);

        menu_caja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu_caja.setText("CAJA");
        menu_caja.setEnabled(false);
        jMenuBar1.add(menu_caja);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
              Producto_IU frame = new Producto_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductosActionPerformed

    private void menu_item_Tipo_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_Tipo_UsuarioActionPerformed
        TipoUsuario_IU frame = new TipoUsuario_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();

        // TODO add your handling code here:
    }//GEN-LAST:event_menu_item_Tipo_UsuarioActionPerformed

    private void menu_item_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_UsuarioActionPerformed
        Usuario_IU frame = new Usuario_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_UsuarioActionPerformed

    private void menu_item_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_turnoActionPerformed
        Turno_IU frame = new Turno_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_turnoActionPerformed

    private void menu_item_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_MarcaActionPerformed

        Marca_IU frame = new Marca_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();


    }//GEN-LAST:event_menu_item_MarcaActionPerformed

    private void menu_item_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_categoriaActionPerformed
        Categoria_IU frame = new Categoria_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();
    }//GEN-LAST:event_menu_item_categoriaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void menu_item_medidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_medidaActionPerformed
        Medida_IU frame = new Medida_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();


    }//GEN-LAST:event_menu_item_medidaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Producto_IU frame = new Producto_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menu_item_composicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_composicionActionPerformed
        Composicion_IU frame = new Composicion_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_item_composicionActionPerformed

    private void menu_item_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_proveedorActionPerformed
       Proveedor_IU frame = new Proveedor_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();    // TODO add your handling code here:
    }//GEN-LAST:event_menu_item_proveedorActionPerformed

    private void menu_item_cuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_cuentasActionPerformed
       CuentaBancariaProveedor_IU frame = new CuentaBancariaProveedor_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_item_cuentasActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          Compra_IU frame = new Compra_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show();   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menu_item_reporte_compra_variosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_reporte_compra_variosActionPerformed
      
                  ReporteComprasVarios_IU frame = new ReporteComprasVarios_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
        frame.show(); // TODO add your handling code here:
    }//GEN-LAST:event_menu_item_reporte_compra_variosActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_IU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCajas;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnCompras;
    public javax.swing.JButton btnEgresos;
    public javax.swing.JButton btnIngresos;
    public javax.swing.JButton btnProductos;
    public javax.swing.JButton btnVentas;
    public transient javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    public javax.swing.JToolBar jToolBar1;
    public javax.swing.JMenu menu_caja;
    public javax.swing.JMenu menu_compras;
    public javax.swing.JMenu menu_inventario;
    private javax.swing.JMenuItem menu_item_Marca;
    private javax.swing.JMenuItem menu_item_Tipo_Usuario;
    private javax.swing.JMenuItem menu_item_Usuario;
    private javax.swing.JMenuItem menu_item_categoria;
    private javax.swing.JMenuItem menu_item_composicion;
    private javax.swing.JMenuItem menu_item_cuentas;
    private javax.swing.JMenuItem menu_item_medida;
    private javax.swing.JMenuItem menu_item_proveedor;
    private javax.swing.JMenuItem menu_item_reporte_compra_varios;
    private javax.swing.JMenuItem menu_item_turno;
    public javax.swing.JMenu menu_mantenimiento_proveedor;
    public javax.swing.JMenu menu_ventas;
    // End of variables declaration//GEN-END:variables
}
