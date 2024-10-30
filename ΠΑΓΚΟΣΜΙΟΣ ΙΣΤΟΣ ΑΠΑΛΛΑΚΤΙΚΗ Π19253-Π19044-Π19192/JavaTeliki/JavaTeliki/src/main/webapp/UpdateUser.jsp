
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

</head>
<body>
<jsp:directive.include file="includes/admin_navbar.inc.jsp" />
<div class="container">
	<br>
	
	<br>
	<br>
    <h3 style="text-align:center;">ΕΝΗΜΕΡΩΣΗ ΧΡΗΣΤΗ</h3>
    
    <form action="contentadmin" method="post">
		<input type="hidden" name="action" value="UpdateUser" />

  	<div class=" form-group row">
			<label for="username" class="col-sm-2 col-form-label">Όνομα Χρήστη</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"  id="username" name="username">
			</div>
		</div>
	
		<div class=" form-group row">
			<label for="email" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control"  id="email" name="email">
			</div>
		</div>
		
		
		<div class=" form-group row">
			<label for="role" class="col-sm-2 col-form-label">Role</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"  id="role" name="role">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Ενημέρωση </button>
    
    </form>
</div>

<jsp:directive.include file="includes/footer.html"/>