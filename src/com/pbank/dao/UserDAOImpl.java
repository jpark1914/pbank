package com.pbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.pbank.models.User;
import com.pbank.DAOUtilities.*;


public class UserDAOImpl implements UserDAO {
	
		Connection connection = null; // To set up the connection.
		PreparedStatement stmt = null; // Will be used for sql stmts.
	
	public boolean addUser(User user) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO 'Users' VALUES(?,?) ";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getAccount_type());

			System.out.println(stmt);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeResources();
		}
	}
	/*------------------------------------------------------------------------------------------------*/
	public boolean deleteUser(User user) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "DELETE 'Users' WHERE id =?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1,  user.getId());
			
			if(stmt.executeUpdate() != 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeResources();
			
		}
	}
	/*------------------------------------------------------------------------------------------------*/
	public boolean updateUser(User user) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE 'Users' SET name=?, account_type=? WHERE id=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getAccount_type());
			stmt.setInt(3, user.getId());
			
			if(stmt.executeUpdate() != 0) {
				return true;
			}else {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}
	
/*------------------------------------------------------------------------------------------------*/

	// Closing all resources is important, to prevent memory leaks. 
	// Ideally, you really want to close them in the reverse-order you open them
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}
}
