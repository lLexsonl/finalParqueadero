package parqueadero.acceso;

/**
 *
 * @author ahurtado
 */
public interface ICentral {

    public String obtenerClienteDeLaCentral(String id);
    public String obtenerVigilanteDeLaCentral(String id);
    public String obtenerClienteVehiculoDeLaCentral(String id);
    public String obtenerVehiculoDeLaCentral(String id);
    public void IngresarClienteEnLaCentral(String info);
    public void IngresarVehiculoEnLaCentral(String info);
    public void IngresarClienteVehiculoEnLaCentral(String info);
    public String obtenerClientesVehiculosDeLaCentral(String id);
    
}
