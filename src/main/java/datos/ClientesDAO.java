package datos;

import dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    private static final String SELECT = "SELECT id_cliente,id_vehiculo,rut,nombre,apellido,fecha_nac,direccion,comuna FROM Clientes";

    private static final String SELECTBYID = "SELECT id_cliente,id_vehiculo,rut,nombre,apellido,fecha_nac,direccion,comuna FROM Clientes WHERE id_cliente=?";

    private static final String INSERT = "INSERT INTO Clientes (id_vehiculo, rut,nombre,apellido,fecha_nac,direccion,comuna) VALUES (?,?,?,?,?,?,?)";

    private static final String UPDATE = "UPDATE Clientes SET id_vehiculo=?,rut=?,nombre=?,apellido=?,fecha_nac=?,direccion=?,comuna=? WHERE id_cliente=?";

    private static final String DELETE = "DELETE FROM Clientes WHERE id_cliente=?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> listadoClientes = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                int idVehiculo = rs.getInt("id_vehiculo");
                String rut = rs.getString("rut");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String fechaNac = rs.getString("fecha_nac");
                String direccion = rs.getString("direccion");
                String comuna = rs.getString("comuna");

                cliente = new Cliente(idCliente, idVehiculo, rut, nombre, apellido, fechaNac,
                        direccion, comuna);

                listadoClientes.add(cliente);

            }

        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listadoClientes;

    }

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECTBYID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();

            rs.absolute(1);

            int idVehiculo = rs.getInt("id_vehiculo");
            String rut = rs.getString("rut");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String fechaNac = rs.getString("fecha_nac");
            String direccion = rs.getString("direccion");
            String comuna = rs.getString("comuna");

            cliente.setIdVehiculo(idVehiculo);
            cliente.setRut(rut);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFechaNac(fechaNac);
            cliente.setDireccion(direccion);
            cliente.setComuna(comuna);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int row = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, cliente.getIdVehiculo());
            stmt.setString(2, cliente.getRut());
            stmt.setString(3, cliente.getNombre());
            stmt.setString(4, cliente.getApellido());
            stmt.setString(5, cliente.getFechaNac());
            stmt.setString(6, cliente.getDireccion());
            stmt.setString(7, cliente.getComuna());

            row = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error; " + ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return row;

    }

    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setInt(1, cliente.getIdVehiculo());
            stmt.setString(2, cliente.getRut());
            stmt.setString(3, cliente.getNombre());
            stmt.setString(4, cliente.getApellido());
            stmt.setString(5, cliente.getFechaNac());
            stmt.setString(6, cliente.getDireccion());
            stmt.setString(7, cliente.getComuna());

            row = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return row;
    }
public int eliminar (Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, cliente.getIdCliente());
            row = stmt.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Error: "+ex);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return row;
    }
    
}
