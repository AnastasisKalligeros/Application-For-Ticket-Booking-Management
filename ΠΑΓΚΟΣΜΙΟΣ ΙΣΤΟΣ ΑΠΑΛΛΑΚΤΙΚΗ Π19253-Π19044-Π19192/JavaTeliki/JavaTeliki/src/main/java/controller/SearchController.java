
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





@WebServlet("/search")
public class SearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDao;
    private AdminDao adminDao;
   
    
    public SearchController() {
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
		String forward = "SearchUser.jsp";
		
	
		if (action.equalsIgnoreCase("searchUser")) {
		    forward = "/ResultSearch.jsp";
		    String username = request.getParameter("username"); 
		    List<CreateUser> users = adminDao.searchUsers(username);
		    request.removeAttribute("CreateUsers");
		    request.setAttribute("CreateUsers", users);
	
		
    
			
		
			
			
	
					
		
    }
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

}
