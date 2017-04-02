package br.com.forecast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public Connection getConnection() throws ClassNotFoundException {
		
	     try {
	    	 
	    	 Class.forName("com.mysql.jdbc.Driver");	    	 
	    	 return DriverManager.getConnection("jdbc:mysql://localhost/forecast", "root", "");
	    	 
	     } catch (SQLException e) {
	    	 
	         throw new RuntimeException(e);
	         
	     }
	 }
	
	
}
