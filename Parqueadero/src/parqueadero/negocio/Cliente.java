package parqueadero.negocio;



/**
 *
 * @author Libardo, Ricardo, Julio Representa un cliente de la agencia de viajes
 * con sus atributos
 *
 */
public class Cliente {

    
    
    private String idCliente;
    private String nombre;
    private String apellido;
    private String genero;
    private String fechaNacimiento;
    private String rol;
    
    /**
     * 
     * @param idCliente
     * @param nombre
     * @param apellido
     * @param genero
     * @param fechaNacimiento
     * @param sexo 
     */
    public Cliente(String idCliente, String nombre, String apellido, String genero, String fechaNacimiento, String sexo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = sexo;
       
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
