<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" />
  <div class="container">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded">
	  <a class="navbar-brand" href="index.jsp">Our Cinema</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
    	<span class="navbar-toggler-icon"></span>
  	 </button>
	  
  	 <div class="collapse navbar-collapse" id="navbar">
  	 	<ul class="navbar-nav mr-auto">
	      
	      <li class="nav-item">
	      	<a class="nav-link" href="film?action=Program"=<c:out value="${sessionScope.registrationnumber}"/>">Προβολή προγράμματος προβολών ταινιών</a>
	      </li>
	      
	      <li class="nav-item">
            <a class="nav-link" href="film?action=newReservation">Κράτηση εισιτηρίων για κάποια προβολή</a>
	      </li>
	      	     
	      	      <li class="nav-item">
            <a class="nav-link" href="film?action=ListAllReservations">Προβολή ιστορικού κρατήσεων</a>
	      </li>
	       
	      	      
	      <li>
		  	<a class="nav-link" href="logout"> Αποσύνδεση </a>
	    </li>

	  </ul>
	</div>
  </nav>
</div>
