package com.isp.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

@WebListener
public class AppShutDownListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 try {
	            // Clean up MySQL abandoned connection thread
	            AbandonedConnectionCleanupThread.checkedShutdown();

	            // Deregister JDBC drivers
	            Enumeration<Driver> drivers = DriverManager.getDrivers();
	            while (drivers.hasMoreElements()) {
	                Driver driver = drivers.nextElement();
	                DriverManager.deregisterDriver(driver);
	            }
	            System.out.println("Database drivers deregistered.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 System.out.println("Application Started.");
	}

}
