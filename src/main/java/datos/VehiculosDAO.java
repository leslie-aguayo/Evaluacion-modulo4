package datos;

import dominio.Cliente;
import dominio.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculosDAO {

    private static final String SELECT = "SELECT id_vehiculo, tipo_vehiculo, marca, modelo, año, rev_tecnica FROM Vehiculos";

    private static final String SELECTBYID = "SELECT id_vehiculo, tipo_vehiculo, marca, modelo, año, rev_tecnica FROM Vehiculos WHERE id_vehiculo=?";

    private static final String INSERT = "INSERT INTO Vehiculos"
            + "(tipo_vehiculo,marca,modelo,año,rev_tecnica) "
            + "VALUES (?,?,?,?,?)";

    private static final String UPDATE = "UPDATE Vehiculos "
            + "SET tipo_vehiculo=?, marca=?, modelo=?,año=?,"
            + "rev_tecnica=? WHERE id_vehiculo=?";

    private static final String DELETE = "DELETE FROM Vehiculos "
            + "WHERE id_vehiculo=?";

    public List<Vehiculo> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vehiculo vehiculo = null;
        List<Vehiculo> listadoVehiculos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idVehiculo = rs.getInt("id_vehiculo");
                String tipoVehiculo = rs.getString("tipo_vehiculo");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int año = rs.getInt("año");
                int revTecnica = rs.getInt("rev_tecnica");

                vehiculo = new Vehiculo(idVehiculo, tipoVehiculo, marca,
                        modelo, año, revTecnica);

                listadoVehiculos.add(vehiculo);

            }

        } catch (SQLException ex) {
            System.out.println("error:" + ex);

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listadoVehiculos;

    }

    public Vehiculo encontrar(Vehiculo vehiculo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECTBYID);
            stmt.setInt(1, vehiculo.getIdVehiculo());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idVehiculo = rs.getInt("id_vehiculo");
                String tipoVehiculo = rs.getString("tipo_vehiculo");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int año = rs.getInt("año");
                int revTecnica = rs.getInt("rev_tecnica");

                vehiculo.setTipoVehiculo(tipoVehiculo);
                vehiculo.setMarca(marca);
                vehiculo.setModelo(modelo);
                vehiculo.setAño(año);
                vehiculo.setRevTecnica(revTecnica);
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return vehiculo;

    }

    public int insertar(Vehiculo vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        int row = 0;
        String idVehiculo = "";

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, vehiculo.getTipoVehiculo());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getAño());
            stmt.setInt(5, vehiculo.getRevTecnica());

            row = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error; " + ex);
        } finally {

            if (row > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    idVehiculo = rs.getString(1);
                }
            }

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return idVehiculo.equals("") ? 0 : Integer.parseInt(idVehiculo);
    }

    public int actualizar(Vehiculo vehiculo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, vehiculo.getTipoVehiculo());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setString(3, vehiculo.getModelo());
            stmt.setInt(4, vehiculo.getAño());
            stmt.setInt(5, vehiculo.getRevTecnica());
            stmt.setInt(6, vehiculo.getIdVehiculo());

            row = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return row;
    }

    public int eliminar(Vehiculo vehiculo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, vehiculo.getIdVehiculo());
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
