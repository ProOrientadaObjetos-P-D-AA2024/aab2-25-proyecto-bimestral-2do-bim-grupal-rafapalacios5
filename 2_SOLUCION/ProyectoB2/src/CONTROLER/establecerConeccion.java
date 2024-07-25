
package CONTROLER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class establecerConeccion {
    private static Connection conn;

    public establecerConeccion() {
    }

    public static Connection connect() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:db2/dbTest.db");
                System.out.println("Conexión establecida.");
            } catch (SQLException e) {
                System.out.println("Error al conectar: " + e.getMessage());
            }
        }
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
    
}
