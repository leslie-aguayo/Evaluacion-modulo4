<div class="form-group row filas">

    <input type="text" class="form-control col-sm-8" id="idVehiculo" value="${vehiculo.idVehiculo}" placeholder="Tipo Veh�culo" name="idVehiculo" hidden />
</div>



<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Marca</label>
    <input type="text" class="form-control col-sm-8" id="marca" maxlength="20"  onkeyup="validarMarca()" value="${vehiculo.marca}" placeholder="Marca" name="marca" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Modelo</label>
    <input type="text" class="form-control col-sm-8" id="modelo" maxlength="20" value="${vehiculo.modelo}" placeholder="Modelo" name="modelo" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">A�o</label>
    <input type="number" min="1940" max="2020" class="form-control col-sm-8" id="ano" value="${vehiculo.a�o}" placeholder="A�o" name="ano" required />
</div>

<div class="form-group row filas">
    <label class="col-sm-3 col-form-label">Revisi�n T�cnica</label>
    <input type="number" class="form-control col-sm-8" min="0" max="1" id="revTecnica" value="${vehiculo.revTecnica}" placeholder="Revisi�n t�cnica" name="revTecnica" required />
</div>