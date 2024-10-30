
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

import dao.UserDao;
import dao.AdminDao;
import model.CreateUser;
import model.User;
import utilities.ServletUtilities;





@WebServlet("/admin")
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDao;
    private AdminDao adminDao;
   
    
    public AdminController() {
        super();
        userDao = new UserDao();
        adminDao = new AdminDao();
       

    }

   

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "20");
		
		
		String action = request.getParameter("action");
		String forward = "admin?action=ListAllusers";
	
		if (action.equalsIgnoreCase("ListAllUsers")){
			forward = "/admin_main.jsp";
			List<CreateUser> users =userDao.getAllUsers();
			request.removeAttribute("CreateUsers");
			request.setAttribute("CreateUsers", users);
			
			
		} else if (action.equalsIgnoreCase("deleteContentAdmin") || action.equalsIgnoreCase("deleteCustomer")) {
				String userRole = ServletUtilities.filter(request.getParameter("userRole"));
				System.out.println("Role= "+userRole);
				
		
				if (userRole.equalsIgnoreCase("admin")) {
					List<String> errors = new ArrayList<String>();
		
					// Username field
					String username =  ServletUtilities.filter(request.getParameter("username"));
					if (ServletUtilities.checkIfEmpty(username)) {
						errors.add("�� ����� Username ��� ������ �� ����� ����");
					} else if (username.contains(" ")) {
						errors.add("�� ����� Username ��� ������ �� �������� ����");
					}
													
				
					
					if (errors.isEmpty()) {
						try {
						
							
							userDao.deleteContentAdmin(username);
							adminDao.deleteCustomer(username);
							forward= "admin?action=ListAllUsers";
							
								
					
						}
						catch (Exception e) {
								e.printStackTrace();
						}
						
					} else {
						request.removeAttribute("errors");
						request.setAttribute("errors", errors);
						forward = ServletUtilities.filter(request.getParameter("deleteContentAdmin.jsp"));

						
					}
				} else {
					request.setAttribute("error", "Only users with contentadmin role can delete a contentadmin");
					forward =  "index.jsp";
					
				}		
				
				
		} else	if (action.equalsIgnoreCase("addAdmin")) {
					String userRole = ServletUtilities.filter(request.getParameter("userRole"));
					System.out.println("Role= "+userRole);
			
					if (userRole.equalsIgnoreCase("admin")) {
						List<String> errors = new ArrayList<String>();
			
						// Username field
						String username =  ServletUtilities.filter(request.getParameter("username"));
						if (ServletUtilities.checkIfEmpty(username)) {
							errors.add("�� ����� Username ��� ������ �� ����� ����");
						} else if (username.contains(" ")) {
							errors.add("�� ����� Username ��� ������ �� �������� ����");
						} else if (userDao.usernameCheck(username) == true) {
							errors.add("� ������� �� username "+ username +" ������� ���!");
						}
						
						// Password field
						String password =  ServletUtilities.filter(request.getParameter("password1"));
						String salt = ServletUtilities.getAlphaNumericString(16);
						if (ServletUtilities.checkIfEmpty(password)) {
							errors.add("�� ����� Password ��� ������ �� ����� ����");
						} else if (password.length() < 8) {
							errors.add("�� ����� Password ������ �� �������� ����������� 8 ����������");
						} else {
							String checkPassword =  ServletUtilities.filter(request.getParameter("password2"));
							if (!password.equals(checkPassword)) {
								errors.add("�� ����� Password ��� Retype Password ��� ����� ����");
							}
						}
						
						// Name field
						String name = ServletUtilities.filter(request.getParameter("name"));
						if (ServletUtilities.checkIfEmpty(name)) {
							errors.add("�� ����� ����� ��� ������ �� ����� ����");
						}
						
						// Email field
						String email = ServletUtilities.filter(request.getParameter("email"));
						if (ServletUtilities.checkIfEmpty(email)) {
							errors.add("�� ����� Email ��� ������ �� ����� ����");
						}
						
						// Role field
						String role = ServletUtilities.filter(request.getParameter("role"));
						
						// ID field
						String tempID = ServletUtilities.filter(request.getParameter("ID"));
						int ID = ServletUtilities.tryParseToInt(tempID);
						if (ID == -1) { // �� -1 �������� ��� ����� �������
							errors.add("�� ����� ID ������ �� ����� �������");
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
				
				
		}	else	if (action.equalsIgnoreCase("addCustomer")) {
			String userRole = ServletUtilities.filter(request.getParameter("userRole"));
			System.out.println("Role= "+userRole);
	
			if (userRole.equalsIgnoreCase("admin")) {
				List<String> errors = new ArrayList<String>();
	
				// Username field
				String username =  ServletUtilities.filter(request.getParameter("username"));
				if (ServletUtilities.checkIfEmpty(username)) {
					errors.add("�� ����� Username ��� ������ �� ����� ����");
				} else if (username.contains(" ")) {
					errors.add("�� ����� Username ��� ������ �� �������� ����");
				} else if (userDao.usernameCheck(username) == true) {
					errors.add("� ������� �� username "+ username +" ������� ���!");
				}
				
				// Password field
				String password =  ServletUtilities.filter(request.getParameter("password1"));
				String salt = ServletUtilities.getAlphaNumericString(16);
				if (ServletUtilities.checkIfEmpty(password)) {
					errors.add("�� ����� Password ��� ������ �� ����� ����");
				} else if (password.length() < 8) {
					errors.add("�� ����� Password ������ �� �������� ����������� 8 ����������");
				} else {
					String checkPassword =  ServletUtilities.filter(request.getParameter("password2"));
					if (!password.equals(checkPassword)) {
						errors.add("�� ����� Password ��� Retype Password ��� ����� ����");
					}
				}
				
				// Name field
				String name = ServletUtilities.filter(request.getParameter("name"));
				if (ServletUtilities.checkIfEmpty(name)) {
					errors.add("�� ����� ����� ��� ������ �� ����� ����");
				}
				
				// Email field
				String email = ServletUtilities.filter(request.getParameter("email"));
				if (ServletUtilities.checkIfEmpty(email)) {
					errors.add("�� ����� Email ��� ������ �� ����� ����");
				}
				
				// Role field
				String role = ServletUtilities.filter(request.getParameter("role"));
				
				// ID field
				String ID = ServletUtilities.filter(request.getParameter("CUSTOMERS_ID"));
				
				
				if (errors.isEmpty()) {
					try {
						password = password + salt;
						MessageDigest digest;
						digest = MessageDigest.getInstance("SHA-1");
						byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
						password = ServletUtilities.bytesToHex(encodedhash);
						
						userDao.addUser(username, email, password, salt, role);
						
						adminDao.addCustomer(ID,name,username);
						forward= "admin?action=ListAllUsers";
	
					
					}
					catch (Exception e) {
							e.printStackTrace();
					}
					
				} else {
					request.setAttribute("errors", errors);
					forward = ServletUtilities.filter(request.getParameter("returnPage"));
					
				}
			} else {
				request.setAttribute("error", "Only users with admin role can add a customer");
				forward =  "index.jsp";
				
			}	
				
		
				} else {
					request.setAttribute("error", "Only users with contentadmin role can delete a contentadmin");
					forward =  "index.jsp";			
			
				
					
		
    }
		
		
		
		
		
     if (action.equalsIgnoreCase("addContentAdmin")) {
				String userRole = ServletUtilities.filter(request.getParameter("userRole"));
				System.out.println("Role= "+userRole);
		
				if (userRole.equalsIgnoreCase("admin")) {
					List<String> errors = new ArrayList<String>();
		
					// Username field
					String username =  ServletUtilities.filter(request.getParameter("username"));
					if (ServletUtilities.checkIfEmpty(username)) {
						errors.add("�� ����� Username ��� ������ �� ����� ����");
					} else if (username.contains(" ")) {
						errors.add("�� ����� Username ��� ������ �� �������� ����");
					} else if (userDao.usernameCheck(username) == true) {
						errors.add("� ������� �� username "+ username +" ������� ���!");
					}
					
					// Password field
					String password =  ServletUtilities.filter(request.getParameter("password1"));
					String salt = ServletUtilities.getAlphaNumericString(16);
					if (ServletUtilities.checkIfEmpty(password)) {
						errors.add("�� ����� Password ��� ������ �� ����� ����");
					} else if (password.length() < 8) {
						errors.add("�� ����� Password ������ �� �������� ����������� 8 ����������");
					} else {
						String checkPassword =  ServletUtilities.filter(request.getParameter("password2"));
						if (!password.equals(checkPassword)) {
							errors.add("�� ����� Password ��� Retype Password ��� ����� ����");
						}
					}
					
					// Name field
					String name = ServletUtilities.filter(request.getParameter("name"));
					if (ServletUtilities.checkIfEmpty(name)) {
						errors.add("�� ����� ����� ��� ������ �� ����� ����");
					}
					
					// Email field
					String email = ServletUtilities.filter(request.getParameter("email"));
					if (ServletUtilities.checkIfEmpty(email)) {
						errors.add("�� ����� Email ��� ������ �� ����� ����");
					}
					
					// Role field
					String role = ServletUtilities.filter(request.getParameter("role"));
					
					// ID field
					String tempID = ServletUtilities.filter(request.getParameter("ID"));
					int ID = ServletUtilities.tryParseToInt(tempID);
					if (ID == -1) { // �� -1 �������� ��� ����� �������
						errors.add("�� ����� ID ������ �� ����� �������");
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
