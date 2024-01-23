package com.Registartion_Application.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

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
 * Servlet implementation class Delete_servelet
 */
@WebServlet("/delete")
public class Delete_servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete_servelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		String email = request.getParameter("email");

		ConnectionDB con = new ConnectionDB();
		Connection connection = con.ConnectionDB();
		Login log = new Login();
		log.deleteRecord(email, connection);

		request.setAttribute("deletemsg", "Record Deleted");

		ResultSet results_display = log.displayRecords(connection);
		request.setAttribute("results", results_display);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Display_records.jsp");

		rd.forward(request, response);
		}else {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
