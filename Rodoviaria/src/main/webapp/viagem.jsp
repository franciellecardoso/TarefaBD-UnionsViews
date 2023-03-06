<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Viagem</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="viagem" method="post">
			<p class="title">
				<b>Viagens</b>
			</p>
			<table>
				<tr>
					<td colspan="3"><input class="id_input_data" type="number"
						min="0" step="1" id="codigo" name="codigo"
						placeholder="Codigo de Viagem"
						value='<c:out value="${viagem.codigo}"></c:out>'></td>
					<td><input type="submit" id="botao" name="botao"
						value="Buscar"></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="placa" name="placa" placeholder="Placa"
						value='<c:out value="${viagem.placa}"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="hora_saida" name="hora_saida" placeholder="Hora de Saida"
						value='<c:out value="${viagem.hora_saida}"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="hora_chegada" name="hora_chegada"
						placeholder="Hora de Chegada"
						value='<c:out value="${viagem.hora_chegada}"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="partida" name="partida" placeholder="Partida"
						value='<c:out value="${viagem.partida }"></c:out>'></td>
				</tr>

				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="destino" name="destino" placeholder="Destino"
						value='<c:out value="${viagem.destino }"></c:out>'></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>