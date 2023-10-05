package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Producto;
import CapaDatos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarProducto() {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "PRESENTACION", "ID_CAT", "ID_MA", "ID_ME"};
        String[] registros = new String[11];
        tabla_temporal = new DefaultTableModel(null, titulos);

        sql = "SELECT pSerie,pDescripcion,pObservacion,digemi,pCondicion,catNombre,maNombre,mPresentacion,"
                + "c.idCategoria,m.idmarca,me.idmedida FROM producto AS p "
                + "INNER JOIN marca AS m ON p.idmarca=m.idmarca "
                + "INNER JOIN medida AS me ON p.idmedida=me.idmedida "
                + "INNER JOIN categoria AS c ON p.idCategoria=c.idCategoria LIMIT 0,20 ";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("pObservacion");
                registros[3] = rs.getString("digemi");
                registros[4] = rs.getString("pCondicion");
                registros[5] = rs.getString("catNombre");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("mPresentacion");
                registros[8] = rs.getString("idCategoria");
                registros[9] = rs.getString("idmarca");
                registros[10] = rs.getString("idmedida");

                tabla_temporal.addRow(registros);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar ProductoBD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }

    public boolean registrarProducto(Producto p) {
        boolean rpta = false;
        sql = "INSERT INTO producto(pSerie,pDescripcion,pObservacion,digemi,pCondicion,idCategoria,idmarca,idmedida) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p.getpSerie());
            pst.setString(2, p.getpDescripcion());
            pst.setString(3, p.getpObservacion());
            pst.setString(4, p.getDigemi());
            pst.setString(5, p.getpCondicion());
            pst.setInt(6, p.getIdCategoria());
            pst.setInt(7, p.getIdmarca());
            pst.setInt(8, p.getIdmedida());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas la registrar producto", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel buscarProducto(String serie) {
        DefaultTableModel tabla_temporal;

        String[] titulos = {"SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "PRESENTACION", "ID_CAT", "ID_MA", "ID_ME"};
        String[] registros = new String[11];

        tabla_temporal = new DefaultTableModel(null, titulos);

        sql = "SELECT pSerie,pDescripcion,pObservacion,digemi,pCondicion,catNombre,maNombre,mPresentacion,c.idCategoria,m.idmarca,me.idmedida FROM producto AS p "
                + "INNER JOIN marca AS m ON p.idmarca=m.idmarca "
                + "INNER JOIN medida AS me ON p.idmedida=me.idmedida "
                + "INNER JOIN categoria AS c ON p.idCategoria=c.idCategoria "
                + "WHERE pSerie=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serie);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("pObservacion");
                registros[3] = rs.getString("digemi");
                registros[4] = rs.getString("pCondicion");
                registros[5] = rs.getString("catNombre");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("mPresentacion");
                registros[8] = rs.getString("idCategoria");
                registros[9] = rs.getString("idmarca");
                registros[10] = rs.getString("idmedida");

                tabla_temporal.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "problemas al buscar productoBD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }

    public boolean modificarProducto(Producto p) {
        boolean rpta = false;
        sql = "UPDATE producto SET pDescripcion=?,pObservacion=?,digemi=?,pCondicion=?,idCategoria=?,idmarca=?,idmedida=? WHERE pSerie=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p.getpDescripcion());
            pst.setString(2, p.getpObservacion());
            pst.setString(3, p.getDigemi());
            pst.setString(4, p.getpCondicion());
            pst.setInt(5, p.getIdCategoria());
            pst.setInt(6, p.getIdmarca());
            pst.setInt(7, p.getIdmedida());
            pst.setString(8, p.getpSerie());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al modifocar productoBD ", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarProducto(String serie) {
        boolean rpta = false;
        sql = "DELETE FROM producto WHERE pSerie=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serie);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Problemas al eliminar",JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
    
    public DefaultTableModel BuscarProductoDescripcion(String descripcion) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "PRESENTACION", "ID_CAT", "ID_MA", "ID_ME"};
        String[] registros = new String[11];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT pSerie,pDescripcion,pObservacion,digemi,pCondicion,catNombre,maNombre,mPresentacion,c.idCategoria,m.idmarca,me.idmedida FROM producto AS p "
                + "INNER JOIN marca AS m ON p.idmarca=m.idmarca "
                + "INNER JOIN medida AS me ON p.idmedida=me.idmedida "
                + "INNER JOIN categoria AS c ON p.idCategoria=c.idCategoria "
                + "WHERE pDescripcion LIKE ? LIMIT 0,20";
        try {

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + descripcion + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("pObservacion");
                registros[3] = rs.getString("digemi");
                registros[4] = rs.getString("pCondicion");
                registros[5] = rs.getString("catNombre");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("mPresentacion");
                registros[8] = rs.getString("idCategoria");
                registros[9] = rs.getString("idmarca");
                registros[10] = rs.getString("idmedida");
                tabla_temporal.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar productoBD...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }
}
