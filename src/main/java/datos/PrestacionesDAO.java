package datos;

import dominio.Cliente;
import dominio.Prestacion;
import dominio.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestacionesDAO {

    private static final String SELECT = "SELECT id_prestacion,id_cliente,id_trabajador,servicios,precio FROM prestacion_servicios";

    private static final String SELECTBYID = "SELECT id_prestacion,id_cliente,id_trabajador,servicios,precio FROM prestacion_servicios WHERE id_prestacion=?";

    private static final String INSERT = "INSERT INTO prestacion_servicios (id_cliente,id_trabajador,servicios,precio) VALUES (?,?,?,?)";

    public List<Prestacion> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Prestacion prestacion = null;
        List<Prestacion> listadoPrestaciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPrestacion = rs.getInt("id_prestacion");
                int idCliente = rs.getInt("id_cliente");
                int idTrabajador = rs.getInt("id_trabajador");
                String servicios = rs.getString("servicios");
                int precio = rs.getInt("precio");

                prestacion = new Prestacion(idPrestacion, idCliente, idTrabajador, servicios, precio);

                listadoPrestaciones.add(prestacion);

            }

        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listadoPrestaciones;

    }

    public Prestacion encontrar(Prestacion prestacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECTBYID);
            stmt.setInt(1, prestacion.getIdPrestacion());
            rs = stmt.executeQuery();

            rs.absolute(1);

            int idCliente = rs.getInt("id_cliente");
            int idTrabajador = rs.getInt("id_trabajador");
            String servicios = rs.getString("servicios");
            int precio = rs.getInt("precio");

        
            prestacion.setIdCliente(idCliente);
            prestacion.setIdTrabajador(idTrabajador);
            prestacion.setServicios(servicios);
            prestacion.setPrecio(precio);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return prestacion;
    }

    public int insertar(Prestacion prestacion) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int row = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, prestacion.getIdCliente());
            stmt.setInt(2, prestacion.getIdTrabajador());
            stmt.setString(3, prestacion.getServicios());
            stmt.setInt(4, prestacion.getPrecio());
            row = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error; " + ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return row;

    }
}
