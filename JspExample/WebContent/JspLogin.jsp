<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.sql.Connection"
 	import= "java.sql.DriverManager"
	import= "java.sql.DriverManager"
	import= "java.sql.DriverManager"
	import= "java.sql.DriverManager"
	import="java.sql.Connection"
	import= "java.sql.Connection"
	import= "java.sql.PreparedStatement"
	import= "java.sql.ResultSet"
	import= "java.sql.SQLException" 
	import= "java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

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
	PrintWriter pw = response.getWriter();  
	
	if(rs.next())
	{
		pw.println("login successful");
	}
	else
	{
		pw.println("login unsucessful");
	}
	
	
} catch (ClassNotFoundException e) {
	
	e.printStackTrace();
	
} catch (SQLException e) {
	
	e.printStackTrace();
}

%>
</body>
</html>