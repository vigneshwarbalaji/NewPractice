package com.org.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

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
		
		String email = request.getParameter("email").trim();
		String pass = request.getParameter("pass").trim();
		
		HttpSession session = request.getSession(false);
		
		if(email.isEmpty()||pass.isEmpty())
		{
			response.getWriter().print("<h6>please fill all the details</h6>");
		}
		else
		{
			UserService dao = (UserService) this.getServletContext().getAttribute("dao");
			UserAccounts userAcc = dao.getUserByMail(email);
			
			if(userAcc == null)
			{
				response.getWriter().print("<h6>User doesnot exist.Please register.</h6>");
			}
			else if(!(userAcc.getPassword().equals(pass)))
			{
				response.getWriter().print("<h6>Password incorrect</h6>");
			}
			else
			{
//				RequestDispatcher rs = request.getRequestDispatcher("/DashController");
//				rs.forward(request, response);
				
				//response.setContentType("URL");
				//response.setHeader("check", "true");
				
				//response.sendRedirect("Dashboard.jsp");
				
				session = request.getSession(true);
				session.setAttribute("email", userAcc.getEmail());
				session.setAttribute("name", userAcc.getName());
				//System.out.println(userAcc.getEmail());
				
				response.getWriter().print("true");
//				request.setAttribute("welcomeString", "Account created successfully");           // Tells base.jsp to include form.jsp
//				request.getRequestDispatcher("/Dashboard.jsp").forward(request, response);
				
//				response.setContentType("application/json");
//				response.setHeader("url","Dashboard.jsp");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String pass = request.getParameter("pass").trim();
		String rePass = request.getParameter("rePass").trim();
		
		
        HttpSession session = request.getSession(false);

		//PrintWriter out = response.getWriter();
		
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
				//response.getWriter().print("<h6>User created with name:"+users.getName()+"<br>");
//				RequestDispatcher rs = request.getRequestDispatcher("Dashboard.jsp");
//				rs.forward(request, response);
				
//				session = request.getSession(true);
//				session.setAttribute("email", users.getEmail());
//				System.out.println(users.getEmail());
				response.getWriter().print("true");
				
			}
			else
			{
				response.getWriter().print("<h6>Account Already exists</h6>"+"<br>");
			}
			
		}
		
		
	}

}
