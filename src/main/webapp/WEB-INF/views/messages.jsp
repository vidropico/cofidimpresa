<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${not empty errorMsg}">
		<div class="wrap">
			<span class="messagesCustom" style="color: red">${errorMsg}</span>
		</div>
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${not empty confirmMsg}">
		<div class="wrap">
			<span class="messagesCustom" style="color: green">${confirmMsg}</span>
		</div>
	</c:when>
</c:choose>