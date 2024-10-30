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
import dao.AdminDao;
import dao.ContentAdminDao;
import dao.UserDao;
import model.ContentAdmin;
import model.Customer;
import model.Movie;
import model.Reservation;
import dao.MovieDao;
import dao.ReservationDao;
import dao.CustomerDao;
import utilities.ServletUtilities;

@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private AdminDao adminDao;
	private ContentAdminDao contentadminDao;
	private MovieDao movieDao;
	private CustomerDao customerDao;
	private ReservationDao reservationDao;
	
	public CustomerController() {
		super();
		userDao=new UserDao();
		movieDao=new MovieDao();
		adminDao=new AdminDao();
		contentadminDao=new ContentAdminDao();
		reservationDao = new ReservationDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "20");
		
		String forward = "/index.jsp";
		String action =  ServletUtilities.filter(request.getParameter("action"));
		


		
		 if (action.equalsIgnoreCase("deleteCustomer")) {
		String userRole = ServletUtilities.filter(request.getParameter("userRole"));
		System.out.println("Role= "+userRole);

		if (userRole.equalsIgnoreCase("admin")) {
			List<String> errors = new ArrayList<String>();

			// Username field
			String username =  ServletUtilities.filter(request.getParameter("username"));
			if (ServletUtilities.checkIfEmpty(username)) {
				errors.add("Το πεδίο Username δεν μπορεί να είναι κενό");
			} else if (username.contains(" ")) {
				errors.add("Το πεδίο Username δεν μπορεί να περιέχει κενά");
			}
											
		
			
			if (errors.isEmpty()) {
				try {
				
					
					adminDao.deleteCustomer(username);
					
						
			
				}
				catch (Exception e) {
						e.printStackTrace();
				}
				
			} else {
				request.setAttribute("errors", errors);
				forward = ServletUtilities.filter(request.getParameter("returnPage"));
				
			}
		} else {
			request.setAttribute("error", "Only users with contentadmin role can delete a contentadmin");
			forward =  "index.jsp";
			
		}	
	
		 }
		 
		
		 
		 
		
			
		 
		 
			  
		 
		 
			
			
			
	  
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	  }
	
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
	