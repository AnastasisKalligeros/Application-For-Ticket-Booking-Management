<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<jsp:scriptlet>
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "20");
</jsp:scriptlet>

<c:if test="${sessionScope.username != null && sessionScope.role != 'customer'}">
	     <c:redirect url="index.jsp"/>  
</c:if>
<c:if test="${sessionScope.username == null}">
	     <c:redirect url="login.jsp"/>  
</c:if>

<html>
<head>
	<meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
	<title>Λειτουργίες Πελάτη - Προβολή προγράμματος προβολών ταινιών</title>
</head>
<body>
<jsp:directive.include file="includes/customer_navbar.inc.jsp" />

<div class="container">

	<h3 style="text-align:center;">ΠΡΟΓΡΑΜΜΑ</h3>
	 	<form action="film" method="post">
		<input type="hidden" name="action" value="Program" />
	 <table class="table table-striped">
    
        <thead class="thead-dark">
            <tr>
             
                <th scope="col">ΤΙΤΛΟΣ</th>
                <th scope="col">ΔΙΑΡΚΕΙΑ</th>
                <th scope="col">ΑΙΘΟΥΣΑ</th>
                <th scope="col">ΩΡΑ ΠΡΟΒΟΛΗΣ</th>
               
                
                
              
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.Programs}" var="movie">
                <tr>
                    <th scope="row"><c:out value="${movie.movieName}" /></th>
                    <td><c:out value="${movie.movieLength}" /></td>
                    <td><c:out value="${movie.movieCinemaID}" /></td>
                     <td><c:out value="${movie.movieTime}" /></td>
                  
                                                                        
                </tr>
            </c:forEach>


        </tbody>
    </table>
	
	
	
		</form>
	</div>
	
     
   
<jsp:directive.include file="includes/footer.html"/>