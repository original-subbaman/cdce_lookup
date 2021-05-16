package com.cdce_gmc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 
public class Dao {
	private static Dao dao; 
	Connection connection; 
	Statement stmt; 
	private Dao() {
		//connection = getRemoteConnection();
		
		
	}
	
	public static Dao getInstance() {
		if(dao == null) {
			dao = new Dao(); 
		}
		return dao; 
	}
	
	public Connection getConnection() {
		connection = getRemoteConnection();
	
		
		return this.connection; 
	}
	
	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private Connection getRemoteConnection() {
	    if (System.getProperty("RDS_HOSTNAME") != null) {
	      try {
	      Class.forName("com.mysql.jdbc.Driver");
	      String dbName = System.getProperty("RDS_DB_NAME");
	      String userName = System.getProperty("RDS_USERNAME");
	      String password = System.getProperty("RDS_PASSWORD");
	      String hostname = System.getProperty("RDS_HOSTNAME");
	      String port = System.getProperty("RDS_PORT");
	      String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
	      Connection con = DriverManager.getConnection(jdbcUrl);
	      return con;
	      }catch(ClassNotFoundException e) {
	    	  e.printStackTrace(); 
	      } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	  return null; 
	}
	
}
