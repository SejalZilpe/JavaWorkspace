package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","root","test");
			String query =" select * from login where username=? and password=?";
			PreparedStatement pst = conn.prepareStatement(query);
			String uname = request.getParameter("username");
			pst.setString(1,uname);
			String pass = request.getParameter("password");
			pst.setString(2,pass);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				if(pass.equals(rs.next()))
				{
					System.out.println("successfully logged in");
				}
			}
			else
			{
				System.out.println("login failed");
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
