package web;

import datos.VehiculosDAO;
import dominio.Vehiculo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VehiculosControlador")
public class VehiculosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
       String accion = peticion.getParameter("accion");
       if(accion != null){
           switch(accion){
               case "editar":
                   this.editarVehiculo(peticion, respuesta);
                   break;
               case "eliminar":
                   this.eliminarVehiculo(peticion, respuesta);
                   break;
                   
               default:
                   this.accionDefault(peticion,respuesta);
           }
       }
       else{
           this.accionDefault(peticion, respuesta);
       }
    }
    
    private void editarVehiculo(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        int idVehiculo = Integer.parseInt(peticion.getParameter("idVehiculos"));
        
        Vehiculo vehiculo = new VehiculosDAO().encontrar(new Vehiculo(idVehiculo));
        peticion.setAttribute("vehiculo",vehiculo);
        String jspEditar = "/WEB-INF/vehiculo/editarVehiculo.jsp";
        peticion.getRequestDispatcher(jspEditar).forward(peticion, respuesta);
       
    }
    
    private void eliminarVehiculo(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        int idVehiculo = Integer.parseInt(peticion.getParameter("idVehiculo"));
        
        Vehiculo vehiculo = new Vehiculo(idVehiculo);
        
        int registrosModificados = new VehiculosDAO().eliminar(vehiculo);
        System.out.println("registros: "+registrosModificados);
        this.accionDefault(peticion, respuesta);
    }
    
    private void modificarVehiculo(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        
       int idVehiculo = Integer.parseInt(peticion.getParameter("idVehiculo")); 
        String tipoVehiculo = peticion.getParameter("tipoVehiculo"); 
        String marca = peticion.getParameter("marca"); 
        String modelo = peticion.getParameter("modelo");
        int ano = Integer.parseInt(peticion.getParameter("ano")); 
        int revTecnica = Integer.parseInt(peticion.getParameter("revTecnica"));
                
        
        //Cramos un objeto de tipo vehiculo (modelo)
        Vehiculo vehiculo = new Vehiculo(idVehiculo,tipoVehiculo, marca, modelo, ano, revTecnica);
        
         int registrosModificados = new VehiculosDAO().actualizar(vehiculo);
         System.out.println("registros :"+registrosModificados);
         
         this.accionDefault(peticion, respuesta);
    }
    
    
    private void accionDefault (HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        List <Vehiculo> listadoVehiculos = new VehiculosDAO().listar();
        System.out.println("vehiculos: "+listadoVehiculos);
        
       HttpSession sesion = peticion.getSession();
       sesion.setAttribute("vehiculos", listadoVehiculos);
       
       respuesta.sendRedirect("vehiculos.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
       String accion = peticion.getParameter("accion");
       if(accion != null){ 
           switch(accion){
               case "insertar":
                   this.insertarVehiculo(peticion,respuesta);
                   break;
               case "modificar":
                   this.modificarVehiculo(peticion, respuesta);
                   break;
                   
               default:
                   this.accionDefault(peticion,respuesta);
           }
       }
       else{
           this.accionDefault(peticion, respuesta);
       }
    }
    
    private void insertarVehiculo(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException { 
        
        int idVehiculo = Integer.parseInt(peticion.getParameter("idVehiculo")); 
        String tipoVehiculo = peticion.getParameter("tipoVehiculo"); 
        String marca = peticion.getParameter("marca"); 
        String modelo = peticion.getParameter("modelo");
        int ano = Integer.parseInt(peticion.getParameter("ano")); 
        int revTecnica = Integer.parseInt(peticion.getParameter("revTecnica"));
                
        
        //Cramos un objeto de tipo vehiculo (modelo)
        Vehiculo vehiculo = new Vehiculo(idVehiculo,tipoVehiculo, marca, modelo, ano, revTecnica);
        
 
        int registrosModificados = new VehiculosDAO().insertar(vehiculo);
        System.out.println("Registros modificados = "+registrosModificados);
        
        this.accionDefault(peticion, respuesta);
        
    }
}
