package Controlador;

import Conexion.Conexion;
import Modelo.RolModelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emilce Fernandez - Tanya Aquino
 */
public class RolControlador {
    
    Conexion conexion = new Conexion();
    private boolean cc;
    
    public RolControlador(String usuario, String password){
        cc = conexion.conectar(usuario, password);
    }
    
    public boolean insertar(RolModelo rol){
        try {
            PreparedStatement st = conexion.c.prepareStatement("INSERT INTO rol (descripcion) VALUES ('"  
                    +rol.getDescripcion()+ "');");
            st.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(RolControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public ResultSet selectByDescripcion(String descripcion) {
        try {
            Statement st = conexion.c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM rol WHERE descripcion = '"
                    + descripcion + "';");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(RolControlador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet selectByCodigo(String codigo) {
        try {
            Statement st = conexion.c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM rol WHERE codigo = '"
                    + codigo + "';");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(RolControlador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet select() {
        try {
            Statement st = conexion.c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM rol;");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(RolControlador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
