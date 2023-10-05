package CapaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    private static String clase = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/farmacia?serverTimezone=UTC";
    private static String usuario = "root";
    private static String clave = "1234";

    public Connection conectar() {

        Connection link = null;
        try {

            Class.forName(clase);
            link = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }

}
