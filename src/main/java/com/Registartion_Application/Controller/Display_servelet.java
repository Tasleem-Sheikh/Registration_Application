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
 * Servlet implementation class Display_servelet
 */
@WebServlet("/display_registration")
public class Display_servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display_servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		ConnectionDB connect= new ConnectionDB();
		Connection con = connect.ConnectionDB();
		
		Login log = new Login();
		ResultSet displayRecords = log.displayRecords(con);
		
		request.setAttribute("results", displayRecords);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Display_records.jsp");
		rd.forward(request, response);
		
		
	}else {
		request.setAttribute("login again", "your session has exprired login again");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
