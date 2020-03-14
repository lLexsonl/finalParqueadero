package central.negocio;

/**
 *
 * @author yerson, breiner, adrian
 */
public class Cliente {
    
    private String idCliente;
    private String nombre;
    private String apellido;
    private String genero;
    private String fechaNacimiento;
    private String rol;
    
    /**
     * Constructor parametrizado
     *
     * @param id cedula
     * @param nombre los dos nombre
     * @param apellido los dos apellido
     * @param genero genero donde vive
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param rol Rol del cliente
     */
    public Cliente(String idCliente, String nombre, String apellido, String genero, String fechaNacimiento, String rol) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
       
    }

    public Cliente() {

    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
