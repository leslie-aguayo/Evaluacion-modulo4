
package dominio;


public class Cliente {
    private int idCliente;
    private int idVehiculo;
    private String rut;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private String direccion;
    private String comuna;
    
    public Cliente(){
        
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(int idVehiculo,String rut, String nombre, String apellido, String fechaNac, String direccion, String comuna) {
        this.idVehiculo = idVehiculo;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.comuna = comuna;
    }

    public Cliente(int idCliente, int idVehiculo, String rut, String nombre, String apellido, String fechaNac, String direccion, String comuna) {
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.comuna = comuna;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", direccion=" + direccion + ", comuna=" + comuna + '}';
    }

   
    
    
    
    
}
