<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_CL"/>

<section id ="clientes" >
    <div class="container ">
        <div class="row justify-content-center align-item-center">
            <div class="col-md-9 ">
                <div class="card-header">
                    <h4>Servicios</h4>
                </div>
                
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Tipo Servicio</th>
                            <th>Precio</th>                            
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach var="servicio" items="${servicios}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${servicio.tipoServicio}</td>
                            <td>${servicio.precio}</td>                         
                            
                            <td>
                                <a href="${pageContext.request.contextPath}/ServiciosControlador?accion=editar&idServicio=${servicio.idServicio}" class="btn btn-secondary">
                                    Editar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/cliente/agregarcliente.jsp"/>
<script src="funciones.js"></script>