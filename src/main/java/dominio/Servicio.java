package dominio;

public class Servicio {

    private int idServicio;
    private String tipoServicio;
    private int precio;

    public Servicio() {
    }

    public Servicio(int idServicio) {
        this.idServicio = idServicio;
    }
    
    public Servicio(String tipoServicio, int precio) {
        this.tipoServicio = tipoServicio;
        this.precio = precio;
    }

    public Servicio(int idServicio, String tipoServicio, int precio) {
        this.idServicio = idServicio;
        this.tipoServicio = tipoServicio;
        this.precio = precio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", tipoServicio=" + tipoServicio + ", precio=" + precio + '}';
    }
}