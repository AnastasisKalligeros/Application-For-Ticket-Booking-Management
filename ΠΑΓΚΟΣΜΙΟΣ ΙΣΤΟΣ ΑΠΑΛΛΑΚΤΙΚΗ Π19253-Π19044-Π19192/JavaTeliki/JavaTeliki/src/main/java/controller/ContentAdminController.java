
package controller;

import java.io.IOException;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MovieDao;
import dao.FilmDao;
import dao.UserDao;
import model.Movie;
import model.Film;
import utilities.ServletUtilities;
import dao.ContentAdminDao;
import model.ContentAdmin;




@WebServlet("/contentadmin")
public class ContentAdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MovieDao movieDao;
    private FilmDao filmDao;
    private ContentAdminDao contentadminDao;
    private UserDao userDao;
   
    
    public ContentAdminController() {
        super();
        movieDao = new MovieDao();
        filmDao = new FilmDao();
        userDao = new UserDao();
        contentadminDao = new ContentAdminDao();

    }

   

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "20");
		
		String forward = "/index.jsp";
		String action = request.getParameter("action");
	
		
	
			if (action.equalsIgnoreCase("ListAllMovies")){
				forward = "/contentadmin_main.jsp";
				List<Movie> movies =movieDao.getAllMovies();
				request.removeAttribute("Movies");
				request.setAttribute("Movies", movies);
		
		} else if (action.equals("newMovie")) {
			forward = "/addMovie.jsp";
			List<ContentAdmin> cons = contentadminDao.getAllContentAdmins();
			request.removeAttribute("Cons");
			request.setAttribute("Cons", cons);
			
		} else if (action.equalsIgnoreCase("UpdateUser")) {
			String username = ServletUtilities.filter(request.getParameter("username"));
			String email = ServletUtilities.filter(request.getParameter("email"));
			String role = ServletUtilities.filter(request.getParameter("role"));
			contentadminDao.setUser(username, email, role);
			
			forward = "admin?action=ListAllUsers";
		
		} else if (action.equals("addMovie")) {
			List<String> errors = new ArrayList<String>();
			
			// Movie ID field
			String ID =  ServletUtilities.filter(request.getParameter("ID"));
			if (ServletUtilities.checkIfEmpty(ID)) {
				errors.add("Το πεδίο Κωδικός Ταινίας δεν μπορεί να είναι κενό");
			} else if (movieDao.movieIdCheck(ID) == true) {
				errors.add("Το μάθημα με κωδικό "+ ID +" υπάρχει ήδη!");
			}
			
			// Movie Name field
			String NAME =  ServletUtilities.filter(request.getParameter("NAME"));
			if (ServletUtilities.checkIfEmpty(NAME)) {
				errors.add("Το πεδίο Τίτλος δεν μπορεί να είναι κενό");
			}
			// Movie Content field
			String CONTENT =  ServletUtilities.filter(request.getParameter("CONTENT"));
			if (ServletUtilities.checkIfEmpty(CONTENT)) {
				errors.add("Το πεδίο Περιεχόμενο δεν μπορεί να είναι κενό");
			}
			// Movie Length field
			String LENGTH =  ServletUtilities.filter(request.getParameter("LENGTH"));
			if (ServletUtilities.checkIfEmpty(LENGTH)) {
				errors.add("Το πεδίο διάρκεια δεν μπορεί να είναι κενό");
			}
						
			// Movie Type field
			String TYPE =  ServletUtilities.filter(request.getParameter("TYPE"));
			if (ServletUtilities.checkIfEmpty(TYPE)) {
				errors.add("Το πεδίο Περιεχόμενο δεν μπορεί να είναι κενό");
			}		
						
			// Movie Summary field
			String SUMMARY =  ServletUtilities.filter(request.getParameter("SUMMARY"));
			if (ServletUtilities.checkIfEmpty(SUMMARY)) {
				errors.add("Το πεδίο Περίληψη δεν μπορεί να είναι κενό");
			}	
			// Movie Director field
			String DIRECTOR =  ServletUtilities.filter(request.getParameter("DIRECTOR"));
			if (ServletUtilities.checkIfEmpty(DIRECTOR)) {
				errors.add("Το πεδίο Σκηνοθέτης δεν μπορεί να είναι κενό");
			}	
			
			// Movie CinemaID field
			String CINEMAS_ID =  ServletUtilities.filter(request.getParameter("CINEMAS_ID"));
			if (ServletUtilities.checkIfEmpty(CINEMAS_ID)) {
			errors.add("Το πεδίο Αίθουσα δεν μπορεί να είναι κενό");
			}
						
			// ΤΙΜΕ field
			String TIME =  ServletUtilities.filter(request.getParameter("TIME"));
			if (ServletUtilities.checkIfEmpty(TIME)) {
			errors.add("Το πεδίο Ώρα δεν μπορεί να είναι κενό");
			}	
			
			
			
			
			//CONTENT_ADMIN_ID field
			String CONTENT_ADMIN_ID =  ServletUtilities.filter(request.getParameter("CONTENT_ADMIN_ID"));
			
			if (errors.isEmpty()) {
				movieDao.addMovie(ID, NAME, CONTENT,LENGTH,TYPE,SUMMARY,DIRECTOR, CINEMAS_ID, TIME, CONTENT_ADMIN_ID);
				forward = "contentadmin?action=ListAllMovies";
				
			} else {
				request.removeAttribute("errors");
				request.setAttribute("errors", errors);
				forward = ServletUtilities.filter(request.getParameter("addMovie.jsp"));
			}
			
			
			
			
		} else if (action.equalsIgnoreCase("deleteMovie")) {
			String userRole = ServletUtilities.filter(request.getParameter("userRole"));
			System.out.println("Role= "+userRole);
	
			if (userRole.equalsIgnoreCase("contentadmin")) {
				List<String> errors = new ArrayList<String>();
	
				// ID field
				String ID =  ServletUtilities.filter(request.getParameter("ID"));
				if (ServletUtilities.checkIfEmpty(ID)) {
					errors.add("Το πεδίο ID δεν μπορεί να είναι κενό");
				} else if (ID.contains(" ")) {
					errors.add("Το πεδίο ID δεν μπορεί να περιέχει κενά");
				}
				
					
				
			
				
				if (errors.isEmpty()) {
					try {
					
						
						movieDao.deleteMovie(ID);
						forward = "contentadmin?action=ListAllMovies";
						
	
				
					}
					catch (Exception e) {
							e.printStackTrace();
					}
					
				} else {
					request.setAttribute("errors", errors);
					forward = "contentadmin?action=ListAllMovies";
					
				}
			} else {
				request.setAttribute("error", "Only users with contentadmin role can delete a movie");
				forward =  "index.jsp";
				
			}			
			
			
			
		} else	if (action.equalsIgnoreCase("assignmovie")) {
			String userRole = ServletUtilities.filter(request.getParameter("userRole"));
			System.out.println("Role= "+userRole);
	
			if (userRole.equalsIgnoreCase("contentadmin")) {
				List<String> errors = new ArrayList<String>();
	
				// CINEMAS_ID field
				String CINEMAS_ID = ServletUtilities.filter(request.getParameter("CINEMAS_ID"));
				int CID = ServletUtilities.tryParseToInt(CINEMAS_ID);
				if (CID == -1) { // Το -1 σημαίνει δεν είναι αριθμός
					errors.add("Το πεδίο ID πρέπει να είναι αριθμός");
				}
				
				
				// PROVOLES_ID field
				String PROVOLES_ID = ServletUtilities.filter(request.getParameter("PROVOLES_ID"));
				int PID = ServletUtilities.tryParseToInt(PROVOLES_ID);
				if (PID == -1) { // Το -1 σημαίνει δεν είναι αριθμός
					errors.add("Το πεδίο ID πρέπει να είναι αριθμός");
				}
				
				
				
				// NΑΜΕ field
				String NAME = ServletUtilities.filter(request.getParameter("ΝΑΜΕ"));
				if (ServletUtilities.checkIfEmpty(NAME)) {
					errors.add("Το πεδίο Όνομα δεν μπορεί να είναι κενό");
				}
				
				
				// TIME field
				String TIME = ServletUtilities.filter(request.getParameter("TIME"));
				if (ServletUtilities.checkIfEmpty(TIME)) {
					errors.add("Το πεδίο ώρα προβολής δεν μπορεί να είναι κενό");
				}
				
							
				
				// ID field
				String tempID = ServletUtilities.filter(request.getParameter("ID"));
				int ID = ServletUtilities.tryParseToInt(tempID);
				if (ID == -1) { // Το -1 σημαίνει δεν είναι αριθμός
					errors.add("Το πεδίο ID πρέπει να είναι αριθμός");
				}
				
				if (errors.isEmpty()) {
					try {
						
						
	
					
					}
					catch (Exception e) {
							e.printStackTrace();
					}
					
				} else {
					request.removeAttribute("errors");
					request.setAttribute("errors", errors);
					forward = ServletUtilities.filter(request.getParameter("registerAdmin.jsp"));
					
				}
			} else {
				request.setAttribute("error", "Only users with admin role can add an admin");
				forward =  "index.jsp";
				
			}	
		
			
			
			
			
			
			
		
    }
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

}
