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
	
	<div class="tabbable" style="margin-top: 20px;">
		<ul class="nav nav-tabs wizard">
			<li class="active"><a data-toggle="tab" aria-expanded="false"
				id="i1"><span class="nmbr">1</span>Finanziamento Cofidi</a></li>
			<li><a data-toggle="tab" aria-expanded="false"
				id="i2"><span class="nmbr">2</span>Finanziamento Banca</a></li>
	</div>

	<div class="wrap" style="margin-top: 10px; margin-bottom: 50px;">
		<form:form action="inserisciFin" method="POST"
			class="form-signin" modelAttribute="finanziamentiData">
			<div id="i9">
				<input id="idSoci" name="idSoci"
					value="${finanziamentiData.idSoci}" type="hidden">
				<c:choose>
					<c:when test="${not empty finanziamentiData.idSoci}">
						<label for="Impresa" style="margin-left: -160px;">Impresa </label> <input
						id="Impresa" name="Impresa" value="${impresa}" type="text"
						placeholder="P Iva">
						<div class="bar">
							<i></i>
						</div>
					</c:when>
					<c:otherwise>
						<label for="piva" style="margin-left: -160px;">Impresa (Partita Iva)</label> <input
						id="piva" name="piva" value="${piva}" type="text"
						placeholder="P Iva">
						<div class="bar">
							<i></i>
						</div>
					</c:otherwise>
				</c:choose>
				<label for="idStatoFinanziamenti" style="margin-left: -160px;">Stato
					Finanziamenti </label> <select id="idStatoFinanziamenti"
					name="idStatoFinanziamenti">
					<c:forEach var="statoFin" items="${statoFinList}">
						<c:choose>
							<c:when
								test="${finanziamentiData.idStatoFinanziamenti eq statoFin.id}">
								<option value="${statoFin.id}" selected>${statoFin.descrizione}</option>
							</c:when>
							<c:otherwise>
								<option value="${statoFin.id}">${statoFin.descrizione}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<div class="bar">
					<i></i>
				</div>
				<label for="importoRichiesto" style="margin-left: -160px;">Importo
					Richiesto:</label> <input id="importoRichiesto" name="importoRichiesto"
					value="${finanziamentiData.importoRichiesto}" type="text"
					placeholder="Importo Richiesto">
				<div class="bar">
					<i></i>
				</div>
				<label for="importoDeliberato" style="margin-left: -160px;">Importo
					Deliberato </label> <input id="importoDeliberato" name="importoDeliberato"
					value="${finanziamentiData.importoDeliberato}" type="number"
					min="0.00" step="0.01" max="500000"
					placeholder="Importo Deliberato">
				<div class="bar">
					<i></i>
				</div>
								
				<label for="dataApprovazioneConsiglio" style="margin-left: -160px;">Data
					Approvazione Consiglio</label> <input id="dataApprovazioneConsiglio"
					name="dataApprovazioneConsiglio"
					value="${finanziamentiData.dataApprovazioneConsiglio}" type="text"
					placeholder="Data Approvazione Consiglio">
				<div class="bar">
					<i></i>
				</div>
			
				<label for="naturaFinanziamento" style="margin-left: -160px;">Natura
					Finaniamento</label> <input id="naturaFinanziamento"
					name="naturaFinanziamento"
					value="${finanziamentiData.naturaFinanziamento}" type="text"
					placeholder="Natura Finanziamento">
				<div class="bar">
					<i></i>
				</div>
				<label for="idGaranzia" style="margin-left: -160px;">Controgaranzia
				</label> <select id="idGaranzia" name="idGaranzia">
				<option value="0" selected>Nessuna Controgaranzia</option>
					<c:forEach var="garanzia" items="${garanziaList}">
						<c:choose>
							<c:when test="${finanziamentiData.idGaranzia eq garanzia.id}">
								<option value="${garanzia.id}" selected>${garanzia.descrizione}</option>
							</c:when>
							<c:otherwise>
								<option value="${garanzia.id}">${garanzia.descrizione}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select> <label for="percentualeGaranzia" style="margin-left: -160px;">Percentuale
					Garanzia</label> <input id="percentualeGaranzia" name="percentualeGaranzia"
					value="${finanziamentiData.percentualeGaranzia}" type="text"
					placeholder="Percentuale Garanzia">
				<div class="bar">
					<i></i>
				</div>
				<label for="costi" style="margin-left: -160px;">Costi
					Finanziamento</label> <input id="costi" name="costi"
					value="${finanziamentiData.costi}" type="text"
					placeholder="Costi Finanziamento">
				<div class="bar">
					<i></i>
				</div>
				<label for="importoGaranzia" style="margin-left: -160px;">Importo
					Garantito </label> <input id="importoGaranzia" name="importoGaranzia"
					value="${finanziamentiData.importoGaranzia}" type="number"
					min="0.00" step="0.01" max="500000" placeholder="Importo Garantito">
				<div class="bar">
					<i></i>
				</div>
				<label for="rateRichieste" style="margin-left: -160px;">Rate Richieste</label> <input
					id="rateRichieste" name="rateRichieste" value="${finanziamentiData.rateRichieste}" type="text"
					placeholder="Rate Richieste">
				<div class="bar">
					<i></i>
				</div>
				<label for="costoIstruttoria" style="margin-left: -160px;">Istruttoria </label> <input
					id="costoIstruttoria" name="costoIstruttoria" value="${finanziamentiData.costoIstruttoria}"  type="number"
					min="0.00" step="10.00" max="500000" placeholder="Istruttoria">
				<div class="bar">
					<i></i>
				</div>				
				<label for="note" style="margin-left: -160px;">Note</label> <input
					id="note" name="note" value="${finanziamentiData.note}" type="text"
					placeholder="Note">
				<div class="bar">
					<i></i>
				</div>
			</div>

			<div id="i10">
				<label for="idBanche" style="margin-left: -160px;">Banca </label> 
				<select id="idBanche" name="idBanche">
					<c:forEach var="banca" items="${bancheList}">
						<c:choose>
							<c:when test="${finanziamentiData.idBanche eq banca.id}">
								<option value="${banca.id}" selected>${banca.descrizione}</option>
							</c:when>
							<c:otherwise>
								<option value="${banca.id}">${banca.descrizione}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select> 
				<div class="bar">
					<i></i>
				</div>
				<label for="importo" style="margin-left: -160px;">Importo
					Erogato:</label> <input id="importo" name="importo"
					value="${finanziamentiData.importo}" type="text"
					placeholder="Importo Erogato">
				<div class="bar">
					<i></i>
				</div>
				<label for="rate" style="margin-left: -160px;">Rate </label> <input
					id="rate" name="rate" value="${finanziamentiData.rate}" type="text"
					placeholder="Rate">
				<div class="bar">
					<i></i>
				</div>
				<label for="importoRata" style="margin-left: -160px;">Importo Rata</label>
				<input id="importoRata" name="importoRata"
					value="${finanziamentiData.importoRata}" type="text"
					placeholder="Importo Rata">
				<div class="bar">
					<i></i>
				</div>
					<label for="dataErogazioneFinanziamento"
					style="margin-left: -160px;">Data Erogazione
					Finananziamento </label> <input id="dataErogazioneFinanziamento"
					name="dataErogazioneFinanziamento"
					value="${finanziamentiData.dataErogazioneFinanziamento}"
					type="text" placeholder="Data Erogazione Finananziamento">
				<div class="bar">
					<i></i>
				</div>
				<label for="dataFineFinanziamento" style="margin-left: -160px;">Data
					Fine Finanziamento</label> <input id="dataFineFinanziamento"
					name="dataFineFinanziamento"
					value="${finanziamentiData.dataFineFinanziamento}" type="text"
					placeholder="Data Fine Finanziamento">
				<div class="bar">
					<i></i>
				</div>
				<label for="accredito" style="margin-left: -160px;">Accredito </label> <input
					id="accredito" name="accredito" value="${finanziamentiData.accredito}" type="text"
					placeholder="Accredito">
				<div class="bar">
					<i></i>
				</div>				
				<input type="submit" value="Salva" style="margin-top: 35px;">
			</div>
	</form:form>
	</div>
	<script type="text/javascript">
		$('.wizard li').click(function() {
			$(this).prevAll().addClass("completed");
			$(this).nextAll().removeClass("completed")
		});
	</script>
</body>
</html>