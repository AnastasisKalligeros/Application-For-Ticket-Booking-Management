<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<jsp:scriptlet>
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "20");
</jsp:scriptlet>

<c:if test="${sessionScope.username == null}">
	<c:redirect url="login.jsp"/>  
</c:if>  
<c:if test="${sessionScope.username != null && sessionScope.role != 'admin'}">
	<c:redirect url="index.jsp"/>  
</c:if>  

<html>
<head>
	<meta charset="UTF-8">
	
	<!-- Bootstrap CSS -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
	<!-- Bootstrap CSS -->
	
	<title>Λειτουργίες Διαχειριστή - Προσθήκη Πελάτη</title>
</head>
<body>
	<jsp:directive.include file="includes/admin_navbar.inc.jsp" />
	
	<c:forEach items="${requestScope.errors}" var="error">
		<div class="alert alert-warning">
		  <c:out value="${error}"/>
		</div>
	</c:forEach>
	
	<div class="container">
		<h1>ΠΡΟΣΘΗΚΗ ΠΕΛΑΤΗ</h1>
	</div>
	
	<div class="container">
		<form action="admin" method="post">
			<input type="hidden" name="action" value="addCustomer" />
			<input type="hidden" name="userRole" value="<c:out value="${sessionScope.role}"/>" />
			
		
			<div class=" form-group row">
				<label for="username" class="col-sm-2 col-form-label">Όνομα Χρήστη:</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="username" name="username" required="required" />
				</div>
			</div>
			
			<div class=" form-group row">
				<label for="password1" class="col-sm-2 col-form-label">Κωδικός:</label>
				<div class="col-sm-7">
					<input type="password" class="form-control" id="password1" name="password1" required="required" />
				</div>
			</div>
			
			<div class=" form-group row">
				<label for="password2" class="col-sm-2 col-form-label">Επανυποβολή Κωδικού:</label>
				<div class="col-sm-7">
					<input type="password" class="form-control" id="password2" name="password2" required="required" />
				</div>
			</div>
						
			<div class=" form-group row">
				<label for="CUSTOMERS_ID" class="col-sm-2 col-form-label">ID Πελάτη:</label>
				<div class="col-sm-7">
					<input type="number" class="form-control" id="CUSTOMERS_ID" name="CUSTOMERS_ID" required="required" placeholder="Numbers only" />
				</div>
			</div>
			
			<div class=" form-group row">
				<label for="name" class="col-sm-2 col-form-label">Όνομα:</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="name" name="name" required="required" />
				</div>
			</div>
			
			<div class=" form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-7">
					<input type="email" class="form-control" id="email" name="email" required="required" />
				</div>
			</div>
			
			
		
			<input type="hidden" name="role" value="customer" />
			<button type="submit" class="btn btn-primary">ΠΡΟΣΘΗΚΗ ΠΕΛΑΤΗ</button>
		</form>
	</div>
	<jsp:directive.include file="includes/footer.html"/>
	