package Controlador;

import Conexion.Conexion;
import Modelo.UsuarioModelo;
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
public class UsuarioControlador {
    
    Conexion conexion = new Conexion();
    private boolean cc;
    
    public UsuarioControlador(String usuario, String password) {
        cc = conexion.conectar(usuario, password);
    }
    
    public boolean insertar(UsuarioModelo usuario) {
        try {
            PreparedStatement st = conexion.c.prepareStatement("INSERT INTO usuario("
                    + "rol_codigo, "
                    + "usuario, "
                    + "contrasenha, "
                    + "cedula, "
                    + "nombre, "
                    + "apellido, "
                    + "estado, "
                    + "email) "
                        + "VALUES ("
                    + usuario.getRol_codigo() +", "
                    + "'" + usuario.getUsuario() + "', "
                    + "'" + usuario.getContrasenha() + "', "
                    + usuario.getCedula() + ", "
                    + "'" + usuario.getNombre() + "', "
                    + "'" + usuario.getApellido() + "', "
                    + usuario.getEstado() + ", "
                    + "'" + usuario.getEmail() + "');");
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ResultSet selectByCodigo(String codigo) {
        try {
            Statement st = conexion.c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE codigo = "
                    + codigo +";");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(RolControlador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean actualizar(UsuarioModelo usuario) {
        try {
            PreparedStatement st = conexion.c.prepareStatement("UPDATE usuario SET "
                    + "rol_codigo = " + usuario.getRol_codigo()
                    + ", usuario = '" + usuario.getUsuario()
                    + "', contrasenha = '" + usuario.getContrasenha()
                    + "', cedula = " + usuario.getCedula()
                    + ", nombre = '" + usuario.getNombre()
                    + "', apellido = '" + usuario.getApellido()
                    + "', estado = " + usuario.getEstado()
                    + ", email = '" + usuario.getEmail()
                        + "' WHERE codigo = " + usuario.getCodigo() + ";");
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean eliminar(UsuarioModelo usuario) {
        try {
            PreparedStatement st = conexion.c.prepareStatement("DELETE FROM usuario WHERE codigo = "
                    + usuario.getCodigo()+ ";");
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
