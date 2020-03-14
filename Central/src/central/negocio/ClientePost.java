package central.negocio;

/**
 *
 * @author Yerson
 */
public class ClientePost {
   
    private String id_cli;
    private String nombre_cli;
    private String apellido_cli;
    private String genero_cli;
    private String fecha_nac_cli;
    private String rol_cli;
    
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
    public ClientePost(String idCliente, String nombre, String apellido, String genero, String fechaNacimiento, String rol) {
        this.id_cli = idCliente;
        this.nombre_cli = nombre;
        this.apellido_cli = apellido;
        this.genero_cli = genero;
        this.fecha_nac_cli = fechaNacimiento;
        this.rol_cli = rol;
       
    }

    public ClientePost() {

    }

    public String getIdCliente() {
        return id_cli;
    }

    public void setIdCliente(String idCliente) {
        this.id_cli = idCliente;
    }

    public String getNombre() {
        return nombre_cli;
    }

    public void setNombre(String nombre) {
        this.nombre_cli = nombre;
    }

    public String getApellido() {
        return apellido_cli;
    }

    public void setApellido(String apellido) {
        this.apellido_cli = apellido;
    }

    public String getGenero() {
        return genero_cli;
    }

    public void setGenero(String genero) {
        this.genero_cli = genero;
    }

    public String getFechaNacimiento() {
        return fecha_nac_cli;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fecha_nac_cli = fechaNacimiento;
    }

    public String getRol() {
        return rol_cli;
    }

    public void setRol(String rol) {
        this.rol_cli = rol;
    } 
    
    public String toJson() {
        return String.format("{\"id_cliente\":\"%s\", \"nombre_cli\":\"%s\", \"apellido_cli\":\"%s\", \"genero_cli\":\"%s\",\"fecha_nac_cli\":\"%s\", \"rol_cli\":\"%s\"}",
                id_cli, nombre_cli, apellido_cli, genero_cli, fecha_nac_cli, rol_cli);
    }
}
