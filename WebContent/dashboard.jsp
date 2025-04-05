<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.isp.model.User" %>
<%@ page import="com.isp.model.Plans" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
		HttpSession sessionObj = request.getSession(false);
		    User user = (sessionObj != null) ? (User) sessionObj.getAttribute("loggedInUser") : null;
		if (user == null) {
  				  response.sendRedirect("login.jsp?error=Please login first!");
  		  return;
		}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dashboard - ISP Recommendation</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding: 20px; background-color: #f4f4f4; }
        .container { max-width: 600px; background: white; padding: 20px; border-radius: 10px; box-shadow: 2px 2px 10px rgba(0,0,0,0.1); }
        select, input, button { width: 90%; padding: 10px; margin: 10px 0; border-radius: 5px; border: 1px solid #ccc; }
        button { background: #007bff; color: white; cursor: pointer; }
        button:hover { background: #0056b3; }
        table { width: 100%; margin-top: 20px; border-collapse: collapse; }
        th, td { padding: 10px; border: 1px solid #ddd; text-align: center; }
        th { background-color: #007bff; color: white; }
        a { display: block; margin-top: 20px; text-decoration: none; font-weight: bold; color: red; }
    </style>
   
</head>
<body>

    <div class="container">
        <h2>Welcome, <%= user.getUserName() %>!</h2>
        <p>Email: <%= user.getEmail() %></p>
       
        <h3>Select ISP Recommendations</h3>
        <form action="recommendation" method="post">
        <label for="category">Select Category:</label>
            <select id="category" name="category">
                <option value="All">All</option>
                <option value="Basic">Basic</option>
                <option value="Premium">Premium</option>
                <option value="Unlimited">Unlimited</option>
                <option value="Business">Business</option>
                <option value="Gaming">Gaming</option>
                 <option value="Enterprise">Enterprise</option>
                 <% 
                    List<String> categories = (List<String>) request.getAttribute("categories");
                    if (categories != null) {
                        for (String cat : categories) {
                %>
                    <option value="<%= cat %>"><%= cat %></option>
                <% } } %>
            </select>
           

            <label for="price">Max Price ($):</label>
             <select id="price" name="price">
               		 <option value="All">All</option>
                  	 <option value="1500">$1500</option>
                   	
                     <option value="700">$700</option>
                	 
                     <option value="500">$500</option>
                
                    <option value="50">$50</option>
                
            <% 
                    List<Double> allPrices = (List<Double>) request.getAttribute("allPrices");
                    if (allPrices != null) {
                        for (Double p : allPrices) {
                %>
                    <option value="<%= p %>"><%= p %></option>
                <% } } %>
                
            </select>
             <label for="speed">Minimum Speed (Mbps):</label>
         				<select id="speed" name="speed">
    								<option value="All">All</option>
    								<option value="100">100 Mbps</option>
    								<option value="500">500 Mbps</option>
    								<option value="800">800 Mbps</option>
    								<option value="1000">1000 Mbps</option>
   									 <option value="3000">3000 Mbps</option>
						</select>

                <% 
    List<Integer> speedList = (List<Integer>) request.getAttribute("speedList");
    if (speedList != null) {
        for (Integer sp : speedList) {
%>
    <option value="<%= sp %>"><%= sp %> Mbps</option>
<%
        }
    }
%>

            <button type="submit">Get Recommendations</button>
        </form>
        <% 
            List<Plans> recommendedPlans = (List<Plans>) request.getAttribute("recommendedPlans");
            if (recommendedPlans != null && !recommendedPlans.isEmpty()) { 
        %>
            <h3>Available ISP Plans</h3>
            <table>
                <tr>
                    <th>Plan Name</th>
                    <th>Speed (Mbps)</th>
                    <th>Price ($)</th>
                    <th>Data Limit</th>
                    <th>Category</th>
                </tr>
                <% for (Plans plan : recommendedPlans) { %>
                    <tr>
                        <td><%= plan.getPlanName() %></td>
                        <td><%= plan.getSpeed() %></td>
                        <td>$<%= plan.getPrice() %></td>
                        <td><%= plan.getDataLimit() %></td>
                        <td><%= plan.getCategory() %></td>
                    </tr>
               <%} %>
            </table>
              <%} %>
        <a href="LogoutServlet">Logout</a>
    </div>

</body>
</html>
