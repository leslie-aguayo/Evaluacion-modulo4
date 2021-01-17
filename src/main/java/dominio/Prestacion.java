
package dominio;


public class Prestacion {
    private int idPrestacion;
    private int idCliente;
    private int idTrabajador;
    private String servicios;
    private int precio;
    
    public Prestacion(){
        
    }
    
    public Prestacion(int idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    public Prestacion(int idCliente, int idTrabajador, String servicios, int precio) {
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.servicios = servicios;
        this.precio = precio;
    }

    public Prestacion(int idPrestacion, int idCliente, int idTrabajador, String servicios, int precio) {
        this.idPrestacion = idPrestacion;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.servicios = servicios;
        this.precio = precio;
    }

    /**
     * @return the idPrestacion
     */
    public int getIdPrestacion() {
        return idPrestacion;
    }

    /**
     * @param idPrestacion the idPrestacion to set
     */
    public void setIdPrestacion(int idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idTrabajador
     */
    public int getIdTrabajador() {
        return idTrabajador;
    }

    /**
     * @param idTrabajador the idTrabajador to set
     */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    /**
     * @return the servicios
     */
    public String getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
