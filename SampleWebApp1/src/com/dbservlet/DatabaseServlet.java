package com.dbservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//load the driver
			Class.forName("org.h2.Driver");
			//establish connection
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","root","test");
			//write query
			
			String query = "select * from gameofthrone where character=?";
			PreparedStatement pstatement= conn.prepareStatement(query);
			String sname = request.getParameter("uname");
			pstatement.setString(2,sname);
			ResultSet rs = pstatement.executeQuery();
			 if(rs.next())
			 {
				 System.out.println("it is there");
			 }
			else {
				System.out.println("it is not there");
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}
	
	
}
