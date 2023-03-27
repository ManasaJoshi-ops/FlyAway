package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
 
	Connection connection=null;
	
	 public void init(ServletConfig config) {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 ServletContext context=config.getServletContext();
			 String dburl=context.getInitParameter("dburl");
			 String dbuser=context.getInitParameter("dbuser");
			 String dbpassword=context.getInitParameter("dbpassword");
			 connection=DriverManager.getConnection(dburl,dbuser,dbpassword);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace(); 
	 }   
	}
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     String email=request.getParameter("email");
			String password=request.getParameter("password");
			try (Statement st=connection.createStatement();){
				int result=st.executeUpdate("update admin set password='"+password+"' where email ='"+email+"'");
				PrintWriter out=response.getWriter();	
			    response.setContentType("text/html");
				
				if(result>0) {
					out.println("<h1>Password Updated</h1>");
					
				}else {
					out.println("<h1>Error Updating user password</h1>");
				}
				out.print("<a href=\"AdminMenu.jsp\">Back</a>");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}
	}

