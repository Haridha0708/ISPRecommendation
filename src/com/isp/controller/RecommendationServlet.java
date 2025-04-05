package com.isp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isp.dao.PlanDAO;
import com.isp.model.Plans;
import com.isp.util.DBConnection;

@WebServlet("/recommendation")
public class RecommendationServlet extends HttpServlet{
	  private static final long serialVersionUID = 1L;
	
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   	
					 response.setContentType("text/html");
				     PrintWriter out = response.getWriter();
				     
				     HttpSession session = request.getSession(false);
				     System.out.println("Session in RecommendationServlet: " + session);
				     System.out.println("User in Session: " + (session != null ? session.getAttribute("loggedInUser") : "null"));
		
				     if (session == null || session.getAttribute("loggedInUser") == null) {
				            response.sendRedirect("login.jsp?error=Please login first!");
				            return;
				        }
				     String userPreference = ((com.isp.model.User) session.getAttribute("loggedInUser")).getPreference();
				     ArrayList<Plans> planisp = new ArrayList<>();
				     Connection conn = null;
			    	  PreparedStatement ps = null;
				    ResultSet rs= null;
		  try {
			  conn = DBConnection.getConnection();
			  String query = "SELECT * FROM plans WHERE category = ?";
			  ps = conn.prepareStatement(query);
	          ps.setString(1, userPreference);
	           rs = ps.executeQuery();
	            
	            while (rs.next()) {
					Plans plan = new Plans();
					plan.setPlanId(rs.getInt("plan_id"));
					plan.setPlanName(rs.getString("plan_name"));
					plan.setPrice(rs.getDouble("price"));
					plan.setSpeed(rs.getInt("speed"));
					plan.setCategory(rs.getString("category"));
					planisp.add(plan);
				}
	         
		} catch (Exception e) {
					e.printStackTrace();
		}finally {
			 try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
	          try { if (ps != null) ps.close(); } catch (Exception e) { e.printStackTrace(); }
	          try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
		}

	        request.setAttribute("recommendedPlans", planisp );
	        request.getRequestDispatcher("/recommendation.jsp").forward(request, response);
		    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(false);

    if (session == null || session.getAttribute("loggedInUser") == null) {
        response.sendRedirect("login.jsp?error=Please login first!");
        return;
    }
    String speedParam = request.getParameter("speed");
    String priceParam = request.getParameter("price");
    String category = request.getParameter("category");

    int speed =  0;
    double price = Double.MAX_VALUE;

    if (speedParam != null && !speedParam.isEmpty()) {
        try {
            speed = Integer.parseInt(speedParam);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Speed: " + speedParam);
            e.printStackTrace();
        }
    }

    if (priceParam != null && !priceParam.isEmpty()) {
        try {
            price = Double.parseDouble(priceParam);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Price: " + priceParam);
            e.printStackTrace();
        }
    }
    if ("All".equalsIgnoreCase(category)) {
        category = "%"; // wildcard match for LIKE in SQL
    }
    System.out.println("Received Speed: " + speed);
    System.out.println("Received Price: " + price);
    System.out.println("Received Category: " + category);

  
    PlanDAO planDAO = new PlanDAO();
    List<Plans> planList = planDAO.getPlansByFilter(speed, price, category);

    System.out.println("Plans Found"+planList.size());
    request.setAttribute("recommendedPlans", planList);
    request.getRequestDispatcher("recommendation.jsp").forward(request, response);
}

				 
				   
			}


