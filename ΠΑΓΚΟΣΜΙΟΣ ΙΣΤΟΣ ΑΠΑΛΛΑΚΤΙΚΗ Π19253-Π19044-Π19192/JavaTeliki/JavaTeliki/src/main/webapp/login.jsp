<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<c:set var="redirectPage" value="index.jsp" scope="page"/>
<c:if test="${sessionScope.username != null}">
	<c:redirect url="index.jsp"/>  
</c:if>
<html>
<head>
	<meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
	<title>Φόρμα Εισόδου</title>
</head>
<body>

<jsp:directive.include file="includes/main_navbar.inc.jsp" />

<div class="container">
	<h1>Φόρμα Εισόδου</h1>
	<form action="login" method="post">
		<div class=" form-group row">
			<label for="userName" class="col-sm-2 col-form-label">Όνομα Χρήστη</label>
			<div class="col-sm-7">
				<input type="text" class="form-control" name="userName" placeholder="Enter username">
    	</div>
    </div>
    
    <div class="form-group row">
    	<label for="passWord" class="col-sm-2 col-form-label">Κωδικός</label>
    	<div class="col-sm-7">
    		<input type="password" class="form-control" name="passWord" placeholder="Enter Password">
      </div>
     </div>
	 <jsp:scriptlet>
		if (request.getAttribute("messageType")=="error")
		{
	 </jsp:scriptlet>
	 <span style="color:red;">
	    <div class="form-group row">
	    	<label class="col-sm-2 col-form-label">Error!</label>
		    <div class="col-sm-7">
		    	<%=request.getAttribute("message")%>
		    </div>
	    </div>
	 </span> 
	 <jsp:scriptlet>
	 	}
     </jsp:scriptlet>

     <button type="submit" class="btn btn-primary">Είσοδος</button>
	</form> 
</div>

<jsp:directive.include file="includes/footer.html" />
