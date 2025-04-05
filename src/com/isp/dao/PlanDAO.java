package com.isp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.isp.model.Plans;
import com.isp.util.DBConnection;

public class PlanDAO {
	
	public List<Plans> getRecommendedPlans(String preference) {
		List<Plans> plan = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
        try {
        	Class.forName( "com.mysql.jdbc.Driver");
           conn = DBConnection.getConnection();
            String query = "SELECT * FROM plans WHERE category = ?";
             ps = conn.prepareStatement(query);
            ps.setString(1, preference);
             rs = ps.executeQuery();

            while (rs.next()) {
            	Plans isp = new Plans();
            	isp.setPlanId(rs.getInt("plan_id"));
            	isp.setPlanName(rs.getString("plan_name"));
            	isp.setPrice(rs.getDouble("price"));
            	isp.setSpeed(rs.getInt("speed"));
                isp.setDataLimit(rs.getString("data_limit"));
                plan.add(isp);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (ps != null) ps.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }

		return plan;
	}
	public List<Plans> getPlansByFilter(int minSpeed, double maxPrice, String category) {
	    List<Plans> planList = new ArrayList<>();
	    try {
	    //    Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DBConnection.getConnection();

	        String query = "SELECT * FROM plans WHERE speed >= ? AND price <= ? AND category LIKE ?";

	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setInt(1, minSpeed);
	        ps.setDouble(2, maxPrice);
	        if (!"All".equalsIgnoreCase(category)) {
	            ps.setString(3, category);
	        }


	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Plans plan = new Plans();
	            plan.setPlanId(rs.getInt("plan_id"));
	            plan.setPlanName(rs.getString("plan_name"));
	            plan.setPrice(rs.getDouble("price"));
	            plan.setSpeed(rs.getInt("speed"));
	            plan.setDataLimit(rs.getString("data_limit"));
	            plan.setCategory(rs.getString("category"));
	            planList.add(plan);
	        }

	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return planList;
	}
	public List<String> getAllCategories() {
	    List<String> categories = new ArrayList<>();
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT category FROM plans");
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            categories.add(rs.getString("category"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return categories;
	}

	public List<Double> getAllDistinctPrices() {
	    List<Double> prices = new ArrayList<>();
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT price FROM plans ORDER BY price ASC");
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            prices.add(rs.getDouble("price"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return prices;
	}
	public List<Integer> getAllDistinctSpeeds() {
	    List<Integer> speeds = new ArrayList<>();
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT speed FROM plans ORDER BY speed ASC");
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            speeds.add(rs.getInt("speed"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return speeds;
	}



}
