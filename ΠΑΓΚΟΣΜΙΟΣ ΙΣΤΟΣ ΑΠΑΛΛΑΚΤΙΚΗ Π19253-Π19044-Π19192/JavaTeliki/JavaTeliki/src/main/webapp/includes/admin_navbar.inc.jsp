<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded">
			<a class="navbar-brand" href="index.jsp">Our Cinema</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="navbar-nav mr-auto">
				<li class="nav-item">
						<a class="nav-link" href="registerAdmin.jsp">Εγγραφή Διαχειριστή Εφαρμογής</a>
					</li>
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Λειτουργίες Διαχειριστή Περιεχομένου</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"  href="registerContentAdmin.jsp">Εγγραφή Διαχειριστή Περιεχομένου</a>				
					
						<a class="dropdown-item" href="deleteContentAdmin.jsp">Διαγραφή Διαχειριστή Περιεχομένου</a>
							<div class="dropdown-divider"></div>
							</div>					
					</li>
					
					
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Λειτουργίες Πελάτη</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					
					<a class="dropdown-item"  href="registerCustomer.jsp">Εγγραφή Πελάτη</a>				
					
						<a class="dropdown-item"  href="deleteContentAdmin.jsp">Διαγραφή Πελάτη</a>
							<div class="dropdown-divider"></div>
							</div>					
					</li>
					
					
						<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Λειτουργίες Χρήστη</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					
					<a class="dropdown-item"  href="UpdateUser.jsp">Ενημέρωση Χρήστη</a>				
					
						<a class="dropdown-item" href="SearchUser.jsp">Αναζήτηση Χρήστη</a>
							<div class="dropdown-divider"></div>
							</div>					
					</li>
					
					
					
				
					
						
					
					<li>
						<a class="nav-link" href="logout"> Αποσύνδεση </a>
					</li>
				</ul>
			</div>
		</nav>
	</div>
