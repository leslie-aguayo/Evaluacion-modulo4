
package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/los_eren2021?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER ="root";
    private static final String PASSWORD ="";
    
    public static DataSource getDataSource(){
    BasicDataSource ds = new BasicDataSource();
    ds.setUrl(URL);
    ds.setUsername(USER);
    ds.setPassword(PASSWORD);
    ds.setInitialSize(30);
    return ds;
    }
    
    public static Connection getConnection() throws SQLException{
      return getDataSource().getConnection();
  }  

    /**
     * 
     * @param rs 
     */
    public static void close(ResultSet rs){
        try{
        rs.close();
        }catch(SQLException ex){
            System.out.println("No se pueden recuperar las filas"+ex);
        }
    }
    
    /**
     * 
     * @param stmt 
     */
    public static void close(PreparedStatement stmt){
     try{
        stmt.close();
        }catch(SQLException ex){
            System.out.println("No se pueden ejecutar: "+ex);
        }
    }
    
    /**
     * 
     * @param conn 
     */
    public static void close(Connection conn){
     try{
        conn.close();
        }catch(SQLException ex){
            System.out.println("No se pueden ejecutar: "+ex);
        }
    }
    
    
}

