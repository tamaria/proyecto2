package Modelo;

/**
 *
 * @author Tanya Aquino - Emilce Fernández
 */
public class TipoTratamiento {
    
    private int codigo;
    private int codigo_especialidad;
    private String descripcion;
    private int costo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_especialidad() {
        return codigo_especialidad;
    }

    public void setCodigo_especialidad(int codigo_especialidad) {
        this.codigo_especialidad = codigo_especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
}
