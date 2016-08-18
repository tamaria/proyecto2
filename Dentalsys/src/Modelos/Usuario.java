package Modelos;

/**
 *
 * @author Tanya Aquino - Emilce Fernández
 */
public class Usuario {
    
   private int codigo;
   private int rol_codigo;
   private String usuario;
   private String password;
   private int cedula;
   private String nombre;
   private String apellido;
   private int estado;
   private String mail;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getRol_codigo() {
        return rol_codigo;
    }

    public void setRol_codigo(int rol_codigo) {
        this.rol_codigo = rol_codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
   
}
