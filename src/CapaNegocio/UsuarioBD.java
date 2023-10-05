package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarUsuario() {
        DefaultTableModel tablaTemporal;
        String[] titulos = {"DNI", "NOMBRES ", "APELLIDOS", "DIRECCION", "CLAVE", "CELULAR", "TIPO USUARIO", "TIENDA"};
        String[] registros = new String[8];
        tablaTemporal = new DefaultTableModel(null, titulos);
        sql = "SELECT  uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda FROM usuario AS u "
                + "INNER JOIN tipousuario AS  tp ON u.idtipousuario=tp.idtipousuario ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uClave");
                registros[5] = rs.getString("uCelular");
                registros[6] = rs.getString("tuNombre");
                registros[7] = rs.getString("tienda");

                tablaTemporal.addRow(registros);
            }
            return tablaTemporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar U suario BD...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public boolean registrarUsuario(Usuario u) {
        boolean rpta = false;
        sql = "INSERT INTO usuario (uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,idtipousuario,tienda) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, u.getuDni());
            pst.setString(2, u.getuNombre());
            pst.setString(3, u.getuApellidos());
            pst.setString(4, u.getuDireccion());
            pst.setString(5, u.getuClave());
            pst.setString(6, u.getuCelular());
            pst.setInt(7, u.getIdtipousuario());
            pst.setString(8, u.getTienda());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean modificarUsuario(Usuario u) {
        boolean rpta = false;
        sql = "UPDATE usuario SET uNombre=?,uApellidos=?,uDireccion=?,uClave=?,uCelular=?,idtipousuario=?,tienda=? WHERE uDni=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, u.getuNombre());
            pst.setString(2, u.getuApellidos());
            pst.setString(3, u.getuDireccion());
            pst.setString(4, u.getuClave());
            pst.setString(5, u.getuCelular());
            pst.setInt(6, u.getIdtipousuario());
            pst.setString(7, u.getTienda());
            pst.setString(8, u.getuDni());
            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarUsuario(String dni) {
        boolean rpta = false;

        try {
            sql = "DELETE FROM usuario WHERE  uDni=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dni);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar un usuario BD..", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;

    }

    public DefaultTableModel buscarUsuarioXDni(String dni) {
        DefaultTableModel tabla_Temporal;
        String[] titulos = {"DNI", "NOMBRES", "APELLIDO", "DIRECCION", "CLAVE", "CELULAR", "TIPO USUARIO", "TIENDA"};
        String[] registros = new String[8];
        tabla_Temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda FROM usuario AS u "
                + "INNER JOIN tipousuario AS tp ON u.idtipousuario=tp.idtipousuario "
                + "WHERE uDni=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dni);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uClave");
                registros[5] = rs.getString("uCelular");
                registros[6] = rs.getString("tuNombre");
                registros[7] = rs.getString("tienda");

                tabla_Temporal.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar usuario BD...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_Temporal;
    }

    public DefaultTableModel BuscaeUsuario(String apellidos) {
        DefaultTableModel tabla_Temporal;
        String[] titulos = {"DNI", "NOMBRES", "APELLIDOS", "DIRECCION", "CLAVE", "CELULAR", "TIPO USUARIO", "TIRNDA"};
        String[] registros = new String[8];
        tabla_Temporal = new DefaultTableModel(null, titulos);

        sql = "select uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda from usuario as u "
                + "inner join tipousuario as tp on u.idtipousuario=tp.idtipousuario "
                + "where uApellidos like ? or uNombre like ? limit 0,15";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + apellidos + "%");
            pst.setString(2, "%" + apellidos + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uClave");
                registros[5] = rs.getString("uCelular");
                registros[6] = rs.getString("tuNombre");
                registros[7] = rs.getString("tienda");

                tabla_Temporal.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar usuario BD..", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_Temporal;

    }

    public List<Usuario> login(String dni, String clave) {
        List<Usuario> lista = new ArrayList<>();
        sql = "SELECT uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,idtipousuario,tienda FROM usuario "
                + "WHERE uDni=? AND uClave=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dni);
            pst.setString(2, clave);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Usuario oUsuario = new Usuario();
                oUsuario.setuDni(rs.getString(1));
                oUsuario.setuNombre(rs.getString(2));
                oUsuario.setuApellidos(rs.getString(3));
                oUsuario.setuDireccion(rs.getString(4));
                oUsuario.setuClave(rs.getString(5));
                oUsuario.setuCelular(rs.getString(6));
                oUsuario.setIdtipousuario(rs.getInt(7));
                oUsuario.setTienda(rs.getString(8));
                
                lista.add(oUsuario);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al login");
        }
        return lista;
    }

}
