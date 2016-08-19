package Modelo;

/**
 *
 * @author Emilce Fernandez - Tanya Aquino
 */
public class RolModelo {
    
    private int codigo;
    private String descripcion;

    public RolModelo(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
