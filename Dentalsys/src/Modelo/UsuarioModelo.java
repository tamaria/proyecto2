package Modelo;

/**
 *
 * @author Emilce Fernandez - Tanya Aquino
 */
public class UsuarioModelo {
    
    private int codigo;
    private int rol_codigo;
    private String usuario;
    private String contrasenha;
    private int cedula;
    private String nombre;
    private String apellido;
    private short estado;
    private String email;

    public UsuarioModelo(int rol_codigo, String usuario, String contrasenha, int cedula, String nombre, String apellido, short estado, String email) {
        this.rol_codigo = rol_codigo;
        this.usuario = usuario;
        this.contrasenha = contrasenha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.email = email;
    }

    
    public UsuarioModelo(int codigo, int rol_codigo, String usuario, String contrasenha, int cedula, String nombre, String apellido, short estado, String email) {
        this.codigo = codigo;
        this.rol_codigo = rol_codigo;
        this.usuario = usuario;
        this.contrasenha = contrasenha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.email = email;
    }

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

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
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

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
