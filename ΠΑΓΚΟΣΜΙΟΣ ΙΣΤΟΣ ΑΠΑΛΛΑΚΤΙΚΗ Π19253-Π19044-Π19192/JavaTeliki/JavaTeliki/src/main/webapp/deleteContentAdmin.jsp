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
	
	<title>Λειτουργίες Διαχειριστή - Διαγραφή Διαχειριστή Περιεχομένου</title>
</head>
<body>
	<jsp:directive.include file="includes/admin_navbar.inc.jsp" />
	
	<c:forEach items="${requestScope.errors}" var="error">
		<div class="alert alert-warning">
		  <c:out value="${error}"/>
		</div>
	</c:forEach>
	
	<div class="container">
		<h1>ΔΙΑΓΡΑΦΗ ΔΙΑΧΕΙΡΙΣΤΗ ΠΕΡΙΕΧΟΜΕΝΟΥ</h1>
	</div>
	
	<div class="container">
		<form action="admin" method="post">
			<input type="hidden" name="action" value="deleteContentAdmin" />
			<input type="hidden" name="userRole" value="<c:out value="${sessionScope.role}"/>" />
			<input type="hidden" name="returnPage" value="deleteContentAdmin.jsp" />
		
			<div class=" form-group row">
				<label for="username" class="col-sm-2 col-form-label">Όνομα Χρήστη:</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="username" name="username" required="required" />
				</div>
			</div>
			
			
			
			
			<input type="hidden" name="dept" value="P" />
			<input type="hidden" name="role" value="contentadmin" />
			<button type="submit" class="btn btn-primary">ΔΙΑΓΡΑΦΗ</button>
		</form>
	</div>
	<jsp:directive.include file="includes/footer.html"/>
	