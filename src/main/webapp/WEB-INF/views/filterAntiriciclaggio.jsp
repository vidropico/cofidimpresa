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

	<div class="wrap" style="margin-top: 10px; margin-bottom: 50px;">
		<form:form action="estraiElencoAntiriciclaggio" method="POST"
			class="form-signin">
			<div>
				<br> <label for="dateFilterStart" style="margin-top: 50px;">Data
					di inizio (gg/mm/aaaa)</label> <input id="dateFilterStart" name="dateFilterStart"
					value="${dateFilterStart}" type="text" style="margin-top: 20px;" required>
				<br> <label for="dateFilterEnd" style="margin-top: 50px;">Data
					di fine (gg/mm/aaaa)</label> <input id="dateFilterEnd" name="dateFilterEnd"
					value="${dateFilterEnd}" type="text" style="margin-top: 20px;" required>
				
				<input type="submit" value="Estrai Elenco" style="margin-top: 35px;">
			</div>
		</form:form>
	</div>
</body>
</html>