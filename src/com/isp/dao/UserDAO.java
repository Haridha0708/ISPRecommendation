package com.isp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.isp.model.User;
import com.isp.util.DBConnection;

public class UserDAO {
	//register new user
	public boolean registerUser(User user) throws SQLException {
		 boolean success = false;
		String query = "INSERT INTO users(username,password,email,preference) VALUES(?,?,?,?)";
		Connection conn = null;
        PreparedStatement stmt = null;
		try {
				
				conn = DBConnection.getConnection();
				 stmt = conn.prepareStatement(query);
		
				stmt.setString(1, user.getUserName());
				stmt.setString(2, user.getPassword());
				stmt.setString(3,user.getEmail());
				stmt.setString(4, user.getPreference());
		
				 success = stmt.executeUpdate() > 0 ;
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return success;
	}
	
	public User loginUser(String username, String password) {
	    User user = null;
	    String query = "SELECT * FROM users WHERE username =? AND password =?";
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs= null;
	    try {
	         conn = DBConnection.getConnection();
	         ps = conn.prepareStatement(query);
	        ps.setString(1, username);
	        ps.setString(2, password);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            user = new User();
	            user.setUserName(rs.getString("username"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally {
	    	try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close(); // 🚨 Close Connection Last!
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	    return user;
	}

	public boolean validateUser(String username) {
		boolean exists = false;
		User user = null;
		String query = "SELECT username FROM users WHERE username = ?";
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs= null;
		try {
			conn = DBConnection.getConnection();	
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			 rs = ps.executeQuery();
			exists = rs.next();//
			} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close(); // 🚨 Close Connection Last!
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return exists;
	}

}
