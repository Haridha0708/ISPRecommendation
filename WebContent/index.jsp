<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to ISP Recommendation System</title>
 <style>
        body {
            font-family: 'Segoe UI', sans-serif;  background-color: #f2f2f2;  margin: 0;  padding: 0;
        }
        .header {
            background-color: #007bff; color: white; padding: 20px 0; text-align: center;
        }
        .nav {
            background-color: #0056b3; padding: 10px 0; text-align: center;
        }
        .nav a {
            color: white;  text-decoration: none; margin: 0 15px;  padding: 10px 20px;
            border-radius: 5px;  font-weight: bold; transition: background 0.3s, color 0.3s;
        }
        .nav a:hover {  background-color: white;  color: #0056b3;
        }
        .container {
            max-width: 800px; margin: 40px auto;  background: white;  padding: 30px;
            text-align: center;   box-shadow: 0 4px 12px rgba(0,0,0,0.1);   border-radius: 10px;
        }
        h1 { color: #333;}
        p { font-size: 18px; color: #666;  }
        .btn {
            background-color: #007bff;  color: white; padding: 12px 25px; border: none; border-radius: 5px;
            margin-top: 20px; text-decoration: none;  font-size: 16px;    transition: background-color 0.3s;
        }
        .btn:hover {   background-color: #0056b3;}
    </style>

</head>
<body>
     <div class="header">
        <h1>Welcome to ISP Recommendation System</h1>
    </div>

    <div class="nav">
        <a href="login.jsp">Login</a>
        <a href="register.jsp">Register</a>
    </div>

    <div class="container">
        <h2>Find the Best Internet Plans Based on Your Needs</h2>
        <p>Login or Register to explore personalized ISP plan recommendations.</p>
        <a class="btn" href="login.jsp">Get Started</a>
    </div>    

</body>
</html>