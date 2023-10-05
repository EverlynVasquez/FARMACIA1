package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Composicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ComposicionBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Composicion> reportarComposicion() {

        List<Composicion> lista = new ArrayList<>();
        sql = "SELECT idComposicion,coNombre,pSerie FROM composicion ORDER BY idComposicion ASC";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Composicion oComposicion = new Composicion();
                oComposicion.setIdComposicion(rs.getInt(1));
                oComposicion.setCoNombre(rs.getString(2));
                oComposicion.setpSerie(rs.getString(3));

                lista.add(oComposicion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar composicion", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    public boolean registrarComposicion(Composicion cp) {
        boolean rpta = false;
        sql = "INSERT INTO composicion(idComposicion,coNombre,pSerie) VALUES (0,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cp.getCoNombre());
            pst.setString(2, cp.getpSerie());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e, "Problemas al registrar composicion", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarComposicion(int idcomposicion) {
        boolean rpta = false;
        sql = "DELETE FROM composicion WHERE idComposicion=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcomposicion);

            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return rpta;
        }
        return rpta;
    }
}
