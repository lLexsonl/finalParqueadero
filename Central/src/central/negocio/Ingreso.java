package central.negocio;

/**
 *
 * @author Yerson
 */
public class Ingreso {
    private String placa;
    private String id;
    private String puesto;
    private String pingreso;
    private String fsalida;

    public Ingreso() {
    }
    
    public Ingreso(String placa, String id, String puesto, String pingreso, String fsalida) {
        this.placa = placa;
        this.id = id;
        this.puesto = puesto;
        this.pingreso = pingreso;
        this.fsalida = fsalida;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPingreso() {
        return pingreso;
    }

    public void setPingreso(String pingreso) {
        this.pingreso = pingreso;
    }

    public String getFsalida() {
        return fsalida;
    }

    public void setFsalida(String fsalida) {
        this.fsalida = fsalida;
    }
    
    @Override
    public String toString() {
        return String.format("{%s, %s, %s, %s, %s}", placa, id, puesto, pingreso, fsalida);
    }
}
