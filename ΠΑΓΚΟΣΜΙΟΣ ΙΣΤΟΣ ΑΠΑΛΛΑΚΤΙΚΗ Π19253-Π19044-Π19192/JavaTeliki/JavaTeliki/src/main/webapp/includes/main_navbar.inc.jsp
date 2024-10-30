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
		  <!-- Login form -->
		  <li class="nav-item">
		  <jsp:scriptlet>
			if(session.getAttribute("username")==null) {
		  </jsp:scriptlet>
		
		  	<a class="nav-link" href="login.jsp"> Είσοδος </a>
		
		  <jsp:scriptlet>
			} else {
		  </jsp:scriptlet>
		  	<a class="nav-link" href="logout"> Αποσύνδεση </a>
		  <jsp:scriptlet>
			}
		  </jsp:scriptlet>
	    </li>
	  </ul>
	</div>
  </nav>
</div>