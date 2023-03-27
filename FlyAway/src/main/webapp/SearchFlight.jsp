<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>Search Flights</h2>
<div>
<h3>Welcome User!!</h3>
</div>
<form action="SearchFlight" method="post">
<div>
<label for="date">Date</label>
<input type="date" id="date" name="date" placeholder="yyyy-mm-dd">
</div>
<br>
<div>
<label for="source">Source</label>
<select id="source" name="source">
<option value="Bengaluru">Bengaluru</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Pune">Pune</option>
<option value="Chennai">Chennai</option>
<option value="Mumbai">Mumbai</option>
<option value="Thiruvananthapuram">Thiruvananthapuram</option>
<option value="Delhi">Delhi</option>
<option value="Noida">Noida</option>
</select>
</div>
<br>
<div>
<label for="destination">Destination</label>
<select id="destination" name="destination">
<option value="Noida">Noida</option>
<option value="Bengaluru">Bengaluru</option>
<option value="Mumbai">Mumbai</option>
<option value="Pune">Pune</option>
<option value="Chennai">Chennai</option>
<option value="Thiruvananthapuram">Thiruvananthapuram</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Delhi">Delhi</option>
</select>
</div>
<br>
<div>
<label for="person">No of people</label>
<select id="person" name="person">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
</select>
</div>
<br>
<input type="submit" value="Submit">
</form>
</body>
</html>