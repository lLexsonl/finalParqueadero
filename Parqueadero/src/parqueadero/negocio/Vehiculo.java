package parqueadero.negocio;

/**
 *
 * @author Usuario
 */
public class Vehiculo {
    
    private String idvehiculo;
    private String nodeplaca;
    private String marca;
    private String tipo;

    public Vehiculo(String idvehiculo, String nodeplaca, String marca, String tipo) {
        this.idvehiculo = idvehiculo;
        this.nodeplaca = nodeplaca;
        this.marca = marca;
        this.tipo = tipo;
    }

    Vehiculo() {
        
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
