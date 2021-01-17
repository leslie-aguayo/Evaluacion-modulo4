package datos;

import dominio.Cliente;
import dominio.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrabajadoresDAO {

    private static final String SELECT = "SELECT id_trabajador,nombre FROM trabajadores";

    private static final String SELECTBYID = "SELECT id_cliente,id_vehiculo,rut,nombre,apellido,fecha_nac,direccion,comuna FROM Clientes WHERE id_cliente=?";

    public List<Trabajador> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Trabajador trabajador = null;
        List<Trabajador> listadoTrabajadores = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idTrabajador = rs.getInt("id_trabajador");
                String nombre = rs.getString("nombre");

                trabajador = new Trabajador(idTrabajador, nombre);

                listadoTrabajadores.add(trabajador);

            }

        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listadoTrabajadores;

    }

    public Trabajador encontrar(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECTBYID);
            stmt.setInt(1, trabajador.getIdTrabajador());
            rs = stmt.executeQuery();

            rs.absolute(1);

            int idTrabajador = rs.getInt("id_trabajador");
            String nombre = rs.getString("nombre");

            
            trabajador.setNombre(nombre);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return trabajador;
    }

    
}
