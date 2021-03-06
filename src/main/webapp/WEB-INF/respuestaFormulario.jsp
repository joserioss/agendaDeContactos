<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<title>vista controlador</title>
</head>
<body>
	<div class="card text-center">
		<div class="card-header">Formulario</div>
		<div class="card-body">
			<h5 class="card-title">Agregar contacto</h5>
			<form action='<c:url value = "/contactManager/"/>' method="post"
				id="frmSend" modelAttribute="formulario">

				<div class="form-group">
					<input type="text" id="nombre" name="nombre"
						placeholder="Ingrese su nombre"> <input type="text"
						id="apellidoPat" name="apellidoPaterno"
						placeholder="Ingrese su primer apellida"> <input
						type="text" id="apellidoMat" name="apellidoMaterno"
						placeholder="Ingrese su segundo apellido"> <input
						type="text" id="direccion" name="direccion"
						placeholder="Ingrese su direccion"> <input type="text"
						id="telefono" name="telefono" placeholder="Ingrese su telefono">

				</div>

				<button type="submit" class="btn btn-primary">Agregar</button>
			</form>
		</div>
	</div>

	<div>
		<p></p>
	</div>

	<div class="card text-center">
		<div class="card-header">Lista de contactos</div>
		<div class="card-body">
			<h5 class="card-title">Personas agregadas</h5>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nombre</th>
						<th scope="col">Direcion</th>
						<th scope="col">Telefono</th>
						<th scope="col">Accion</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${respuestasFormulario != null}">

						<c:forEach var="resp" items="${respuestasFormulario}">
							<tr>
								<td>${resp['id']}</td>
								<td>${resp['nombre']} ${resp['apellidoPaterno']}
									${resp['apellidoMaterno']}</td>
								<td>${resp['direccion']}</td>
								<td>${resp['telefono']}</td>
								<td><a
									href='<c:out value = "/contactManager/delete?id=${resp.getId()}"></c:out>'
									class="btn btn-primary">Eliminar</a></td>

							</tr>
						</c:forEach>


					</c:if>
				</tbody>
			</table>

		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>