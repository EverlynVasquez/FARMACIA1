package CapaPresentacion;

import CapaNegocio.CompraBD;
import CapaNegocio.DetalleCompraBD;
import CapaNegocio.ProveedorBD;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.java2d.pipe.SpanShapeRenderer;

public class ReporteComprasVarios_IU extends javax.swing.JInternalFrame {

    DefaultTableModel tabla_temporal_compras, tabla_temporal_detalle_compras;

    public ReporteComprasVarios_IU() {
        initComponents();
        cargarProveedor();
    }

    private void cargarProveedor() {
        try {
            cmbProveedor.removeAllItems();;
            ProveedorBD oProveedorBD = new ProveedorBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oProveedorBD.reportarProveedor();
            cmbProveedor.addItem("Seleccionar");
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                String proveedor = String.valueOf(tabla_temporal.getValueAt(i, 1));

                cmbProveedor.addItem(proveedor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar proveedor", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar_tabla_formulario() {
        tabla_temporal_compras = (DefaultTableModel) tabla_reporte_compras.getModel();
        tabla_temporal_compras.setRowCount(0);

        tabla_temporal_detalle_compras = (DefaultTableModel) tabla_reporte_detalle_compra_doc.getModel();
        tabla_temporal_detalle_compras.setRowCount(0);
    }

    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        dcFechaInicioFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        dcFechaFinalFecha = new com.toedter.calendar.JDateChooser();
        btnBuscarComprasFechas = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_reporte_compras = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_reporte_detalle_compras_fecha = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dcFechaInicioDoc = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dcFechaFinalDoc = new com.toedter.calendar.JDateChooser();
        cmbDocumento = new javax.swing.JComboBox<>();
        btnBuscarDocumento = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTotalCompraDocumento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_detalle_compra_doc = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla_reporte_compras_doc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dcFechaInicioProv = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        dcFechaFinalProv = new com.toedter.calendar.JDateChooser();
        cmbProveedor = new javax.swing.JComboBox<>();
        btnBuscarCompraProv = new javax.swing.JButton();
        btnImprimirProv = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTotalCompraProv = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabla_reporte_detalle_compra_prov = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabla_reporte_compras2 = new javax.swing.JTable();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setTitle("REPORTES COMPRAS");

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 204));

        jLabel4.setText("Fecga Inicio");

        jLabel5.setText("Fecha Final");

