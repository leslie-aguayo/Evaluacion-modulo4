<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_CL"/>

<section id ="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card-header">
                    <h4>Listado de Clientes</h4>
                </div>
                
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Cliente</th>
                            <th>Rut</th>
                            <th>Dirección</th>
                            <th>Comuna</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach var="cliente" items="${clientes}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${cliente.nombre} ${cliente.apellido}</td>
                            <td>${cliente.rut}</td>
                            <td>${cliente.direccion}</td>
                            <td>${cliente.comuna}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ClientesControlador?accion=editar&idCliente=${cliente.idCliente}" class="btn btn-secondary">
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