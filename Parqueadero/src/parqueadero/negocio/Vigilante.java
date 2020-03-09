/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.negocio;

/**
 *
 * @author Usuario
 */
public class Vigilante {
    private String numeroid;
    private String codigo;
    private String nombre;
    private String apellido;
    private String genero;
    private String fechadenacimiento;
    private String empresa;
    private String claveacceso;
    
    public Vigilante() {
    }

    public Vigilante(String numeroid, String codigo, String nombre, String apellidos, String genero, String fechadenacimiento, String empresa, String claveacceso) {
        this.numeroid = numeroid;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellidos;
        this.genero = genero;
        this.fechadenacimiento = fechadenacimiento;
        this.empresa = empresa;
        this.claveacceso = claveacceso;
    }

    public String getNumeroid() {
        return numeroid;
    }

    public void setNumeroid(String numeroid) {
        this.numeroid = numeroid;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(String fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getClaveacceso() {
        return claveacceso;
    }

    public void setClaveacceso(String claveacceso) {
        this.claveacceso = claveacceso;
    }
    
    
}
