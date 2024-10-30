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
<c:if test="${sessionScope.username != null && sessionScope.role != 'customer'}">
	<c:redirect url="index.jsp"/>  
</c:if>  

<html>
<head>
	<meta charset="UTF-8">
	
	<!-- Bootstrap CSS -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
	<!-- Bootstrap CSS -->
	
	<title>ΚΡΑΤΗΣΗ ΕΙΣΙΤΗΡΙΩΝ ΓΙΑ ΚΑΠΟΙΑ ΠΡΟΒΟΛΗ</title>
</head>
<body>
	<jsp:directive.include file="includes/customer_navbar.inc.jsp" />
	
	<c:forEach items="${requestScope.errors}" var="error">
		<div class="alert alert-warning">
		  <c:out value="${error}"/>
		</div>
	</c:forEach>

<div class="container">
<h1>ΚΡΑΤΗΣΗ ΕΙΣΙΤΗΡΙΩΝ</h1>
</div>
<div class="container">
	<form action="film" method="post">
		<input type="hidden" name="action" value="addReservation" />
	
			<div class=" form-group row">
				<label for="ID" class="col-sm-2 col-form-label">Όνομα Ταινίας:</label>
				<div class="col-sm-7">
					<select name="ID" id="ID" style="font-size:18px;">
					<c:forEach items="${requestScope.Mov}" var="movie">
						<option value="<c:out value="${movie.movieID}" />"><c:out value="${movie.movieName}" /></option>
					</c:forEach>
				</select>
				</div>
			</div>
			
			
			
			<div class=" form-group row">
				<label for="NAME" class="col-sm-2 col-form-label">ID Ταινίας:</label>
				<div class="col-sm-7">
					<select name="NAME" id="NAME" style="font-size:18px;">
					<c:forEach items="${requestScope.Mov}" var="movie">
						<option value="<c:out value="${movie.movieName}" />"><c:out value="${movie.movieID}" /></option>
					</c:forEach>
				</select>
				</div>
			</div>
								
			
		
		<div class=" form-group row">
				<label for="CUSTOMERS_ID" class="col-sm-2 col-form-label">ID Πελάτη:</label>
				<div class="col-sm-10">
				<input type="text" class="form-control" required="required" id="CUSTOMERS_ID" name="CUSTOMERS_ID" placeholder="Numbers only" />
			</div>
			</div>
		
				<div class=" form-group row">
				<label for="CINEMAS_ID" class="col-sm-2 col-form-label">Αίθουσα</label>
				<div class="col-sm-7">
					<select name="CINEMAS_ID" id="CINEMAS_ID" style="font-size:18px;">
					<c:forEach items="${requestScope.Mov}" var="movie">
						<option value="<c:out value="${movie.movieID}" />"><c:out value="${movie.movieCinemaID}" /></option>
					</c:forEach>
				</select>
				</div>
			</div>
					

		
		<div class=" form-group row">
			<label for="NUMBER_OF_SEATS" class="col-sm-2 col-form-label">Αριθμός θέσεων:</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" required="required" id="NUMBER_OF_SEATS" name="NUMBER_OF_SEATS" placeholder="Numbers only" />
			</div>
		</div>
		
			
		<button  type="submit" class="btn btn-primary">Προσθήκη</button>
	</form> 
</div>
<jsp:directive.include file="includes/footer.html"/>