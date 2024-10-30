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
import model.Movie;
import model.User;
import model.CreateUser;
import dao.MovieDao;
import utilities.ServletUtilities;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private AdminDao adminDao;
	private ContentAdminDao contentadminDao;
	private MovieDao movieDao;
	
	public RegisterServlet() {
		super();
		userDao=new UserDao();
		movieDao=new MovieDao();
		adminDao=new AdminDao();
		contentadminDao=new ContentAdminDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "20");;
		
		
		String forward = "/index.jsp";
		String action =  ServletUtilities.filter(request.getParameter("action"));
		

		if (action.equalsIgnoreCase("ListAllUsers")){
			forward = "/admin_main.jsp";
			List<CreateUser> users =userDao.getAllUsers();
			request.removeAttribute("CreateUsers");
			request.setAttribute("CreateUsers", users);
			
							
		
    }
		
		if (action.equalsIgnoreCase("addContentAdmin")) {
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
				} else if (userDao.usernameCheck(username) == true) {
					errors.add("Ο χρήστης με username "+ username +" υπάρχει ήδη!");
				}
				
				// Password field
				String password =  ServletUtilities.filter(request.getParameter("password1"));
				String salt = ServletUtilities.getAlphaNumericString(16);
				if (ServletUtilities.checkIfEmpty(password)) {
					errors.add("Το πεδίο Password δεν μπορεί να είναι κενό");
				} else if (password.length() < 8) {
					errors.add("Το πεδίο Password πρέπει να περιέχει τουλάχιστον 8 χαρακτήρες");
				} else {
					String checkPassword =  ServletUtilities.filter(request.getParameter("password2"));
					if (!password.equals(checkPassword)) {
						errors.add("Τα πεδία Password και Retype Password δεν είναι ίδια");
					}
				}
				
				// Name field
				String name = ServletUtilities.filter(request.getParameter("name"));
				if (ServletUtilities.checkIfEmpty(name)) {
					errors.add("Το πεδίο Όνομα δεν μπορεί να είναι κενό");
				}
				
				// Email field
				String email = ServletUtilities.filter(request.getParameter("email"));
				if (ServletUtilities.checkIfEmpty(email)) {
					errors.add("Το πεδίο Email δεν μπορεί να είναι κενό");
				}
				
				// Role field
				String role = ServletUtilities.filter(request.getParameter("role"));
				
				// ID field
				String tempID = ServletUtilities.filter(request.getParameter("ID"));
				int ID = ServletUtilities.tryParseToInt(tempID);
				if (ID == -1) { // Το -1 σημαίνει δεν είναι αριθμός
					errors.add("Το πεδίο ID πρέπει να είναι αριθμός");
				}
				
				if (errors.isEmpty()) {
				
					try {
						password = password + salt;
						MessageDigest digest;
						digest = MessageDigest.getInstance("SHA-1");
						byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
						password = ServletUtilities.bytesToHex(encodedhash);
						
						userDao.addUser(username, email, password, salt, role);
						
						adminDao.addContentAdmin(ID,name,username);
						
						forward= "admin?action=ListAllUsers";
	
					
					}
					catch (Exception e) {
							e.printStackTrace();
					}
					
				} else {
					request.setAttribute("errors", errors);
					forward = "admin?action=ListAllUsers";
					
				}
			} else {
				request.setAttribute("error", "Only users with admin role can add a contentadmin");
				forward =  "index.jsp";
				
			}	
			
			
		
		
		}	else	if (action.equalsIgnoreCase("addAdmin")) {
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
					} else if (userDao.usernameCheck(username) == true) {
						errors.add("Ο χρήστης με username "+ username +" υπάρχει ήδη!");
					}
					
					// Password field
					String password =  ServletUtilities.filter(request.getParameter("password1"));
					String salt = ServletUtilities.getAlphaNumericString(16);
					if (ServletUtilities.checkIfEmpty(password)) {
						errors.add("Το πεδίο Password δεν μπορεί να είναι κενό");
					} else if (password.length() < 8) {
						errors.add("Το πεδίο Password πρέπει να περιέχει τουλάχιστον 8 χαρακτήρες");
					} else {
						String checkPassword =  ServletUtilities.filter(request.getParameter("password2"));
						if (!password.equals(checkPassword)) {
							errors.add("Τα πεδία Password και Retype Password δεν είναι ίδια");
						}
					}
					
					// Name field
					String name = ServletUtilities.filter(request.getParameter("name"));
					if (ServletUtilities.checkIfEmpty(name)) {
						errors.add("Το πεδίο Όνομα δεν μπορεί να είναι κενό");
					}
					
					// Email field
					String email = ServletUtilities.filter(request.getParameter("email"));
					if (ServletUtilities.checkIfEmpty(email)) {
						errors.add("Το πεδίο Email δεν μπορεί να είναι κενό");
					}
					
					// Role field
					String role = ServletUtilities.filter(request.getParameter("role"));
					
					// ID field
					String tempID = ServletUtilities.filter(request.getParameter("ID"));
					int ID = ServletUtilities.tryParseToInt(tempID);
					if (ID == -1) { // Το -1 σημαίνει δεν είναι αριθμός
						errors.add("Το πεδίο ID πρέπει να είναι αριθμός");
					}
					
					if (errors.isEmpty()) {
						try {
							password = password + salt;
							MessageDigest digest;
							digest = MessageDigest.getInstance("SHA-1");
							byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
							password = ServletUtilities.bytesToHex(encodedhash);
							
							userDao.addUser(username, email, password, salt, role);
							
							adminDao.addAdmin(ID,name,username);
							forward= "admin?action=ListAllUsers";
		
						
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
				
		}else	if (action.equalsIgnoreCase("addCustomer")) {
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
						} else if (userDao.usernameCheck(username) == true) {
							errors.add("Ο χρήστης με username "+ username +" υπάρχει ήδη!");
						}
						
						// Password field
						String password =  ServletUtilities.filter(request.getParameter("password1"));
						String salt = ServletUtilities.getAlphaNumericString(16);
						if (ServletUtilities.checkIfEmpty(password)) {
							errors.add("Το πεδίο Password δεν μπορεί να είναι κενό");
						} else if (password.length() < 8) {
							errors.add("Το πεδίο Password πρέπει να περιέχει τουλάχιστον 8 χαρακτήρες");
						} else {
							String checkPassword =  ServletUtilities.filter(request.getParameter("password2"));
							if (!password.equals(checkPassword)) {
								errors.add("Τα πεδία Password και Retype Password δεν είναι ίδια");
							}
						}
						
						// Name field
						String name = ServletUtilities.filter(request.getParameter("name"));
						if (ServletUtilities.checkIfEmpty(name)) {
							errors.add("Το πεδίο Όνομα δεν μπορεί να είναι κενό");
						}
						
						// Email field
						String email = ServletUtilities.filter(request.getParameter("email"));
						if (ServletUtilities.checkIfEmpty(email)) {
							errors.add("Το πεδίο Email δεν μπορεί να είναι κενό");
						}
						
						// Role field
						String role = ServletUtilities.filter(request.getParameter("role"));
						
						// ID field
						String CUSTOMERS_ID = ServletUtilities.filter(request.getParameter("CUSTOMERS_ID"));
					
						
						if (errors.isEmpty()) {
							try {
								password = password + salt;
								MessageDigest digest;
								digest = MessageDigest.getInstance("SHA-1");
								byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
								password = ServletUtilities.bytesToHex(encodedhash);
								
								userDao.addUser(username, email, password, salt, role);
								
								adminDao.addCustomer(CUSTOMERS_ID,name,username);
								forward= "admin?action=ListAllUsers";
			
							
							}
							catch (Exception e) {
									e.printStackTrace();
							}
							
						} else {
							request.removeAttribute("errors");
							request.setAttribute("errors", errors);
							forward = ServletUtilities.filter(request.getParameter("registerCustomer.jsp"));
							
						}
					} else {
						request.setAttribute("error", "Only users with admin role can add a customer");
						forward =  "index.jsp";
						
					}	
			
			
		
			
			
		}
			
			
		
			
	
	
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
	