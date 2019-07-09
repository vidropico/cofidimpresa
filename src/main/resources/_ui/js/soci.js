
$(document).ready(function() {
	$("#i9").show();
	$("#i10").hide();
	$("#i11").hide();
	$("#i12").hide();
	$("#i13").hide();
	$("#i14").hide();

	$("#i1").click(function() {
		$("#i9").show();
		$("#i10").hide();
		$("#i11").hide();
		$("#i12").hide();
		$("#i13").hide();
		$("#i14").hide();
	});

	$("#i2").click(function() {
		$("#i9").hide();
		$("#i10").show();
		$("#i11").hide();
		$("#i12").hide();
		$("#i13").hide();
		$("#i14").hide();
	});

	$("#i3").click(function() {
		$("#i9").hide();
		$("#i10").hide();
		$("#i11").show();
		$("#i12").hide();
		$("#i13").hide();
		$("#i14").hide();
	});

	$("#i4").click(function() {
		$("#i9").hide();
		$("#i10").hide();
		$("#i11").hide();
		$("#i12").show();
		$("#i13").hide();
		$("#i14").hide();
	});

	$("#i5").click(function() {
		$("#i9").hide();
		$("#i10").hide();
		$("#i11").hide();
		$("#i12").hide();
		$("#i13").show();
		$("#i14").hide();
	});
	$("#i6").click(function() {
		$("#i9").hide();
		$("#i10").hide();
		$("#i11").hide();
		$("#i12").hide();
		$("#i13").hide();
		$("#i14").show();
	});
});

$(function() {
	$("#dataCostituzione").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
});

$(function() {
	$("#dataAttivita").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
});

$(function() {
	$("#dataDiNascita").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
});

$(function() {
	$("#dataInizio").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
});


$(function() {
	$("#dataCessazione").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
});

$(function() {
	$("#dataApprovazioneConsiglio").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
});

$(function() {
	$("#dataErogazioneFinanziamento").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
});

$(function() {
	$("#dataFineFinanziamento").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
});


function removeAteco(idSocio,idAteco){
	$.ajax({
		  // definisco il tipo della chiamata
		  type: "GET",
		  // specifico la URL della risorsa da contattare
		  url: "GestioneSoci/removeAteco/"+idSocio+"/"+idAteco,
		  // definisco il formato della risposta
		  dataType: "text",
		  //contentType: "application/x-www-form-urlencoded",
		  // imposto un'azione per il caso di successo
		  success: function(risposta){
		  //$("div#risposta").html(risposta);
			  //$( "#atecoTable" ).load(window.location.href + " #atecoTable" );
			  window.location.reload("#atecoTable");
		  },
		  // ed una per il caso di fallimento
		  error: function(){
		    alert("Non è possibile cancellare il codice Ateco!!!");
		  }
	})
};