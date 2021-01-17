
package dominio;


public class Trabajador {
    private int idTrabajador;
    private String nombre;
    
    public Trabajador(){
        
    }

    public Trabajador(int idTrabajador, String nombre) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
    }

    public Trabajador(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTrabajador() {
        return this.idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

   
    
    
    
    
}
