package central.negocio;

/**
 *
 * @author Yerson
 */
public class Multa {
    private String nomulta;
    private String placa_vehi;
    private String descripcion_mul;
    private String fotografia_mul;
    private String fecha_mul;
    private String estado_mul;

    public Multa() {
    }

    public Multa(String nomulta, String placa_vehi, String descripcion_mul, String fotografia_mul, String fecha_mul, String estado_mul) {
        this.nomulta = nomulta;
        this.placa_vehi = placa_vehi;
        this.descripcion_mul = descripcion_mul;
        this.fotografia_mul = fotografia_mul;
        this.fecha_mul = fecha_mul;
        this.estado_mul = estado_mul;
    }

    public String getNomulta() {
        return nomulta;
    }

    public void setNomulta(String nomulta) {
        this.nomulta = nomulta;
    }

    public String getPlaca_vehi() {
        return placa_vehi;
    }

    public void setPlaca_vehi(String placa_vehi) {
        this.placa_vehi = placa_vehi;
    }

    public String getDescripcion_mul() {
        return descripcion_mul;
    }

    public void setDescripcion_mul(String descripcion_mul) {
        this.descripcion_mul = descripcion_mul;
    }

    public String getFotografia_mul() {
        return fotografia_mul;
    }

    public void setFotografia_mul(String fotografia_mul) {
        this.fotografia_mul = fotografia_mul;
    }

    public String getFecha_mul() {
        return fecha_mul;
    }

    public void setFecha_mul(String fecha_mul) {
        this.fecha_mul = fecha_mul;
    }

    public String getEstado_mul() {
        return estado_mul;
    }

    public void setEstado_mul(String estado_mul) {
        this.estado_mul = estado_mul;
    }
    
    public String toJson() {
        return String.format("{\"nomulta\":\"%s\", \"placa_vehi\":\"%s\", \"descripcion_mul\":\"%s\", \"fotografia_mul\":\"%s\", \"fecha_mul\":\"%s\", \"estado_mul\":\"%s\"}",
                nomulta, placa_vehi, descripcion_mul, fotografia_mul, fecha_mul, estado_mul);
    }
}
