package CapaPresentacion;

import CapaDatos.TipoUsuario;
import CapaDatos.Usuario;
import CapaNegocio.TipoUsuarioBD;
import CapaNegocio.UsuarioBD;
import java.awt.Color;
import java.awt.Cursor;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario_IU extends javax.swing.JInternalFrame {

    List<TipoUsuario> lista_tipo_usuario;

    public Usuario_IU() {
        initComponents();
        cargarTipoUsuario();
        reportarUsuario();
    }

    private void limpiar() {
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtClave.setText("");
        txtCelular.setText("");
        txtBuscar_apellidos.setText("");
        txtId_tipo_usuario.setText("");
        cmbTipo_Usuario.setSelectedIndex(0);

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

    private void cargarTipoUsuario() {
        try {
            cmbTipo_Usuario.removeAllItems();
            TipoUsuarioBD oMedidaBD = new TipoUsuarioBD();
            DefaultTableModel tabla_Temporal;
            tabla_Temporal = oMedidaBD.reportarTipoUsuario();

            lista_tipo_usuario = new ArrayList<>();
            cmbTipo_Usuario.addItem("Seleccionar");
            for (int i = 0; i < tabla_Temporal.getRowCount(); i++) {
                int idTipoUsuario = Integer.parseInt(tabla_Temporal.getValueAt(i, 0).toString());
                String tuNombre = String.valueOf(tabla_Temporal.getValueAt(i, 1));
                lista_tipo_usuario.add(new TipoUsuario(idTipoUsuario, tuNombre));
                cmbTipo_Usuario.addItem(tuNombre);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al cargar tipo Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reportarUsuario() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tablaTempoarl;
            UsuarioBD oUsuarioBD = new UsuarioBD();
            tablaTempoarl = oUsuarioBD.reportarUsuario();
            tabla_reporte_usuarios.setModel(tablaTempoarl);

            int canLista = tablaTempoarl.getRowCount();
            txtCantidad.setText("" + canLista);
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
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        cmbTipo_Usuario = new javax.swing.JComboBox<>();
        cmbTienda = new javax.swing.JComboBox<>();
        bntRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        bntCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_usuarios = new javax.swing.JTable();
        txtId_tipo_usuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar_apellidos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MANTENIMIENTO DE USUARIOS");
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("DNI");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("NOMBRES");

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

        txtNombres.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombresFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombresFocusLost(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("APELLIDOS");

        txtApellidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidosFocusLost(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("DIRECCION");

        txtDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("CLAVE");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("CELULAR");

        txtCelular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCelularFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCelularFocusLost(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("TIPO");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("TIENDA");

        txtClave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClaveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtClaveFocusLost(evt);
            }
        });
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveKeyTyped(evt);
            }
        });

        cmbTipo_Usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipo_Usuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbTipo_Usuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipo_UsuarioItemStateChanged(evt);
            }
        });

        cmbTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRINCIPAL" }));
        cmbTienda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bntRegistrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bntRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/disk.png"))); // NOI18N
        bntRegistrar.setText("Registrar");
        bntRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bntRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/report_edit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bin_empty.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/printer.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        bntCerrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bntCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cross.png"))); // NOI18N
        bntCerrar.setText("cerrar");
        bntCerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bntCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCerrarActionPerformed(evt);
            }
        });

        tabla_reporte_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_reporte_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_usuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_usuarios);

        txtId_tipo_usuario.setEditable(false);
        txtId_tipo_usuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Buscar Apellidos");

        txtBuscar_apellidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBuscar_apellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscar_apellidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscar_apellidosFocusLost(evt);
            }
        });
        txtBuscar_apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar_apellidosActionPerformed(evt);
            }
        });
        txtBuscar_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscar_apellidosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_apellidosKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setText("Cantidad");

        txtCantidad.setEditable(false);
        txtCantidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bntRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClave, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipo_Usuario, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTienda, javax.swing.GroupLayout.Alignment.LEADING, 0, 468, Short.MAX_VALUE)
                    .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId_tipo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar_apellidos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipo_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntCerrar)
                            .addComponent(bntRegistrar)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnImprimir)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId_tipo_usuario)
                            .addComponent(jLabel10)
                            .addComponent(txtCantidad))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipo_UsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipo_UsuarioItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String txtoSeleccionado = (String) cmbTipo_Usuario.getSelectedItem();
            if (txtoSeleccionado.equals("Seleccionar")) {
                txtId_tipo_usuario.setText("");

            } else {
                int i = cmbTipo_Usuario.getSelectedIndex() - 1;
                txtId_tipo_usuario.setText("" + lista_tipo_usuario.get(i).getIdtipoUsuario());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipo_UsuarioItemStateChanged

    private void bntRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRegistrarActionPerformed
        try {
            if (txtDni.getText().length() > 0) {
                if (txtNombres.getText().length() > 0) {
                    if (txtApellidos.getText().length() > 0) {
                        if (txtDireccion.getText().length() > 0) {
                            if (txtCelular.getText().length() > 0) {
                                if (txtClave.getText().length() > 0) {

                                    Usuario oUsuario = new Usuario();
                                    UsuarioBD oUsuarioBD = new UsuarioBD();
                                    oUsuario.setuDni(txtDni.getText().toUpperCase().trim());
                                    oUsuario.setuNombre(txtNombres.getText().toUpperCase().trim());
                                    oUsuario.setuApellidos(txtApellidos.getText().toUpperCase().trim());
                                    oUsuario.setuDireccion(txtDireccion.getText().toUpperCase());
                                    oUsuario.setuClave(txtClave.getText().toUpperCase());
                                    oUsuario.setuCelular(txtCelular.getText().toUpperCase());
                                    oUsuario.setIdtipousuario(Integer.parseInt(txtId_tipo_usuario.getText()));
                                    oUsuario.setTienda(cmbTienda.getSelectedItem().toString());

                                    boolean rpta = oUsuarioBD.registrarUsuario(oUsuario);
                                    if (rpta) {
                                        exito("Se registro con exito");
                                        reportarUsuario();
                                        limpiar();
                                    } else {
                                        error("Tienes problemas al registrar");
                                    }

                                } else {
                                    advertencia("Ingrese cleve");
                                    txtClave.requestFocus();
                                }
                            } else {
                                advertencia("Ingrese celular");
                                txtCelular.requestFocus();
                            }
                        } else {
                            advertencia("Ingrese direccion");
                            txtDireccion.requestFocus();
                        }
                    } else {
                        advertencia("Ingrese apellidos");
                        txtApellidos.requestFocus();
                    }
                } else {
                    advertencia("Ingrese nombre");
                    txtNombres.requestFocus();
                }
            } else {
                advertencia("Ingrese dni");
                txtDireccion.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }


    }//GEN-LAST:event_bntRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtDni.getText().length() > 0) {
            if (txtNombres.getText().length() > 0) {
                if (txtApellidos.getText().length() > 0) {
                    if (txtDireccion.getText().length() > 0) {
                        if (txtCelular.getText().length() > 0) {
                            if (txtClave.getText().length() > 0) {
                                if (txtId_tipo_usuario.getText().length() > 0) {

                                    Usuario oUsuario = new Usuario();
                                    UsuarioBD oUsuarioBD = new UsuarioBD();
                                    oUsuario.setuDni(txtDni.getText().toUpperCase().trim());
                                    oUsuario.setuNombre(txtNombres.getText().toUpperCase().trim());
                                    oUsuario.setuApellidos(txtApellidos.getText().toUpperCase().trim());
                                    oUsuario.setuDireccion(txtDireccion.getText().toUpperCase());
                                    oUsuario.setuClave(txtClave.getText().toUpperCase());
                                    oUsuario.setuCelular(txtCelular.getText().toUpperCase());
                                    oUsuario.setIdtipousuario(Integer.parseInt(txtId_tipo_usuario.getText()));
                                    oUsuario.setTienda(cmbTienda.getSelectedItem().toString());

                                    boolean rpta = oUsuarioBD.modificarUsuario(oUsuario);
                                    if (rpta) {
                                        exito("Se modifico con exito");
                                        reportarUsuario();
                                        limpiar();
                                    } else {
                                        error("Tienes problemas al modificar usuario");
                                    }

                                } else {
                                    error("No ha seleccionado al usuario a modificar");
                                }
                            } else {
                                advertencia("Ingrese cleve");
                                txtClave.requestFocus();
                            }
                        } else {
                            advertencia("Ingrese celular");
                            txtCelular.requestFocus();
                        }
                    } else {
                        advertencia("Ingrese direccion");
                        txtDireccion.requestFocus();
                    }
                } else {
                    advertencia("Ingrese apellidos");
                    txtApellidos.requestFocus();
                }
            } else {
                advertencia("Ingrese nombre");
                txtNombres.requestFocus();
            }
        } else {
            advertencia("Ingrese dni");
            txtDireccion.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tabla_reporte_usuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_usuariosMousePressed
        if (evt.getClickCount() == 2) {
            int fila_Seleccionada = tabla_reporte_usuarios.getSelectedRow();
            txtDni.setText(tabla_reporte_usuarios.getValueAt(fila_Seleccionada, 0).toString());
            txtNombres.setText(tabla_reporte_usuarios.getValueAt(fila_Seleccionada, 1).toString());
            txtApellidos.setText(tabla_reporte_usuarios.getValueAt(fila_Seleccionada, 2).toString());
            txtDireccion.setText(tabla_reporte_usuarios.getValueAt(fila_Seleccionada, 3).toString());
            txtClave.setText(tabla_reporte_usuarios.getValueAt(fila_Seleccionada, 4).toString());
            txtCelular.setText(tabla_reporte_usuarios.getValueAt(fila_Seleccionada, 5).toString());
            cmbTipo_Usuario.setSelectedItem(tabla_reporte_usuarios.getValueAt(fila_Seleccionada, 6).toString());
            cmbTienda.setSelectedItem(tabla_reporte_usuarios.getValueAt(fila_Seleccionada, 7).toString());

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_reporte_usuariosMousePressed

    private void txtBuscar_apellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar_apellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar_apellidosActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtDni.getText().length() > 0) {
                int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar ");

                if (aviso == 0) {
                    UsuarioBD oUsuarioBD = new UsuarioBD();
                    String Dni = txtDni.getText();
                    boolean rpta = oUsuarioBD.eliminarUsuario(Dni);

                    if (rpta) {
                        exito("Se elimino al usuario correcatmente");
                        reportarUsuario();
                        limpiar();
                        txtDni.requestFocus();
                    } else {
                        error("Tienes problemas para eliminar");
                    }

                } else {
                    error("Ingrese un dni para eliminar");
                    txtDni.requestFocus();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void bntCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCerrarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_bntCerrarActionPerformed

    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained
        txtDni.setBackground(Color.cyan);           // TODO add your handling code here:
    }//GEN-LAST:event_txtDniFocusGained

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        txtDni.setBackground(Color.WHITE);           // TODO add your handling code here:
    }//GEN-LAST:event_txtDniFocusLost

    private void txtNombresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusGained
        txtNombres.setBackground(Color.cyan);           // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresFocusGained

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost
        txtNombres.setBackground(Color.WHITE);           // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresFocusLost

    private void txtApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusGained
        txtApellidos.setBackground(Color.cyan);
    }//GEN-LAST:event_txtApellidosFocusGained

    private void txtApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusLost
        txtApellidos.setBackground(Color.white);
    }//GEN-LAST:event_txtApellidosFocusLost

    private void txtDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusGained
        txtDireccion.setBackground(Color.cyan);           // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionFocusGained

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
        txtDireccion.setBackground(Color.white);           // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionFocusLost

    private void txtClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusGained
        txtClave.setBackground(Color.cyan);           // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveFocusGained

    private void txtClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusLost
        txtClave.setBackground(Color.white);           // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveFocusLost

    private void txtCelularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCelularFocusGained
        txtCelular.setBackground(Color.cyan);           // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularFocusGained

    private void txtCelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCelularFocusLost
        txtCelular.setBackground(Color.cyan);           // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularFocusLost

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNombres.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtApellidos.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDireccion.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtClave.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCelular.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveKeyPressed

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbTipo_Usuario.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtBuscar_apellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar_apellidosFocusGained
        txtBuscar_apellidos.setBackground(Color.cyan);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar_apellidosFocusGained

    private void txtBuscar_apellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar_apellidosFocusLost
        txtBuscar_apellidos.setBackground(Color.white);             // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar_apellidosFocusLost

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtDni.getText().length() >= 8) {
            evt.consume();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
char c=evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
char c=evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyTyped

        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtClave.getText().length() >= 6) {
            evt.consume();
        }

    }//GEN-LAST:event_txtClaveKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtCelular.getText().length() >= 9) {
            evt.consume();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtBuscar_apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_apellidosKeyTyped
        if (!(Character.isLetter(evt.getKeyChar()))) {
            evt.consume();

        }

    }//GEN-LAST:event_txtBuscar_apellidosKeyTyped

    private void txtBuscar_apellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_apellidosKeyPressed
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tabla_temporal;

            String apellidos = txtBuscar_apellidos.getText();
            UsuarioBD oUsuarioBD = new UsuarioBD();
            tabla_temporal = oUsuarioBD.BuscaeUsuario(apellidos);
            tabla_reporte_usuarios.setModel(tabla_temporal);

            int canLista = tabla_temporal.getRowCount();
            txtCantidad.setText("" + canLista);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar_apellidosKeyPressed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
char c=evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCerrar;
    private javax.swing.JButton bntRegistrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbTienda;
    private javax.swing.JComboBox<String> cmbTipo_Usuario;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_usuarios;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar_apellidos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtId_tipo_usuario;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
