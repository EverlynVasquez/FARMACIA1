package CapaPresentacion;

import CapaDatos.Compra;
import CapaDatos.DetalleCompra;
import CapaDatos.Medida;
import CapaNegocio.CompraBD;
import CapaNegocio.DetalleCompraBD;
import CapaNegocio.MedidaBD;
import CapaNegocio.ProductoBD;
import CapaNegocio.ProveedorBD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Compra_IU extends javax.swing.JInternalFrame {

    List<Medida> lista_medida;

    public Compra_IU() {
        initComponents();
        cargarMedida();
        calcularTotal();

    }

    private void limpiarCompra() {
        cmbTipoComprobante.setSelectedIndex(0);
        cmbFormaPago.setSelectedIndex(0);
        txtNroCompravante.setText("");
        dcFechaCompra.setToolTipText("");
        cmbMoneda.setSelectedIndex(0);
        cmbTienda.setSelectedIndex(0);
        cmbTipoPago.setSelectedIndex(0);
        txtBarras.setText("");
        txtProducto.setText("");
        txtCantidad.setText("");
        txtLote.setText("");
        txtPrecio.setText("");
        txtImporte.setText("");
        cmbMedida.setSelectedIndex(0);
        txtRuc.setText("");
        txtRazonSocial.setText("");
        txtSubTotal.setText("");
        txtDescuento.setText("");
        txtSubTotalDescto.setText("");
        txtFlete.setText("");
        txtIgv.setText("");
        txtTotalPagar.setText("");
    }

    public void registrarDetalleCompra(int idcompra) {
        DefaultTableModel tabla_temporal_compra = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
        int cantCompras = tabla_temporal_compra.getRowCount();
        DetalleCompra oDetalleCompra = new DetalleCompra();
        DetalleCompraBD oDetalleCompraBD = new DetalleCompraBD();
        for (int i = 0; i < cantCompras; i++) {
            oDetalleCompra.setIdCompra(idcompra);
            oDetalleCompra.setpSerie(tabla_temporal_compra.getValueAt(i, 0).toString());
            oDetalleCompra.setDcLote(tabla_temporal_compra.getValueAt(i, 2).toString());
            oDetalleCompra.setDcPresentacion(tabla_temporal_compra.getValueAt(i, 3).toString());
            oDetalleCompra.setDcCantidad((Double) tabla_temporal_compra.getValueAt(i, 4));
            oDetalleCompra.setDcPrecio((Double) tabla_temporal_compra.getValueAt(i, 5));
            oDetalleCompra.setDcImporte((Double) tabla_temporal_compra.getValueAt(i, 6));

            oDetalleCompraBD.registrarDetalleCompra(oDetalleCompra);

        }
    }

    private void calcularTotal() {
        DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
        int maxCompras = tabla_temporal_compras.getRowCount();
        double total = 0;
        for (int i = 0; i < maxCompras; i++) {
            total = total + (Double) tabla_temporal_compras.getValueAt(i, 6);
        }
        BigDecimal nro = new BigDecimal(total);
        BigDecimal decimal_total = nro.setScale(2, RoundingMode.DOWN);
        txtSubTotal.setText("" + decimal_total);
        txtTotalPagar.setText("" + decimal_total);
    }

    public void limpiarAgregar() {
        txtBarras.setText("");
        txtProducto.setText("");
        txtCantidad.setText("");
        txtLote.setText("");
        txtPrecio.setText("");
        txtImporte.setText("");
        cmbMedida.setSelectedIndex(0);

    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_detalle_productos = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
        tabla_temporal_detalle_productos.setRowCount(0);
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

    private void cargarMedida() {
        try {
            cmbMedida.removeAllItems();
            MedidaBD oMedidaBD = new MedidaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oMedidaBD.reportarMedida();

            lista_medida = new ArrayList<>();
            cmbMedida.addItem("Seleccionar");

            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                int codigo = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String nombre = String.valueOf(tabla_temporal.getValueAt(i, 1).toString());

                lista_medida.add(new Medida(codigo, nombre, ""));
                cmbMedida.addItem(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al cargar medida", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField8 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbTipoComprobante = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbFormaPago = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNroCompravante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dcFechaCompra = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cmbMoneda = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbTienda = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtBarras = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbMedida = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtLote = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_detalle_productos = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtSubTotalDescto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtFlete = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        jTextField8.setText("jTextField8");

        setTitle("COMPRAS");

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Compra"));

        jLabel1.setText("Tipo Comprovante");

        cmbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACTURA", "BOLETA", " " }));

        jLabel2.setText("Forma de Pago");

        cmbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO" }));

        jLabel3.setText("Nro Comprovante");

        jLabel4.setText("Fecha de Compra");

        jLabel5.setText("Moneda");

        cmbMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLES ", "PESOS", "DOLARES", "EUROS" }));

        jLabel6.setText("jLabel6");

        cmbTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRINCIPAL" }));

        jLabel7.setText("Tipo de Pago");

        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbTipoComprobante, 0, 128, Short.MAX_VALUE)
                    .addComponent(cmbFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNroCompravante, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcFechaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNroCompravante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(dcFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Compra"));

        jLabel8.setText("Ruc");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/buscar_proveedor.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel9.setText("Razon Social");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtRuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(txtRazonSocial))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel10.setText("Barras");

        txtBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarrasActionPerformed(evt);
            }
        });

        jLabel11.setText("Producto");

        jLabel12.setText("Presentacion");

        cmbMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Lote");

        jLabel14.setText("Cant");

        jLabel15.setText("Precio");

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel16.setText("Importe");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/carrito_compras.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/eliminar2.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabla_reporte_detalle_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BARRAS", "PRODUCTO", "LOTE", "PRESENTACION", "CANT", "PRECIO", "IMPORTE"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_detalle_productos);
        if (tabla_reporte_detalle_productos.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_detalle_productos.getColumnModel().getColumn(0).setMinWidth(150);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(0).setMaxWidth(150);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(2).setMinWidth(150);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(2).setMaxWidth(150);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(3).setMinWidth(150);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(3).setMaxWidth(150);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(4).setMinWidth(70);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(4).setPreferredWidth(30);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(4).setMaxWidth(150);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(5).setMinWidth(70);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(5).setPreferredWidth(40);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(5).setMaxWidth(150);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(6).setMinWidth(50);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla_reporte_detalle_productos.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        jLabel17.setText("Sub Total");

        txtSubTotal.setEditable(false);
        txtSubTotal.setEnabled(false);

        jLabel18.setText("Descuento");

        jLabel19.setText("Sub Total con Descto");

        jLabel20.setText("Flete");

        jLabel21.setText("IGV");

        jLabel22.setText("Total a Pagar");

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setEnabled(false);

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/disk.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cross.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(87, 87, 87)
                                .addComponent(jLabel18)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel19)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSubTotalDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTotalDescto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped


    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        try {
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            double cant = Double.parseDouble(txtCantidad.getText().trim());
            double resultado = precio * cant;

            BigDecimal numero = new BigDecimal(resultado);
            BigDecimal decimal = numero.setScale(2, RoundingMode.DOWN);

            txtImporte.setText("" + decimal);

        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtRuc.getText().length() > 0) {
            DefaultTableModel tabla_temporal;
            ProveedorBD oProveedorBD = new ProveedorBD();
            tabla_temporal = oProveedorBD.buscaProveedor(txtRuc.getText().trim());
            if (tabla_temporal.getRowCount() > 0) {
                txtRazonSocial.setText(tabla_temporal.getValueAt(0, 1).toString());
            } else {
                advertencia("No se encontro , tienes que registrarlo primero al proveedor ");
                txtRuc.requestFocus();
                txtRazonSocial.requestFocus();
            }
        } else {
            advertencia("Ingrese el ruc para buscar el proveedor");
            txtRuc.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarrasActionPerformed
        if (txtBarras.getText().length() > 0) {
            DefaultTableModel tabla_temporal;
            ProductoBD oProductoBD = new ProductoBD();
            tabla_temporal = oProductoBD.buscarProducto(txtBarras.getText().trim());
            if (tabla_temporal.getRowCount() > 0) {
                txtProducto.setText(tabla_temporal.getValueAt(0, 1).toString());
            } else {
                error("No se encontro el producto con este codigo de barras...");
                txtBarras.requestFocus();
                txtProducto.setText("");
            }
        } else {
            advertencia("Ingrese codigo de barras");
            txtBarras.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarrasActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int cant_productos = tabla_reporte_detalle_productos.getRowCount();
        if (cant_productos > 0) {
            if (txtNroCompravante.getText().length() > 0) {
                if (txtRuc.getText().length() > 0) {
                    if (txtRazonSocial.getText().length() > 0) {
                        if (txtSubTotal.getText().length() > 0) {
                            if (txtDescuento.getText().length() > 0) {
                                if (txtSubTotalDescto.getText().length() >0) {
                                    if (txtFlete.getText().length() > 0) {
                                        if (txtIgv.getText().length() > 0) {
                                            if (dcFechaCompra.getDate() != null) {

                                                Compra oCompra = new Compra();
                                                CompraBD oCompraBD = new CompraBD();
                                                SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
                                                String fecha = dcn.format(dcFechaCompra.getDate());

                                                oCompra.setCoFecha(fecha);
                                                oCompra.setCoTipDoc(cmbTipoComprobante.getSelectedItem().toString());
                                                oCompra.setCoNroDoc(txtNroCompravante.getText().toUpperCase());
                                                oCompra.setCoTipoPago(cmbTipoPago.getSelectedItem().toString());
                                                oCompra.setCoFormaPago(cmbFormaPago.getSelectedItem().toString());
                                                oCompra.setCoMoneda(cmbMoneda.getSelectedItem().toString());
                                                oCompra.setCoSubTotal(Double.parseDouble(txtSubTotal.getText().trim()));
                                                oCompra.setCoFlete(Double.parseDouble(txtFlete.getText().trim()));
                                                oCompra.setCoIgv(Double.parseDouble(txtIgv.getText().trim()));
                                                oCompra.setCoTotal(Double.parseDouble(txtTotalPagar.getText().trim()));
                                                oCompra.setProvRuc(txtRuc.getText().trim());
                                                oCompra.setuDni(Login_IU.dni_publico);
                                                oCompra.setTienda(cmbTienda.getSelectedItem().toString());

                                                int idCompra = oCompraBD.registrarCompra(oCompra);
                                                if (idCompra > -1) {
                                                    registrarDetalleCompra(idCompra);
                                                    exito("Todo OK...");
                                                    limpiarCompra();
                                                    limpiar_tabla_formulario();
                                                } else {
                                                    error("No se puede realizar la compra");
                                                }
                                            } else {
                                                advertencia("Seleccione una fecha");
                                                dcFechaCompra.requestFocus();
                                            }
                                        } else {
                                            advertencia("Ingrese el igv de la compra.");
                                            txtIgv.requestFocus();
                                        }
                                    } else {
                                        advertencia("Ingrese el flete de lacompra");
                                        txtFlete.requestFocus();
                                    }
                                } else {
                                    advertencia("Ingrese el sub total del descuento dela compra");
                                    txtSubTotalDescto.requestFocus();
                                }
                            } else {
                                advertencia("Ingrese el descuento de la compra");
                                txtDescuento.requestFocus();
                            }
                        } else {
                            advertencia("Ingrese el total de la compra");
                            txtSubTotal.requestFocus();
                        }
                    } else {
                        advertencia("Coloque un Ruc valido");
                        txtRazonSocial.requestFocus();
                    }
                } else {
                    advertencia("Ingrese un rud del provvedor ");
                    txtRuc.requestFocus();
                }
            } else {
                advertencia("Ingrese el nro de comprovante de la compra");
                txtNroCompravante.requestFocus();
            }
        } else {
            advertencia("No hay productos a la lista");
            txtBarras.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtProducto.getText().length() > 0) {
            if (txtImporte.getText().length() > 0) {
                if (txtPrecio.getText().length() > 0) {
                    if (txtLote.getText().length() > 0) {
                        if (!cmbMedida.getSelectedItem().equals("Seleccionar")) {

                            String barras = txtBarras.getText().trim();
                            String producto = txtProducto.getText().toUpperCase();
                            String lote = txtLote.getText().toUpperCase();
                            String presentacion = cmbMedida.getSelectedItem().toString();
                            double cant = Double.parseDouble(txtCantidad.getText().trim());
                            double precio = Double.parseDouble(txtPrecio.getText().trim());
                            double importe = Double.parseDouble(txtImporte.getText().trim());

                            DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
                            Object[] data = {barras, producto, lote, presentacion, cant, precio, importe};
                            tabla_temporal_compras.addRow(data);
                            limpiarAgregar();
                            calcularTotal();
                        } else {
                            advertencia("Seleccione una medida");
                            cmbMedida.requestFocus();
                        }
                    } else {
                        advertencia("Ingrese el lote  de la compra");
                        txtLote.requestFocus();
                    }
                } else {
                    advertencia("Ingrese el precio del producto");
                    txtPrecio.requestFocus();
                }
            } else {
                advertencia("Ingrese el importe");
                txtImporte.requestFocus();
            }
        } else {
            advertencia("Ingrese un producto");
            txtBarras.requestFocus();
        }     // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila_seleccionada = tabla_reporte_detalle_productos.getSelectedRow();
        try {
            DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
            tabla_temporal_compras.removeRow(fila_seleccionada);
            tabla_reporte_detalle_productos.setModel(tabla_temporal_compras);
            calcularTotal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al quitar", "ERROR", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbFormaPago;
    private javax.swing.JComboBox<String> cmbMedida;
    private javax.swing.JComboBox<String> cmbMoneda;
    private javax.swing.JComboBox<String> cmbTienda;
    private javax.swing.JComboBox<String> cmbTipoComprobante;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private com.toedter.calendar.JDateChooser dcFechaCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tabla_reporte_detalle_productos;
    private javax.swing.JTextField txtBarras;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFlete;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtNroCompravante;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtSubTotalDescto;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
