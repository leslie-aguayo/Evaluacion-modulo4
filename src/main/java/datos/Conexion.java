package datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/los_eren2021";
    private static final String USER = "root";
    private static final String PASSWORD = "Hakreload001";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;

    }

    /**
     *
     * @param rs
     */
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("No se pueden recuperar las filas" + ex);
        }
    }

    /**
     *
     * @param stmt
     */
    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("No se pueden ejecutar: " + ex);
        }
    }

    /**
     *
     * @param conn
     */
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("No se pueden ejecutar: " + ex);
        }
    }

}
