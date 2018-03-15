package LA_pages;

import java.util.*;
import java.io.*;

public class business_coord {
	
	private String bus_name;
	private String bus_number;
	private String bus_address;
	private String bus_tag;
	private double bus_lat;
	private double bus_long;
	public String user_loc;
	public final static double AVERAGE_RAD_EARTH_KM = 6371.0;
	
	public business_coord(String name, String number, String location, String tag, double lat, double lon) {
		this.bus_name = name;
		this.bus_number = number;
		this.bus_address = location;
		this.bus_tag = tag;
		this.bus_lat = lat;
		this.bus_long = lon;
	}
		
	public double get_lat() {
		return this.bus_lat;
	}
	
	public double get_long() {
		return this.bus_long;
	}
	
	public String get_tag() {
		return this.bus_tag;
	}
	
	public String get_name() {
		return this.bus_name;
	}
	
	public String get_number() {
		return this.bus_number;
	}
	
	public String get_address(){
		return this.bus_address;
	}
	
	public void printBusiness() {
		System.out.println("---------------------------------------\n");
		System.out.println("Business Name : " + this.bus_name);
		System.out.println("Phone Number : " + this.bus_number);
		System.out.println("Address : " + this.bus_address);
	}
	
	public void printBusiness(double user_lat, double user_long) {
		System.out.println("---------------------------------------\n");
		System.out.println("Business Name : " + this.bus_name);
		System.out.println("Phone Number : " + this.bus_number);
		System.out.println("Address : " + this.bus_address);
		System.out.println("Distance : " + Sort_coord.calculateDist(user_lat, user_long, this.bus_lat, this.bus_long)+ " km.");		
	}
	
	public double calculateDist(double user_lat, double user_long){
		double latDistance = Math.toRadians(userLat - this.bus_lat);
        double lngDistance = Math.toRadians(userLng - this.bus_long);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
        + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(this.bus_lat))
        * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = ((double)Math.round((AVERAGE_RAD_EARTH_KM * c * 100000d)))/100000d; 
        return  dist;
	}
}
