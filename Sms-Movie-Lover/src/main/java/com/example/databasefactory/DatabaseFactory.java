package com.example.databasefactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseFactory {
	public final static Connection getConnection() {
		Connection connection = null;
		
		try {
			String url = "jdbc:postgresql://localhost:5433/movie";
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","password");
			props.setProperty("ssl","false");
			connection = DriverManager.getConnection(url, props);
			
		
			System.err.println("Connected Successfully");
		}
		catch (SQLException sqlException) {
			System.err.println("Error connecting to the database: "+sqlException.getMessage());
		}
		
		return connection;
	}
}
