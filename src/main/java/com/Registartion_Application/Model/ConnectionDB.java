package com.Registartion_Application.Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	
	private Connection con;
	public Connection ConnectionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_application","root","Z1xcvbnm@#");
			
			return con;
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		return con;

	}
	
}
