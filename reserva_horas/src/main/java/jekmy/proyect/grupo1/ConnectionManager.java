package jekmy.proyect.grupo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection = null;

    public static Connection obtenerConexion() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection ("jdbc:postgresql://forgedb.netbyteoss.com:5443/forge_alumnos", "jquiroga", "Q19.21");
        return connection;

    }
}
