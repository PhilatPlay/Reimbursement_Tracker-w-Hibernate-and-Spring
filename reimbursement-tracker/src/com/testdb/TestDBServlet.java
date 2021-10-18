package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// setup connection variables
		String user = "root";
		String pass = "root";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/request_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		// get a connection to the database
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to the database, Phil!" + jdbcUrl);
			
			Class.forName(driver);
			
			Connection dbConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("We are Connected, Phil... SUCCESS!" + jdbcUrl);
			
			dbConn.close();			
			
		}catch (Exception e){
			
			e.printStackTrace();
			
			throw new ServletException(e);
		}
		
	}

}
