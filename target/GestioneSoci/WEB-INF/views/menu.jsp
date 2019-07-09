
<div class="col-sm-12">
	<nav class="cbp-hsmenu-wrapper" id="cbp-hsmenu-wrapper">
		<div class="cbp-hsinner">
			<ul class="cbp-hsmenu">
				<li><a href="#">Soci</a>
					<ul class="cbp-hssubmenu">
						<li><a href="${pageContext.request.contextPath}/elencoSoci"><span>Elenco Soci</span></a></li>
						<li><a href="${pageContext.request.contextPath}/inserisciSocio"><span>Inserisci Socio</span></a></li>
<!-- 						<li><a href="#"><span></span></a></li> -->
<!-- 						<li><a href="#"><span></span></a></li> -->
<!-- 						<li><a href="#"><span></span></a></li> -->
<!-- 						<li><a href="#"><span></span></a></li> -->
					</ul></li>
				<li><a href="#">Finanziamenti</a>
					<ul class="cbp-hssubmenu cbp-hssub-rows">
						<li><a href="${pageContext.request.contextPath}/elencoFinanziamenti"><span>Elenco Finanziamenti</span></a></li>
						<li><a href="${pageContext.request.contextPath}/inserisciFinanziamento"><span>Inserisci Finanziamento</span></a></li>
<!-- 						<li><a href="#"><span>Eggy Liquor</span></a></li> -->
<!-- 						<li><a href="#"><span>Fresh Juice</span></a></li> -->
<!-- 						<li><a href="#"><span>Delicate Wine</span></a></li> -->
<!-- 						<li><a href="#"><span>Fine Spirit</span></a></li> -->
<!-- 						<li><a href="#"><span>Heavenly Ale</span></a></li> -->
					</ul></li>
				<li><a href="#">Genera File</a>
					<ul class="cbp-hssubmenu">
						<li><a href="${pageContext.request.contextPath}/generaFileCrif"><span>Genera File Crif</span></a></li>
						<li><a href="${pageContext.request.contextPath}/generaFileXls"><span>Report Finanziamenti Excel</span></a></li>
<!-- 						<li><a href="#"><span>Eggy Liquor</span></a></li> -->
					</ul></li>
				<li><a href="${pageContext.request.contextPath}/elencoAntiriciclaggio">Gestione Antiriciclaggio</a></li>
				
				<li><a href="#">Amministrazione</a>
					<ul class="cbp-hssubmenu">
<!-- 						<li><a href="#"><span>Fresh Juice</span></a></li> -->
<!-- 						<li><a href="#"><span>Sweet Rum</span></a></li> -->
<!-- 						<li><a href="#"><span>Eggy Liquor</span></a></li> -->
					</ul></li>
				
			</ul>
		</div>
	</nav>
</div>
<script src="js/cbpHorizontalSlideOutMenu.min.js"></script>
<script>
	var menu = new cbpHorizontalSlideOutMenu(document
			.getElementById('cbp-hsmenu-wrapper'));
</script>