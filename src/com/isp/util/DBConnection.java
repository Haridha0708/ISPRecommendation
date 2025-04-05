package com.isp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
		private static final String URL = "jdbc:mysql://localhost:3306/ISPRecommendation";
	    private static final String USER = "root";
	    private static final String PASSWORD = "haridha";
	    private static final String DRIVER = "com.mysql.jdbc.Driver";
	    
	    public static Connection getConnection() throws SQLException{
	    	
	    	try {
	    		Class.forName(DRIVER);
				return DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new SQLException("Database connection failed.");
			}
			

		}

}
