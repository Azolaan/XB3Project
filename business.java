package lapages;

import java.util.*;
import java.io.*;

public class business {
	
	private String bus_name;
	private String bus_number;
	private String loc_address;
	private String bus_tag;
	private double dist_to;
	
	public String user_loc;
	
	
	public business(String name, String number, String location, String tag) {
		this.bus_name = name;
		this.bus_number = number;
		this.loc_address = location;
		this.bus_tag = tag;
		this.dist_to = DistTo(location, user_loc);
	}
	
	public double DistTo(String location, String user_loc) {
		double x_dist = toLat(location) - toLat(user_loc);
		double y_dist = toLong(location) - toLong(user_loc);
		double distance = Math.sqrt(Math.pow(x_dist,2) + Math.pow(y_dist,2));
		return distance;
	}
	
	public double toLat(String address ) {
		return 0;
	}
	
	public double toLong(String address ) {
		return 0;
	}
	
	
}
