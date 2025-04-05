package com.isp.controller;

	import com.isp.dao.PlanDAO;
	import com.isp.model.Plans;
	import com.isp.model.User;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.*;
	import java.io.IOException;
	import java.util.List;

	@WebServlet("/DashboardServlet")
	public class DashboardServlet extends HttpServlet {
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        HttpSession session = request.getSession(false);

	        // Check user is logged in
	        if (session == null || session.getAttribute("loggedInUser") == null) {
	            response.sendRedirect("login.jsp?error=Please login first!");
	            return;
	        }

	        // Fetch categories and distinct prices from PlanDAO
	        PlanDAO planDAO = new PlanDAO();
	        List<String> categories = planDAO.getAllCategories();
	        List<Double> prices = planDAO.getAllDistinctPrices();
	        List<Integer> speedList = planDAO.getAllDistinctSpeeds();
	      

	        // Set to request
	        request.setAttribute("categories", categories);
	        request.setAttribute("allPrices", prices);
	        request.setAttribute("speedList", speedList);

	        // Forward to dashboard.jsp
	        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	    }
	}



