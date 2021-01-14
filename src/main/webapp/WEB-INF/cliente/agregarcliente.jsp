<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title">Agregar Cliente</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>


            <form method="post" id="formulario" action="${pageContext.request.contextPath}/ClientesControlador?accion=insertar"
                  class="was-validated">
                <div class="modal-body">
                    <div class="row justify-content-center align-item-center justify-content-md-start">
                        <div class="col-md-6 card-deck">
                            <div class="card bg-white mb-3">

                                <div class="card-header text-center font-weight-bold lead" id="titulo" style="color:#0B0B61">
                                    <img src="./img/cars4.jpg" height="50px" class="icono">
                                    Datos Clientes
                                </div>

                                <div class="card-body">



                                    <div class="form-group row filas">
                                        <label class="col-sm-3 col-form-label">Run</label>
                                        <input type="text" class="form-control col-sm-3" id="rut" oninput="validarRut(rut)" maxlength="10"
                                               placeholder="123456789" required />
                                    </div>

                                    <div class="form-group row filas">
                                        <label class="col-sm-3 col-form-label">Nombre</label>
                                        <input type="text" class="form-control col-sm-8" id="nombre"
                                               onkeyup="validarNombre()" onkeypress="soloLetras()"
                                               placeholder="Ingrese su Nombre" maxlength="50" required />
                                        <div id="mensaje1" style="color:blue" hidden>
                                            Ingrese solo letras
                                        </div>
                                    </div>

                                    <div class="form-group row filas">
                                        <label class="col-sm-3 col-form-label">Apellido</label>
                                        <input type="text" class="form-control col-sm-8" id="apellido" maxlength="50"
                                               onkeyup="validarApellido()" onkeypress="soloLetras()"
                                               placeholder="Ingrese su Apellido" required />
                                        <div id="mensaje2" style="color:blue" hidden>
                                            Ingrese solo letras
                                        </div>
                                    </div>

                                    <div class="form-group row filas">
                                        <label class="col-sm-3 col-form-label">Fecha Nacimiento</label>
                                        <input id="fechaN" type="date" class="form-control col-sm-8" required="">
                                    </div>

                                    <div class="form-group row filas">
                                        <label class="col-sm-3 col-form-label">Direccion</label>
                                        <input type="text" class="form-control col-sm-8" id="direccion" maxlenght="100"
                                               placeholder="Ingrese su Dirección" oninput="validarDireccion(this)" required />
                                        <div id="mensaje3" style="color:blue" hidden class="col-sm-8">
                                            Ingrese solo letras
                                        </div>
                                    </div>

                                    <div class="form-group row filas">
                                        <label class="col-sm-3 col-form-label">Comuna</label>
                                        <input type="text" class="form-control col-sm-8" oninput="ingresarSoloLetras(this)" placeholder="Ingrese su Comuna"
                                               required>
                                    </div>

                                    <br/>		

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success" type="submit">Guardar</button>

                </div>

            </form>
        </div>
    </div>
</div> 