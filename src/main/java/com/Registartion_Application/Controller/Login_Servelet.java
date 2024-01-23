package com.Registartion_Application.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Registartion_Application.Model.ConnectionDB;
import com.Registartion_Application.Model.Login;

/**
 * Servlet implementation class Login_Servelet
 */
@WebServlet("/Login")
public class Login_Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login_Servelet() {
		super();
		// TODO Auto-gerated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		ConnectionDB connect = new ConnectionDB();
		Connection con = connect.ConnectionDB();

		Login log = new Login();
		boolean verifylogin = log.verifylogin(email, password, con);
HttpSession session = request.getSession();
		if (verifylogin == true) {
			session.setAttribute("email", email);
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registration.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error msg", "please provide valid user name and password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);

		}

	}

}
