package central.negocio;

/**
 *
 * @author Yerson
 */
public class UsuarioPost {
    private String id_cli;
    private String user_usu;
    private String pass_usu;

    public UsuarioPost(String id_cli, String user_usu, String pass_usu) {
        this.id_cli = id_cli;
        this.user_usu = user_usu;
        this.pass_usu = pass_usu;
    }
    
    public UsuarioPost(){this("","","");}
    
    public String getId_cli() {
        return id_cli;
    }

    public void setId_cli(String id_cli) {
        this.id_cli = id_cli;
    }

    public String getUser_usu() {
        return user_usu;
    }

    public void setUser_usu(String user_usu) {
        this.user_usu = user_usu;
    }

    public String getPass_usu() {
        return pass_usu;
    }

    public void setPass_usu(String pass_usu) {
        this.pass_usu = pass_usu;
    }
    
    public String toJson() {
        return String.format("{\"id_cliente\":\"%s\", \"user_usu\":\"%s\", \"pass_usu\":\"%s\"}",
                id_cli, user_usu, pass_usu);
    }
    
}
