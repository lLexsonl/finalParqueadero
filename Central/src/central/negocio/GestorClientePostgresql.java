package central.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class GestorClientePostgresql {

    private central.negocio.Connection connector;

    public GestorClientePostgresql() {
        connector = ConectorPostgresql.getConector();
    }

    public ClientePost buscarClientePorId(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();

        connector.crearConsulta("SELECT * FROM cliente Where id_cli='" + id + "'");

        ClientePost cliente = null;
        if (connector.getResultado().next()) {
            cliente = new ClientePost(connector.getResultado().getString("id_cli"), 
                    connector.getResultado().getString("nombre_cli"),
                    connector.getResultado().getString("apellido_cli"),
                    connector.getResultado().getString("genero_cli"),
                    connector.getResultado().getString("fecha_nac_cli"),
                    connector.getResultado().getString("rol_cli"));
        }
        connector.desconectarse();
        return cliente;
    }

    public void agregarCliente(String idcliente, String nombre, String apellido, String genero, String fechanacimiento, String rol) throws ClassNotFoundException, SQLException {
        System.out.println(String.format("Insertar cliente: %s %s %s %s %s %s" , idcliente, nombre, apellido, genero, fechanacimiento, rol));
        connector.conectarse();
        connector.actualizar("INSERT INTO cliente"
                + " VALUES ("
                + "'" + idcliente + "',"
                + "'" + nombre + "',"
                + "'" + apellido + "',"
                + "'" + genero + "',"
                + "'" + fechanacimiento + "',"
                + "'" + rol + "'"
                + ")");
        connector.desconectarse();
    }

    public void agregarMulta(String id, String placa, String desc, String url, String fecha) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.actualizar("INSERT INTO MULTA"
                + " VALUES ("
                + "'" + id + "',"
                + "'" + placa + "',"
                + "'" + desc + "',"
                + "'" + url + "',"
                + "'" + fecha + "',"
                + "'DEBE'"
                + ")");
        //connector.actualizar(String.format("INSERT INTO MULTA VALUES(1, '%s', '%s', '%s', CURRENT_DATE, 'DEBE')", placa, desc, url));
        connector.desconectarse();
    }
    
    public UsuarioPost buscarVigilante(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.crearConsulta("SELECT * FROM usuario Where user_usu='" + id + "'");

        UsuarioPost usuario = null;
        if (connector.getResultado().next()) {
            usuario = new UsuarioPost(connector.getResultado().getString("id_cli"), connector.getResultado().getString("user_usu"), connector.getResultado().getString("pass_usu"));
        }
        connector.desconectarse();
        return usuario;
    }
    
    public List<ClienteVehiculoPost> buscarVehiculosCliente(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        
        connector.crearConsulta(String.format("select * from cliente c inner join clientevehiculo cv " +
            "on c.id_cli = cv.id_cli " +
            "inner join vehiculo v " +
            "on cv.placa_vehi = v.placa_vehi where c.id_cli = '%s'", id));
        
        List<ClienteVehiculoPost> list = new ArrayList<>();
        
        while(connector.getResultado().next()) {
            ClienteVehiculoPost cvp = new ClienteVehiculoPost(
                    connector.getResultado().getString("id_cli"),
                    connector.getResultado().getString("nombre_cli"),
                    connector.getResultado().getString("apellido_cli"),
                    connector.getResultado().getString("rol_cli"),
                    connector.getResultado().getString("placa_vehi"),
                    connector.getResultado().getString("marca_vehi"),
                    connector.getResultado().getString("tipo_vehi"));
            list.add(cvp);
        }
        connector.desconectarse();
        return list;
    }
    
    public void agregarIngreso(String placa, String id, String puesto, String fingreso) throws ClassNotFoundException, SQLException  {
        System.out.println(String.format("Insertar en ingreso postgresql: %s, %s ,%s ,%s", placa, id, puesto, fingreso));
        connector.conectarse();
        connector.actualizar("INSERT INTO ingreso"
                + " VALUES ("
                + "'" + placa + "',"
                + "'" + puesto + "',"
                + "'" + id + "',"
                + "'" + fingreso + "',"
                + "NULL"
                + ")");
        connector.desconectarse();
    }
    
    public List<Ingreso> buscarIngresos() throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.crearConsulta("Select * from ingreso where fechasalida is null");
        List<Ingreso> list = new ArrayList<>();
        
        while(connector.getResultado().next()) {
            Ingreso ing = new Ingreso(
                    connector.getResultado().getString("placa_vehi"),
                    connector.getResultado().getString("id_cli"),
                    connector.getResultado().getString("id_puesto"),
                    connector.getResultado().getString("fechaIngreso"),
                    connector.getResultado().getString("fechaSalida"));
            list.add(ing);
        }
        connector.desconectarse();
        return list;
    }
    
    public void editarSalida(String placa, String id, String puesto, String fingreso, String fsalida) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.actualizar(String.format("UPDATE INGRESO SET fechasalida='%s' WHERE placa_vehi='%s' and id_puesto = '%s' and id_cli = '%s' and fechaingreso = '%s'",
                fsalida, placa, puesto, id, fingreso) );
        connector.desconectarse();
    }
    
    public void insertarVehiculo(String placa, String marca, String tipo, String color) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.actualizar(String.format("INSERT INTO VEHICULO VALUES ('%s','%s','%s','%s')", placa, marca, tipo, color));
        connector.desconectarse();
    }
    
    public VehiculoPost buscarVehiculo(String placa) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.crearConsulta(String.format("SELECT * FROM VEHICULO WHERE PLACA_VEHI='%s'", placa));
        VehiculoPost vehi = null;
        if(connector.getResultado().next()) {
            vehi = new VehiculoPost(
                    connector.getResultado().getString("placa_vehi"),
                    connector.getResultado().getString("marca_vehi"),
                    connector.getResultado().getString("tipo_vehi"),
                    connector.getResultado().getString("color_vehi")
            );
        }
        connector.desconectarse();
        return vehi;
    }
    
    public void insertarClienteVehiculo(String id, String placa) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.actualizar(String.format("INSERT INTO CLIENTEVEHICULO VALUES ('%s','%s')", id, placa));
        connector.desconectarse();
    }
    
    public List<Multa> buscarMultas(String placa) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.crearConsulta(String.format("SELECT * FROM MULTA WHERE PLACA_VEHI='%s'", placa));
        
        List<Multa> list = new ArrayList<>();
        while(connector.getResultado().next()) {
            Multa multa = new Multa(
                    connector.getResultado().getString("nomulta"),
                    connector.getResultado().getString("placa_vehi"),
                    connector.getResultado().getString("descripcion_mul"),
                    connector.getResultado().getString("fotografia_mul"),
                    connector.getResultado().getString("fecha_mul"),
                    connector.getResultado().getString("estado_mul")
            );
            list.add(multa);
        }
        connector.desconectarse();
        return list;
    }
    
    public void insertarUsuario(String id, String user, String pass) throws ClassNotFoundException, SQLException {
        System.out.println("insertar usario: " + id + user + pass);
        connector.conectarse();
        connector.actualizar(String.format("INSERT INTO USUARIO VALUES ('%s','%s','%s')", id, user, pass));
        connector.desconectarse();
    }
    
    public List<ReporteIngreso> buscarReporteIngresos(String placa) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        
        connector.crearConsulta(String.format("select extract(dow from fechaingreso) as fechaingreso, count(*) as cant from ingreso\n" +
                                                "where fechaingreso > current_date - 7 and placa_vehi = '%s'\n" +
                                                "group by extract(dow from fechaingreso) order by extract(dow from fechaingreso);", placa));
        
        List<ReporteIngreso> list = new ArrayList<>();
        
        while(connector.getResultado().next()) {
            ReporteIngreso reporte = new ReporteIngreso(
                    connector.getResultado().getString("fechaingreso"),
                    connector.getResultado().getString("cant"));
            list.add(reporte);
        }
        connector.desconectarse();
        return list;
    }
    
    public List<ReporteIngreso> generarReporteHorasIngreso() throws ClassNotFoundException, SQLException {
        connector.conectarse();
        
        connector.crearConsulta(String.format("select extract(hour from fechaingreso) as fechaingreso, count(*) cant from ingreso\n" +
"group by extract(hour from fechaingreso)\n" +
"order by extract(hour from fechaingreso);"));
        
        List<ReporteIngreso> list = new ArrayList<>();
        
        while(connector.getResultado().next()) {
            ReporteIngreso reporte = new ReporteIngreso(
                    connector.getResultado().getString("fechaingreso"),
                    connector.getResultado().getString("cant"));
            list.add(reporte);
        }
        connector.desconectarse();
        return list;
    }
}
