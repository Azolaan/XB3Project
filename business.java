package lapages;

import java.util.*;
import java.io.*;

public class business {
	
	private String bus_name;
	private String bus_number;
	private String loc_address;
	private String bus_genre;
	private double loc_long;
	private double loc_lat;
	
	public business(String name, String number, String location, String genre, double longitude, double lat) {
		this.bus_name = name;
		this.bus_number = number;
		this.loc_address = location;
		this.bus_genre = genre;
		this.loc_long = longitude;
		this.loc_lat = lat;
	}
	
}
