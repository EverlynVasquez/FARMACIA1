package CapaPresentacion;

import CapaDatos.Categoria;
import CapaDatos.Marca;
import CapaDatos.Medida;
import CapaDatos.Producto;
import CapaNegocio.CategoriaBD;
import CapaNegocio.MarcaBD;
import CapaNegocio.MedidaBD;
import CapaNegocio.ProductoBD;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Producto_IU extends javax.swing.JInternalFrame {

    List<Categoria> lista_Categoria;
    List<Marca> lista_Marca;
    List<Medida> lista_Medida;

    public Producto_IU() {
        initComponents();
        cargarCategoria();
        cargarMarca();
        cargarMedida();
        reportarProducto();
        deshabilitar();
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

    private void habilitar() {
        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnRegistrar.setEnabled(true);
        txtSerie.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtObsercacion.setEnabled(true);
        txtDigemI.setEnabled(true);
        cmbCategoria.setEnabled(true);
        cmbMarca.setEnabled(true);
        cmbMedida.setEnabled(true);
        txtProducto.setEnabled(true);
        cmbCondicion.setEnabled(true);

    }

    private void deshabilitar() {
        btnBuscar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnRegistrar.setEnabled(false);
        txtSerie.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtObsercacion.setEnabled(false);
        txtDigemI.setEnabled(false);
        cmbCategoria.setEnabled(false);
        cmbMarca.setEnabled(false);
        cmbMedida.setEnabled(false);
        txtProducto.setEnabled(false);
        cmbCondicion.setEnabled(false);
    }

    private void limpiar() {
        cmbCategoria.setSelectedIndex(0);
        cmbMarca.setSelectedIndex(0);
        cmbMedida.setSelectedIndex(0);

        txtSerie.setText("");
        txtDescripcion.setText("");
        txtObsercacion.setText("");
        txtDigemI.setText("");
        txtIdCategoria.setText("");
        txtIdMarca.setText("");
        txtIdMedida.setText("");

    }

    private void limpiar_formulario() {
        DefaultTableModel tabla_tempoarl_productos = (DefaultTableModel) tabla_reporte_producto.getModel();
        tabla_tempoarl_productos.setRowCount(0);
    }

    private void cargarCategoria() {
        try {
            cmbCategoria.removeAllItems();
            CategoriaBD oCategoriaBD = new CategoriaBD();
            lista_Categoria = oCategoriaBD.reportarCategoria();
            cmbCategoria.addItem("Seleccionar");
            for (int i = 0; i < lista_Categoria.size(); i++) {
                int idcategoria = lista_Categoria.get(i).getIdCategoria();
                String nombre = lista_Categoria.get(i).getCatNombre();

                cmbCategoria.addItem(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al cargar categoria", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cargarMarca() {
        try {
            cmbMarca.removeAllItems();
            MarcaBD oMarcaBD = new MarcaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oMarcaBD.reporteMarca();
            lista_Marca = new ArrayList<>();

            cmbMarca.addItem("Seleccionar");
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                int codigo = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String nombre = String.valueOf(tabla_temporal.getValueAt(i, 1));

                lista_Marca.add(new Marca(codigo, nombre));
                cmbMarca.addItem(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al cargar marca", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarMedida() {
        try {
            cmbMedida.removeAllItems();
            MedidaBD oMedidaBD = new MedidaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oMedidaBD.reportarMedida();
            lista_Medida = new ArrayList<>();

            cmbMedida.addItem("Seleccionar");

            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                int codigo = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String presentacion = String.valueOf(tabla_temporal.getValueAt(i, 1));
                String equivalencia = String.valueOf(tabla_temporal.getValueAt(i, 2));

                lista_Medida.add(new Medida(codigo, presentacion, equivalencia));
                cmbMedida.addItem(presentacion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al cargar marca", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reportarProducto() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

            limpiar_formulario();
            DefaultTableModel tabla_temporal;
            ProductoBD oProductoBD = new ProductoBD();

            tabla_temporal = oProductoBD.reportarProducto();
            int cantidad_productos_encontrados = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cantidad_productos_encontrados);
            DefaultTableModel tabla_temporal_productos = (DefaultTableModel) this.tabla_reporte_producto.getModel();

            for (int i = 0; i < cantidad_productos_encontrados; i++) {

                String serie = tabla_temporal.getValueAt(i, 0).toString();
                String descripcion = tabla_temporal.getValueAt(i, 1).toString();
                String observacion = tabla_temporal.getValueAt(i, 2).toString();
                String digemi = tabla_temporal.getValueAt(i, 3).toString();
                String condicion = tabla_temporal.getValueAt(i, 4).toString();
                String categoria = tabla_temporal.getValueAt(i, 5).toString();
                String marca = tabla_temporal.getValueAt(i, 6).toString();
                String medida = tabla_temporal.getValueAt(i, 7).toString();

                Object[] data = {serie, descripcion, observacion, digemi, condicion, categoria, marca, medida};
                tabla_temporal_productos.addRow(data);
            }
            tabla_reporte_producto.setModel(tabla_temporal_productos);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        bntCerrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnComposicion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtIdMedida = new javax.swing.JTextField();
        txtIdMarca = new javax.swing.JTextField();
        txtIdCategoria = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtObsercacion = new javax.swing.JTextField();
        txtDigemI = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbCondicion = new javax.swing.JComboBox<>();
        cmbMarca = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbMedida = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_producto = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(51, 0, 204))); // NOI18N

        jLabel9.setText("PRODUCTO");

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProducto)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/application.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/disk.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setEnabled(false);
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/report_magnify.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setEnabled(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/report_edit.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setEnabled(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bin_empty.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setEnabled(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        bntCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cerrar3.png"))); // NOI18N
        bntCerrar.setText("CERRAR");
        bntCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bntCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntCerrar))
        );

        jLabel10.setText("CANTIDAD");

        txtCantidad.setEditable(false);

        btnComposicion.setText("COMPOSICION");

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

        txtIdMedida.setEditable(false);
        txtIdMedida.setEnabled(false);

        txtIdMarca.setEditable(false);
        txtIdMarca.setEnabled(false);

        txtIdCategoria.setEditable(false);
        txtIdCategoria.setEnabled(false);

        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        jLabel2.setText("DESCRIPCION");

        jLabel3.setText("OBSERVACION");

        jLabel4.setText("DIGEMI");

        jLabel6.setText("CATEGORIA");

        txtObsercacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtObsercacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtObsercacionFocusLost(evt);
            }
        });
        txtObsercacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtObsercacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObsercacionKeyTyped(evt);
            }
        });

        txtDigemI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDigemIFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDigemIFocusLost(evt);
            }
        });
        txtDigemI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDigemIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDigemIKeyTyped(evt);
            }
        });

        cmbCategoria.setFont(new java.awt.Font("Agency FB", 0, 10)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });
        cmbCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbCategoriaKeyPressed(evt);
            }
        });

        jLabel7.setText("LABORATORIO");

        jLabel5.setText("CONDICION");

        cmbCondicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORMAL", "RECETA MÈDICA" }));
        cmbCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCondicionActionPerformed(evt);
            }
        });
        cmbCondicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbCondicionKeyPressed(evt);
            }
        });

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMarcaItemStateChanged(evt);
            }
        });
        cmbMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMarcaKeyPressed(evt);
            }
        });

        jLabel8.setText("MEDIDA");

        cmbMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMedida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedidaItemStateChanged(evt);
            }
        });
        cmbMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMedidaKeyPressed(evt);
            }
        });

        tabla_reporte_producto.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        tabla_reporte_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "MEDIDA"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_producto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(610, 610, 610)
                                        .addComponent(jLabel8)
                                        .addGap(4, 4, 4)
                                        .addComponent(cmbMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(0, 548, Short.MAX_VALUE)
                                        .addComponent(txtIdMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtDigemI)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(4, 4, 4)
                                                        .addComponent(jLabel7)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescripcion))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtObsercacion))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnComposicion)
                        .addGap(663, 663, 663)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtObsercacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtDigemI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))))
                        .addGap(3, 3, 3)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComposicion))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String textoSeleccionado = (String) cmbCategoria.getSelectedItem();
            if (textoSeleccionado.equals("Seleccionar")) {
                txtIdCategoria.setText("");
            } else {
                int i = cmbCategoria.getSelectedIndex() - 1;
                txtIdCategoria.setText("" + lista_Categoria.get(i).getIdCategoria());
            }
        }

    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void cmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarcaItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String textoSeleccionado = (String) cmbMarca.getSelectedItem();

            if (textoSeleccionado.equals("Seleccionar")) {
                txtIdMarca.setText("");
            } else {
                int i = cmbMarca.getSelectedIndex() - 1;
                txtIdMarca.setText("" + lista_Marca.get(i).getIdmarca());

            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMarcaItemStateChanged

    private void cmbMedidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedidaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String textoSeleccionado = (String) cmbMedida.getSelectedItem();

            if (textoSeleccionado.equals("Seleccionar")) {
                txtIdMedida.setText("");
            } else {
                int i = cmbMedida.getSelectedIndex() - 1;
                txtIdMedida.setText("" + lista_Medida.get(i).getIdmedida());

            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedidaItemStateChanged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtSerie.getText().length() > 0) {
            if (txtDescripcion.getText().length() > 0) {
                if (txtIdCategoria.getText().length() > 0) {
                    if (txtIdMarca.getText().length() > 0) {
                        if (txtIdMedida.getText().length() > 0) {

                            Producto oProducto = new Producto();
                            ProductoBD oProductoBD = new ProductoBD();
                            oProducto.setpSerie(txtSerie.getText().trim());
                            oProducto.setpDescripcion(txtDescripcion.getText().toUpperCase().trim());
                            oProducto.setpObservacion(txtObsercacion.getText().toUpperCase().trim());
                            oProducto.setDigemi(txtDigemI.getText().toUpperCase());
                            oProducto.setpCondicion(cmbCondicion.getSelectedItem().toString());
                            oProducto.setIdCategoria(Integer.parseInt(txtIdCategoria.getText()));
                            oProducto.setIdmarca(Integer.parseInt(txtIdMarca.getText()));
                            oProducto.setIdmedida(Integer.parseInt(txtIdMedida.getText()));

                            boolean rpta = oProductoBD.registrarProducto(oProducto);
                            if (rpta) {
                                exito("Se registro con exito");
                                reportarProducto();
                                limpiar();
                                deshabilitar();
                            } else {
                                error("Tienes problemas al registrar");
                            }
                        } else {
                            error("Seleccione una medida");
                        }
                    } else {
                        error("Seleccione un laboratorio");
                    }
                } else {
                    error("Seleccione una categoria");
                }
            } else {
                error("Ingrese la descripcion del producto");
                txtDescripcion.requestFocus();
            }
        } else {
            error("Ingreseel codigo del producto");
            txtSerie.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
        limpiar();
        reportarProducto();
        txtSerie.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void cmbCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCondicionActionPerformed

    }//GEN-LAST:event_cmbCondicionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtSerie.getText().length() > 0) {
            String serie = txtSerie.getText();
            DefaultTableModel tabla_temporal;
            ProductoBD oProductoBD = new ProductoBD();
            tabla_temporal = oProductoBD.buscarProducto(serie);

            int cantidad_productos_encontrados = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cantidad_productos_encontrados);
            limpiar_formulario();

            if (cantidad_productos_encontrados > 0) {

                txtDescripcion.setText(tabla_temporal.getValueAt(0, 1).toString());
                txtObsercacion.setText(tabla_temporal.getValueAt(0, 2).toString());
                txtDigemI.setText(tabla_temporal.getValueAt(0, 3).toString());
                cmbCondicion.setSelectedItem(tabla_temporal.getValueAt(0, 4).toString());
                cmbCategoria.setSelectedItem(tabla_temporal.getValueAt(0, 5).toString());
                cmbMarca.setSelectedItem(tabla_temporal.getValueAt(0, 6).toString());
                cmbMedida.setSelectedItem(tabla_temporal.getValueAt(0, 7).toString());
                txtIdCategoria.setText(tabla_temporal.getValueAt(0, 8).toString());
                txtIdMarca.setText(tabla_temporal.getValueAt(0, 9).toString());
                txtIdMedida.setText(tabla_temporal.getValueAt(0, 10).toString());

                DefaultTableModel tabla_temporal_producto = (DefaultTableModel) this.tabla_reporte_producto.getModel();

                for (int i = 0; i < cantidad_productos_encontrados; i++) {
                    serie = tabla_temporal.getValueAt(i, 0).toString();
                    String descripcion = tabla_temporal.getValueAt(i, 1).toString();
                    String observacion = tabla_temporal.getValueAt(i, 2).toString();
                    String digemi = tabla_temporal.getValueAt(i, 3).toString();
                    String condicion = tabla_temporal.getValueAt(i, 4).toString();
                    String categoria = tabla_temporal.getValueAt(i, 5).toString();
                    String marca = tabla_temporal.getValueAt(i, 6).toString();
                    String medida = tabla_temporal.getValueAt(i, 7).toString();

                    Object[] data = {serie, descripcion, observacion, digemi, condicion, categoria, marca, medida};
                    tabla_temporal_producto.addRow(data);

                }
                tabla_reporte_producto.setModel(tabla_temporal_producto);

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el producto buscado");
                txtSerie.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Ingrese serie..");
            txtSerie.requestFocus();
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtSerie.getText().length() > 0) {
            if (txtDescripcion.getText().length() > 0) {
                if (txtIdCategoria.getText().length() > 0) {
                    if (txtIdMarca.getText().length() > 0) {
                        if (txtIdMedida.getText().length() > 0) {

                            Producto oProducto = new Producto();
                            ProductoBD oProductoBD = new ProductoBD();
                            oProducto.setpSerie(txtSerie.getText().trim());
                            oProducto.setpDescripcion(txtDescripcion.getText().toUpperCase().trim());
                            oProducto.setpObservacion(txtObsercacion.getText().toUpperCase().trim());
                            oProducto.setDigemi(txtDigemI.getText().toUpperCase());
                            oProducto.setpCondicion(cmbCondicion.getSelectedItem().toString());
                            oProducto.setIdCategoria(Integer.parseInt(txtIdCategoria.getText()));
                            oProducto.setIdmarca(Integer.parseInt(txtIdMarca.getText()));
                            oProducto.setIdmedida(Integer.parseInt(txtIdMedida.getText()));

                            boolean rpta = oProductoBD.modificarProducto(oProducto);
                            if (rpta) {
                                exito("Se modifico con exito");
                                reportarProducto();
                                limpiar();
                                deshabilitar();
                            } else {
                                error("Tienes problemas al modificar");
                            }
                        } else {
                            error("Seleccione una medida");
                        }
                    } else {
                        error("Seleccione un laboratorio");
                    }
                } else {
                    error("Seleccione una categoria");
                }
            } else {
                error("Ingrese la descripcion del producto");
                txtDescripcion.requestFocus();
            }
        } else {
            error("Ingreseel codigo del producto");
            txtSerie.requestFocus();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try {
            if (txtSerie.getText().length() > 0) {
                String serie = txtSerie.getText();
                int aviso = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de eliminar?");
                if (aviso == 0) {
                    ProductoBD oProductoBD = new ProductoBD();
                    boolean rpta = oProductoBD.eliminarProducto(serie);
                    if (rpta) {
                        exito("Se elimino el producto");
                        reportarProducto();
                        limpiar();
                        deshabilitar();
                        txtSerie.requestFocus();
                    } else {
                        error("Tienes problema sal eliminar producto");
                    }
                }
            } else {
                error("Falta codigo del producto al eliminar");
                txtSerie.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoKeyReleased

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
        limpiar_formulario();
        String descripcion = txtProducto.getText();
        DefaultTableModel tabla_temporal;
        DefaultTableModel tabla_temporal_producto = (DefaultTableModel) tabla_reporte_producto.getModel();
        ProductoBD oProductoBD = new ProductoBD();
        tabla_temporal = oProductoBD.BuscarProductoDescripcion(descripcion);
        int cant = tabla_temporal.getRowCount();
        for (int i = 0; i < cant; i++) {
            String serie = tabla_temporal.getValueAt(i, 0).toString();
            descripcion = tabla_temporal.getValueAt(i, 1).toString();
            String observacion = tabla_temporal.getValueAt(i, 2).toString();
            String digemi = tabla_temporal.getValueAt(i, 3).toString();
            String condicion = tabla_temporal.getValueAt(i, 4).toString();
            String categoria = tabla_temporal.getValueAt(i, 5).toString();
            String marca = tabla_temporal.getValueAt(i, 6).toString();
            String medida = tabla_temporal.getValueAt(i, 7).toString();

            Object[] data = {serie, descripcion, observacion, digemi, condicion, categoria, marca, medida};
            tabla_temporal_producto.addRow(data);
        }
        tabla_reporte_producto.setModel(tabla_temporal_producto);
        txtCantidad.setText("" + cant);

    }//GEN-LAST:event_txtProductoKeyPressed

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtSerie.getText().length() >= 13) {
            evt.consume();
        }           // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieKeyTyped

    private void txtSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusGained
        txtSerie.setBackground(Color.CYAN);        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieFocusGained

    private void txtSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusLost
        txtSerie.setBackground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieFocusLost

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusGained
        txtDescripcion.setBackground(Color.cyan);        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionFocusGained

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        txtDescripcion.setBackground(Color.white);            // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionFocusLost

    private void txtObsercacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObsercacionFocusGained
        txtObsercacion.setBackground(Color.cyan);              // TODO add your handling code here:
    }//GEN-LAST:event_txtObsercacionFocusGained

    private void txtObsercacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObsercacionFocusLost
        txtObsercacion.setBackground(Color.white);              // TODO add your handling code here:
    }//GEN-LAST:event_txtObsercacionFocusLost

    private void txtDigemIFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDigemIFocusGained
        txtDigemI.setBackground(Color.cyan);              // TODO add your handling code here:
    }//GEN-LAST:event_txtDigemIFocusGained

    private void txtDigemIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDigemIFocusLost
        txtDigemI.setBackground(Color.white);          // TODO add your handling code here:
    }//GEN-LAST:event_txtDigemIFocusLost

    private void txtProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusGained
        txtProducto.setBackground(Color.cyan);              // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoFocusGained

    private void txtProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusLost
        txtProducto.setBackground(Color.white);              // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoFocusLost

    private void txtSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDescripcion.requestFocus();

        }

    }//GEN-LAST:event_txtSerieKeyPressed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtObsercacion.requestFocus();

        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtObsercacion.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtObsercacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObsercacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDigemI.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtObsercacionKeyPressed

    private void txtDigemIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDigemIKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbCondicion.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtDigemIKeyPressed

    private void cmbCondicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCondicionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbCategoria.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_cmbCondicionKeyPressed

    private void cmbCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCategoriaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbMarca.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaKeyPressed

    private void cmbMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMarcaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbMedida.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_cmbMarcaKeyPressed

    private void cmbMedidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMedidaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedidaKeyPressed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();

        }
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void txtObsercacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObsercacionKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtObsercacionKeyTyped

    private void txtDigemIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDigemIKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtDigemIKeyTyped

    private void txtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoKeyTyped

    private void bntCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCerrarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_bntCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCerrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnComposicion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbCondicion;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_producto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDigemI;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtIdMarca;
    private javax.swing.JTextField txtIdMedida;
    private javax.swing.JTextField txtObsercacion;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
