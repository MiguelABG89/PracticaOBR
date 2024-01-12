package data;

import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {
    //CONSTANTES PARA REALIZAR LA BASE DE DATOS
    private static final String SERVER = "jdbc:oracle:thin:@//localhost:1523/oracleOBR";
    private static final String USER = "root";
    private static final String PASW = "admin";

    //CODIGO PARA CONECTAR
    static DataSource poolConexiones(){// Creamos el pool de conexiones como un DataSource que utilizara el resto de codigo
        String URL = SERVER;
        //en este caso usamos un OracleDataSource pero tambien seria posible usar un BasicDataSource por ejemplo en Apache
        OracleDataSource oracleDataSource = null;
        try {

            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(URL);
            oracleDataSource.setUser(USER);
            oracleDataSource.setPassword(PASW);
            oracleDataSource.setConnectionProperty("maxpoolsize","10");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        //pasamos el data source a quien pide la conexion
        return oracleDataSource;
    }
    //Metodo para realizar la conexion
    public static Connection conectar() throws SQLException{
        return poolConexiones().getConnection();
    }
}
