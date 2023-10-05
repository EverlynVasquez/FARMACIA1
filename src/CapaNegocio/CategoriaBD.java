package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Categoria;
import com.mysql.cj.conf.PropertyKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Categoria> reportarCategoria() {
        List<Categoria> lista = new ArrayList<>();
        sql = "SELECT idCategoria,catNombre FROM categoria";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Categoria oCategoria = new Categoria();
                oCategoria.setIdCategoria(rs.getInt(1));
                oCategoria.setCatNombre(rs.getString(2));

                lista.add(oCategoria);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar categoria BD...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }

    public boolean registrarCategoria(Categoria c) {
        boolean rpta = false;
        sql = "INSERT INTO categoria(idCategoria,catNombre) VALUES (0,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, c.getCatNombre());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas la registrar categoriaBD..", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean modificarCategoria(Categoria c) {
        boolean rpta = false;
        sql = "UPDATE categoria SET catNombre=? WHERE idCategoria=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, c.getCatNombre());
            pst.setInt(2, c.getIdCategoria());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al modificar categoria BD...", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarCategoria(Categoria c) {
        boolean rpta = false;
        sql = "DELETE FROM categoria WHERE idCategoria=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, c.getIdCategoria());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar categoria BD..", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public List<Categoria> buscarCategoria(String valor) {
        List<Categoria> lista = new ArrayList<>();
        sql = "SELECT idCategoria,catNombre FROM categoria WHERE catNombre LIKE ?";
        try {
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, "%" + valor+"%");
            
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {                
                Categoria oCategoria=new Categoria();
                oCategoria.setIdCategoria(rs.getInt(1));
                oCategoria.setCatNombre(rs.getString(2));
                
                lista.add(oCategoria);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Error al buscar actegoriaBD...",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }

}
