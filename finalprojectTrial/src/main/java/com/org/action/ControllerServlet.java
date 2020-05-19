package com.org.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;
import com.org.dao.UserService;
import com.org.dao.UserServiceImpl;
import com.org.model.UserAccounts;




/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.init();
        ObjectifyService.register(UserAccounts.class);
	    UserService dao = new UserServiceImpl();
	    this.getServletContext().setAttribute("dao", dao);
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String pass = request.getParameter("pass").trim();
		String rePass = request.getParameter("rePass").trim();
		
		
		int passLength = pass.length();
		int rePassLength = rePass.length();
		
		
		if((name.isEmpty()||email.isEmpty()||
				pass.isEmpty() ||rePass.isEmpty()))
		{
			response.getWriter().print("<h6>please fill all the details</h6>");
		}
		else if(!(pass.equals(rePass)) || passLength != rePassLength)
		{
			response.getWriter().print("<h6>Password doesn't match</h6>");
		}
		else if(pass.length() < 6 || rePass.length() < 6)
		{
			response.getWriter().print("<h6>Password must atleast be of length 6</h6>");
		}
		else
		{
//			System.out.println(name);
//			System.out.println(email);
//			System.out.println(pass);
//			System.out.println(rePass);
			UserAccounts users = new UserAccounts();
			boolean result = false;
			
			users.setId(null);
			users.setName(name);
			users.setEmail(email);
			users.setPassword(pass);
			//user.setId(user.getId());
			
			UserService dao = (UserService) this.getServletContext().getAttribute("dao");
			
			result = dao.createUserAcc(users);
			
			if(result == true)
			{
				response.getWriter().print("<h6>User created with name:"+users.getName()+"<br>");

			}
			else
			{
				response.getWriter().print("<h6>Account creation failed</h6>"+"<br>");
			}
			
		}
		
		
	}

}
