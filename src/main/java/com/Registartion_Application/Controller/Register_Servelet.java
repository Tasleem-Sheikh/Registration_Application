package com.Registartion_Application.Controller;

import java.io.IOException;
import java.sql.Connection;

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
 * Servlet implementation class Register_Servelet
 */
@WebServlet("/Register")
public class Register_Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register_Servelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("email") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registration.jsp");
			rd.forward(request, response);

		}

		else {

			request.setAttribute("login again", "your session has exprired login again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Firstname = request.getParameter("firstname");
		String Lastname = request.getParameter("lastname");
		String Email = request.getParameter("email");
		String Location = request.getParameter("location");
		HttpSession session = request.getSession();
		if (session.getAttribute("email") != null) {
			ConnectionDB con = new ConnectionDB();
			Connection connect = con.ConnectionDB();

			Login log = new Login();

			boolean register = log.register(Firstname, Lastname, Email, Location, connect);

			request.setAttribute("success", "Registered Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registration.jsp");
			rd.include(request, response);

		} else {

			request.setAttribute("login again", "your session has exprired login again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		}
	}

}
