package com.isp.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {
	
	public static void main(String[] args) {
		 try (Connection conn = DBConnection.getConnection() ){
	            if ( conn != null) {
	                System.out.println("Database connected successfully!");
	            }else {
					System.out.println("Database Connection Failed");
				}
	        } catch (SQLException e) {
	        	System.out.println("DataBase Connection Error");
	            e.printStackTrace();
	        }
	}

}
