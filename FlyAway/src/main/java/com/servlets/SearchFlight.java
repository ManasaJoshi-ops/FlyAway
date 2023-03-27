package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.Search;


@WebServlet("/SearchFlight")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		Search.date=request.getParameter("date");
		Search.source=request.getParameter("source");
		Search.destination=request.getParameter("destination");
		Search.person=Integer.parseInt(request.getParameter("person"));
		
		if(Search.date.equals("")) {
			out.println("Please enter a valid date");
		}else {
			Search.day=getDay(Search.date);
			response.sendRedirect("SearchResult.jsp");
		}
	}

	private String getDay(String date) {
		LocalDate dt=LocalDate.parse(date);
		return dt.getDayOfWeek().toString();
	}

}
