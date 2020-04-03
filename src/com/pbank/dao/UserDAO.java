package com.pbank.dao;

import com.pbank.models.User;
import java.util.List;

public interface UserDAO {
	
//	public List<User> getAllUsers();
//	public User getUserByName(String name);
	
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
}
