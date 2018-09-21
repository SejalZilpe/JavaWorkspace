package com.sampleservlet;

import javax.servlet.http.HttpServlet;

import org.apache.jasper.tagplugins.jstl.core.Out;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;



public class FirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		pw.println("first servlet");
	}
}
