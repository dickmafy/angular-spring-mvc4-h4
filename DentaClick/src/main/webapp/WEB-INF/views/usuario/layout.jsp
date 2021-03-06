<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
	<div id="fui-button" class="pbl"></div>
	<div class="demo-row">
		<div class="demo-title">USUARIO / LAYOUT</div>
		<div class="demo-content">
			<span class="label label-danger" ng-show="error">{{errorMessage}}</span> <span class="label label-success" ng-show="success">{{successMessage}}</span>
			<div class="row">
				<!-- ADD -->
				<form ng-submit="add(bean)">
					<div class="col-lg-8">
						<input class="form-control" placeholder="Ingresa nombre" type="text" ng-model="bean.nomb" required min="1" />
						<input class="form-control" placeholder="Ingresa correo" type="text" ng-model="bean.pass" required min="1" />
						<b>Perfiles:</b> <select ng-model="bean.fkPerfil.pkPerfil" id="personData">
							<option value="">-- Seleccione Perfiles --</option>
							<option data-ng-repeat="perfil in perfilList" value="{{perfil.pkPerfil}}">{{perfil.nomb}}</option>
						</select><br>
					</div>
				</form>
				<button class="btn btn-primary" ng-disabled="!bean" ng-hide="editMode" ng-click="add(bean)">Agregar Usuario</button>
				<button type="btn btn-primary" class="btn btn-primary" ng-disabled="!bean" ng-show="editMode" ng-click="update(bean)">Guardar</button>
				<button type="btn btn-primary" class="btn btn-primary" ng-click="reset()">Limpiar</button>
			</div>
			<hr />
			<!-- BUSCAR -->
			<div class="row">
				<div class="col-lg-8">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search" id="search-query-3" ng-model="searchAddressBook">
							<span class="input-group-btn">
								<button type="submit" class="btn">
									<span class="fui-search"></span>
								</button>
							</span>
						</div>
					</div>
				</div>
			</div>
			<hr />
			<div class="alert alert-info" style="width: 400px; margin-left: 100px;" ng-show="beanList.length == 0">No address book entry
				found</div>
			beanList.length : {{beanList.length}}
			<!-- Mostrar solo si hay data -->
			<table class="table table-bordered table-striped" ng-show="beanList.length > 0">
				<thead>
					<!-- CABECERA TABLA -->
					<tr>
						<th style="text-align: center; width: 25px;">Borrar</th>
						<th style="text-align: center; width: 25px;">Actualizar</th>
						<th style="text-align: center;"><a href="" ng-click="reverse=!reverse;order('pkUsuario', reverse)">ID </a></th>
						<th style="text-align: center;"><a href="" ng-click="reverse=!reverse;order('nomb', reverse)">NOMBRE </a></th>
						<th style="text-align: center;"><a href="" ng-click="reverse=!reverse;order('pass', reverse)">PASS </a></th>
						<th style="text-align: center;"><a href="" ng-click="reverse=!reverse;order('fkPerfil.nomb', reverse)">PERFIL</a></th>
					</tr>
				</thead>
				<tbody>
					<!-- FILAS TABLA -->
					<tr ng-repeat="bean in beanList | filter:searchAddressBook">
						<td style="width: 70px; text-align: center;">
							<button class="btn btn-mini btn-danger" ng-click="delete(bean)">Delete</button>
						</td>
						<td style="width: 70px; text-align: center;">
							<button class="btn btn-mini btn-danger" ng-click="set(beanList.indexOf(bean), bean)">Update</button>
						</td>
						<td>{{bean.pkUsuario}}</td>
						<td>{{bean.nomb}}</td>
						<td>{{bean.pass}}</td>
						<td>{{bean.fkPerfil.nomb}}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- /.demo-content -->
	</div>
	<!-- /.demo-row -->
</div>
<!-- /.container -->
