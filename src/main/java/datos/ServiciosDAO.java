package datos;

import dominio.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiciosDAO {

    private static final String SELECT = "SELECT id_servicio,tipo_servicio,precio FROM Servicios";

    private static final String SELECTBYID = "SELECT id_servicio,tipo_servicio,precio FROM Servicios WHERE id_servicio=?";

    private static final String INSERT = "INSERT INTO Servicios"
            + "(tipo_servicio,precio) "
            + "VALUES (?,?)";

    private static final String UPDATE = "UPDATE Servicios "
            + "SET tipo_servicio=?, precio=? WHERE id_servicio=?";

    private static final String DELETE = "DELETE FROM Servicios "
            + "WHERE id_servicio=?";

    public List<Servicio> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio servicio = null;
        List<Servicio> listadoServicios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idServicio = rs.getInt("id_servicio");
                int idVehiculo = rs.getInt("id_vehiculo");
                int precio = rs.getInt("precio");

                servicio = new Servicio(idServicio, idVehiculo, precio);

                listadoServicios.add(servicio);

            }

        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listadoServicios;
    }

    public Servicio encontrar(Servicio servicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECTBYID);
            stmt.setInt(1, servicio.getIdServicio());
            rs = stmt.executeQuery();

            rs.absolute(1);

            int idVehiculo = rs.getInt("id_vehiculo");
            int idServicio = rs.getInt("id_servicio");
            int precio = rs.getInt("precio");

            servicio.setIdVehiculo(idVehiculo);
            servicio.setIdServicio(idServicio);
            servicio.setPrecio(precio);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return servicio;
    }

    public int insertar(Servicio servicio) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int row = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, servicio.getIdVehiculo());
            stmt.setInt(2, servicio.getIdServicio());
            stmt.setInt(3, servicio.getPrecio());

            row = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error; " + ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return row;

    }

    public int actualizar(Servicio servicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, servicio.getIdVehiculo());
            stmt.setInt(2, servicio.getIdServicio());
            stmt.setInt(3, servicio.getPrecio());

            row = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return row;
    }

    public int eliminar(Servicio servicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, servicio.getIdServicio());
            row = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return row;
    }

}
