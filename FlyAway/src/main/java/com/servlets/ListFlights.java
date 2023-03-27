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

@WebServlet("/ListFlights")
public class ListFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
    private Statement statement =null;
    public void init(ServletConfig config) {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		ServletContext context=config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbuser = context.getInitParameter("dbuser");
			String dbpassword = context.getInitParameter("dbpassword");
			connection =DriverManager.getConnection(dburl, dbuser,dbpassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try(
				Statement statement=connection.createStatement();
				ResultSet result=statement.executeQuery("select * from flight");) {
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				response.setContentType("text/html");
				out.println("");
				out.print("<table border=1>");
				out.print("<tr>");
				out.print("<th>Flight Id</th>");
				out.print("<th>Name</th>");
				out.print("<th>Source</th>");
				out.print("<th>Destination</th>");
				out.print("<th>Day</th>");
				out.print("<th>Ticket Price</th>");
				out.print("</tr>");
				while(result.next()) {
					int FlightId = result.getInt(1);
					String Name = result.getString(2);
					String Source = result.getString(3);
					String Destination = result.getString(4);
					String Day = result.getString(5);
					int TicketPrice = result.getInt(6);
					out.print("<tr>");
					out.print("<td>"+FlightId+"</th>");
					out.print("<td>"+Name+"</td>");
					out.print("<td>"+Source+"</td>");
					out.print("<td>"+Destination+"</td>");
					out.print("<td>"+Day+"</td>");
					out.print("<td>"+TicketPrice+"</td>");
					out.print("</tr>");
					
				}
				out.print("</table>");
				out.println("<a href=\"AdminMenu.jsp\">Back</a>");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
	}
	public void destroy() {
		if(connection !=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

	
	