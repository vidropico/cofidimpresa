<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>
	<jsp:include page="testata.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<jsp:include page="messages.jsp" />
	<div style="margin-top: 80px">
		<table id="elencoSoci" class="display responsive nowrap"
			style="width: 100%">
			<thead>
				<tr>
					<th>IMPRESA</th>
					<th>COD. FISCALE</th>
					<th>P. IVA</th>
					<th>INDIRIZZO AZIENDA</th>
					<th>TIPOLOGIA MERCEOLOGICA</th>
					<th>STATO</th>
					<th>E-MAIL</th>
					<th>DATA INIZIO</th>
					<th>NUM. FINANZIAMENTI</th>
					<th>AZIONI</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="socioData" items="${sociTables}">
					<tr>
						<td>${socioData.impresa}</td>
						<td>${socioData.codFiscale}</td>
						<td>${socioData.pIva}</td>
						<td>${socioData.indirizzoAzienda}</td>
						<td>${socioData.tipologiaMerceologica}</td>
						<td>${socioData.stato}</td>
						<td>${socioData.email}</td>
						<td>${socioData.dataInizio}</td>
						<td>${socioData.finanziamentiNum}</td>
						<td><a href="modificaSocio?idSocio=${socioData.idSocio}">
								<img title="Modifica Socio" src="images/icons/modifica.png"
								alt="Modifica Socio" height="25px" width="25px">
						</a>
						<a href="inserisciFinanziamentoSocio?idSocio=${socioData.idSocio}">
								<img title="Inserisci Finanziamento" src="images/icons/add.png"
								alt="Modifica Socio" height="25px" width="25px">
						</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#elencoSoci').DataTable();
		});
	</script>
</body>
</html>