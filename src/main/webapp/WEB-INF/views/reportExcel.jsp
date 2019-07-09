<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.flash.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>

<body>
	<jsp:include page="testata.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<jsp:include page="messages.jsp" />
	<div style="margin-top: 80px">
		<table id="reportFinanziamenti" class="display responsive nowrap"
			style="width: 100%">
			<thead>
				<tr>
					<th>N.</th>
					<th>NOME</th>
					<th>COGNOME</th>
					<th>IMPRESA</th>
					<th>CODICE FISCALE</th>
					<th>PARTITA IVA</th>
					<th>DATA DEL CONSIGLIO</th>
					<th>IMPORTO</th>
					<th>DATA DELLA BANCA</th>
					<th>IMP BANCA</th>
					<th>BANCA</th>
					<th>RATA</th>
					<th>N. RATE</th>
					<th>INIZIO</th>
					<th>FINE</th>
					<th>ACCREDITI</th>
					<th>ISCRIZIONE</th>
					<th>QUOTA ASS</th>
					<th>PREVENZIONE USURA</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tableExcelData" items="${tableExcelDataList}">
					<tr>
						<td>${tableExcelData.numProgressivo}</td>
						<td>${tableExcelData.nome}</td>
						<td>${tableExcelData.cognome}</td>
						<td>${tableExcelData.impresa}</td>
						<td>${tableExcelData.codiceFiscale}</td>
						<td>${tableExcelData.partitaIva}</td>
						<td>${tableExcelData.dataApprovazioneConsiglio}</td>
						<td>${tableExcelData.importoDeliberato}</td>
						<td>${tableExcelData.dataErogazioneFinanziamento}</td>
						<td>${tableExcelData.importo}</td>
						<td>${tableExcelData.nomeBanca}</td>
						<td>${tableExcelData.importoRata}</td>
						<td>${tableExcelData.rate}</td>
						<td>${tableExcelData.dataErogazioneFinanziamento}</td>
						<td>${tableExcelData.dataFineFinanziamento}</td>
						<td>${tableExcelData.costi}</td>
						<td>${tableExcelData.costoIstruttoria}</td>
						<td>${tableExcelData.importoQuote}</td>
						<td>${tableExcelData.flgUsura}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#reportFinanziamenti').DataTable( {
		        dom: 'Bfrtip',
		        buttons: [
		             'excel', 'pdf'
		        ]
		    } );
		});
	</script>
</body>
</html>