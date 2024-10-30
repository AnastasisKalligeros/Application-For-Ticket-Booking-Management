
package controller;

import java.io.IOException;



import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import model.Admin;
import model.ContentAdmin;
import utilities.ServletUtilities;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private ContentAdminDao contentadminDao;

	
	public LoginServlet() {
		super();
		userDao = new UserDao();
		contentadminDao = new ContentAdminDao();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");

		if (userDao.usernameCheck(username)==false)
		{
			String message = "There is no user with the username: "+username+", please enter a valid username!";
			request.setAttribute("messageType", "error");
			request.setAttribute("message", message);
			request.setAttribute("username", username);
			RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
			view.forward(request, response);
		}
		else
		{
			password = password + userDao.getSalt(username);
			MessageDigest digest;
			try {
					digest = MessageDigest.getInstance("SHA-1");
					byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
					password = ServletUtilities.bytesToHex(encodedhash);

					if (userDao.passwordCheck(username, password)==false)
					{
						request.setAttribute("messageType", "error");
						request.setAttribute("message", "Wrong password!");
						RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
						view.forward(request, response);
					}
					else
					{
						String role = userDao.getRole(username);
						HttpSession session = request.getSession(true);
						synchronized(session)
						{
							session.setAttribute("username", username);
							session.setAttribute("role", role);
							String forward = "/index.jsp";

							if (role.equals("admin"))
							{
								forward = "admin?action=ListAllUsers";
							}
							
							else if (role.equals("customer"))
							{
								
								forward = "film?action=ListAllFilms";
							}
							else if (role.equals("contentadmin"))
							{
								
								ContentAdmin contentadmin = contentadminDao.getContentAdminByUsername(username);
								session.setAttribute("contentadmin", contentadmin);
								forward = "contentadmin?action=ListAllMovies";
							}
							else
							{
								
								System.out.println("Can't recognise the user's role!");
							}
							RequestDispatcher view = request.getRequestDispatcher(forward);
							view.forward(request, response);
						}
					}
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
