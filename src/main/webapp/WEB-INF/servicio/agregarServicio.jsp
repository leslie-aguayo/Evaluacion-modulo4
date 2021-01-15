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

            <form method="post" id="formulario2" action="${pageContext.request.contextPath}/ServiciosControlador?accion=insertar"
                  class="was-validated">
                <div class="modal-body" style="justify-content:center">
                    <br/>
                  <div class="form-group">
                        <label for="servicio">Seleccione el Tipo de Servicio <em>(Precios Sin IVA)</em></label><br/>
                        <input type="checkbox" name="servicio" value="Lavado Exterior" id="exterior" onclick="valor()">&nbsp;Lavado Exterior $5000<br/>
                        <input type="checkbox" name="servicio" value="Lavado Interior" id="interior" onclick="valor()">&nbsp;Lavado Interior $3000<br/>
                        <input type="checkbox" name="servicio" value="Lavado de Motor" id="motor" onclick="valor()">&nbsp;Lavado de Motor   $12000<br/>
                         <div class="row align-items-center justify-content-center mb-3">
                            <label class="input-group-text"><h6>Total a pagar $</h6>&nbsp;<h6 name="totalServicio" id="resultado">0000</h6></label>
                        </div>
                    </div>
                    
                </div>
            </form>
        </div>
    </div>
</div>
