package parqueadero.acceso;

/**
 *
 * @author ahurtado, adrian
 */
public interface ICentral {

    public String obtenerClienteDeLaCentral(String id);
    public String obtenerVigilanteDeLaCentral(String id);
    public String obtenerClienteVehiculoDeLaCentral(String id);
    public String obtenerVehiculoDeLaCentral(String id);
    public String IngresarClienteEnLaCentral(String info);
    public String IngresarVehiculoEnLaCentral(String info);
    public String IngresarClienteVehiculoEnLaCentral(String info);
    public String obtenerClientesVehiculosDeLaCentral(String id);
    public String ingresarMulta(String sql);
    public void insertarIngreso(String info);
    public String buscarIngresosCentral();
    public String editarSalidaCentral(String info);
    public String buscarMultas(String info);
    public String insertarUsuario(String info);
    public String buscarReporteIngresos(String info);
    public String generarReporteHorasIngreso(String info);
}
