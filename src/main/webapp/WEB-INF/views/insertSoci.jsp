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
		</ul>
	</div>

	<div class="col-sm-12" style="margin-top: 10px; margin-bottom: 50px;">
		<form:form action="addSocio" method="POST" class="form-signin"
			modelAttribute="sociData">
			<div id="i9">
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<form:input path="impresa" value="${sociData.impresa}"
					type="text" placeholder="Denominazione sociale"/>
				<form:errors path="impresa" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:select path="idTipoSocieta">
					<c:forEach var="tipoSocieta" items="${tipoSocietaList}">
						<c:choose>
							<c:when test="${sociData.idTipoSocieta eq tipoSocieta.id}">
								<form:option label="${tipoSocieta.descrizione}" value="${tipoSocieta.id}" selected="true"/>
							</c:when>
							<c:otherwise>
								<form:option label="${tipoSocieta.descrizione}" value="${tipoSocieta.id}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
				</div>
				<div class="col-sm-3">				
				<form:input path="codiceFiscale"
					value="${sociData.codiceFiscale}" type="text"
					placeholder="Codice Fiscale"/>
				<form:errors path="codiceFiscale" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="partitaIva"
					value="${sociData.partitaIva}" type="text"
					placeholder="Partita Iva"/>
				<form:errors path="partitaIva" cssClass="error"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<form:select path="idSettoreImpresa">
					<c:forEach var="settoreImpresa" items="${settoreImpresaList}">
						<c:choose>
							<c:when test="${sociData.idSettoreImpresa eq settoreImpresa.id}">
								<form:option label="${settoreImpresa.descrizione}" value="${settoreImpresa.id}" selected="true"/>
							</c:when>
							<c:otherwise>
								<form:option value="${settoreImpresa.id}" label="${settoreImpresa.descrizione}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
				</div>
				<div class="col-sm-3">
				<form:input path="numeroDipendenti"
					value="${sociData.numeroDipendenti}" type="text"
					placeholder="Numero Addetti"/>
				</div>
				<div class="col-sm-3">
				<form:input path="dataCostituzione"
					value="${sociData.dataCostituzione}" type="text"
					placeholder="Data Costituzione"/>
				<form:errors path="dataCostituzione" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="dataAttivita"
					value="${sociData.dataAttivita}" type="text"
					placeholder="Data Inizio Attività"/>
				<form:errors path="dataAttivita" cssClass="error"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<form:input path="telefono" value="${sociData.telefono}"
					type="text" placeholder="Telefono"/>
				</div>
				<div class="col-sm-3">
				<form:input path="mobile" value="${sociData.mobile}"
					type="text" placeholder="Cellulare"/>
				</div>
				<div class="col-sm-3">
				<form:input path="email" value="${sociData.email}" type="text"
					placeholder="E-Mail"/>
				</div>
				<div class=col-sm-3>
				<form:input path="fax" value="${sociData.fax}" type="text"
					placeholder="Fax"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">			
				<form:input path="indirizzoSedeLegale"
					value="${sociData.indirizzoSedeLegale}" type="text"
					placeholder="Indirizzo Sede Legale"/>
				<form:errors path="indirizzoSedeLegale" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="cittaSedeLegale"
					value="${sociData.cittaSedeLegale}" type="text"
					placeholder="Città Sede Legale"/>
				<form:errors path="cittaSedeLegale" cssClass="error"/>				
				</div>
				<div class="col-sm-3">
				<form:input path="capSedeLegale"
					value="${sociData.capSedeLegale}" type="text"
					placeholder="Cap Sede Legale"/>
				<form:errors path="capSedeLegale" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="provinciaSedeLegale"
					value="${sociData.provinciaSedeLegale}" type="text"
					placeholder="Provincia Sede Legale" maxlength="2"/>
				<form:errors path="provinciaSedeLegale" cssClass="error"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<form:input path="indirizzoAzienda"
					value="${sociData.indirizzoAzienda}" type="text"
					placeholder="Indirizzo Sede Azienda"/>
				</div>
				<div class="col-sm-3">
				<form:input path="cittaAzienda"
					value="${sociData.cittaAzienda}" type="text"
					placeholder="Città Sede Azienda"/>
				</div>
				<div class="col-sm-3">
				<form:input path="capAzienda"
					value="${sociData.capAzienda}" type="text"
					placeholder="Cap Sede Azienda"/>
				</div>
				<div class="col-sm-3">
				<form:input path="provinciaAzienda"
					value="${sociData.provinciaAzienda}" type="text"
					placeholder="Provincia Sede Azienda" maxlength="2"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">			
				<form:input path="indirizzoSedeOperativa"
					value="${sociData.indirizzoSedeOperativa}" type="text"
					placeholder="Indirizzo Sede Operativa"/>
				</div>
				<div class="col-sm-3">
				<form:input path="cittaSedeOperativa"
					value="${sociData.cittaSedeOperativa}" type="text"
					placeholder="Città Sede Operativa"/>
				</div>
				<div class="col-sm-3">
				<form:input path="capSedeOperativa"
					value="${sociData.capSedeOperativa}" type="text"
					placeholder="Cap Sede Operativa"/>
				</div>
				<div class="col-sm-3">
				<form:input path="provinciaSedeOperativa"
					value="${sociData.provinciaSedeOperativa}" type="text"
					placeholder="Provincia Sede Operativa" maxlength="2"/>
				</div>
			</div>
		</div>
		<div id="i10">
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<form:input path="nome" value="${sociData.nome}" type="text"
					placeholder="Nome"/>
				<form:errors path="nome" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="cognome" value="${sociData.cognome}"
					type="text" placeholder="Cognome"/>
				<form:errors path="cognome" cssClass="error"/>				
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<form:select path="idQualitaTitolare">
					<c:forEach var="qualitaTitolare" items="${qualitaTitolareList}">
						<c:choose>
							<c:when
								test="${sociData.idQualitaTitolare eq qualitaTitolare.id}">
								<form:option value="${qualitaTitolare.id}" label="${qualitaTitolare.descrizione}" selected="true"/>
							</c:when>
							<c:otherwise>
								<form:option value="${qualitaTitolare.id}" label="${qualitaTitolare.descrizione}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
				</div>
				<div class="col-sm-3">
				<form:input path="codiceFiscaleTitolare"
					value="${sociData.codiceFiscaleTitolare}" type="text"
					placeholder="Codice Fiscale"/>
				<form:errors path="codiceFiscaleTitolare" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="dataDiNascita"
					value="${sociData.dataDiNascita}" type="text"
					placeholder="Data di nascita"/>
				<form:errors path="dataDiNascita" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="luogoDiNascita"
					value="${sociData.luogoDiNascita}" type="text"
					placeholder="Luogo di Nascita"/>
				<form:errors path="luogoDiNascita" cssClass="error"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<form:input path="indirizzoResidenza"
					value="${sociData.indirizzoResidenza}" type="text"
					placeholder="Indirizzo Residenza"/>
				<form:errors path="indirizzoResidenza" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="cittaResidenza"
					value="${sociData.cittaResidenza}" type="text"
					placeholder="Città Residenza"/>
				<form:errors path="cittaResidenza" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="capResidenza"
					value="${sociData.capResidenza}" type="text"
					placeholder="Cap Residenza"/>
				<form:errors path="capResidenza" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="provinciaResidenza"
					value="${sociData.provinciaResidenza}" type="text"
					placeholder="Provincia Residenza" maxlength="2"/>
				<form:errors path="provinciaResidenza" cssClass="error"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<form:input type="text" path="dataInizio"
					placeholder="Data Inizio" value="${sociData.dataInizio}"/>
				<form:errors path="dataInizio" cssClass="error"/>		
				</div>
				<div class="col-sm-3">
				<form:input path="dataCessazione" type="text"
					value="${sociData.dataCessazione }" placeholder="Data Cessazione"/>
				</div>
				<div class="col-sm-3">
				<form:input path="cciaa" value="${sociData.cciaa}" type="text"
					placeholder="Iscritto alla CCIAA"/>
				<form:errors path="cciaa" cssClass="error"/>
				</div>
				<div class="col-sm-3">
				<form:input path="rea" value="${sociData.rea}" type="text"
					placeholder="REA"/>
				<form:errors path="rea" cssClass="error"/>
				</div>
			</div>
				
		    <div class="row" style="margin-bottom:10px;">		
		        <div class="col-xs-5">
		            <select name="from[]" id="search" class="form-control" size="8" multiple="multiple" style="width: 300px;height: 300px;">
		                <c:forEach var="ateco" items="${atecoList}">
							<option value="${ateco.id }">${ateco.descrizione}</option>
						</c:forEach>
		            </select>
		        </div>
		        
		        <div class="col-xs-4" style="margin-top: 120px !important;width: 70px;">
		        	<button type="button" id="search_rightSelected" class="btn btn-block"><i class="glyphicon glyphicon-chevron-right"></i></button>
		            <button type="button" id="search_leftSelected" class="btn btn-block"><i class="glyphicon glyphicon-chevron-left"></i></button>
		        </div>
		        
		        <div class="col-xs-3">
		            <select name="to[]" id="search_to" class="form-control" size="8" multiple="multiple" style="width: 300px;height:  300px;">
		            	<option value=""></option>
		            </select>
		        </div>
		    </div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<form:input path="tipologiaMerceologica"
					value="${sociData.tipologiaMerceologica}" type="text"
					placeholder="Tipologia Merceologica"/>
				<form:errors path="tipologiaMerceologica" cssClass="error"/>
				</div>
				<div class="col-md-2">
				<form:select path="idStatoSocio">
					<c:forEach var="statoSocio" items="${statoSocioList}">
						<c:choose>
							<c:when test="${sociData.idStatoSocio eq statoSocio.id}">
								<form:option value="${statoSocio.id}" label="${statoSocio.descrizione}" selected="true"/>
							</c:when>
							<c:otherwise>
								<form:option value="${statoSocio.id}" label="${statoSocio.descrizione}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
				</div>
				<div class="col-md-3">
				<label for="numeroLibroSoci">Numero Libro Soci</label> 
				<form:input path="numeroLibroSoci"
					value="${sociData.numeroLibroSoci}" type="number"
					placeholder="Numero Libro Soci" min="0"/>
				</div>
				<div class="col-md-3">
				<label for="numeroQuote">Numero Quote </label> 
				<form:input path="numeroQuote"
					value="${sociData.numeroQuote}" type="number"
					placeholder="Numero Quote Pagate" min="0"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-md-3">
				<label for="importoQuote">Importo Quote </label> 
				<form:input path="importoQuote"
					value="${sociData.importoQuote}" type="number" min="0.00"
					step="0.01" max="500000" placeholder="Importo Quota"/>
				</div>
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
		
	    jQuery(document).ready(function($) {
	        $('#search').multiselect({
	            search: {
	                left: '<input type="text" name="q" class="form-control" placeholder="Search..." style="width:  300px;"/>',
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