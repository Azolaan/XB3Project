package LA_pages;

import java.util.*;
import java.io.*;

public class business {
	
	private String bus_name;
	private String bus_number;
	private String loc_address;
	private String bus_tag;
	private double bus_lat;
	private double bus_long;
	
	public String user_loc;
	
	public business(String name, String number, String location, String tag, double lat, double lon) {
		this.bus_name = name;
		this.bus_number = number;
		this.loc_address = location;
		this.bus_tag = tag;
		
		this.bus_lat = lat;
		this.bus_long = lon;
		/**
		
		 */
	}
	
	
	public double get_lat() {
		return bus_lat;
	}
	
	public double get_long() {
		return bus_long;
	}
	
	public String get_name() {
		return this.bus_name;
	}
	
	public String get_number() {
		return this.bus_number;
	}
	
	public String get_address(){
		return this.loc_address;
	}
}
