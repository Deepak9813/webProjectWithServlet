package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("SignupForm.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// receive data in Server(Servlet) from view page
		//String fname = request.getParameter("firstname"); 
		String lname = request.getParameter("lastname");
		String un = request.getParameter("username");
		String psw = request.getParameter("password");

		
		//send data to database
		User u = new User();
		//u.setFname(fname);
		u.setFname(request.getParameter("firstname"));  //direct lekhda ni hunxa, mathi ko nalekhera
		u.setLname(lname);
		u.setUsername(un);
		u.setPassword(psw);
		
		UserService us = new UserServiceImpl();
		us.userSignup(u);
		
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		
	}

}
