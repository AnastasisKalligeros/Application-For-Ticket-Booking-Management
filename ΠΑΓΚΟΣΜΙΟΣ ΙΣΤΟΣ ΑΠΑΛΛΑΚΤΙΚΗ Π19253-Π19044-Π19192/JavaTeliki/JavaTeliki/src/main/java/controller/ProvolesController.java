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

import model.Film;
import model.Movie;
import dao.MovieDao;
import dao.FilmDao;
import utilities.ServletUtilities;

@WebServlet("/provoles")
public class ProvolesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;
	private FilmDao filmDao;
	public ProvolesController() {
		super();
		movieDao=new MovieDao();
		filmDao=new FilmDao();

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
	
		
	
			if (action.equalsIgnoreCase("ListAllProvoles")){
				forward = "/AssignMovie.jsp";
				List<Movie> movies =movieDao.getAllMovies();
				request.removeAttribute("Movies");
				request.setAttribute("Movies", movies);
		
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	
		}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
	