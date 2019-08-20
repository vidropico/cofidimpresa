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

	<div class="col-sm-12" style="margin-top: 10px; margin-bottom: 50px;">
		<form:form action="inserisciFin" method="POST"
			class="form-signin" modelAttribute="finanziamentiData">
			<div id="i9">
				<form:input path="idSoci"
					value="${finanziamentiData.idSoci}" type="hidden"/>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<c:choose>
					<c:when test="${finanziamentiData.idSoci >0}">
						<label for="Impresa" >Impresa </label><br> 
						<input id="Impresa" name="Impresa" value="${impresa}" type="text" readonly="readonly"/>
					</c:when>
					<c:otherwise>
						<label for="piva" class="error">Impresa (Partita Iva)</label><br>
						<input id="piva" name="piva" value="${piva}" type="text"/>				
					</c:otherwise>
				</c:choose>
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
				</div>
				<div class="col-sm-3">
				<label for="rate" >Rate </label><br> <form:input
					path="rate" value="${finanziamentiData.rate}" type="text"/>
				</div>
				<div class="col-sm-3">
				<label for="importoRata" >Importo Rata</label><br>
				<form:input path="importoRata"
					value="${finanziamentiData.importoRata}" type="text"/>
				</div>
			</div>
			<div class="row" style="margin-bottom:10px;">		
				<div class="col-sm-3">
				<label for="dataErogazioneFinanziamento"
					>Data Erogazione
					Finananziamento </label><br> <form:input path="dataErogazioneFinanziamento"
					value="${finanziamentiData.dataErogazioneFinanziamento}"
					type="text" />
				</div>
				<div class="col-sm-3">	
				<label for="dataFineFinanziamento" >Data
					Fine Finanziamento</label><br> <form:input path="dataFineFinanziamento"
					value="${finanziamentiData.dataFineFinanziamento}" type="text"/>
				</div>
				<div class="col-sm-3">
				<label for="accredito" >Accredito </label><br> 
				<form:input path="accredito" value="${finanziamentiData.accredito}" type="text"/>
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
	</script>
</body>
</html>