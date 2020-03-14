package central.negocio;

/**
 *
 * @author Yerson
 */
public class ClienteVehiculoPost {
    private String id_cli;
    private String nombre_cli;
    private String apellido_cli;
    private String rol_cli;
    private String placa_vehi;
    private String marca_vehi;
    private String tipo_vehi;

    public ClienteVehiculoPost() {
    }

    public ClienteVehiculoPost(String id_cli, String nombre_cli, String apellido_cli, String rol_cli, String placa_vehi, String marca_vehi, String tipo_vehi) {
        this.id_cli = id_cli;
        this.nombre_cli = nombre_cli;
        this.apellido_cli = apellido_cli;
        this.rol_cli = rol_cli;
        this.placa_vehi = placa_vehi;
        this.marca_vehi = marca_vehi;
        this.tipo_vehi = tipo_vehi;
    }

    public String getId_cli() {
        return id_cli;
    }

    public void setId_cli(String id_cli) {
        this.id_cli = id_cli;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public void setNombre_cli(String nombre_cli) {
        this.nombre_cli = nombre_cli;
    }

    public String getApellido_cli() {
        return apellido_cli;
    }

    public void setApellido_cli(String apellido_cli) {
        this.apellido_cli = apellido_cli;
    }

    public String getRol_cli() {
        return rol_cli;
    }

    public void setRol_cli(String rol_cli) {
        this.rol_cli = rol_cli;
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
    
    public String toJson() {
        return String.format("{\"id_cliente\":\"%s\", \"nombre_cli\":\"%s\", \"apellido_cli\":\"%s\", \"rol_cli\":\"%s\", \"placa_vehi\":\"%s\", \"marca_vehi\":\"%s\", \"tipo_vehi\":\"%s\"}",
                id_cli, nombre_cli, apellido_cli,rol_cli ,placa_vehi, marca_vehi, tipo_vehi);
    }
}
