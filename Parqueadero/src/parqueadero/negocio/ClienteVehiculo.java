package parqueadero.negocio;

/**
 *
 * @author Usuario
 */
public class ClienteVehiculo {
    
    private String idCliente;
    private String nombre;
    private String apellido;
    private String genero;
    private String fechaNacimiento;
    private String idvehiculo;
    private String nodeplaca;
    private String marca;
    private String tipoVehiculo;

    public ClienteVehiculo() {
    }

    public ClienteVehiculo(String idCliente, String nombre, String apellido, String genero, String fechaNacimiento, String idvehiculo, String nodeplaca, String marca, String tipo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;  
        this.idvehiculo = idvehiculo;
        this.nodeplaca = nodeplaca;
        this.marca = marca;
        this.tipoVehiculo = tipo;
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

    public String getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(String idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getNodeplaca() {
        return nodeplaca;
    }

    public void setNodeplaca(String nodeplaca) {
        this.nodeplaca = nodeplaca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    

    @Override
    public String toString() {
        return "ClienteVehiculo{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + ", idvehiculo=" + idvehiculo + ", nodeplaca=" + nodeplaca + ", marca=" + marca + ", tipoVehiculo=" + tipoVehiculo + '}';
    }
    
    //TODO: CAMBIAR CENTRAL CLIENTEVEHICULO
    
}

