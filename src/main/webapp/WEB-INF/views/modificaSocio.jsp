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
					class="nmbr">2</span>Iscrizione Cofidi</a></li>
			<li><a data-toggle="tab" aria-expanded="true" id="i5"><span
					class="nmbr">3</span>Finanziamenti</a></li>
		</ul>
	</div>

	<div class="col-sm-12" style="margin-top: 10px; margin-bottom: 50px;">
		<form:form action="updateSocio" method="POST" class="form-signin"
			modelAttribute="sociData">
			<div id="i9">
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<input id="idSoci" name="idSoci" value="${sociData.idSoci}"
							type="hidden"> <label for="impresa">Denominazione
							sociale</label><br>
						<form:input path="impresa" value="${sociData.impresa}" type="text" />
						<form:errors path="impresa" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="idTipoSocieta">Tipo Societ�</label><br>
						<form:select path="idTipoSocieta">
							<c:forEach var="tipoSocieta" items="${tipoSocietaList}">
								<c:choose>
									<c:when test="${sociData.idTipoSocieta eq tipoSocieta.id}">
										<form:option value="${tipoSocieta.id}"
											label="${tipoSocieta.descrizione }" selected="true" />
									</c:when>
									<c:otherwise>
										<form:option value="${tipoSocieta.id}"
											label="${tipoSocieta.descrizione}" />
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-sm-3">
						<label for="codiceFiscale">Codice Fiscale</label><br>
						<form:input path="codiceFiscale" value="${sociData.codiceFiscale}"
							type="text" />
						<form:errors path="codiceFiscale" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="partitaIva">Partita Iva</label><br>
						<form:input path="partitaIva" value="${sociData.partitaIva}"
							type="text" />
						<form:errors path="partitaIva" cssClass="error" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="idSettoreImpresa">Settore d'Impresa</label><br>
						<form:select path="idSettoreImpresa">
							<c:forEach var="settoreImpresa" items="${settoreImpresaList}">
								<c:choose>
									<c:when
										test="${sociData.idSettoreImpresa eq settoreImpresa.id}">
										<option value="${settoreImpresa.id}"
											label="${settoreImpresa.descrizione}" selected="true" />
									</c:when>
									<c:otherwise>
										<option value="${settoreImpresa.id}"
											label="${settoreImpresa.descrizione}" />
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-sm-3">
						<label for="numeroDipendenti">Numero Addetti</label><br>
						<form:input path="numeroDipendenti"
							value="${sociData.numeroDipendenti}" type="text" />
					</div>
					<div class="col-sm-3">
						<label for="dataCostituzione">Data Costituzione</label><br>
						<form:input path="dataCostituzione"
							value="${sociData.dataCostituzione}" type="text" />
						<form:errors path="dataCostituzione" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="dataAttivita">Data Inizio Attivit�</label><br>
						<form:input path="dataAttivita" value="${sociData.dataAttivita}"
							type="text" />
						<form:errors path="dataAttivita" cssClass="error" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="telefono">Telefono</label><br>
						<form:input path="telefono" value="${sociData.telefono}"
							type="text" />
					</div>
					<div class="col-sm-3">
						<label for="mobile">Cellulare</label><br>
						<form:input path="mobile" value="${sociData.mobile}" type="text" />
					</div>
					<div class="col-sm-3">
						<label for="email">E-Mail</label><br>
						<form:input path="email" value="${sociData.email}" type="text" />
					</div>
					<div class="col-sm-3">
						<label for="fax">Fax</label><br>
						<form:input path="fax" value="${sociData.fax}" type="text" />
					</div>
				</div>


				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="indirizzoSedeLegale">Indirizzo Sede Legale</label><br>
						<form:input path="indirizzoSedeLegale"
							value="${sociData.indirizzoSedeLegale}" type="text" />
						<form:errors path="indirizzoSedeLegale" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="cittaSedeLegale">Citt� Sede Legale</label><br>
						<form:input path="cittaSedeLegale"
							value="${sociData.cittaSedeLegale}" type="text" />
						<form:errors path="cittaSedeLegale" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="capSedeLegale">Cap Sede Legale</label><br>
						<form:input path="capSedeLegale" value="${sociData.capSedeLegale}"
							type="text" />
						<form:errors path="capSedeLegale" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="provinciaSedeLegale">Provincia Sede Legale</label><br>
						<form:input path="provinciaSedeLegale"
							value="${sociData.provinciaSedeLegale}" type="text" maxlength="2" />
						<form:errors path="provinciaSedeLegale" cssClass="error" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="indirizzoAzienda">Indirizzo Azienda</label><br>
						<form:input path="indirizzoAzienda"
							value="${sociData.indirizzoAzienda}" type="text" />
					</div>
					<div class="col-sm-3">
						<label for="cittaAzienda">Citt� Azienda</label><br>
						<form:input path="cittaAzienda" value="${sociData.cittaAzienda}"
							type="text" />
					</div>
					<div class="col-sm-3">
						<label for="capAzienda">Cap Azienda</label><br>
						<form:input path="capAzienda" value="${sociData.capAzienda}"
							type="text" />
					</div>
					<div class="col-sm-3">
						<label for="provinciaAzienda">Provincia Azienda</label><br>
						<form:input path="provinciaAzienda"
							value="${sociData.provinciaAzienda}" type="text" maxlength="2" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="indirizzoSedeOperativa">Indirizzo Sede
							Operativa</label><br>
						<form:input path="indirizzoSedeOperativa"
							value="${sociData.indirizzoSedeOperativa}" type="text" />
					</div>
					<div class="col-sm-3">
						<label for="cittaSedeOperativa">Citt� Sede Operativa</label><br>
						<form:input path="cittaSedeOperativa"
							value="${sociData.cittaSedeOperativa}" type="text" />
					</div>
					<div class="col-sm-3">
						<label for="capSedeOperativa">Cap Sede Operativa</label><br>
						<form:input path="capSedeOperativa"
							value="${sociData.capSedeOperativa}" type="text" />
					</div>
					<div class="col-sm-3">
						<label for="provinciaSedeOperativa">Provincia Sede
							Operativa</label><br>
						<form:input path="provinciaSedeOperativa"
							value="${sociData.provinciaSedeOperativa}" type="text"
							maxlength="2" />
					</div>
				</div>
			</div>

			<div id="i10">
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="nome">Nome</label><br>
						<form:input path="nome" value="${sociData.nome}" type="text"
							placeholder="Nome" />
						<form:errors path="nome" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="cognome">Cognome</label><br>
						<form:input path="cognome" value="${sociData.cognome}" type="text"
							placeholder="Cognome" />
						<form:errors path="cognome" cssClass="error" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="idQualitaTitolare">In qualit� di</label><br>
						<form:select path="idQualitaTitolare">
							<c:forEach var="qualitaTitolare" items="${qualitaTitolareList}">
								<c:choose>
									<c:when
										test="${sociData.idQualitaTitolare eq qualitaTitolare.id}">
										<form:option value="${qualitaTitolare.id}"
											label="${qualitaTitolare.descrizione}" selected="true" />
									</c:when>
									<c:otherwise>
										<form:option value="${qualitaTitolare.id}"
											label="${qualitaTitolare.descrizione}" />
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-sm-3">
						<label for="codiceFiscaleTitolare">Codice Fiscale</label><br>
						<form:input path="codiceFiscaleTitolare"
							value="${sociData.codiceFiscaleTitolare}" type="text"
							placeholder="Codice Fiscale" />
						<form:errors path="codiceFiscaleTitolare" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="dataDiNascita">Data di Nascita</label><br>
						<form:input path="dataDiNascita" value="${sociData.dataDiNascita}"
							type="text" placeholder="Data di nascita" />
						<form:errors path="dataDiNascita" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="luogoDiNascita">Luogo di Nascita</label><br>
						<form:input path="luogoDiNascita"
							value="${sociData.luogoDiNascita}" type="text"
							placeholder="Luogo di Nascita" />
						<form:errors path="luogoDiNascita" cssClass="error" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="indirizzoResidenza">Indirizzo di Residenza</label><br>
						<form:input path="indirizzoResidenza"
							value="${sociData.indirizzoResidenza}" type="text"
							placeholder="Indirizzo Residenza" />
						<form:errors path="indirizzoResidenza" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="cittaResidenza">Citt� di Residenza</label><br>
						<form:input path="cittaResidenza"
							value="${sociData.cittaResidenza}" type="text"
							placeholder="Citt� Residenza" />
						<form:errors path="cittaResidenza" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="capResidenza">Cap Residenza</label><br>
						<form:input path="capResidenza" value="${sociData.capResidenza}"
							type="text" placeholder="Cap Residenza" />
						<form:errors path="capResidenza" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="provinciaResidenza">Provincia Residenza</label><br>
						<form:input path="provinciaResidenza"
							value="${sociData.provinciaResidenza}" type="text"
							placeholder="Provincia Residenza" maxlength="2" />
						<form:errors path="provinciaResidenza" cssClass="error" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="dataInizio">Data Inizio Rapporto</label><br>
						<form:input type="text" path="dataInizio"
							placeholder="Data Inizio" value="${sociData.dataInizio}" />
						<form:errors path="dataInizio" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="dataCessazione">Data Cessazione Rapporto</label><br>
						<form:input path="dataCessazione" type="text"
							value="${sociData.dataCessazione}" placeholder="Data Cessazione" />
					</div>
					<div class="col-sm-3">
						<label for="cciaa">CCIAA</label><br>
						<form:input path="cciaa" value="${sociData.cciaa}" type="text"
							placeholder="Iscritto alla CCIAA" />
						<form:errors path="cciaa" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="rea">REA</label><br>
						<form:input path="rea" value="${sociData.rea}" type="text"
							placeholder="REA" />
						<form:errors path="rea" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-5">
						<select name="from[]" id="search" class="form-control" size="8"
							multiple="multiple" style="width: 600px; height: 300px;">
							<c:forEach var="ateco" items="${atecoList}">
								<option value="${ateco.id }">${ateco.descrizione}</option>
							</c:forEach>
						</select>
					</div>

					<div class="col-xs-4"
						style="margin-top: 120px !important; width: 70px; margin-left: 30px !important">
						<button type="button" id="search_rightSelected"
							class="btn btn-block">
							<i class="glyphicon glyphicon-chevron-right"></i>
						</button>
						<button type="button" id="search_leftSelected"
							class="btn btn-block">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</button>
					</div>

					<div class="col-xs-3">
						<select name="to[]" id="search_to" class="form-control" size="8"
							multiple="multiple" style="width: 600px; height: 300px;">
							<option value=""></option>
						</select>
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="tipologiaMerceologica">Tipologia Merceologica</label><br>
						<form:input path="tipologiaMerceologica"
							value="${sociData.tipologiaMerceologica}" type="text"
							placeholder="Tipologia Merceologica" />
						<form:errors path="tipologiaMerceologica" cssClass="error" />
					</div>
					<div class="col-sm-3">
						<label for="idStatoSocio">Stato Socio</label><br>
						<form:select path="idStatoSocio">
							<c:forEach var="statoSocio" items="${statoSocioList}">
								<c:choose>
									<c:when test="${sociData.idStatoSocio eq statoSocio.id}">
										<form:option value="${statoSocio.id}"
											label="${statoSocio.descrizione}" selected="true" />
									</c:when>
									<c:otherwise>
										<form:option value="${statoSocio.id}"
											label="${statoSocio.descrizione}" />
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-sm-3">
						<label for="numeroLibroSoci">Numero Libro Soci</label><br>
						<form:input path="numeroLibroSoci"
							value="${sociData.numeroLibroSoci}" type="number"
							placeholder="Numero Libro Soci" min="0" />
					</div>
					<div class="col-sm-3">
						<label for="numeroQuote">Numero Quote</label><br>
						<form:input path="numeroQuote" value="${sociData.numeroQuote}"
							type="number" placeholder="Numero Quote Pagate" min="0" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-3">
						<label for="importoQuote">Importo Quote</label><br>
						<form:input path="importoQuote" value="${sociData.importoQuote}"
							type="number" min="0.00" step="0.01" max="500000"
							placeholder="Importo Quota" />
					</div>
					<div class="col-md-3">
						<label for="codiceUnivoco">Codice Univoco </label>
						<form:input path="codiceUnivoco" value="${sociData.codiceUnivoco}"
							type="text" placeholder="Codice Univoco" />
					</div>
				</div>
				<div id="atecoTable" style="margin-top: 50px;">
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
									<td><img alt="Rimuovi" src="images/icons/delete.png"
										onclick="removeAteco(${sociData.idSoci},${ateco.id})"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<input type="submit" value="Salva" style="margin-top: 35px;">
			</div>

		</form:form>

	</div>
	<div id="i11">
		<a href="inserisciFinanziamentoSocio?idSocio=${socioData.idSocio}">
			<img title="Inserisci Finanziamento" src="images/icons/add.png"
			alt="Modifica Socio" height="25px" width="25px">
		</a> <br>
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
	                left: '<input type="text" name="q" class="form-control" placeholder="Search..." style="width:  600px;"/>',
	                right: '<input type="text" name="q" class="form-control" placeholder="Search..." style="width:  600px;"/>',
	            },
	            fireSearch: function(value) {
	                return value.length > 3;
	            }
	        });
	    });
	</script>
</body>
</html>