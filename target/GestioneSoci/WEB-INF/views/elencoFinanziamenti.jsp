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
		<table id="example" class="display responsive nowrap"
			style="width: 100%">
			<thead>
				<tr>
					<th>IMPRESA</th>
					<th>IMPORTO DELIBERATO</th>
					<th>IMPORTO EROGATO</th>
					<th>IMPORTO GARANZIA</th>
					<th>PERCENTUALE GARANZIA</th>
					<th>RATE</th>
					<th>DATA APPROVAZIONE CONSIGLIO</th>
					<th>DATA EROGAZIONE FINANZIAMENTO</th>
					<th>STATO</th>
					<th>AZIONI</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="finanziamentoData"
					items="${finanziamentiTableDatas}">
					<tr>
						<td>${finanziamentoData.impresa}</td>
						<td>&euro; ${finanziamentoData.importoDeliberato}</td>
						<td>&euro; ${finanziamentoData.importoErogato}</td>
						<td>&euro; ${finanziamentoData.importoGaranzia}</td>
						<td>${finanziamentoData.percentualeGaranzia}</td>
						<td>${finanziamentoData.rate}</td>
						<td>${finanziamentoData.dataApprovazioneConsiglio}</td>
						<td>${finanziamentoData.dataErogazioneFinanziamento}</td>
						<td>${finanziamentoData.stato}</td>
						<td><a href="modificaFinanziamento?idFin=${finanziamentoData.idFinanziamenti}"><img
								title="Modifica Finanziamento" src="images/icons/modifica.png"
								alt="Modifica Finanziamento" height="25px" width="25px"></a> 
							<a href="addebitoBanca?idSocio=${finanziamentoData.idSocio}&idFinanziamenti=${finanziamentoData.idFinanziamenti}">
								<img title="Addebito Banca" src="images/icons/addebitoBanca.png"
								alt="Addebito Banca" height="25px" width="25px"></a>
							<a href="domandaBanca?idSocio=${finanziamentoData.idSocio}&idFinanziamenti=${finanziamentoData.idFinanziamenti}">
								<img title="Domanda Banca" src="images/icons/domandaBanca.png"
								alt="Domanda Banca" height="25px" width="25px"></a>
							<a href="ricapitolo?idSocio=${finanziamentoData.idSocio}&idFinanziamenti=${finanziamentoData.idFinanziamenti}">
								<img title="Ricapitolo" src="images/icons/ricapitolo.png"
								alt="Ricapitolo" height="25px" width="25px"></a>
							<a href="inserisciAntiriciclaggio?idFin=${finanziamentoData.idFinanziamenti}&idSoci=${finanziamentoData.idSocio}">
								<img title="Antiriciclaggio" src="images/icons/antiriciclaggio.png"
								alt="Antiriciclaggio" height="25px" width="25px"></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
</body>
</html>