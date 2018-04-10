package LA_pages;

import java.util.*;
import java.io.*;

public class business_coord {
	
	private final String bus_name;
	private final String bus_number;
	private final String bus_address;
	private final String bus_tag;
	private final double bus_lat;
	private final double bus_long;
	private int bus_ID;
	public final static double AVERAGE_RAD_EARTH_KM = 6371.0;
	
	public business_coord(String name, String number, String location, String tag, double lat, double lon) {
		this.bus_name = name;
		this.bus_number = number;
		this.bus_address = location;
		this.bus_tag = tag;
		this.bus_lat = lat;
		this.bus_long = lon;
		this.bus_ID = -1;
	}
	
	public void set_ID(int id) {
		this.bus_ID = id;
	}
	
	public int get_ID() {
		return this.bus_ID;
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
		System.out.println("------------------------------------------------");
		System.out.println("Business Name : " + this.bus_name);
		System.out.println("Phone Number : " + this.bus_number);
		System.out.println("Address : " + this.bus_address);
		System.out.println("------------------------------------------------");
	}
	
	public void printBusiness(double user_lat, double user_long) {
		System.out.println("------------------------------------------------");
		System.out.println("Business Name : " + this.bus_name);
		System.out.println("Phone Number : " + this.bus_number);
		System.out.println("Address : " + this.bus_address);
		System.out.println("Distance : " + calculateDist(user_lat, user_long) + " km.");
		System.out.println("------------------------------------------------");
	}
	
	public double calculateDist(double userLat, double userLng){
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
