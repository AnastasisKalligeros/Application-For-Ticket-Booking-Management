<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
	<title>Our Cinema</title>
</head>
<body>

<img src="img/cinema.jpg" width="100%" height="200px" class="img-responsive">

<c:if test="${sessionScope.username == null}">
	<jsp:directive.include file="includes/main_navbar.inc.jsp" />
</c:if>
<c:if test="${sessionScope.username != null && sessionScope.role == 'admin'}">
	<jsp:directive.include file="includes/admin_navbar.inc.jsp" />
</c:if>
<c:if test="${sessionScope.username != null && sessionScope.role == 'contentadmin'}">
	<jsp:directive.include file="includes/contentadmin_navbar.inc.jsp" />
</c:if>
<c:if test="${sessionScope.username != null && sessionScope.role == 'customer'}">
	<jsp:directive.include file="includes/customer_navbar.inc.jsp" />
</c:if>

<c:if test="${requestScope.error != null}">
	<div class="alert alert-danger">
	  <c:out value="${requestScope.error}"/>
	</div>
</c:if>

<div class="container">
<h1>Καλωσήρθατε στον κινηματογράφο μας!</h1>
</div>
<jsp:directive.include file="includes/footer.html" />