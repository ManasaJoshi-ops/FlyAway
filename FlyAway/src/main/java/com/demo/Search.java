package com.demo;
public abstract class Search {

	
	    public static String date;
	    public static String day;
	    public static String source;
	    public static String destination;
	    public static int person;

	    public static String getQuery() {
	        return "SELECT * FROM flight WHERE Source = '"+source+"' AND Destination='"+destination+"'AND Day='"+day+"'";
	    }
	
	
	
}
