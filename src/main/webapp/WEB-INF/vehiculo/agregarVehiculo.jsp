<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Tipo Vehículo</label>
    <input type="text" class="form-control col-sm-8" id="tipoVehiculo" placeholder="Tipo Vehículo" name="tipoVehiculo" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Marca</label>
    <input type="text" class="form-control col-sm-8" id="marca" placeholder="Marca"  maxlength="20" name="marca" onkeyup="validarMarca()" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Modelo</label>
    <input type="text" class="form-control col-sm-8" id="modelo" placeholder="Modelo" name="modelo" maxlength="20"
           placeholder="Ingrese Modelo" onkeyup="validarModelo()" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Año</label>
    <input type="number" min="1940" max="2020" class="form-control col-sm-8" id="ano" placeholder="Año" name="ano" oninput="soloNum(this)" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Revisión Técnica</label>
    <input type="number" min="0" max="1"  class="form-control col-sm-8" id="revTecnica" placeholder="Ingrese 0 si no está al día y 1 si está al día" name="revTecnica" required />
</div>