package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.TipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;

public class TipoUsuarioBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarTipoUsuario() {
        DefaultTableModel tabla_Temporal;
        String[] cabecera = {"CODIGO", "NOMBRE"};
        String[] registros = new String[2];
        tabla_Temporal = new DefaultTableModel(null, cabecera);
        sql = "SELECT idtipoUsuario,tuNombre FROM tipousuario ";
        try {

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                registros[0] = rs.getString("idtipoUsuario");
                registros[1] = rs.getString("tuNombre");
                tabla_Temporal.addRow(registros);
            }
            return tabla_Temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Tipo Usuario...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public boolean registrarTipoUsuario(TipoUsuario tu) {
        sql = "INSERT INTO tipousuario (idtipoUsuario,tuNombre) VALUES (0,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, tu.getTuNombre());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean modificarTipoUsuario(TipoUsuario tu) {
        sql = "UPDATE tipousuario SET tuNombre=? WHERE idtipoUsuario=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, tu.getTuNombre());
            pst.setInt(2, tu.getIdtipoUsuario());
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean eliminarTipoUsuario(TipoUsuario tu) {      
        sql = "DELETE FROM tipousuario WHERE idtipoUsuario=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setInt(1, tu.getIdtipoUsuario());
            pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
