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

	<div class="col-sm-12" style="margin-top: 10px; margin-bottom: 50px;">
		<form:form action="updateFinanziamento" method="POST"
			class="form-signin" modelAttribute="finanziamentiData">
			<div id="i9">
				<form:input path="idFinanziamenti"
					value="${finanziamentiData.idFinanziamenti}" type="hidden"/>
				<form:input path="idSoci"
					value="${finanziamentiData.idSoci}" type="hidden"/>
					
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
					<label for="Impresa" >Impresa </label><br> 
					<input name="Impresa" id="impresa" value="${impresa}" type="text" readonly/>
				</div>
				<div class="col-sm-3">
				<label for="idStatoFinanziamenti" >Stato
					Finanziamenti </label><br> 
					<form:select path="idStatoFinanziamenti">
					<c:forEach var="statoFin" items="${statoFinList}">
						<c:choose>
							<c:when
								test="${finanziamentiData.idStatoFinanziamenti eq statoFin.id}">
								<form:option value="${statoFin.id}" label="${statoFin.descrizione}" selected="true" />
							</c:when>
							<c:otherwise>
								<form:option value="${statoFin.id}" label="${statoFin.descrizione}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					</form:select>
				</div>
				<div class="col-sm-3">
				<label for="importoRichiesto" >Importo
					Richiesto:</label><br> <form:input path="importoRichiesto"
					value="${finanziamentiData.importoRichiesto}" type="text"/>
					<form:errors path="importoRichiesto" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<label for="importoDeliberato" >Importo
					Deliberato </label><br> <form:input path="importoDeliberato"
					value="${finanziamentiData.importoDeliberato}" type="number"
					min="0.00" step="0.01" max="500000"/>
					<form:errors path="importoDeliberato" cssClass="error"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">			
				<label for="dataApprovazioneConsiglio" >Data
					Approvazione Consiglio</label><br> <form:input path="dataApprovazioneConsiglio"
					value="${finanziamentiData.dataApprovazioneConsiglio}" type="text"/>
					<form:errors path="dataApprovazioneConsiglio" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<label for="naturaFinanziamento" >Natura
					Finaniamento</label><br> <form:input path="naturaFinanziamento"
					value="${finanziamentiData.naturaFinanziamento}" type="text"/>
				</div>
				<div class="col-sm-3">
				<label for="idGaranzia" >Controgaranzia
				</label><br> <form:select path="idGaranzia">
				<option value="0" selected>Nessuna Controgaranzia</option>
					<c:forEach var="garanzia" items="${garanziaList}">
						<c:choose>
							<c:when test="${finanziamentiData.idGaranzia eq garanzia.id}">
								<form:option value="${garanzia.id}" label="${garanzia.descrizione}" selected="true"/>
							</c:when>
							<c:otherwise>
								<form:option value="${garanzia.id}" label="${garanzia.descrizione}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select> 
				</div>
				<div class="col-sm-3">
				<label for="percentualeGaranzia" >Percentuale
					Garanzia</label><br> <form:input path="percentualeGaranzia"
					value="${finanziamentiData.percentualeGaranzia}" type="text"/>
					<form:errors path="percentualeGaranzia" cssClass="error"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">			
				<label for="costi" >Costi
					Finanziamento</label><br> <form:input path="costi"
					value="${finanziamentiData.costi}" type="text"/>
				</div>
				<div class="col-sm-3">			
				<label for="importoGaranzia" >Importo
					Garantito </label><br> <form:input path="importoGaranzia"
					value="${finanziamentiData.importoGaranzia}" type="number"
					min="0.00" step="0.01" max="500000"/>
					<form:errors path="importoGaranzia" cssClass="error"/>
				</div>
				<div class="col-sm-3">			
				<label for="rateRichieste" >Rate Richieste</label><br> <form:input
					path="rateRichieste" value="${finanziamentiData.rateRichieste}" type="text"/>
					<form:errors path="rateRichieste" cssClass="error"/>
				</div>
				<div class="col-sm-3">			
				<label for="costoIstruttoria" >Istruttoria </label><br> <form:input
					path="costoIstruttoria" value="${finanziamentiData.costoIstruttoria}"  type="number"
					min="0.00" step="10.00" max="500000" />
				</div>				
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">			
				<label for="note" >Note</label><br> <form:textarea
					path="note" rows="10" cols="100" value="${finanziamentiData.note}" type="text"/>
				</div>
			</div>
			</div>

			<div id="i10">
				<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<label for="idBanche" >Banca </label><br> 
				<form:select path="idBanche">
					<c:forEach var="banca" items="${bancheList}">
						<c:choose>
							<c:when test="${finanziamentiData.idBanche eq banca.id}">
								<form:option value="${banca.id}" label="${banca.descrizione}" selected="true"/>
							</c:when>
							<c:otherwise>
								<form:option value="${banca.id}" label="${banca.descrizione}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select> 
				</div>
				<div class="col-sm-3">
				<label for="importo" >Importo
					Erogato:</label><br> <form:input path="importo"
					value="${finanziamentiData.importo}" type="text"/>
					<form:errors path="importo" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<label for="rate" >Rate </label><br> <form:input
					path="rate" value="${finanziamentiData.rate}" type="text"/>
					<form:errors path="rate" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<label for="importoRata" >Importo Rata</label><br>
				<form:input path="importoRata"
					value="${finanziamentiData.importoRata}" type="text"/>
					<form:errors path="importoRata" cssClass="error"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<label for="dataErogazioneFinanziamento"
					>Data Erogazione
					Finananziamento </label><br> <form:input path="dataErogazioneFinanziamento"
					value="${finanziamentiData.dataErogazioneFinanziamento}"
					type="text" />
					<form:errors path="dataErogazioneFinanziamento" cssClass="error"/>
				</div>
				<div class="col-sm-3">	
				<label for="dataFineFinanziamento" >Data
					Fine Finanziamento</label><br> <form:input path="dataFineFinanziamento"
					value="${finanziamentiData.dataFineFinanziamento}" type="text"/>
					<form:errors path="dataFineFinanziamento" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<label for="accredito" >Accredito </label><br> 
				<form:input path="accredito" value="${finanziamentiData.accredito}" type="text"/>
				<form:errors path="accredito" cssClass="error"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">				
				<label for="impQuotaBanca" >Quote Socio Banca
				</label><br> <form:input path="impQuotaBanca"
					value="${finanziamentiData.impQuotaBanca}" type="text"/>
					<form:errors path="impQuotaBanca" cssClass="error"/>
				</div>
				<div class="col-sm-3">				
				<label for="istruttoriaBanca" >Istruttoria Erogata
				</label><br> <form:input path="istruttoriaBanca"
					value="${finanziamentiData.istruttoriaBanca}" type="text"/>
					<form:errors path="istruttoriaBanca" cssClass="error"/>
				</div>
				<div class="col-sm-3">								
				<label for="flgUsura">Prevenzione Usura</label><br> 
				<c:choose>
				<c:when test="${finanziamentiData.flgUsura eq 0}">
					<form:select path="flgUsura">
						<form:option value="0" label="No" selected="true"/>
						<form:option value="1" label="Si"/>
					</form:select>
				</c:when>
				<c:otherwise>
					<form:select path="flgUsura">
						<form:option value="0" label="No"/>
						<form:option value="1" label="Si" selected="true"/>
					</form:select>
				</c:otherwise>
				</c:choose>
				</div>
			</div>
			</div>

			<div id="i11">
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">				
				<label for="rateScadute">Rate
					Scadute </label><br> <form:input path="rateScadute"
					value="${finanziamentiData.rateScadute}" type="text"/>
				</div>
				<div class="col-sm-3">				
				<label for="importoScaduto">Importo
					Scaduto</label><br> <form:input path="importoScaduto"
					value="${finanziamentiData.importoScaduto}" type="text"/>
				</div>
			</div>
			</div>
			<div id="i12">
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<label for="pagamento">Pagamento</label><br>				
				<form:select path="pagamento">
					<c:choose>
						<c:when test="${finanziamentiData.pagamento eq 0}">
							<form:option value="0" label="No" selected="true"/>
							<form:option value="1" label="Yes"/>
						</c:when>
						<c:otherwise>
							<form:option value="0" label="No"/>
							<form:option value="1" label="Yes" selected="true"/>
						</c:otherwise>
					</c:choose>
				</form:select> 
				</div>
				<div class="col-sm-3">				
				<label for="tipologiaRientro">Tipologia
					Rientro</label><br> <form:input path="tipologiaRientro"
					value="${finanziamentiData.tipologiaRientro}" type="text"/>
				</div>
				<div class="col-sm-3">				
				<label for="pianoRientro" >Piano
					di Rientro</label><br> <form:input path="pianoRientro"
					value="${finanziamentiData.pianoRientro}" type="text"/>
				</div>
			</div>
			</div>

			<div id="i13">
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">				
				<label for="nomeAvvocato" >Affidata
					all'Avvocato</label><br> <form:input path="nomeAvvocato"
					value="${finanziamentiData.nomeAvvocato}" type="text"/>
				</div>
				<div class="col-sm-3">
				<label for="azioni" >Azioni </label><br> 
				<form:input path="azioni" value="${finanziamentiData.azioni}"
					type="text" />
				</div>
				<div class="col-sm-3">
				<label for="risultato" >Risultato
				</label><br> <form:input path="risultato"
					value="${finanziamentiData.pianoRientro}" type="text"/>
				</div>
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