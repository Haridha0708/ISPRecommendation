package com.isp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isp.dao.UserDAO;
import com.isp.model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
	     //PrintWriter out = response.getWriter();*/
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String preference = request.getParameter("preference");
		
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.validateUser(username)) {
				response.sendRedirect("register.jsp?error=Username already exists!");
				return;
			} 
			User user = new User();
			user.setUserName(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPreference(preference);
			
			if (userDAO.registerUser(user))
			{
				
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(30 * 60);
                response.sendRedirect("dashboard.jsp");
              
            } else {
                response.sendRedirect("register.jsp?error=Registration failed. Try again.");
            }
		} catch (Exception e) {
			  e.printStackTrace();
			  response.sendRedirect("register.jsp?error=Error occurred: " + e.getMessage());
		}
	}
}
