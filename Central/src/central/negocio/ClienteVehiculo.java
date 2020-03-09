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
public class ClienteVehiculo {
    
    private String idCliente;
    private String nombre;
    private String apellido;
    private String genero;
    private String fechaNacimiento;
    private String rol;
    private String idvehiculo;
    private String nodeplaca;
    private String marca;
    private String tipo;

    public ClienteVehiculo(String idCliente, String nombre, String apellido, String genero, String fechaNacimiento, String rol, String idvehiculo, String nodeplaca, String marca, String tipo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
        this.idvehiculo = idvehiculo;
        this.nodeplaca = nodeplaca;
        this.marca = marca;
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "ClienteVehiculo{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + ", rol=" + rol + ", idvehiculo=" + idvehiculo + ", nodeplaca=" + nodeplaca + ", marca=" + marca + ", tipo=" + tipo + '}';
    }
    
    
}
