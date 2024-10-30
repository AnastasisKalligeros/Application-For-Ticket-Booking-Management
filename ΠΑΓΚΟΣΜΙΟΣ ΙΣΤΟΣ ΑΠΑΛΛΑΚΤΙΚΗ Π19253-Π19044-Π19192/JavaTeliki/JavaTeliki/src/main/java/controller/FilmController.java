package controller;

import java.io.IOException;






import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import model.Movie;
import model.Reservation;
import dao.MovieDao;
import dao.CustomerDao;
import dao.FilmDao;
import utilities.ServletUtilities;

@WebServlet("/film")
public class FilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;
	private FilmDao filmDao;
	private CustomerDao customerDao;
	public FilmController() {
		super();
		movieDao=new MovieDao();
		filmDao=new FilmDao();
		customerDao=new CustomerDao();

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "20");
		String forward = "film;action=ListAllFilms";
		String action =  ServletUtilities.filter(request.getParameter("action"));
		
		if (action.equalsIgnoreCase("ListAllFilms")){
			forward = "/customer_main.jsp";
			List<Film> films =filmDao.getAllFilms();
			request.removeAttribute("Films");
			request.setAttribute("Films",films);
		
		}

		else if (action.equalsIgnoreCase("Program")){
			forward = "/Program.jsp";
			List<Movie> programs =movieDao.getProgram();
			request.removeAttribute("Programs");
			request.setAttribute("Programs",programs);
		
		}
		 else if (action.equals("newReservation")) {
				forward = "/ReservationTickets.jsp";
				List<Movie> mov = movieDao.getAllMovies();
				request.removeAttribute("Mov");
				request.setAttribute("Mov", mov);
				}
		
		
		  else if (action.equals("addReservation")) {
			 
					List<String> errors = new ArrayList<String>();
		
					
					
					//MOVIE_ID field
					String ID =  ServletUtilities.filter(request.getParameter("ID"));
					
					// Name field
					String NAME = ServletUtilities.filter(request.getParameter("NAME"));
					if (ServletUtilities.checkIfEmpty(NAME)) {
						errors.add("Το πεδίο Όνομα δεν μπορεί να είναι κενό");
					}

					// Cinema ID field
					String  CINEMAS_ID = ServletUtilities.filter(request.getParameter("CINEMAS_ID"));
					int ID2 = ServletUtilities.tryParseToInt( CINEMAS_ID);
					if (ID2 == -1) { // Το -1 σημαίνει δεν είναι αριθμός
						errors.add("Το πεδίο Αίθουσα πρέπει να είναι αριθμός");
					}
					
					//CUSTOMER_ID field
					String CUSTOMERS_ID =  ServletUtilities.filter(request.getParameter("CUSTOMERS_ID"));
		
					
					
					// Seats field
					String NUMBER_OF_SEATS = ServletUtilities.filter(request.getParameter("NUMBER_OF_SEATS"));
					if (ServletUtilities.checkIfEmpty(NUMBER_OF_SEATS)) {
						errors.add("Το πεδίο Θέσεις δεν μπορεί να είναι κενό");
					}
					
				
					
					
					if (errors.isEmpty()) {
						try {

							
							
							customerDao.addReservation(ID, NAME, CINEMAS_ID,  CUSTOMERS_ID,  NUMBER_OF_SEATS );
							forward= "film?action=ListAllFilms";
		
						
						}
						catch (Exception e) {
								e.printStackTrace();
						}
						
					} else {
						request.removeAttribute("errors");
						request.setAttribute("errors", errors);
						forward = ServletUtilities.filter(request.getParameter("ReservationTickets.jsp"));
						
					}
					
				
		  }
		
		
		  else if (action.equalsIgnoreCase("ListAllReservations")){
			forward = "/ReservationHistory.jsp";
			List<Reservation> reservations =movieDao.getAllReservations();
			request.removeAttribute("Reservation");
			request.setAttribute("Reservation", reservations);
		  }
		
		
		
		
		
		
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	
		}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
	