        btnBuscarComprasFechas.setText("....");
        btnBuscarComprasFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarComprasFechasActionPerformed(evt);
            }
        });

        btnImprimir1.setText("Imprimir");

        btnEliminar1.setText("Eliminar");

        tabla_reporte_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "RUC", "PROVEEDOR", "DOCUMENTO", "CORRELATIVO", "TIPO PAGO", "FORMA PAGO", "TOTAL", "USUARIO", "TIENDA"
            }
        ));
        tabla_reporte_compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_comprasMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_reporte_compras);
        if (tabla_reporte_compras.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_compras.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla_reporte_compras.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla_reporte_compras.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_reporte_compras.getColumnModel().getColumn(3).setPreferredWidth(400);
            tabla_reporte_compras.getColumnModel().getColumn(4).setPreferredWidth(150);
            tabla_reporte_compras.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabla_reporte_compras.getColumnModel().getColumn(6).setPreferredWidth(150);
            tabla_reporte_compras.getColumnModel().getColumn(7).setPreferredWidth(150);
            tabla_reporte_compras.getColumnModel().getColumn(8).setPreferredWidth(100);
            tabla_reporte_compras.getColumnModel().getColumn(9).setPreferredWidth(150);
            tabla_reporte_compras.getColumnModel().getColumn(10).setPreferredWidth(150);
        }

        tabla_reporte_detalle_compras_fecha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_reporte_detalle_compras_fecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_detalle_compras_fechaMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tabla_reporte_detalle_compras_fecha);

        jLabel6.setText("Detalle de la compra ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane4)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFechaInicioFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
                .addComponent(dcFechaFinalFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnBuscarComprasFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(btnEliminar1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcFechaFinalFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarComprasFechas)
                        .addComponent(btnImprimir1)
                        .addComponent(btnEliminar1))
                    .addComponent(dcFechaInicioFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("COMPRAS POR FECHA", jPanel1);

        jLabel1.setText("Fecha Inicion");

        jLabel2.setText("Fecha Final");

        cmbDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACRTURA", "BOLETA", " " }));

        btnBuscarDocumento.setText(".....");
        btnBuscarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDocumentoActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");

        jLabel3.setText("Total Compras");

        tabla_reporte_detalle_compra_doc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_detalle_compra_doc);

        jLabel7.setText("Detalle de la compra");

        tabla_reporte_compras_doc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "RUC", "PROVEEDOR", "DOCUMENTO", "CORRELATIVO", "TIPO PAGO", "FORMA PAGO", "TOTAL", "USUARIO", "TIENDA"
            }
        ));
        tabla_reporte_compras_doc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_compras_docMousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(tabla_reporte_compras_doc);
        if (tabla_reporte_compras_doc.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_compras_doc.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla_reporte_compras_doc.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla_reporte_compras_doc.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_reporte_compras_doc.getColumnModel().getColumn(3).setPreferredWidth(400);
            tabla_reporte_compras_doc.getColumnModel().getColumn(4).setPreferredWidth(150);
            tabla_reporte_compras_doc.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabla_reporte_compras_doc.getColumnModel().getColumn(6).setPreferredWidth(150);
            tabla_reporte_compras_doc.getColumnModel().getColumn(7).setPreferredWidth(150);
            tabla_reporte_compras_doc.getColumnModel().getColumn(8).setPreferredWidth(100);
            tabla_reporte_compras_doc.getColumnModel().getColumn(9).setPreferredWidth(150);
            tabla_reporte_compras_doc.getColumnModel().getColumn(10).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaInicioDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcFechaFinalDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarDocumento)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalCompraDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dcFechaFinalDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dcFechaInicioDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGap(9, 9, 9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalCompraDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("COMPRAS POR DUCUMENTO", jPanel2);

        jLabel8.setText("Fecha Inicion");

        jLabel9.setText("Fecha Final");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBuscarCompraProv.setText(".....");

        btnImprimirProv.setText("Imprimir");

        jLabel10.setText("Total Compras");

        jLabel11.setText("Detalle de la compra");

        tabla_reporte_detalle_compra_prov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tabla_reporte_detalle_compra_prov);

        jLabel12.setText("Proveedor");

        tabla_reporte_compras2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "RUC", "PROVEEDOR", "DOCUMENTO", "CORRELATIVO", "TIPO PAGO", "FORMA PAGO", "TOTAL", "USUARIO", "TIENDA"
            }
        ));
        jScrollPane8.setViewportView(tabla_reporte_compras2);
        if (tabla_reporte_compras2.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_compras2.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla_reporte_compras2.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla_reporte_compras2.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_reporte_compras2.getColumnModel().getColumn(3).setPreferredWidth(400);
            tabla_reporte_compras2.getColumnModel().getColumn(4).setPreferredWidth(150);
            tabla_reporte_compras2.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabla_reporte_compras2.getColumnModel().getColumn(6).setPreferredWidth(150);
            tabla_reporte_compras2.getColumnModel().getColumn(7).setPreferredWidth(150);
            tabla_reporte_compras2.getColumnModel().getColumn(8).setPreferredWidth(100);
            tabla_reporte_compras2.getColumnModel().getColumn(9).setPreferredWidth(150);
            tabla_reporte_compras2.getColumnModel().getColumn(10).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaInicioProv, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaFinalProv, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCompraProv)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimirProv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalCompraProv, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcFechaInicioProv, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(btnImprimirProv))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtTotalCompraProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscarCompraProv)
                            .addComponent(dcFechaFinalProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("COMPRAS POR PROVEEDOR", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarComprasFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarComprasFechasActionPerformed
        try {
            limpiar_tabla_formulario();
            CompraBD oCompraBD = new CompraBD();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            if (dcFechaFinalFecha.getDate() != null) {
                if (dcFechaInicioFecha.getDate() != null) {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                    String fechaInicio = dcn.format(dcFechaInicioFecha.getDate());
                    String fechaFinal = dcn.format(dcFechaFinalFecha.getDate());
                    DefaultTableModel tabla_temporal;
                    tabla_temporal = oCompraBD.reportarCompraFechas(fechaInicio, fechaFinal);
                    int cant = tabla_temporal.getRowCount();
                    for (int i = 0; i < cant; i++) {
                        String idcompra = tabla_temporal.getValueAt(i, 0).toString();
                        String fecha = tabla_temporal.getValueAt(i, 1).toString();
                        String ruc = tabla_temporal.getValueAt(i, 12).toString();
                        String proveedor = tabla_temporal.getValueAt(i, 2).toString();
                        String doc = tabla_temporal.getValueAt(i, 3).toString();
                        String correlativo = tabla_temporal.getValueAt(i, 4).toString();
                        String t_Pago = tabla_temporal.getValueAt(i, 5).toString();
                        String f_Pago = tabla_temporal.getValueAt(i, 6).toString();
                        String total = tabla_temporal.getValueAt(i, 11).toString();
                        String tienda = Login_IU.tienda;
                        String uDni = Login_IU.dni_publico;
                        Object[] data = {idcompra, fecha, ruc, proveedor, doc, correlativo, t_Pago, f_Pago, total, uDni, tienda};
                        tabla_temporal_compras.addRow(data);
                    }
                    tabla_reporte_compras.setModel(tabla_temporal_compras);
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                } else {
                    advertencia("Ingrese la fecha de inicio");
                }
            } else {
                advertencia("Ingrese la fecha Final");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Tienes problema en tu vida, y la sigues teniendo aqui", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarComprasFechasActionPerformed

    private void tabla_reporte_detalle_compras_fechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_detalle_compras_fechaMousePressed

    }//GEN-LAST:event_tabla_reporte_detalle_compras_fechaMousePressed

    private void tabla_reporte_comprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_comprasMousePressed
        int fila_seleccionada = tabla_reporte_compras.getSelectedRow();
        DetalleCompraBD oDetalleCompraBD = new DetalleCompraBD();
        int idcompra = Integer.parseInt(tabla_temporal_compras.getValueAt(fila_seleccionada, 0).toString());
        tabla_temporal_detalle_compras = oDetalleCompraBD.buscarDetalleCompra(idcompra);

        tabla_reporte_detalle_compras_fecha.setModel(tabla_temporal_detalle_compras);        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_reporte_comprasMousePressed

    private void btnBuscarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDocumentoActionPerformed
        try {
            limpiar_tabla_formulario();
            CompraBD oCompraBD = new CompraBD();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            if (dcFechaFinalDoc.getDate() != null) {
                if (dcFechaInicioDoc.getDate() != null) {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                    String fechaInicio = dcn.format(dcFechaInicioDoc.getDate());
                    String fechaFinal = dcn.format(dcFechaFinalDoc.getDate());
                    String documento = cmbDocumento.getSelectedItem().toString();
                    DefaultTableModel tabla_temporal;
                    tabla_temporal = oCompraBD.reporteCompraDocumento(fechaInicio, fechaFinal, documento);
                    int cant = tabla_temporal.getRowCount();
                    for (int i = 0; i < cant; i++) {
                        String idcompra = tabla_temporal.getValueAt(i, 0).toString();
                        String fecha = tabla_temporal.getValueAt(i, 1).toString();
                        String ruc = tabla_temporal.getValueAt(i, 12).toString();
                        String proveedor = tabla_temporal.getValueAt(i, 2).toString();
                        documento = tabla_temporal.getValueAt(i, 3).toString();
                        String correlativo = tabla_temporal.getValueAt(i, 4).toString();
                        String t_Pago = tabla_temporal.getValueAt(i, 5).toString();
                        String f_Pago = tabla_temporal.getValueAt(i, 6).toString();
                        String total = tabla_temporal.getValueAt(i, 11).toString();
                        String tienda = Login_IU.tienda;
                        String uDni = Login_IU.dni_publico;
                        Object[] data = {idcompra, fecha, ruc, proveedor, documento, correlativo, t_Pago, f_Pago, total, uDni, tienda};
                        tabla_temporal_compras.addRow(data);
                    }
                    tabla_reporte_compras_doc.setModel(tabla_temporal_compras);
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                } else {
                    advertencia("Ingrese la fecha de inicio");
                }
            } else {
                advertencia("Ingrese la fecha Final");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Tienes problema en tu vida, y la sigues teniendo aqui", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarDocumentoActionPerformed

    private void tabla_reporte_compras_docMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_compras_docMousePressed









        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_reporte_compras_docMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCompraProv;
    private javax.swing.JButton btnBuscarComprasFechas;
    private javax.swing.JButton btnBuscarDocumento;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JButton btnImprimirProv;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbDocumento;
    private javax.swing.JComboBox<String> cmbProveedor;
    private com.toedter.calendar.JDateChooser dcFechaFinalDoc;
    private com.toedter.calendar.JDateChooser dcFechaFinalFecha;
    private com.toedter.calendar.JDateChooser dcFechaFinalProv;
    private com.toedter.calendar.JDateChooser dcFechaInicioDoc;
    private com.toedter.calendar.JDateChooser dcFechaInicioFecha;
    private com.toedter.calendar.JDateChooser dcFechaInicioProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla_reporte_compras;
    private javax.swing.JTable tabla_reporte_compras2;
    private javax.swing.JTable tabla_reporte_compras_doc;
    private javax.swing.JTable tabla_reporte_detalle_compra_doc;
    private javax.swing.JTable tabla_reporte_detalle_compra_prov;
    private javax.swing.JTable tabla_reporte_detalle_compras_fecha;
    private javax.swing.JTextField txtTotalCompraDocumento;
    private javax.swing.JTextField txtTotalCompraProv;
    // End of variables declaration//GEN-END:variables
}
