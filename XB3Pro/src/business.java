package lapages;

import java.util.*;
import java.io.*;

public class business {
	
	private String bus_name;
	private String bus_number;
	private String loc_address;
	private String bus_tag;
	
	public String user_loc;
	
	public business(String name, String number, String location, String tag) {
		this.bus_name = name;
		this.bus_number = number;
		this.loc_address = location;
		this.bus_tag = tag;
	}
	
	public String get_loc(){
		return this.loc_address;
	}
}