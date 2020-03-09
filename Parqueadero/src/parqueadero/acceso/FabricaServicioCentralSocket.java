package parqueadero.acceso;

/**
 *
 * @author ahurtado
 */
public class FabricaServicioCentralSocket extends IFabricaServicioCentral {

    @Override
    public ICentral crearServicioRegistraduria() {
        return new ServicioCentralSocket();
    }
    
}
