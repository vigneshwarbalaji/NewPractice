package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import cloudDao.UserService;
import cloudDao.UserServiceImpl;
import model.User;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init() throws ServletException {
	    UserService dao = new UserServiceImpl();
	    this.getServletContext().setAttribute("dao", dao);
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User user = new User();
		
		user.setName(request.getParameter("name"));
		user.setMail(request.getParameter("email"));
		
		UserService dao = (UserService) this.getServletContext().getAttribute("dao");
		
		boolean result = dao.createUser(user);
		
		if(result == true)
		{
			response.getWriter().print(user.getName());
			response.getWriter().print(user.getMail());
		}
		
	}

}
