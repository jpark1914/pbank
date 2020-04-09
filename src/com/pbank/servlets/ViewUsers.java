package com.pbank.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pbank.dao.UserDAO;
import com.pbank.models.User;
import com.pbank.DAOUtilities.DAOUtilities;

import java.util.List;
/**
 * Servlet implementation class ViewUsers
 */
@WebServlet("/ViewUsers")
public class ViewUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = DAOUtilities.getUserDAO();
		List<User> userList = dao.getAllUsers();
		
		// Populate the list into a variable that will be stored in the session
		request.getSession().setAttribute("users", userList);
		request.getRequestDispatcher("userList.jsp").forward(request, response); 
	}


}
