<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="agregarServicioModal">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header d-block bg-primary text-white" style="align-items: center">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
                <div>
                    <h5 class="modal-title text-center" id="titulo1" >                        
                        Agregar Servicio
                        <img src="./img/cars4.jpg" height="50px" class="icono">
                    </h5>

                </div>

            </div>

            <form method="post" id="formularioServicios" action="${pageContext.request.contextPath}/PrestacionesControlador?accion=insertar"
                  class="was-validated">
                <div class="modal-body" style="justify-content:center">
                    <br/>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Cliente</label>

                        <select id="cliente" name="cliente" class="col-sm-8 col-form-label" style="color:#0B0B61;" required>
                            <c:forEach var="cliente" items="${sessionScope.clientes}">
                                <option value="${cliente.idCliente}">${cliente.nombre} ${cliente.apellido}</option>
                            </c:forEach>
                        </select>
                        </br>

                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Trabajador</label>

                        <select id="trabajador" name="trabajador" class="col-sm-8 col-form-label" style="color:#0B0B61;" required>
                            <c:forEach var="trabajador" items="${sessionScope.trabajadores}">
                                <option value="${trabajador.idTrabajador}">${trabajador.nombre}</option>
                            </c:forEach>
                        </select>
                        </br>

                    </div>
                    <div class="form-group">
                        <label for="servicio">Seleccione el Tipo de Servicio <em>(Precios Sin IVA)</em></label><br/>
                        <c:forEach var="servicio" items="${sessionScope.servicios}">
                            <input type="checkbox" name="servicios" value="${servicio.idServicio}" precio="${servicio.precio}" id="servicio-${servicio.idServicio}" onclick="valor(this)"> ${servicio.tipoServicio} $${servicio.precio}<br/>
                        </c:forEach>

                    </div>
                    <div class="form-group row filas">
                        <label class="col-sm-3 col-form-label">Total con IVA</label>
                        <label class="col-sm-3 col-form-label" id="total">0</label>
                        <input type="text" class="form-control col-sm-8" name="resultado" id="resultado" value="0" hidden />
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success" type="submit">Guardar</button>

                </div>
            </form>
        </div>
    </div>
</div>
