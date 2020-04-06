package com.pbank.DAOUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.pbank.dao.UserDAO;
import com.pbank.dao.UserDAOImpl;

/**
 * Class used to retrieve DAO Implementations. Serves as a factory. Also manages a single instance of the database connection.
 */
public class DAOUtilities {

	private static final String CONNECTION_USERNAME = "jordanparker";
	private static final String CONNECTION_PASSWORD = "Park7937!";
	private static final String URL = "jdbc:postgresql://localhost:5432/bank";
	private static Connection connection;
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}
	
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	

}
