<div class="modal fade" id="agregarServicioModal">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header d-block bg-primary text-white" style="align-items: center">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
                <div>
                    <h5 class="modal-title text-center" id="titulo" >                        
                        Agregar Servicio
                        <img src="./img/cars4.jpg" height="50px" class="icono">
                    </h5>

                </div>

            </div>

           <form method="post" id="formulario2" action="${pageContext.request.contextPath}/ServiciosControlador?accion=insertar"
                  class="was-validated">
                <div class="modal-body" style="justify-content:center">
                    <br/>
                    <div class="form-group row filas">
                            <label class="col-sm-4 col-form-label form-check-inline"> Seleccione Tipo de Lavado</label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox1"
                                       value="5000">
                                <label class="form-check-label" for="inlineCheckbox1">Exterior <br /> $5.000.-
                                </label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox2"
                                       value="8000">
                                <label class="form-check-label" for="inlineCheckbox2">Motor <br /> $12.000.- </label>
                            </div>
                            
                              <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox3"
                                       value="5000">
                                <label class="form-check-label" for="inlineCheckbox3">Interior <br /> $3.000.- </label>
                            </div>

                            <br />
                            <br />
                            <br />
                            <br />
                            &nbsp;

                        </div>
                    </div>
                </div>
