package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionbd {

    
    private static final String URL =
            "jdbc:mysql://localhost:3306/tienda?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = ""; 
    public static Connection getConexion() {
        Connection conexion = null;

        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexión OK");

        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: No se encontró el driver de MySQL");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("ERROR: Fallo al conectar con la base de datos");
            e.printStackTrace();
        }

        return conexion;
    }
}
