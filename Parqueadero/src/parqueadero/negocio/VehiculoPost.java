package parqueadero.negocio;

/**
 *
 * @author Yerson
 */
public class VehiculoPost {
    private String placa_vehi;
    private String marca_vehi;
    private String tipo_vehi;
    private String color_vehi;

    public VehiculoPost() {
    }

    public VehiculoPost(String placa_vehi, String marca_vehi, String tipo_vehi, String color_vehi) {
        this.placa_vehi = placa_vehi;
        this.marca_vehi = marca_vehi;
        this.tipo_vehi = tipo_vehi;
        this.color_vehi = color_vehi;
    }

    public String getPlaca_vehi() {
        return placa_vehi;
    }

    public void setPlaca_vehi(String placa_vehi) {
        this.placa_vehi = placa_vehi;
    }

    public String getMarca_vehi() {
        return marca_vehi;
    }

    public void setMarca_vehi(String marca_vehi) {
        this.marca_vehi = marca_vehi;
    }

    public String getTipo_vehi() {
        return tipo_vehi;
    }

    public void setTipo_vehi(String tipo_vehi) {
        this.tipo_vehi = tipo_vehi;
    }

    public String getColor_vehi() {
        return color_vehi;
    }

    public void setColor_vehi(String color_vehi) {
        this.color_vehi = color_vehi;
    }
    
    public String toJson() {
        return String.format("{\"placa_vehi\":\"%s\", \"marca_vehi\":\"%s\", \"tipo_vehi\":\"%s\", \"color_vehi\":\"%s\"}",
                placa_vehi, marca_vehi, tipo_vehi, color_vehi);
    }
}
