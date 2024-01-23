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
 * Servlet implementation class Update_servelet
 */
@WebServlet("/update")
public class Update_servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String Location = request.getParameter("location");

		request.setAttribute("Oldemail", email);
		request.setAttribute("oldlocation", Location);
		HttpSession session = request.getSession();
		if (session.getAttribute("email") != null) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update.jsp");
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
		
		
		
		String email = request.getParameter("email");
		String location = request.getParameter("location");
		HttpSession session = request.getSession();
		if (session.getAttribute("email") != null) {
		ConnectionDB cdb= new ConnectionDB();
		Connection connectionDB = cdb.ConnectionDB();
		
		
		
		Login log = new Login();
		log.updateRecords(connectionDB,email,location);
		
		
		request.setAttribute("update_msg","RECORD UPDATED");
		
		
		
		ResultSet rs = log.displayRecords(connectionDB);
		
		request.setAttribute("results", rs);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Display_records.jsp");
		rd.forward(request, response);
		
	}
		else {

			request.setAttribute("login again", "your session has exprired login again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}
