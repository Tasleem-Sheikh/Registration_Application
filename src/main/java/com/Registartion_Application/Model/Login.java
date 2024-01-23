package com.Registartion_Application.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	private Statement statement;
	private ResultSet rs;

	public boolean verifylogin(String email, String password, Connection con) {

		try {
			statement = con.createStatement();
			rs = statement.executeQuery(
					"select * from login_details where Email='" + email + "' and Password='" + password + "'");
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
	public boolean register(String fn,String ln,String email,String loc,Connection con) {
		 try {
			 statement= con.createStatement();
			  statement.executeUpdate("insert into registration_details values ('"+fn+"','"+ln+"','"+email+"','"+loc+"')");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return false;
		 
	}
	
	public ResultSet displayRecords(Connection con) {
		
		
		try {
			statement=con.createStatement();
			
			 rs = statement.executeQuery("select * from registration_details");
			 
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
		
	}
	public void deleteRecord(String email, Connection con) {
	 try {
		statement = con.createStatement();
		statement.executeUpdate("delete from registration_details where Email='"+email+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	public void updateRecords(Connection connectionDB, String email, String location) {
		// TODO Auto-generated method stub
		try {
			statement=connectionDB.createStatement();
			ResultSet rs = statement.executeQuery("select Location from registration_details where Email='"+email+"'");
			if(rs.next()) {
			statement.executeUpdate("update registration_details Set Location='"+location+"' where Email='"+email+"'");
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
