/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central.negocio;

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
