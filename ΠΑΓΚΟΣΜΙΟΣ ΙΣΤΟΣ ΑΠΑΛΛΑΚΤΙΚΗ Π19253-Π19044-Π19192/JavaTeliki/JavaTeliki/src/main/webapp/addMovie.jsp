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
<c:if test="${sessionScope.username != null && sessionScope.role != 'contentadmin'}">
	<c:redirect url="index.jsp"/>  
</c:if>  

<html>
<head>

	<meta charset="UTF-8">
	
	<!-- Bootstrap CSS -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
	<!-- Bootstrap CSS -->
	
	<title>Λειτουργίες Διαχειριστή Περιεχόμενου - Προσθήκη Ταινίας</title>
</head>
<body>
	<jsp:directive.include file="includes/contentadmin_navbar.inc.jsp" />
	
	<c:forEach items="${requestScope.errors}" var="error">
		<div class="alert alert-warning">
		  <c:out value="${error}"/>
		</div>
	</c:forEach>

<div class="container">
<h1>ΠΡΟΣΘΗΚΗ ΤΑΙΝΙΑΣ</h1>
</div>
<div class="container">
	<form action="contentadmin" method="post">
		<input type="hidden" name="action" value="addMovie" />
	
		<div class=" form-group row">
			<label for="ID" class="col-sm-2 col-form-label">Κωδικός Ταινίας</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" required="required" id="ID" name="ID" placeholder="Numbers only" >
			</div>
		</div>
		
		<div class=" form-group row">
			<label for="NAME" class="col-sm-2 col-form-label">Τίτλος:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" required="required" id="NAME" name="NAME" >
			</div>
		</div>
		
				<div class=" form-group row">
			<label for="CONTENT" class="col-sm-2 col-form-label">Καταλληλότητα:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" required="required" id="CONTENT" name="CONTENT" >
			</div>
		</div>
		
		
				<div class=" form-group row">
			<label for="LENGTH" class="col-sm-2 col-form-label">Διάρκεια:</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" required="required" id="LENGTH" name="LENGTH" placeholder="Numbers only" >
			</div>
		</div>
		
		
		
				<div class=" form-group row">
			<label for="TYPE" class="col-sm-2 col-form-label">Κατηγορία:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" required="required" id="TYPE" name="TYPE" >
			</div>
		</div>
		
		
		
				<div class=" form-group row">
			<label for="SUMMARY" class="col-sm-2 col-form-label">Περίληψη:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" required="required" id="SUMMARY" name="SUMMARY" >
			</div>
		</div>
		
			
				<div class=" form-group row">
			<label for="DIRECTOR" class="col-sm-2 col-form-label"> Σκηνοθέτης:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" required="required" id="DIRECTOR" name="DIRECTOR" >
			</div>
		</div>
		
		<div class=" form-group row">
			<label for="CINEMAS_ID" class="col-sm-2 col-form-label">Αίθουσα:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" required="required" id="CINEMAS_ID" name="CINEMAS_ID" >
			</div>
		</div>
		
		<div class=" form-group row">
			<label for="TIME" class="col-sm-2 col-form-label">Ώρα Προβολής:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" required="required" id="TIME" name="TIME"  >
			</div>
		</div>
		
		
		
		
		<div class=" form-group row">
			<label for="CONTENT_ADMIN_ID" class="col-sm-2 col-form-label">Διαχειριστής Πειριεχομένου</label>
			<div class="col-sm-7">
				<select name="CONTENT_ADMIN_ID" id="CONTENT_ADMIN_ID" style="font-size:18px;">
					<c:forEach items="${requestScope.Cons}" var="contentadmin">
						<option value="<c:out value="${contentadmin.contentadminid}" />"><c:out value="${contentadmin.name}" /></option>
					</c:forEach>
				</select>
			</div>
		
		</div>
		
		
		<button type="submit" class="btn btn-primary">Προσθήκη</button>
	</form> 
</div>
<jsp:directive.include file="includes/footer.html"/>