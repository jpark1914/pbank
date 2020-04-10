package com.pbank.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pbank.DAOUtilities.*;
import com.pbank.dao.*;
import com.pbank.models.User;

@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String user_name= req.getParameter("user_name");
		int account_type = Integer.parseInt(req.getParameter("account_type"));
		
		UserDAO dao = DAOUtilities.getUserDAO();
		User user = new User();
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setUser_name(user_name);
		user.setAccount_type(account_type);
		
		
		
		boolean isSuccess = dao.addUser(user);
		
		if(isSuccess) {
			System.out.println("User successfully added");
			res.sendRedirect("ViewUsers");
		}else {
			System.out.println("User WAS NOT CREATED");
			res.sendRedirect("ViewUsers");
		}
	
		
		
		
	}
}
