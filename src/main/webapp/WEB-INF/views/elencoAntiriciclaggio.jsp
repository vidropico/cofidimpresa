<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="head.jsp"></jsp:include>
<body>
	<jsp:include page="testata.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<jsp:include page="messages.jsp" />
	<div style="margin-top: 80px">
		<table id="antiriciclaggioTable" class="display responsive nowrap"
			style="width: 100%">
			<thead>
				<tr>
					<th>NOMINATIVO</th>
					<th>TIPO DOCUMENTO</th>
					<th>NUMERO DOCUMENTO</th>
					<th>DATA RILASCIO</th>
					<th>LUOGO RILASCIO</th>
					<th>DATA SCADENZA</th>
					<th>AUTORITA' COMPETENTE</th>
					<th>NUMERO PROGRESSIVO</th>
					<th>ANNO</th>
					<th>STAMPATO</th>
					<th>AZIONI</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="antiriciclaggio" items="${antiriciclaggioList}">
					<tr>
						<td>${antiriciclaggio.nominativo}</td>
						<td>${antiriciclaggio.idDocumento}</td>
						<td>${antiriciclaggio.numeroDocumento}</td>
						<td>${antiriciclaggio.dataRilascio}</td>
						<td>${antiriciclaggio.luogoRilascio}</td>
						<td>${antiriciclaggio.dataScadenza}</td>
						<td>${antiriciclaggio.autoritaCompetente}</td>
						<td>${antiriciclaggio.numeroProgressivo}</td>
						<td>${antiriciclaggio.annoProgressivo}</td>
						<c:choose>
							<c:when test="${antiriciclaggio.flagStampa eq '0'}">
								<td>NO</td>
								<td><a href="modAntiriciclaggio?idAnt=${antiriciclaggio.idAntiriciclaggio}"><img
								title="Modifica Antiriciclaggio" src="images/icons/modifica.png"
								alt="Modifica Antiriciclaggio" height="25px" width="25px"></a></td>
							</c:when>
							<c:otherwise>
								<td>SI</td>
								<td></td>
							</c:otherwise>
						</c:choose>							
						
					</tr>					
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">		
		$(document).ready(function() {
			$('#antiriciclaggioTable').DataTable();
		});
	</script>
</body>
</html>