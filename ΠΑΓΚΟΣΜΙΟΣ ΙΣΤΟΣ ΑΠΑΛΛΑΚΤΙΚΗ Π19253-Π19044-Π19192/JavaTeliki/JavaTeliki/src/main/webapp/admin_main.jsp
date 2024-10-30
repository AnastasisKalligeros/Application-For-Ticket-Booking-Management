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
	<title>Κεντρική Σελίδα Διαχειριστή Εφαρμογής</title>
</head>
<body>
<jsp:directive.include file="includes/admin_navbar.inc.jsp" />

<div class="container">
	<h1>ΚΕΝΤΡΙΚΗ ΣΕΛΙΔΑ ΔΙΑΧΕΙΡΙΣΤΗ ΕΦΑΡΜΟΓΗΣ</h1>
	<br>
	<h2>
		Καλωσήρθες <c:out value="${sessionScope.username}"/>. Έχεις συνδεθεί ως <c:out value="${sessionScope.role}"/>
	</h2>
	
	 <h3 style="text-align:center;">ΛΙΣΤΑ ΧΡΗΣΤΩΝ</h3>
	 	<form action="admin" method="post">
		<input type="hidden" name="action" value="ListAllUsers" />
	<table class="table table-striped">
    
        <thead class="thead-dark">
            <tr>
                <th scope="col">Όνομα Χρήστη</th>
                <th scope="col">Email</th>
                <th scope="col">Ρόλος</th>
               
        
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.CreateUsers}" var="createuser">
                <tr>
                    <th scope="row"><c:out value="${createuser.username}" /></th>
                    <td><c:out value="${createuser.email}" /></td>
                    <td><c:out value="${createuser.role}" /></td>
                       
                                            
                </tr>
            </c:forEach>
             </tbody>
    </table>
    </form>
    </div>
 
   
<jsp:directive.include file="includes/footer.html"/>