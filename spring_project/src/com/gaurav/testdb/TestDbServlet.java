package com.gaurav.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variables
		String user="spring_student";
		String pass="spring_student";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/spring_demo_project?allowPublicKeyRetrieval=true&useSSL=FALSE";
		String driver="com.mysql.jdbc.Driver";
	
		//get connection to database
		Connection conn = null;
		try {
			PrintWriter out=response.getWriter();
			out.println("Connecting to database: "+jdbcUrl);
			Class.forName(driver);
			conn=DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("SUCCESS!!!");
		}catch(Exception e) {
			System.out.println("Exception occured: "+e);
			e.printStackTrace();
			throw new ServletException(e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


}
