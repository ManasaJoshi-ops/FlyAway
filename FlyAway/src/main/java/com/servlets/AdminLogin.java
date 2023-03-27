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
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
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
			try (Statement st=connection.createStatement();
					ResultSet rs=st.executeQuery("select * from admin where email='"+email+"' and password='"+password+"'");
					PrintWriter out =response.getWriter();
					){
					
				
				if(rs.next()) {
					out.println("Welcome to User page"+email);
					
					response.sendRedirect("AdminMenu.jsp");
				}else {
					out.println("Wrong credentials");
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	}

