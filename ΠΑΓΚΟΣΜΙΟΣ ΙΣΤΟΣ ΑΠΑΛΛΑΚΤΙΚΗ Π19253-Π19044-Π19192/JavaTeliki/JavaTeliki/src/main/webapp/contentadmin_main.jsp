
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
	<title>Κεντρική Σελίδα Διαχειριστή Περιεχομένου</title>
</head>
<body>
<jsp:directive.include file="includes/contentadmin_navbar.inc.jsp" />
<div class="container">
	<br>
	<h1>ΚΕΝΤΡΙΚΗ ΣΕΛΙΔΑ ΔΙΑΧΕΙΡΙΣΤΗ ΠΕΡΙΕΧΟΜΕΝΟΥ</h1>
	<br>
	<h2>
		Καλωσήρθες <c:out value="${sessionScope.username}"/>. Έχεις συνδεθεί ως <c:out value="${sessionScope.role}"/>
	</h2>
	<br>
    <h3 style="text-align:center;">ΔΙΑΘΕΣΙΜΕΣ ΤΑΙΝΙΕΣ</h3>
    
    <form action="contentadmin" method="post">
		<input type="hidden" name="action" value="ListAllMovies" />

    <table class="table table-striped">
    
        <thead class="thead-dark">
            <tr>
                 <th scope="col">ID Ταινίας</th>
                <th scope="col">ΤΙΤΛΟΣ</th>
                <th scope="col">ΠΕΡΙΕΧΟΜΕΝΟ</th>
                <th scope="col">ΜΕΓΕΘΟΣ</th>
                <th scope="col">ΚΑΤΗΓΟΡΙΑ</th>
                <th scope="col">ΠΕΡΙΛΗΨΗ</th>
                <th scope="col">ΣΚΗΝΟΘΕΤΗΣ</th>                      
                 <th scope="col">ΑΙΘOΥΣΑ</th>
                  <th scope="col">ΩΡΑ ΕΚΚΙΝΗΣΗΣ</th>
                   <th scope="col">ID ΔΙΑΧΕΙΡΙΣΤΗ ΠΕΡΙΕΧΟΜΕΝΟΥ</th>
                
                
              
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.Movies}" var="movie">
                <tr>
                    <th scope="row"><c:out value="${movie.movieID}" /></th>
                    <td><c:out value="${movie.movieName}" /></td>
                    <td><c:out value="${movie.movieContent}" /></td>
                     <td><c:out value="${movie.movieLength}" /></td>
                      <td><c:out value="${movie.movieType}" /></td>
                       <td><c:out value="${movie.movieSummary}" /></td>
                        <td><c:out value="${movie.movieDirector}" /></td>  
                        <td><c:out value="${movie.movieCinemaID}" /></td>   
                        <td><c:out value="${movie.movieTime}" /></td>                      
                        <td><c:out value="${movie.contentadmin.contentadminid}" /></td>                                                                      
                </tr>
            </c:forEach>


        </tbody>
    </table>
    
    
    </form>
</div>

<jsp:directive.include file="includes/footer.html"/>