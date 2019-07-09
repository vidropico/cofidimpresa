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
				id="i1"><span class="nmbr">1</span>Antiriciclaggio</a></li>
		</ul>
	</div>

	<div class="wrap" style="margin-top: 10px; margin-bottom: 50px;">
		<form:form action="insAntiriciclaggio" method="POST" class="form-signin"
			modelAttribute="antData">
			<div id="i9">
				<input id="idSoci" name="idSoci" value="${antData.idSoci}" type="hidden"> 
				<input id="idFinanziamento" name="idFinanziamento" value="${antData.idFinanziamento}" type="hidden"> 
				
				<label for="nominativo" style="margin-left: -160px;">Nominativo</label> 
				<input id="nominativo" name="nominativo"
					value="${antData.nominativo}" type="text"
					placeholder="Nominativo">
				<div class="bar">
					<i></i>
				</div>
				
				<label for="idDocumento" style="margin-left: -160px;">Documento</label> 
				<select id="idDocumento" name="idDocumento">
					<option value="Carta identita" selected>Carta d'identità</option>
					<option value="Patente di guida" selected>Patente di guida</option>
					<option value="Passaporto" selected>Passaporto</option>
					<option value="Porto armi" selected>Porto d'armi</option>
					<option value="Patente nautica" selected>Patente nautica</option>
					<option value="Libretto di pensione" selected>Libretto di
						pensione</option>
				</select> 
				
				<label for="numeroDocumento" style="margin-left: -160px;">Numero
					Richiesto:</label> <input id="numeroDocumento" name="numeroDocumento"
					value="${antData.numeroDocumento}" type="text"
					placeholder="Numero Documento">
				<div class="bar">
					<i></i>
				</div>
				
				<label for="dataRilascio" style="margin-left: -160px;">Data di rilascio (gg/mm/aaaa)</label> 
				<input id="dataRilascio" name="dataRilascio"
					value="${antData.dataRilascio}" type="text"
					placeholder="Data di rilascio">
				<div class="bar">
					<i></i>
				</div>
				
				<label for="luogoRilascio" style="margin-left: -160px;">Luogo di Rilascio</label> 
				<input id="luogoRilascio"
					name="luogoRilascio"
					value="${antData.luogoRilascio}" type="text"
					placeholder="Luogo di Rilascio">
				<div class="bar">
					<i></i>
				</div>
							
				<label for="autoritaCompetente" style="margin-left: -160px;">Autorità Competente</label> 
				<input id="autoritaCompetente" name="autoritaCompetente"
					value="${antData.autoritaCompetente}" type="text"
					placeholder="Autorità competente">
				<div class="bar">
					<i></i>
				</div>
				
				<label for="dataScadenza" style="margin-left: -160px;">Data di scadenza (gg/mm/aaaa)</label> 
				<input id="dataScadenza" name="dataScadenza"
					value="${antData.dataScadenza}" type="text"
					placeholder="Data di scadenza">
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