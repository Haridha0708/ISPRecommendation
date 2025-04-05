# ISP Recommendation System

A Java EE-based web application that recommends internet plans to users based on speed, price, and category. Includes login, registration, and personalized dashboard.

## Tech Stack
- Java (Servlets, JSP)
- MySQL
- Apache Tomcat
- HTML/CSS

## Features
- User login & registration
- ISP plan recommendations
- Filter by speed, price, category
- Session-based dashboard

## How to Run
1. Import project into Eclipse (Dynamic Web Project)
2. Set up MySQL database and update DBConnection.java
3. Configure Tomcat and run on server
4. Visit: `http://localhost:2020/ISPRecommendations`

## Folder Structure
- `src/com/isp/controller`: Servlets
- `src/com/isp/dao`: Database access classes
- `src/com/isp/model`: JavaBeans
- `WebContent`: JSP files + `web.xml`

## Test Credentials
- Username: testuser
- Password: testpassword
