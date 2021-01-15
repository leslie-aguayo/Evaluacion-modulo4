<html>
    <head>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">

        <!-- Bootstrap CSS Aspectos Visuales -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/c2f0fa766c.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="./estilos.css">
        <title>Editar Servicio</title>

    </head>
    <body>

        <!-- Llamar al header -->
        <jsp:include page="/WEB-INF/comunes/header.jsp"/>

        <form action="${pageContext.request.contextPath}/ServiciosControlador?accion=modificar&idCliente=${cliente.idCliente}"
              method="POST" class="was-validated">

            <!-- Botones de navegacion -Edicion -->
            <jsp:include page="/WEB-INF/comunes/botonNavEdicion.jsp"/>



            <div class="modal-body ">
                <div class="row justify-content-center align-item-center">
                    <div class="col-md-6 card-deck">
                        <div class="card bg-white mb-3">

                            <div class="card-body">



                                <label class="col-sm-4 col-form-label form-check-inline"> Seleccione Tipo de Lavado</label>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="inlineCheckbox3"
                                           value="5000">
                                    <label class="form-check-label" for="inlineCheckbox3">Interior <br /> $3.000.- </label>
                                </div>

                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="inlineCheckbox2"
                                           value="8000">
                                    <label class="form-check-label" for="inlineCheckbox2">Motor <br /> $12.000.- </label>
                                </div>



                                <br />
                                <br />
                                <br />
                                <br />
                                &nbsp;

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
        <script src="funciones.js"></script>


    </body>
</html>