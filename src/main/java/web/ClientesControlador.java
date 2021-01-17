package web;

import datos.ClientesDAO;
import datos.ServiciosDAO;
import datos.TrabajadoresDAO;
import datos.VehiculosDAO;
import dominio.Cliente;
import dominio.Servicio;
import dominio.Trabajador;
import dominio.Vehiculo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ClientesControlador")
public class ClientesControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
       String accion = peticion.getParameter("accion");
       if(accion != null){
           switch(accion){
               case "editar":
                   this.editarCliente(peticion, respuesta);
                   break;
               case "eliminar":
                   this.eliminarCliente(peticion, respuesta);
                   break;
                   
               default:
                   this.accionDefault(peticion,respuesta);
           }
       }
       else{
           this.accionDefault(peticion, respuesta);
       }
    }
    
    private void editarCliente(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        //recuperar idcliente desde la vista de listadoClientes.jsp
        HttpSession sesion = peticion.getSession();
        int idCliente = Integer.parseInt(peticion.getParameter("idCliente"));
        //el cliente se busca por medio del ID
        Cliente cliente = new ClientesDAO().encontrar(new Cliente(idCliente));
        
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setIdVehiculo(cliente.getIdVehiculo());
        vehiculo = new VehiculosDAO().encontrar(vehiculo);
        
        sesion.setAttribute("cliente",cliente);
        sesion.setAttribute("vehiculo", vehiculo);
        System.out.println(cliente.toString());
        System.out.println(vehiculo.toString());
        
        String jspEditar = "/WEB-INF/cliente/editarCliente.jsp";
        
        peticion.getRequestDispatcher(jspEditar).forward(peticion, respuesta);
       
    }
    
    private void eliminarCliente(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        int idCliente = Integer.parseInt(peticion.getParameter("idCliente"));
        
        //creamos un objeto de cliente utilizando el ID
        Cliente cliente = new Cliente(idCliente);
        
        //Eliminar el registro de la bdd
        int registrosModificados = new ClientesDAO().eliminar(cliente);
        System.out.println("registros: "+registrosModificados);
        //redirigir la pagina para listar los clientes
        this.accionDefault(peticion, respuesta);
    }
    
    private void modificarCliente(HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        
       //recuperar idcliente desde la vista de listadoClientes.jsp
        int idCliente = Integer.parseInt(peticion.getParameter("idCliente"));
        int idVehiculo = Integer.parseInt(peticion.getParameter("idVehiculo"));
        String rut = peticion.getParameter("rut");
        String nombre = peticion.getParameter("nombre");
        String apellido = peticion.getParameter("apellido");
        String fechaNac = peticion.getParameter("fechaNac");
        String direccion = peticion.getParameter("direccion");
        String comuna = peticion.getParameter("comuna");
        
        String tipoVehiculo = peticion.getParameter("tipoVehiculo");
        String marca = peticion.getParameter("marca");
        String modelo = peticion.getParameter("modelo");
        int ano = Integer.parseInt(peticion.getParameter("ano"));
        int revTecnica = Integer.parseInt(peticion.getParameter("revTecnica"));
        
        Vehiculo vehiculo = new Vehiculo(idVehiculo, tipoVehiculo, marca, modelo, ano, revTecnica);
            
        int modificaciones = new VehiculosDAO().actualizar(vehiculo);
        
         //crear el objeto del modelo cliente
         Cliente cliente = new Cliente(idCliente, idVehiculo, rut, nombre,apellido, fechaNac,direccion,comuna);
         int registrosModificados = new ClientesDAO().actualizar(cliente);
         System.out.println("registros :"+registrosModificados);
         
         this.accionDefault(peticion, respuesta);
    }
    
    
    private void accionDefault (HttpServletRequest peticion, HttpServletResponse respuesta)
        throws ServletException, IOException{
        List <Cliente> listadoClientes = new ClientesDAO().listar();
        List<Servicio> listadoServicios = new ServiciosDAO().listar();
        List<Trabajador> listadoTrabajadores = new TrabajadoresDAO().listar();
        
        System.out.println("clientes: "+listadoClientes);
        
       //scope - limites - alcances
       HttpSession sesion = peticion.getSession();
       // el string de clientes: es la variable con la que puedo identificarlo
       //en un JSP - osea, en la parte visual
       //y el otro parametro es un objeto de java, que dice
       //que la variable String clientes es lo mismo que listadoClientes.
       //el jsp tiene un elemento clientes y este se comunica con ClientesDAO y le dice
       //que debe obtener un listado de clientes.
       sesion.setAttribute("clientes", listadoClientes);
       sesion.setAttribute("servicios", listadoServicios);
       sesion.setAttribute("trabajadores", listadoTrabajadores);
       sesion.setAttribute("idVehiculo", 0);
       
       //peticion.getRequestDispatcher("clientes.jsp").forward(peticion, respuesta);
       respuesta.sendRedirect("clientes.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
       String accion = peticion.getParameter("accion");
       if(accion != null){ 
           switch(accion){
               case "insertar":
                   this.insertarCliente(peticion,respuesta);
                   break;
               case "modificar":
                   this.modificarCliente(peticion, respuesta);
                   break;
                   
               default:
                   this.accionDefault(peticion,respuesta);
           }
       }
       else{
           this.accionDefault(peticion, respuesta);
       }
    }
    
    private void insertarCliente(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
        
        String rut = peticion.getParameter("rut");
        String nombre = peticion.getParameter("nombre");
        String apellido = peticion.getParameter("apellido");
        String fechaNac = peticion.getParameter("fechaNac");
        String direccion = peticion.getParameter("direccion");
        String comuna = peticion.getParameter("comuna");
        

        String tipoVehiculo = peticion.getParameter("tipoVehiculo");
        String marca = peticion.getParameter("marca");
        String modelo = peticion.getParameter("modelo");
        int ano = Integer.parseInt(peticion.getParameter("ano"));
        int revTecnica = Integer.parseInt(peticion.getParameter("revTecnica"));
        
        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, marca, modelo, ano, revTecnica);
        int idVehiculo = 0;
        try {
            idVehiculo = new VehiculosDAO().insertar(vehiculo);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(idVehiculo != 0){
        //Cramos un objeto de tipo cliente (modelo)
        Cliente cliente = new Cliente(idVehiculo , rut, nombre, apellido, fechaNac, direccion, comuna);
        
        //insertar el objeto de cliente en la base de datos
        int registrosModificados = new ClientesDAO().insertar(cliente);
        System.out.println("Registros modificados = "+registrosModificados);
        }
        
        //redirigimos nuevamente a la pantalla principal para que muestre el nuevo cliente en pantalla
        this.accionDefault(peticion, respuesta);
        
    }
}
