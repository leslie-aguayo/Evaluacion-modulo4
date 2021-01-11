package dominio;


public class Vehiculo {
    private int idCliente;
    private int idVehiculo;
    private String tipoVehiculo;
    private String marca;
    private String modelo;
    private int año;
    private String revTecnica;
    private String comuna;
    
    public Vehiculo(){
        
    }

    public Vehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(int idCliente, String tipoVehiculo, String marca, String modelo, int año, String revTecnica, String comuna) {
        this.idCliente = idCliente;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.revTecnica = revTecnica;
        this.comuna = comuna;
    }
    
    

    public Vehiculo(int idCliente, int idVehiculo, String tipoVehiculo, String marca, String modelo, int año, String revTecnica) {
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.revTecnica = revTecnica;
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

    public String getTipo_Vehiculo() {
        return tipoVehiculo;
    }

    public void setTipo_Vehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getRevTecnica() {
        return revTecnica;
    }

    public void setRev_Tecnica(String revTecnica) {
        this.revTecnica = revTecnica;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", tipo_Vehiculo=" + tipoVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", año=" + año + ", rev_Tecnica=" + revTecnica + ", comuna=" + comuna + '}';
    }
    
    
}

   