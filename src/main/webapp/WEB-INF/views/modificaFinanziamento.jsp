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
			<li><a data-toggle="tab" aria-expanded="false" id="i2"><span
					class="nmbr">2</span>Finanziamento Banca</a></li>
			<li><a data-toggle="tab" aria-expanded="false" id="i3"><span
					class="nmbr">3</span>Incaglio</a></li>
			<li><a data-toggle="tab" aria-expanded="false" id="i4"><span
					class="nmbr">4</span>Sofferenza</a></li>
			<li><a data-toggle="tab" aria-expanded="false" id="i5"><span
					class="nmbr">5</span>Contensioso</a></li>
			<li><a data-toggle="tab" aria-expanded="false" id="i6"><span
			class="nmbr">6</span>Antiriciclaggio</a></li>
		</ul>
	</div>

	<div class="wrap" style="margin-top: 10px; margin-bottom: 50px;">
		<form:form action="updateFinanziamento" method="POST"
			class="form-signin" modelAttribute="finanziamentiData">
			<div id="i9">
				<input id="idFinanziamenti" name="idFinanziamenti"
					value="${finanziamentiData.idFinanziamenti}" type="hidden">
				<input id="idSoci" name="idSoci"
					value="${finanziamentiData.idSoci}" type="hidden">
				<label for="Impresa" style="margin-left: -160px;">Impresa </label> <input
					id="Impresa" name="Impresa" value="${impresa}" type="text"
					placeholder="Impresa" readonly>
				<div class="bar">
					<i></i>
				</div>

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
				<label for="costoIstruttoria" style="margin-left: -160px;">Istruttoria
				</label> <input id="costoIstruttoria" name="costoIstruttoria"
					value="${finanziamentiData.costoIstruttoria}" type="number" 
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
				<label for="idBanche" style="margin-left: -160px;">Banca </label> <select
					id="idBanche" name="idBanche">
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
				</select> <label for="importo" style="margin-left: -160px;">Importo
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
				<label for="importoRata" style="margin-left: -160px;">Importo
					Rata</label> <input id="importoRata" name="importoRata"
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
				<label for="accredito" style="margin-left: -160px;">Accredito
				</label> <input id="accredito" name="accredito"
					value="${finanziamentiData.accredito}" type="text"
					placeholder="Accredito">
				<div class="bar">
					<i></i>
				</div>
				<label for="impQuotaBanca" style="margin-left: -160px;">Quote Socio Banca
				</label> <input id="impQuotaBanca" name="impQuotaBanca"
					value="${finanziamentiData.impQuotaBanca}" type="text">
				<div class="bar">
					<i></i>
				</div>
				<label for="istruttoriaBanca" style="margin-left: -160px;">Istruttoria Erogata
				</label> <input id="istruttoriaBanca" name="istruttoriaBanca"
					value="${finanziamentiData.istruttoriaBanca}" type="text">
				<div class="bar">
					<i></i>
				</div>
				<label for="flgUsura" style="margin-left: -160px;">Prevenzione Usura</label> 

				<c:choose>
				<c:when test="${finanziamentiData.flgUsura eq 0}">
					<select id="flgUsura" name="flgUsura">
						<option value="0" selected>No</option>
						<option value="1" >Si</option>
					</select>
				</c:when>
				<c:otherwise>
					<select id="flgUsura" name="flgUsura">
						<option value="0" >No</option>
						<option value="1" selected>Si</option>
					</select>
				</c:otherwise>
				</c:choose>
				 
				<div class="bar">
					<i></i>
				</div>
				
			</div>

			<div id="i11">
				<label for="rateScadute" style="margin-left: -160px;">Rate
					Scadute </label> <input id="rateScadute" name="rateScadute"
					value="${finanziamentiData.rateScadute}" type="text"
					placeholder="Rate Scadute">
				<div class="bar">
					<i></i>
				</div>
				<label for="importoScaduto" style="margin-left: -160px;">Importo
					Scaduto</label> <input id="importoScaduto" name="importoScaduto"
					value="${finanziamentiData.importoScaduto}" type="text"
					placeholder="Importo Scaduto">
				<div class="bar">
					<i></i>
				</div>
			</div>
			<div id="i12">
				<select id="pagamento" name="pagamento">
					<c:choose>
						<c:when test="${finanziamentiData.pagamento eq 0}">
							<option value="0" selected>No</option>
							<option value="1">Yes</option>
						</c:when>
						<c:otherwise>
							<option value="0">No</option>
							<option value="1" selected>Yes</option>
						</c:otherwise>
					</c:choose>
				</select> <label for="tipologiaRientro" style="margin-left: -160px;">Tipologia
					Rientro</label> <input id="tipologiaRientro" name="tipologiaRientro"
					value="${finanziamentiData.tipologiaRientro}" type="text"
					placeholder="Tipologia Rientro">
				<div class="bar">
					<i></i>
				</div>

				<label for="pianoRientro" style="margin-left: -160px;">Piano
					di Rientro</label> <input id="pianoRientro" name="pianoRientro"
					value="${finanziamentiData.pianoRientro}" type="text"
					placeholder="Piano di Rientro">
				<div class="bar">
					<i></i>
				</div>
			</div>

			<div id="i13">
				<label for="nomeAvvocato" style="margin-left: -160px;">Affidata
					all'Avvocato</label> <input id="nomeAvvocato" name="nomeAvvocato"
					value="${finanziamentiData.nomeAvvocato}" type="text"
					placeholder="Affidata all'Avvocato">
				<div class="bar">
					<i></i>
				</div>

				<label for="azioni" style="margin-left: -160px;">Azioni </label> <input
					id="azioni" name="azioni" value="${finanziamentiData.azioni}"
					type="text" placeholder="Azioni">
				<div class="bar">
					<i></i>
				</div>

				<label for="risultato" style="margin-left: -160px;">Risultato
				</label> <input id="risultato" name="risultato"
					value="${finanziamentiData.pianoRientro}" type="text"
					placeholder="Risultato">
				<div class="bar">
					<i></i>
				</div>
				<input type="submit" value="Salva" style="margin-top: 35px;">
			</div>			
		</form:form>
	</div>
	
	<div id="i14">
		<a href="inserisciAntiriciclaggio?idFin=${finanziamentiData.idFinanziamenti}&idSoci=${finanziamentiData.idSoci}">
		<img title="Antiriciclaggio" src="images/icons/antiriciclaggio.png"
		alt="Antiriciclaggio" height="25px" width="25px"></a>
		<br>
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
		$('.wizard li').click(function() {
			$(this).prevAll().addClass("completed");
			$(this).nextAll().removeClass("completed")
		});
		
		$(document).ready(function() {
			$('#antiriciclaggioTable').DataTable();
		});
	</script>
</body>
</html>