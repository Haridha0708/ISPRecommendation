<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
	<%@ page import="com.isp.model.Plans" %>
	<%@ page import="javax.servlet.http.HttpSession" %>
	<%@ page import="com.isp.model.User" %>
	<%
    	HttpSession sessionObj = request.getSession(false);
	 	User user = (sessionObj != null) ? (User) sessionObj.getAttribute("loggedInUser") : null;
   					 if (user == null) {
     					   response.sendRedirect("login.jsp?error=Please login first!");
     				   return;
  					  }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recommended  Plans</title>
 <style>
        body {
        font-family: Arial, sans-serif; background-color: #eef2f3; padding: 40px; text-align: center;
        }
       .container { 
       max-width: 750px;margin: auto;  background: white; padding: 30px;border-radius: 12px;box-shadow: 0 0 12px rgba(0, 0, 0, 0.15);
        }
        table {
         width: 100%; border-collapse: collapse; margin-top: 20px;
        }
        table th, table td { 
        border: 1px solid #ddd; padding: 12px;
        }
        table th {
         background-color: #007bff;
       	 color: white;
         }
        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        p {
            font-size: 18px;
        }
        .back-link {
            margin-top: 30px; display: inline-block;  color: #007bff;  font-weight: bold;  text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>

</head>
<body>
 <%
        List<Plans> recommendedPlans = (List<Plans>) request.getAttribute("recommendedPlans");
        if (recommendedPlans != null && !recommendedPlans.isEmpty()) {
    %>
    			<p>We found <strong><%= recommendedPlans.size() %></strong> plan(s) matching your preferences.</p>
   				<h2>Recommended ISP  Plans</h2>
    					<table border="1">
      							  <tr>
          								 <th>Plan Name</th>
           								 <th>Speed</th>
            							<th>Price</th>
            							<th>Data Limit</th>
       							 </tr>
        <% for (Plans isp : recommendedPlans) { %>
                <tr>
                    <td><%= isp.getPlanName() %></td>
                    <td><%= isp.getSpeed() %> Mbps</td>
                    <td>$<%= isp.getPrice() %></td>
                    <td><%= isp.getDataLimit() %></td>
                </tr>
        <% } %>
        </table>
        <% } else { %>
            <p style="color: red;">No ISP plans available for your selection.</p>
         <% } %>
    <a class ="back link" href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>