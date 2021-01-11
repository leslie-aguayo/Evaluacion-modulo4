
package dominio;

public class Servicio {
    
    private int idVehiculo;
    private int idServicio;
    private int precio;

    public Servicio() {
    }

    public Servicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio(int idVehiculo, int precio) {
        this.idVehiculo = idVehiculo;
        this.precio = precio;
    }

    public Servicio(int idVehiculo, int idServicio, int precio) {
        this.idVehiculo = idVehiculo;
        this.idServicio = idServicio;
        this.precio = precio;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Servicio{" + "idVehiculo=" + idVehiculo + ", idServicio=" + idServicio + ", precio=" + precio + '}';
    }
    
    
    
    
}
