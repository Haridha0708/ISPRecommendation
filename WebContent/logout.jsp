<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    session.invalidate(); // Destroy session
    response.sendRedirect("login.jsp"); // Redirect to login page
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogOut- ISP Recommendation</title>
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
        <h2>You have been logged out.</h2>
        <p style="color: #007bff; font-weight: bold; font-size: 18px;">Thank you for using our service!</p>

        <a href="login.jsp">Login Again</a>
    </div>

</body>
</html>