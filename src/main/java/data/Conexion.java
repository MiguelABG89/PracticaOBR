package data;

import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {

    // CONSTANTES PARA REALIZAR LA CONEXIÓN A LA BASE DE DATOS
    private static final String SERVER = "jdbc:oracle:thin:@//localhost:1523/oracleOBR";
    private static final String USER = "root";
    private static final String PASW = "admin";

    // CÓDIGO PARA CREAR EL POOL DE CONEXIONES
    static DataSource poolConexiones() {
        String URL = SERVER;
        // En este caso, utilizamos un OracleDataSource, pero también sería posible usar un BasicDataSource, por ejemplo, en Apache
        OracleDataSource oracleDataSource = null;
        try {
            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(URL);
            oracleDataSource.setUser(USER);
            oracleDataSource.setPassword(PASW);
            oracleDataSource.setConnectionProperty("maxpoolsize", "10");
        } catch (SQLException e) {
            // Capturar excepciones SQL y lanzar una RuntimeException
            throw new RuntimeException(e);
        }
        // Pasamos el DataSource a quien solicita la conexión
        return oracleDataSource;
    }

    // Método para realizar la conexión a la base de datos
    public static Connection conectar() throws SQLException {
        return poolConexiones().getConnection();
    }
}
