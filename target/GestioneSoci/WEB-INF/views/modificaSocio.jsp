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
				id="i1"><span class="nmbr">1</span>Anagrafica Azienda</a></li>
			<li><a data-toggle="tab" aria-expanded="false" id="i2"><span
					class="nmbr">2</span>Indirizzi Azienda</a></li>
			<li><a data-toggle="tab" aria-expanded="false" id="i3"><span
					class="nmbr">3</span>Anagrafica Titolare</a></li>
			<li><a data-toggle="tab" aria-expanded="false" id="i4"><span
					class="nmbr">4</span>Iscrizione Cofidi</a></li>
			<li><a data-toggle="tab" aria-expanded="true" id="i5"><span
					class="nmbr">5</span>Finanziamenti</a></li>
		</ul>
	</div>

	<div class="wrap" style="margin-top: 10px; margin-bottom: 50px;">
		<form:form action="updateSocio" method="POST" class="form-signin"
			modelAttribute="sociData">
			<div id="i9">
				<input id="idSoci" name="idSoci" value="${sociData.idSoci}"
					type="hidden"> <label for="impresa"
					style="margin-left: -160px;">Denominazione sociale</label> <input
					id="impresa" name="impresa" value="${sociData.impresa}" type="text"
					placeholder="Denominazione sociale">
				<div class="bar">
					<i></i>
				</div>
				<label for="idTipoSocieta" style="margin-left: -160px;">Tipo
					Società</label> <select id="idTipoSocieta" name="idTipoSocieta">
					<c:forEach var="tipoSocieta" items="${tipoSocietaList}">
						<c:choose>
							<c:when test="${sociData.idTipoSocieta eq tipoSocieta.id}">
								<option value="${tipoSocieta.id}" selected>${tipoSocieta.descrizione}</option>
							</c:when>
							<c:otherwise>
								<option value="${tipoSocieta.id}">${tipoSocieta.descrizione}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<div class="bar">
					<i></i>
				</div>
				<label for="codiceFiscale" style="margin-left: -160px;">Codice
					Fiscale</label> <input id="codiceFiscale" name="codiceFiscale"
					value="${sociData.codiceFiscale}" type="text"
					placeholder="Codice Fiscale">
				<div class="bar">
					<i></i>
				</div>
				<label for="partitaIva" style="margin-left: -160px;">Partita
					Iva</label> <input id="partitaIva" name="partitaIva"
					value="${sociData.partitaIva}" type="text"
					placeholder="Partita Iva">
				<div class="bar">
					<i></i>
				</div>
				<label for="idSettoreImpresa" style="margin-left: -160px;">Settore
					d'Impresa</label> <select id="idSettoreImpresa" name="idSettoreImpresa">
					<c:forEach var="settoreImpresa" items="${settoreImpresaList}">
						<c:choose>
							<c:when test="${sociData.idSettoreImpresa eq settoreImpresa.id}">
								<option value="${settoreImpresa.id}" selected>${settoreImpresa.descrizione}</option>
							</c:when>
							<c:otherwise>
								<option value="${settoreImpresa.id}">${settoreImpresa.descrizione}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<div class="bar">
					<i></i>
				</div>
				<label for="numeroDipendenti" style="margin-left: -160px;">Numero
					Addetti</label> <input id="numeroDipendenti" name="numeroDipendenti"
					value="${sociData.numeroDipendenti}" type="text"
					placeholder="Numero Addetti">
				<div class="bar">
					<i></i>
				</div>
				<label for="dataCostituzione" style="margin-left: -160px;">Data
					Costituzione</label> <input id="dataCostituzione" name="dataCostituzione"
					value="${sociData.dataCostituzione}" type="text"
					placeholder="Data Costituzione">
				<div class="bar">
					<i></i>
				</div>
				<label for="dataAttivita" style="margin-left: -160px;">Data
					Inizio Attività</label> <input id="dataAttivita" name="dataAttivita"
					value="${sociData.dataAttivita}" type="text"
					placeholder="Data Inizio Attività">
				<div class="bar">
					<i></i>
				</div>
				<label for="telefono" style="margin-left: -160px;">Telefono</label>
				<input id="telefono" name="telefono" value="${sociData.telefono}"
					type="text" placeholder="Telefono">
				<div class="bar">
					<i></i>
				</div>
				<label for="mobile" style="margin-left: -160px;">Cellulare</label> <input
					id="mobile" name="mobile" value="${sociData.mobile}" type="text"
					placeholder="Cellulare">
				<div class="bar">
					<i></i>
				</div>
				<label for="email" style="margin-left: -160px;">E-Mail</label> <input
					id="email" name="email" value="${sociData.email}" type="text"
					placeholder="E-Mail">
				<div class="bar">
					<i></i>
				</div>
				<label for="fax" style="margin-left: -160px;">Fax</label> <input
					id="fax" name="fax" value="${sociData.fax}" type="text"
					placeholder="Fax">
				<div class="bar">
					<i></i>
				</div>
			</div>


			<div id="i10">
				<label for="indirizzoSedeLegale" style="margin-left: -160px;">Indirizzo
					Sede Legale</label> <input id="indirizzoSedeLegale"
					name="indirizzoSedeLegale" value="${sociData.indirizzoSedeLegale}"
					type="text" placeholder="Indirizzo Sede Legale">
				<div class="bar">
					<i></i>
				</div>
				<label for="cittaSedeLegale" style="margin-left: -160px;">Città
					Sede Legale</label> <input id="cittaSedeLegale" name="cittaSedeLegale"
					value="${sociData.cittaSedeLegale}" type="text"
					placeholder="Città Sede Legale">
				<div class="bar">
					<i></i>
				</div>
				<label for="capSedeLegale" style="margin-left: -160px;">Cap
					Sede Legale</label> <input id="capSedeLegale" name="capSedeLegale"
					value="${sociData.capSedeLegale}" type="text"
					placeholder="Cap Sede Legale">
				<div class="bar">
					<i></i>
				</div>
				<label for="provinciaSedeLegale" style="margin-left: -160px;">Provincia
					Sede Legale</label> <input id="provinciaSedeLegale"
					name="provinciaSedeLegale" value="${sociData.provinciaSedeLegale}"
					type="text" placeholder="Provincia Sede Legale">
				<div class="bar">
					<i></i>
				</div>
				<label for="indirizzoAzienda" style="margin-left: -160px;">Indirizzo
					Azienda</label> <input id="indirizzoAzienda" name="indirizzoAzienda"
					value="${sociData.indirizzoAzienda}" type="text"
					placeholder="Indirizzo Sede Azienda">
				<div class="bar">
					<i></i>
				</div>
				<label for="cittaAzienda" style="margin-left: -160px;">Città
					Azienda</label> <input id="cittaAzienda" name="cittaAzienda"
					value="${sociData.cittaAzienda}" type="text"
					placeholder="Città Sede Azienda">
				<div class="bar">
					<i></i>
				</div>
				<label for="capAzienda" style="margin-left: -160px;">Cap
					Azienda</label> <input id="capAzienda" name="capAzienda"
					value="${sociData.capAzienda}" type="text"
					placeholder="Cap Sede Azienda">
				<div class="bar">
					<i></i>
				</div>
				<label for="provinciaAzienda" style="margin-left: -160px;">Provincia
					Azienda</label> <input id="provinciaAzienda" name="provinciaAzienda"
					value="${sociData.provinciaAzienda}" type="text"
					placeholder="Provincia Sede Azienda">
				<div class="bar">
					<i></i>
				</div>
				<label for="indirizzoSedeOperativa" style="margin-left: -160px;">Indirizzo
					Sede Operativa</label> <input id="indirizzoSedeOperativa"
					name="indirizzoSedeOperativa"
					value="${sociData.indirizzoSedeOperativa}" type="text"
					placeholder="Indirizzo Sede Operativa">
				<div class="bar">
					<i></i>
				</div>
				<label for="cittaSedeOperativa" style="margin-left: -160px;">Città
					Sede Operativa</label> <input id="cittaSedeOperativa"
					name="cittaSedeOperativa" value="${sociData.cittaSedeOperativa}"
					type="text" placeholder="Città Sede Operativa">
				<div class="bar">
					<i></i>
				</div>
				<label for="capSedeOperativa" style="margin-left: -160px;">Cap
					Sede Operativa</label> <input id="capSedeOperativa" name="capSedeOperativa"
					value="${sociData.capSedeOperativa}" type="text"
					placeholder="Cap Sede Operativa">
				<div class="bar">
					<i></i>
				</div>
				<label for="provinciaSedeOperativa" style="margin-left: -160px;">Provincia
					Sede Operativa</label> <input id="provinciaSedeOperativa"
					name="provinciaSedeOperativa"
					value="${sociData.provinciaSedeOperativa}" type="text"
					placeholder="Provincia Sede Operativa">
				<div class="bar">
					<i></i>
				</div>
			</div>

			<div id="i11">
				<label for="nome" style="margin-left: -160px;">Nome</label> <input
					id="nome" name="nome" value="${sociData.nome}" type="text"
					placeholder="Nome">
				<div class="bar">
					<i></i>
				</div>
				<label for="cognome" style="margin-left: -160px;">Cognome</label> <input
					id="cognome" name="cognome" value="${sociData.cognome}" type="text"
					placeholder="Cognome">
				<div class="bar">
					<i></i>
				</div>
				<label for="idQualitaTitolare" style="margin-left: -160px;">In
					qualità di</label> <select id="idQualitaTitolare" name="idQualitaTitolare">
					<c:forEach var="qualitaTitolare" items="${qualitaTitolareList}">
						<c:choose>
							<c:when
								test="${sociData.idQualitaTitolare eq qualitaTitolare.id}">
								<option value="${qualitaTitolare.id}" selected>${qualitaTitolare.descrizione}</option>
							</c:when>
							<c:otherwise>
								<option value="${qualitaTitolare.id}">${qualitaTitolare.descrizione}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<div class="bar">
					<i></i>
				</div>
				<label for="codiceFiscaleTitolare" style="margin-left: -160px;">Codice
					Fiscale</label> <input id="codiceFiscaleTitolare"
					name="codiceFiscaleTitolare"
					value="${sociData.codiceFiscaleTitolare}" type="text"
					placeholder="Codice Fiscale">
				<div class="bar">
					<i></i>
				</div>
				<label for="dataDiNascita" style="margin-left: -160px;">Data
					di Nascita</label> <input id="dataDiNascita" name="dataDiNascita"
					value="${sociData.dataDiNascita}" type="text"
					placeholder="Data di nascita">
				<div class="bar">
					<i></i>
				</div>
				<label for="luogoDiNascita" style="margin-left: -160px;">Luogo
					di Nascita</label> <input id="luogoDiNascita" name="luogoDiNascita"
					value="${sociData.luogoDiNascita}" type="text"
					placeholder="Luogo di Nascita">
				<div class="bar">
					<i></i>
				</div>
				<label for="indirizzoResidenza" style="margin-left: -160px;">Indirizzo
					di Residenza</label> <input id="indirizzoResidenza"
					name="indirizzoResidenza" value="${sociData.indirizzoResidenza}"
					type="text" placeholder="Indirizzo Residenza">
				<div class="bar">
					<i></i>
				</div>
				<label for="cittaResidenza" style="margin-left: -160px;">Città
					di Residenza</label> <input id="cittaResidenza" name="cittaResidenza"
					value="${sociData.cittaResidenza}" type="text"
					placeholder="Città Residenza">
				<div class="bar">
					<i></i>
				</div>
				<label for="capResidenza" style="margin-left: -160px;">Cap
					Residenza</label> <input id="capResidenza" name="capResidenza"
					value="${sociData.capResidenza}" type="text"
					placeholder="Cap Residenza">
				<div class="bar">
					<i></i>
				</div>
				<label for="provinciaResidenza" style="margin-left: -160px;">Provincia
					Residenza</label> <input id="provinciaResidenza" name="provinciaResidenza"
					value="${sociData.provinciaResidenza}" type="text"
					placeholder="Provincia Residenza">
				<div class="bar">
					<i></i>
				</div>
			</div>

			<div id="i12">
				<label for="dataInizio" style="margin-left: -160px;">Data
					Inizio Rapporto</label> <input type="text" id="dataInizio"
					name="dataInizio" placeholder="Data Inizio"
					value="${sociData.dataInizio}">
				<div class="bar">
					<i></i>
				</div>
				<label for="dataCessazione" style="margin-left: -160px;">Data
					Cessazione Rapporto</label> <input id="dataCessazione"
					name="dataCessazione" type="text"
					value="${sociData.dataCessazione}" placeholder="Data Cessazione">
				<div class="bar">
					<i></i>
				</div>
				<label for="cciaa" style="margin-left: -160px;">CCIAA</label> <input
					id="cciaa" name="cciaa" value="${sociData.cciaa}" type="text"
					placeholder="Iscritto alla CCIAA">
				<div class="bar">
					<i></i>
				</div>
				<label for="rea" style="margin-left: -160px;">REA</label> <input
					id="rea" name="rea" value="${sociData.rea}" type="text"
					placeholder="REA">
				<div class="bar">
					<i></i>
				</div>
				  <div class="row">
				        <div class="col-xs-5">
				            <select name="from[]" id="search" class="form-control" size="8" multiple="multiple" style="width: 300px;height: 300px;margin-left: -210px;">
				                <c:forEach var="ateco" items="${atecoList}">
									<option value="${ateco.id }">${ateco.descrizione}</option>
								</c:forEach>
				            </select>
				        </div>
				        
				        <div class="col-xs-4" style="margin-top: 20px !important;width: 70px;">
				        	<button type="button" id="search_rightSelected" class="btn btn-block"><i class="glyphicon glyphicon-chevron-right"></i></button>
				            <button type="button" id="search_leftSelected" class="btn btn-block"><i class="glyphicon glyphicon-chevron-left"></i></button>
				        </div>
				        
				        <div class="col-xs-3">
				            <select name="to[]" id="search_to" class="form-control" size="8" multiple="multiple" style="width: 300px;height:  300px;">
				            	<option value=""></option>
				            </select>
				        </div>
				    </div>
