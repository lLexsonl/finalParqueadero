package central.negocio;

/**
 *
 * @author Yerson
 */
public class ReporteIngreso {
    private String fechaIngreso;
    private String cantidad;

    public ReporteIngreso() {
    }

    public ReporteIngreso(String fechaIngreso, String cantidad) {
        this.fechaIngreso = fechaIngreso;
        this.cantidad = cantidad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
