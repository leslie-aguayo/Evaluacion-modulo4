package web;

import datos.PrestacionesDAO;
import datos.ServiciosDAO;
import dominio.Prestacion;
import dominio.Servicio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PrestacionesControlador")
public class PrestacionesControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
       String accion = peticion.getParameter("accion");
       if(accion != null){
           switch(accion){
               case "editar":
                   this.editarPrestacion(peticion, respuesta);
                   break;
               case "eliminar":
                   this.eliminarPrestacion(peticion, respuesta);
                   break;
                   
               default:
                   this.accionDefault(peticion,respuesta);
           }
       }
       else{
           this.accionDefault(peticion, respuesta);
       }
    }
    
    private void editarPrestacion(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        int idPrestacion = Integer.parseInt(peticion.getParameter("idPrestaciones"));
        
        Prestacion prestacion = new PrestacionesDAO().encontrar(new Prestacion(idPrestacion));
        peticion.setAttribute("prestacion",prestacion);
        String jspEditar = "/WEB-INF/prestacion/editarPrestacion.jsp";
        peticion.getRequestDispatcher(jspEditar).forward(peticion, respuesta);
       
    }
    
    private void eliminarPrestacion(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        int idPrestacion = Integer.parseInt(peticion.getParameter("idPrestacion"));
        
        Prestacion prestacion = new Prestacion(idPrestacion);
        
        //int registrosModificados = new PrestacionesDAO().eliminar(prestacion);
        //System.out.println("registros: "+registrosModificados);
        this.accionDefault(peticion, respuesta);
    }
    
    private void modificarPrestacion(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        
        int idPrestacion = Integer.parseInt(peticion.getParameter("idPrestacion")); 
        int idCliente = Integer.parseInt(peticion.getParameter("idCliente"));
        int idTrabajador = Integer.parseInt(peticion.getParameter("idTrabajador"));
        String prestaciones = peticion.getParameter("prestaciones");
        int precio = Integer.parseInt(peticion.getParameter("precio"));
                
        //Cramos un objeto de tipo prestacion (modelo)
        Prestacion prestacion = new Prestacion(idPrestacion, idCliente, idTrabajador, prestaciones, precio);
        
         //int registrosModificados = new PrestacionesDAO().actualizar(prestacion);
         //System.out.println("registros :"+registrosModificados);
         
         this.accionDefault(peticion, respuesta);
    }
    
    
    private void accionDefault (HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        List <Prestacion> listadoPrestaciones = new PrestacionesDAO().listar();
        System.out.println("prestaciones: "+listadoPrestaciones);
        
       HttpSession sesion = peticion.getSession();
       sesion.setAttribute("prestaciones", listadoPrestaciones);
       
       respuesta.sendRedirect("prestaciones.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
       String accion = peticion.getParameter("accion");
       if(accion != null){ 
           switch(accion){
               case "insertar":
                   this.insertarPrestacion(peticion,respuesta);
                   break;
               case "modificar":
                   this.modificarPrestacion(peticion, respuesta);
                   break;
                   
               default:
                   this.accionDefault(peticion,respuesta);
           }
       }
       else{
           this.accionDefault(peticion, respuesta);
       }
    }
    
    private void insertarPrestacion(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException { 
        
        int idCliente = Integer.parseInt(peticion.getParameter("cliente"));
        int idTrabajador = Integer.parseInt(peticion.getParameter("trabajador"));
        String[] servicios = peticion.getParameterValues("servicios");
        
        String cadena = "";
        for(String servicio:servicios){
            if(cadena.equals("")){
                cadena += servicio;
            }else{
                cadena += ","+servicio;
            }
        }
        
        int precio = Integer.parseInt(peticion.getParameter("resultado")); 
                
        Prestacion prestacion = new Prestacion(idCliente, idTrabajador, cadena, precio);
        
 
        int registrosModificados = new PrestacionesDAO().insertar(prestacion);
        System.out.println("Registros modificados = "+registrosModificados);
        
        respuesta.sendRedirect("clientes.jsp");
        
    }
}