<!-- 				<select multiple id="idAteco" name="idAteco" -->
<!-- 					style="height: 210px; width: 1000px; margin-left: -350px ! important;"> -->
<%-- 					<c:forEach var="ateco" items="${atecoList}"> --%>
<%-- 						<option value="${ateco.id }">${ateco.descrizione}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
				<div class="bar">
					<i></i>
				</div>
				<label for="tipologiaMerceologica" style="margin-left: -160px;">Tipologia
					Merceologica</label> <input id="tipologiaMerceologica"
					name="tipologiaMerceologica"
					value="${sociData.tipologiaMerceologica}" type="text"
					placeholder="Tipologia Merceologica">
				<div class="bar">
					<i></i>
				</div>
				<label for="idStatoSocio" style="margin-left: -160px;">Stato
					Socio</label> <select id="idStatoSocio" name="idStatoSocio">
					<c:forEach var="statoSocio" items="${statoSocioList}">
						<c:choose>
							<c:when test="${sociData.idStatoSocio eq statoSocio.id}">
								<option value="${statoSocio.id}" selected>${statoSocio.descrizione}</option>
							</c:when>
							<c:otherwise>
								<option value="${statoSocio.id}">${statoSocio.descrizione}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<div class="bar">
					<i></i>
				</div>
				<label for="numeroLibroSoci" style="margin-left: -160px;">Numero
					Libro Soci</label> <input id="numeroLibroSoci" name="numeroLibroSoci"
					value="${sociData.numeroLibroSoci}" type="number"
					placeholder="Numero Libro Soci">
				<div class="bar">
					<i></i>
				</div>
				<label for="numeroQuote" style="margin-left: -160px;">Numero
					Quote</label> <input id="numeroQuote" name="numeroQuote"
					value="${sociData.numeroQuote}" type="number"
					placeholder="Numero Quote Pagate">
				<div class="bar">
					<i></i>
				</div>
				<label for="importoQuote" style="margin-left: -160px;">Importo
					Quote</label> <input id="importoQuote" name="importoQuote"
					value="${sociData.importoQuote}" type="number" min="0.00"
					step="0.01" max="500000" placeholder="Importo Quota">
				<div class="bar">
					<i></i>
				</div>
				<label for="utenteRegistrazione" style="margin-left: -160px;">Utente
					Registrazione</label> <input id="utenteRegistrazione"
					name="utenteRegistrazione" value="" type="text"
					placeholder="Utente che effettua la registrazione" readonly>
				<div class="bar">
					<i></i>
				</div>
				<div id="atecoTable">
					<table id="elencoSociAteco" class="display responsive nowrap"
						style="margin-top: 20px; width: 100%;">
						<thead>
							<tr>
								<th>CODICE ATECO - DESCIZIONE</th>
								<th>DELETE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ateco" items="${atecoSelected}">
								<tr>
									<td>${ateco.descrizione}</td>
									<td><img alt="Rimuovi" src="images/icons/delete.png" onclick="removeAteco(${sociData.idSoci},${ateco.id})"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<input type="submit" value="Salva" style="margin-top: 35px;">
			</div>

		</form:form>

	</div>
	<div id="i13">
		<a href="inserisciFinanziamentoSocio?idSocio=${socioData.idSocio}">
		<img title="Inserisci Finanziamento" src="images/icons/add.png"
		alt="Modifica Socio" height="25px" width="25px">
		</a>
		<br>
		<table id="elencoFinanziamentiSocio" class="display responsive nowrap"
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
				<c:forEach var="finanziamentoData" items="${finanziamentiList}">
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
						<td><a
							href="modificaFinanziamento?idFin=${finanziamentoData.idFinanziamenti}"><img
								src="images/icons/modifica.png" alt="Modifica Socio"
								height="25px" width="25px"></a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
	$(document).ready(function() {
	    $('#elencoFinanziamentiSocio').DataTable();
	    $('#elencoSociAteco').DataTable();
	} );
	
	$('.wizard li').click(function() {
		$(this).prevAll().addClass("completed");
		$(this).nextAll().removeClass("completed")
	});
	
	 jQuery(document).ready(function($) {
	        $('#search').multiselect({
	            search: {
	                left: '<input type="text" name="q" class="form-control" placeholder="Search..." style="width:  300px;margin-left:  -210px;"/>',
	                right: '<input type="text" name="q" class="form-control" placeholder="Search..." style="width:  300px;"/>',
	            },
	            fireSearch: function(value) {
	                return value.length > 3;
	            }
	        });
	    });
	</script>
</body>
</html>