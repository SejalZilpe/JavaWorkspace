
package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
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
			 PrintWriter out = response.getWriter();  
			
			if(rs.next())
			{
				out.println("login successful");
			}
			else
			{
				out.println("login unsucessful");
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
