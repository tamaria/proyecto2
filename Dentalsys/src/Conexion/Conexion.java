
package Conexion;

import Util.ManejoVentana;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Emilce Fernandez - Tanya Aquino
 */
public class Conexion {
    public Connection c = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    public boolean conectar(String usuario, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            String direccion = "jdbc:postgresql://localhost:5432/dentalsys";
            c = DriverManager.getConnection(direccion, usuario, password);
            stmt = (Statement) c.createStatement();
            return true;
        } catch (ClassNotFoundException e1) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e1); 
            JOptionPane.showMessageDialog(null, "Error en Drivers", "Conexion", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Error en la conexion", "Conexion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public static void main(String[] args) {
        Conexion x = new Conexion();
        boolean c = x.conectar("postgres", "1234");
        if (c) {
            System.out.println("Conectado");
        } else
            System.out.println("NO FUNCIONA!");
    }
    
}
