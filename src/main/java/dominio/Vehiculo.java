package dominio;

public class Vehiculo {

    private int idVehiculo;
    private String tipoVehiculo;
    private String marca;
    private String modelo;
    private int año;
    private int revTecnica;

    public Vehiculo() {

    }

    public Vehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(String tipoVehiculo, String marca, String modelo, int año, int revTecnica) {
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.revTecnica = revTecnica;
    }

    public Vehiculo(int idVehiculo, String tipoVehiculo, String marca, String modelo, int año, int revTecnica) {
        this.idVehiculo = idVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.revTecnica = revTecnica;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
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

    public int getRevTecnica() {
        return revTecnica;
    }

    public void setRevTecnica(int revTecnica) {
        this.revTecnica = revTecnica;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", tipoVehiculo=" + tipoVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", a\u00f1o=" + año + ", revTecnica=" + revTecnica + '}';
    }
    
    

}
