<html>
    <head>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">

        <!-- Bootstrap CSS Aspectos Visuales -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/c2f0fa766c.js" crossorigin="anonymous"></script>

        <title>Editar Clientes</title>

    </head>
    <body>

        <!-- Llamar al header -->
        <jsp:include page="/WEB-INF/comunes/header.jsp"/>

        <form action="${pageContext.request.contextPath}/ClientesControlador?accion=modificar&idCliente=${cliente.idCliente}"
              method="POST" class="was-validated">

            <!-- Botones de navegacion -Edicion -->
            <jsp:include page="/WEB-INF/comunes/botonNavEdicion.jsp"/>



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
                                    <label class="col-sm-3 col-form-label">Vehículo</label>
                                    <input type="number" class="form-control col-sm-8" id="idVehiculo"
                                           placeholder="Ingrese Id Vehículo" name="idVehiculo" value="${cliente.idVehiculo}" required />
                                </div>
                                <div class="form-group row filas">
                                    <label class="col-sm-3 col-form-label">Run</label>
                                    <input type="text" class="form-control col-sm-3" id="rut" oninput="validarRut(rut)" maxlength="10"
                                           placeholder="123456789" name="rut" value="${cliente.rut}"required />
                                </div>

                                <div class="form-group row filas">
                                    <label class="col-sm-3 col-form-label">Nombre</label>
                                    <input type="text" class="form-control col-sm-8" id="nombre" name="nombre" value="${cliente.nombre}"
                                           onkeyup="validarNombre()" onkeypress="soloLetras()"
                                           placeholder="Ingrese su Nombre" maxlength="50" required />
                                    <div id="mensaje1" style="color:blue" hidden>
                                        Ingrese solo letras
                                    </div>
                                </div>

                                <div class="form-group row filas">
                                    <label class="col-sm-3 col-form-label">Apellido</label>
                                    <input type="text" class="form-control col-sm-8" id="apellido" name="apellido" value="${cliente.apellido}" maxlength="50"
                                           onkeyup="validarApellido()" onkeypress="soloLetras()"
                                           placeholder="Ingrese su Apellido" required />
                                    <div id="mensaje2" style="color:blue" hidden>
                                        Ingrese solo letras
                                    </div>
                                </div>

                                <div class="form-group row filas">
                                    <label class="col-sm-3 col-form-label">Fecha Nacimiento</label>
                                    <input id="fechaN" type="date" class="form-control col-sm-8" name="fechaNac" value="${cliente.fechaNac}" required>
                                </div>

                                <div class="form-group row filas">
                                    <label class="col-sm-3 col-form-label">Direccion</label>
                                    <input type="text" class="form-control col-sm-8" id="direccion" maxlenght="100"
                                           placeholder="Ingrese su Dirección" oninput="validarDireccion(this)" name="direccion" value="${cliente.direccion}" required />
                                    <div id="mensaje3" style="color:blue" hidden class="col-sm-8">
                                        Ingrese solo letras
                                    </div>
                                </div>

                                <div class="form-group row filas">
                                    <label class="col-sm-3 col-form-label">Comuna</label>
                                    <input type="text" class="form-control col-sm-8" oninput="ingresarSoloLetras(this)" placeholder="Ingrese su Comuna"
                                           name="comuna" value="${cliente.comuna}" required>
                                </div>

                                <br/>		

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </form>

        <jsp:include page="/WEB-INF/comunes/footer.jsp"/>


        <!-- Scripts funcional-->  

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>



    </body>




</html>