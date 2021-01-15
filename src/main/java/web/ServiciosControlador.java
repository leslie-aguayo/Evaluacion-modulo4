package web;

import datos.ServiciosDAO;
import dominio.Servicio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServiciosControlador")
public class ServiciosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
       String accion = peticion.getParameter("accion");
       if(accion != null){
           switch(accion){
               case "editar":
                   this.editarServicio(peticion, respuesta);
                   break;
               case "eliminar":
                   this.eliminarServicio(peticion, respuesta);
                   break;
                   
               default:
                   this.accionDefault(peticion,respuesta);
           }
       }
       else{
           this.accionDefault(peticion, respuesta);
       }
    }
    
    private void editarServicio(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        int idServicio = Integer.parseInt(peticion.getParameter("idServicios"));
        
        Servicio servicio = new ServiciosDAO().encontrar(new Servicio(idServicio));
        peticion.setAttribute("servicio",servicio);
        String jspEditar = "/WEB-INF/servicio/editarServicio.jsp";
        peticion.getRequestDispatcher(jspEditar).forward(peticion, respuesta);
       
    }
    
    private void eliminarServicio(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        int idServicio = Integer.parseInt(peticion.getParameter("idServicio"));
        
        Servicio servicio = new Servicio(idServicio);
        
        int registrosModificados = new ServiciosDAO().eliminar(servicio);
        System.out.println("registros: "+registrosModificados);
        this.accionDefault(peticion, respuesta);
    }
    
    private void modificarServicio(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        
        int idServicio = Integer.parseInt(peticion.getParameter("idServicio")); 
        String tipoServicio = peticion.getParameter("tipoServicio");
        int precio = Integer.parseInt(peticion.getParameter("precio")); 
                
        //Cramos un objeto de tipo servicio (modelo)
        Servicio servicio = new Servicio(idServicio, tipoServicio, precio);
        
         int registrosModificados = new ServiciosDAO().actualizar(servicio);
         System.out.println("registros :"+registrosModificados);
         
         this.accionDefault(peticion, respuesta);
    }
    
    
    private void accionDefault (HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        List <Servicio> listadoServicios = new ServiciosDAO().listar();
        System.out.println("servicios: "+listadoServicios);
        
       HttpSession sesion = peticion.getSession();
       sesion.setAttribute("servicios", listadoServicios);
       
       respuesta.sendRedirect("servicios.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
       String accion = peticion.getParameter("accion");
       if(accion != null){ 
           switch(accion){
               case "insertar":
                   this.insertarServicio(peticion,respuesta);
                   break;
               case "modificar":
                   this.modificarServicio(peticion, respuesta);
                   break;
                   
               default:
                   this.accionDefault(peticion,respuesta);
           }
       }
       else{
           this.accionDefault(peticion, respuesta);
       }
    }
    
    private void insertarServicio(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException { 
        
        int idServicio = Integer.parseInt(peticion.getParameter("idServicio")); 
        String tipoServicio = peticion.getParameter("tipoServicio");
        int precio = Integer.parseInt(peticion.getParameter("precio")); 
                
        //Cramos un objeto de tipo servicio (modelo)
        Servicio servicio = new Servicio(idServicio, tipoServicio, precio);
        
 
        int registrosModificados = new ServiciosDAO().insertar(servicio);
        System.out.println("Registros modificados = "+registrosModificados);
        
        this.accionDefault(peticion, respuesta);
        
    }
}
