<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header d-block bg-primary text-white" style="align-items: center">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
                <div>
                    <h5 class="modal-title text-center" id="titulo" >                        
                        Agregar Cliente
                        <img src="./img/cars4.jpg" height="50px" class="icono">
                    </h5>

                </div>


            </div>

            <form method="post" id="formulario" action="${pageContext.request.contextPath}/ClientesControlador?accion=insertar"
                  class="was-validated">
                <div class="modal-body" style="justify-content:center">
                    
                    <div class="form-group row filas">
                        <label class="col-sm-3 col-form-label">Run</label>
                        <input type="text" class="form-control col-sm-8" id="rut" oninput="validarRut(rut)" maxlength="10"
                               placeholder="123456789" name="rut" required />
                    </div>

                    <div class="form-group row filas">
                        <label class="col-sm-3 col-form-label">Nombre</label>
                        <input type="text" class="form-control col-sm-8" id="nombre"
                               onkeyup="validarNombre()" onkeypress="soloLetras()"
                               placeholder="Ingrese su Nombre" name="nombre" maxlength="50" required />
                        <div id="mensaje1" style="color:blue" hidden>
                            Ingrese solo letras
                        </div>
                    </div>

                    <div class="form-group row filas">
                        <label class="col-sm-3 col-form-label">Apellido</label>
                        <input type="text" class="form-control col-sm-8" id="apellido" maxlength="50"
                               onkeyup="validarApellido()" onkeypress="soloLetras()"
                               placeholder="Ingrese su Apellido" name="apellido" required />
                        <div id="mensaje2" style="color:blue" hidden>
                            Ingrese solo letras
                        </div>
                    </div>

                    <div class="form-group row filas">
                        <label class="col-sm-3 col-form-label">Fecha Nacimiento</label>
                        <input id="fechaN" type="date" class="form-control col-sm-8" name="fechaNac" required="">
                    </div>

                    <div class="form-group row filas">
                        <label class="col-sm-3 col-form-label">Direccion</label>
                        <input type="text" class="form-control col-sm-8" id="direccion" maxlenght="100"
                               placeholder="Ingrese su Dirección" name="direccion" oninput="validarDireccion(this)" required />
                        <div id="mensaje3" style="color:blue" hidden class="col-sm-8">
                            Ingrese solo letras
                        </div>
                    </div>

                    <div class="form-group row filas">
                        <label class="col-sm-3 col-form-label">Comuna</label>
                        <input type="text" class="form-control col-sm-8" name="comuna" oninput="ingresarSoloLetras(this)" placeholder="Ingrese su Comuna"
                               required>
                    </div>
                    
                    <jsp:include page="/WEB-INF/vehiculo/agregarVehiculo.jsp"/>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-success" type="submit">Guardar</button>

                </div>

            </form>
        </div>
    </div>
</div> 