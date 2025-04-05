<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String error = request.getParameter("error"); %>
<% if (error != null) { %>
    <p style="color: red;"><%= error %></p>
<% } %>

<% String message = request.getParameter("message"); %>
<% if (message != null) { %>
    <p style="color: green;"><%= message %></p>
<% } %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register ISP-Recommendation</title>
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

			<div class = "container">
					<h2>Register</h2>
    <form action="RegisterServlet" method="post">
        <label for="username">UserName:</label>
        <input type="text" id="username" name="username" placeholder="Full Name" required /><br/><br/>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Email"required /><br/><br/>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Password"required /><br/><br/>
        
        <label for="preference">Preference:</label>
         		   <select id="preference" name="preference">
         		    <option value="">Select a plan preference</option>
             			   <option value="low">Low</option>
             			   <option value="high_speed">High_Speed</option>
          			      <option value="unlimited">Unlimited Data</option>
            </select><br/>
        
        
        <button type="submit">Register</button>
    </form>
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>

</body>
</html>