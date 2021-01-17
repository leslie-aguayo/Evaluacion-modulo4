<div class="form-group row filas">

    <input type="text" class="form-control col-sm-8" id="idVehiculo" value="${vehiculo.idVehiculo}" placeholder="Tipo Vehículo" name="idVehiculo" hidden />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Tipo Vehículo</label>
    <input type="text" class="form-control col-sm-8" id="tipoVehiculo" value="${vehiculo.tipoVehiculo}" placeholder="Tipo Vehículo" name="tipoVehiculo" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Marca</label>
    <input type="text" class="form-control col-sm-8" id="marca" value="${vehiculo.marca}" placeholder="Marca" name="marca" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Modelo</label>
    <input type="text" class="form-control col-sm-8" id="modelo" value="${vehiculo.modelo}" placeholder="Modelo" name="modelo" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Año</label>
    <input type="text" class="form-control col-sm-8" id="ano" value="${vehiculo.año}" placeholder="Año" name="ano" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Revisión técnica</label>
    <input type="text" class="form-control col-sm-8" id="revTecnica" value="${vehiculo.revTecnica}" placeholder="Revisión técnica" name="revTecnica" required />
</div>