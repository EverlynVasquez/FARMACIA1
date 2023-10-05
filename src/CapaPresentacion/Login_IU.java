package CapaPresentacion;

import CapaDatos.Asistencia;
import CapaDatos.Turno;
import CapaDatos.Usuario;
import CapaNegocio.AsistenciaBD;
import CapaNegocio.TurnoBD;
import CapaNegocio.UsuarioBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class Login_IU extends javax.swing.JFrame {

    public static String dni_publico;
    public static String usuario;
    public static String tienda;
    public static int idasistencia;

    public Login_IU() {
        initComponents();
        this.setLocationRelativeTo(null);
        obtener_fecha_actual();
        obtener_hora();
    }

    private String obtener_fecha_actual() {
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);
        String fecha = anio + "-" + mes + "-" + dia;

        return fecha;
    }

    private String obtener_hora() {
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);
        int segundo = calendario.get(Calendar.SECOND);
        String tiempo = hora + ":" + minuto + ":" + segundo;
        return tiempo;
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

        txtClave = new javax.swing.JPasswordField();
        btnCerrar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(3);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveKeyPressed(evt);
            }
        });
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 160, 30));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cerrar.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 120, -1));

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/llave.png"))); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        btnIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIngresarKeyPressed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 120, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("BIENVENIDOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

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
        getContentPane().add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 160, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8-candado-2-30.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8-usuario-30.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/os1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained
        txtDni.setBackground(Color.ORANGE);        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniFocusGained

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        txtDni.setBackground(Color.white);          // TODO add your handling code here:
    }//GEN-LAST:event_txtDniFocusLost

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtDni.getText().length() >= 8) {
            evt.consume();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtClave.requestFocus();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtDniKeyPressed

    private void btnIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresarKeyPressed

    }//GEN-LAST:event_btnIngresarKeyPressed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
if (txtDni.getText().length() > 0) {
            if (txtClave.getText().length() > 0) {
                String dni = txtDni.getText().trim();
                String clave = txtClave.getText();
                UsuarioBD oUsuarioBD = new UsuarioBD();
                List<Usuario> lista_usuario = oUsuarioBD.login(dni, clave);

                if (lista_usuario.size() > 0) {
                    String nombre = lista_usuario.get(0).getuNombre();
                    String apellidos = lista_usuario.get(0).getuApellidos();
                    tienda = lista_usuario.get(0).getTienda();
                    dni_publico = dni;
                    usuario = nombre + " " + apellidos;

                    TurnoBD oTurnoBD = new TurnoBD();
                    String hora_actual = obtener_hora();
                    List<Turno> lista_turno = oTurnoBD.buscarTurno(hora_actual, hora_actual, dni);

                    if (lista_turno.size() > 0) {
                        Menu_IU o_Menu_IU = new Menu_IU();
                        String fecha = obtener_fecha_actual();
                        String hora = obtener_hora();
                        Asistencia o_Asistencia = new Asistencia();
                        AsistenciaBD o_AsistenciaBD = new AsistenciaBD();

                        int tipo = lista_usuario.get(0).getIdtipousuario();
                        if (tipo == 1) {
                            o_Menu_IU.menu_mantenimiento_proveedor.setEnabled(true);
                            o_Menu_IU.menu_compras.setEnabled(true);
                            o_Menu_IU.menu_inventario.setEnabled(true);
                            o_Menu_IU.btnProductos.setEnabled(true);
                            o_Menu_IU.btnCompras.setEnabled(true);
                            o_Menu_IU.btnCerrar.setEnabled(true);
                           

                            o_Menu_IU.setVisible(true);
                            o_Menu_IU.setTitle("TIENDA: " + tienda + "- USUARIO: " + usuario);
                            this.setVisible(false);
                        }
                        if (tipo == 2) {
                            o_Menu_IU.menu_ventas.setEnabled(true);
                            o_Menu_IU.menu_caja.setEnabled(true);
                            o_Menu_IU.btnIngresos.setEnabled(true);
                            o_Menu_IU.btnCajas.setEnabled(true);
                            o_Menu_IU.btnVentas.setEnabled(true);
                            o_Menu_IU.btnCerrar.setEnabled(true);
                            o_Menu_IU.btnEgresos.setEnabled(true);

                            List<Asistencia> lista = o_AsistenciaBD.buscarAsistenciaUsuario(dni, tienda, fecha);
                            if (lista.size() > 0) {
                                String estado = lista.get(0).getaEstado();
                                if (estado.equals("CERRADO")) {
                                    advertencia("YA NO PUEDES INGRESAR AL SISTEMA POR QUE CERRASTE TU CAJA");

                                } else {
                                    idasistencia = lista.get(0).getIdasistencia();
                                    o_Menu_IU.setVisible(true);
                                    o_Menu_IU.setTitle("TIENDA: " + tienda + "- USUARIO: " + usuario);
                                }
                            } else {
                                o_Asistencia.setaFechaE(fecha);
                                o_Asistencia.setaHoraE(hora);
                                o_Asistencia.setaHoraS("00:00:00");
                                o_Asistencia.setuDni(dni);
                                o_Asistencia.setaTurno("");
                                o_Asistencia.setaEstado("ABIERTO");
                                o_Asistencia.setaTienda(tienda);
                                idasistencia = o_AsistenciaBD.registrarAsistencia(o_Asistencia);
                                o_Menu_IU.setVisible(true);
                                o_Menu_IU.setTitle("TIENDA: " + tienda + "- USUARIO: " + usuario);
                                this.setVisible(false);
                            }
                        }

                    } else {
                        advertencia("No puedes ingresar al sistema, por que no es tu turno");
                    }
                } else {
                    error("No perteneces al sistema");
                    txtDni.requestFocus();
                }

            } else {
                advertencia("Ingrese su clave");
                txtClave.requestFocus();
            }
        } else {
            advertencia("Ingrese dni");
            txtDni.requestFocus();
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIngresar.requestFocus();
            btnIngresar.doClick();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveKeyPressed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_IU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtDni;
    // End of variables declaration//GEN-END:variables
}
