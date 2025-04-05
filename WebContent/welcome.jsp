<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.isp.model.User" %>
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
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f4f4f4;
            padding: 50px;
        }
        .container {
            max-width: 500px;
            background: white;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 2px 2px 10px rgba(0,0,0,0.1);
            margin: auto;
        }
        h2 {
            color: #333;
        }
        a {
            display: block;
            margin-top: 20px;
            color: blue;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Welcome, <%= user.getUserName() %>!</h2>
        <p>You have successfully logged in.</p>

        <a href="dashboard.jsp">Go to Dashboard</a>
        <a href="LogoutServlet" style="color: red;">Logout</a>
    </div>

</body>
</html>
