
package datos;


public class VehiculoDAO {
    
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
    
}
