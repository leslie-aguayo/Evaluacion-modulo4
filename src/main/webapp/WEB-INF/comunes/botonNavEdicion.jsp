<section id="actions" class="py-4 mb-4 bg-light ">
    <div class="container ">
        <div class="row justify-content-center align-item-center">
            <div class="col-md-3 ">
                <a href="index.jsp" class="btn btn-primary btn-block">
                    Regresar
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">Guardar</button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ClientesControlador?accion=eliminar&idCliente=${cliente.idCliente}"
                   class="btn btn-danger btn-block">Eliminar Cliente</a>
            </div>
        </div>
    </div>
</section>