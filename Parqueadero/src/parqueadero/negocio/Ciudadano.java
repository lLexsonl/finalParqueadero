package parqueadero.negocio;

import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author libardo
 */
public class Ciudadano {

    private String cedula;
    private String nom;
    private String ape;
    private String direccion;
    private ArrayList<String> vehiculo;
    private String codigo;
    
    public Ciudadano() {
        this.cedula = null;
        this.nom = null;
        this.ape = null;
        this.direccion = null;
        this.vehiculo = null;
        this.codigo = null;
    }

    public Ciudadano(String cedula, String nombres, String apellidos, String direccion, ArrayList vehiculo, String email) {
        this.cedula = cedula;
        this.nom = nombres;
        this.ape = apellidos;
        this.direccion = direccion;
        this.vehiculo = vehiculo;
        this.codigo = email;
        
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String id) {
        this.cedula = id;
    }

    public String getNombres() {
        return nom;
    }

    public void setNombres(String nombres) {
        this.nom = nombres;
    }

    public String getApellidos() {
        return ape;
    }

    public void setApellidos(String apellidos) {
        this.ape = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<String> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(ArrayList<String> vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
