package com.isp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.isp.dao.UserDAO;
import com.isp.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
		
		 response.setContentType("text/html");
	 		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.loginUser(username,password);
		
				if (user != null) {
					HttpSession session = request.getSession(true);
					
					 session.setAttribute("loggedInUser", user);//to change
					 System.out.println("Session Created: " + session);
					 System.out.println("User in Session: " + session.getAttribute("loggedInUser"));
					 session.setMaxInactiveInterval(30 * 60); 
					
					 request.getRequestDispatcher("welcome.jsp").forward(request, response);

				} else {
					response.sendRedirect("login.jsp?error = Invalid username or password");
		       
				}
}

}
