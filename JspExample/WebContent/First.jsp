<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>first page</title>
</head>
<body>
<H1>JSP Expression</H1>
<%= 5+10 %>
<H1>JSP Declaration</H1>
<%! int a=10,b=10;%>
<H1>JSP Scriplet</H1>
<% out.println(a);%>
</body>
</html>

<%@ include file="ad.jsp"%>