<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.demo.Search" %>
<%@ page import="com.demo.Booking" %>
<%
    Booking.name_on_card = request.getParameter("name_on_card");
    Booking.card_details = request.getParameter("card_details");

    if (Booking.name_on_card.equals("") || Booking.card_details.equals("")) {
        out.println("Please enter valid card details");
    }
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank You</title>
</head>
<body>


<div>
        <h2 align="center"><span><strong>Thank You</strong></span></h2>
       
        <p align="center"><span><strong>Flight has booked</strong></span></p>
       
        <br>
        <h3>Ticket Details</h3>
        <h4><strong><%=Search.source%> to <%=Search.destination%> | <%=Search.date%> (<%=Search.day%>)</strong></h4>
        <p align="left"><%=Booking.flight_booking_id%> - <%=Booking.flight_name%> (Travellers <%=Search.person%>)</p><br>
        <br>
        <h3><strong>Passenger Summary</strong></h3>
        <h4>Booking Name-<%=Booking.passenger_name%> </h4>
        <h4>Email- <%=Booking.passenger_email%></h4>
        <h4>Phone- <%=Booking.passenger_phone%></h4>
        <br>
        <h3><strong>Payment Summary</strong></h3>
        <h4>Payment By-<%=Booking.name_on_card%></h4><br>
        <h2 align="right"><strong>Total Paid- Rs.<%=Search.person*Booking.ticket_price%></strong></h2><br><br>
         <div align="center">
    <a href ="index.jsp">Home</a>
    </div>
         <p><button onclick="window.print()" >Print Ticket</button></p>
    </div>

</body>
</html>