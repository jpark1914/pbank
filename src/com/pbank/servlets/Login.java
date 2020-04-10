package com.pbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pbank.models.*;
import com.pbank.DAOUtilities.DAOUtilities;
import com.pbank.dao.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("user_name");
		
		UserDAO dao = DAOUtilities.getUserDAO();
		User user = dao.getByUserName(name);
		String user_name = user.getUser_name();
		
			if(user_name == name) {
				response.sendRedirect("index.jsp");
				
			}else {
				PrintWriter out = response.getWriter();
				out.println("This name is not in the database");
				out.println("Please enter correct name or create a new account");
				
			}
		
	}



}
