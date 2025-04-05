<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<% 
    HttpSession sessionObj = request.getSession(false);
    if (sessionObj != null && sessionObj.getAttribute("user") != null) {
        response.sendRedirect("dashboard.jsp");
        return;
    }
%>
<% String error = request.getParameter("error"); %>
<% if (error != null) { %>
    <p style="color: red;"><%= error %></p>
<% } %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login - ISP Recommendation</title>
   <style>
    body {   font-family: Arial, sans-serif;  text-align: center;  padding: 50px; background-color: #f4f4f4;
    }
    .container { max-width: 600px; margin: auto; background: white; padding: 20px; border: 1px solid #ddd; border-radius: 10px; box-shadow: 2px 2px 10px rgba(0,0,0,0.1);
    }
    input, select, button { width: 90%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 5px;
    }
    button {background: #007bff; color: white;border: none;cursor: pointer;font-size: 16px;
    }
    button:hover { background: #0056b3;
    }
    a {display: block;margin-top: 20px;color: red;text-decoration: none;font-weight: bold;
    }
</style>
</head>
<body>
<div class="container">
    <h2>Login</h2>
     <% if (request.getParameter("error") != null) { %>
        <p class="error"><%= request.getParameter("error") %></p>
    <% } %>
    <form action="LoginServlet" method="post">
        <label for="username">UserName:</label>
        <input type="text" id="username" name="username" placeholder="UserName" required><br/><br/>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Password" required><br/><br/>

        <button type="submit">Login</button>
    </form>
</div>
<p>Don't have an account? <a href="register.jsp">New User? Register Here</a></p>

</body>
</html>
