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
		
		
	/*------------------------------------------------------------------------------------------------*/
		public User getByUserName(String user_name) {
			User user = null;
			try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM \"Users\" WHERE user_name = ?";
			stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setUser_name(rs.getString("user_name"));
				user.setAccount_type(rs.getInt("account_type"));
			}
			
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeResources();
			}
			return user;
		}
		
		
	/*------------------------------------------------------------------------------------------------*/
		@Override
		public List<User> getUsersByName(String name) {
			List<User> users = new ArrayList<>();
			try {
				connection = DAOUtilities.getConnection();
				String sql = "SELECT * FROM \"Users\" WHERE user_name = ?";
				stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, "%" + name + "%");
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setFirst_name(rs.getString("first_name"));
					user.setLast_name(rs.getString("last_name"));
					user.setUser_name(rs.getString("user_name"));;
					user.setAccount_type(rs.getInt("account_type"));
					
					users.add(user);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeResources();
			}
			return users;
		}
	/*------------------------------------------------------------------------------------------------*/
		
		public List<User> getAllUsers(){
			List<User> users = new ArrayList<>();
		try {
			
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM \"Users\"";
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setUser_name(rs.getString("user_name"));;
				user.setAccount_type(rs.getInt("account_type"));
				
				users.add(user);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return users;
			
		}
		
	/*------------------------------------------------------------------------------------------------*/
		
	
	public boolean addUser(User user) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"Users\" (first_name, last_name, user_name, account_type) VALUES(?,?,?,?) ";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getFirst_name());
			stmt.setString(2, user.getLast_name());
			stmt.setString(3, user.getUser_name());
			stmt.setInt(4, user.getAccount_type());

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
			String sql = "UPDATE \"Users\" SET first_name=?,last_name =?, user_name=? account_type=? WHERE id=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getFirst_name());
			stmt.setString(2,  user.getLast_name());
			stmt.setString(3, user.getUser_name());
			stmt.setInt(4, user.getAccount_type());
			stmt.setInt(5, user.getId());
			
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
