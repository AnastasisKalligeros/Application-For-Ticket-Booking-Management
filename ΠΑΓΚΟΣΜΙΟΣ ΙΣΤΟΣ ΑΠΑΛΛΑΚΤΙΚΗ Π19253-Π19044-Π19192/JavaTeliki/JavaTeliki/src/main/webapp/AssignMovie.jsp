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
	
	<title>Λειτουργίες Διαχειριστή Περιεχομένου- Ανάθεση ταινίας σε αίθουσα και ώρα προβολής</title>
</head>
<body>
	<jsp:directive.include file="includes/contentadmin_navbar.inc.jsp" />
	
	<c:forEach items="${requestScope.errors}" var="error">
		<div class="alert alert-warning">
		  <c:out value="${error}"/>
		</div>
	</c:forEach>
	
	<div class="container">
		<h1>ΑΝΑΘΕΣΗ ΤΑΙΝΙΑΣ ΣΕ ΑΙΘΟΥΣΑ ΚΑΙ ΩΡΑ ΠΡΟΒΟΛΗΣ</h1>
	</div>
	
	<div class="container">
		<form action="contentadmin" method="post">
			<input type="hidden" name="action" value="ListAllProvoles" />
			<input type="hidden" name="userRole" value="<c:out value="${sessionScope.role}"/>" />
			<input type="hidden" name="returnPage" value="AssignMovie.jsp" />
			
			
			
			

	 <table class="table table-striped">
    
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID Ταινίας</th>
                <th scope="col">Τίτλος Ταινίας</th>
                <th scope="col">Αίθουσα</th>
                <th scope="col">Ώρα Προβολής</th>
               
               
        
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.Provoles}" var="film">
                <tr>
                
                
                 <td><c:out value="${film.movie.movieID}" /></td>
                    <th scope="row"><c:out value="${film.movie.movieName}" /></th>
                      <td><c:out value="${film.cinema.cinemaID}" /></td>
                    <td><c:out value="${film.time}" /></td>
                   
                 
                </tr>
            </c:forEach>


        </tbody>
    </table>
			
			
			
			
		
			<button type="submit" class="btn btn-primary">ΑΝΑΘΕΣΗ</button>
		</form>
	</div>
	<jsp:directive.include file="includes/footer.html"/>
	