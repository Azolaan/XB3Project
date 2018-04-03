package LA_pages;
import java.sql.*;
import java.util.Arrays;
import java.util.Map;

import geocoder.OpenStreetMapUtils;

public class main_func_coord {
	
	public static double user_long;
	public static double user_lat;
	
	public static void main(String[] args) throws SQLException {
		
		// takes user tag preference for industry, can be more than one
		System.out.println("Enter business tag of choice : ");
		String user_tag = args[0];
		
		// takes business name to prioritize businesses that match the name
		System.out.println("Enter business name (optional, enter 0 if no preference))");
		String user_name = args[1];
		
		/*
		// takes user longitude and latitude
		System.out.println("Please enter longitude");
		user_long = Double.parseDouble(args[2]);
		System.out.println("Please enter latitude");
		user_lat = Double.parseDouble(args[3]);
		*/
		
		System.out.println("Enter current location (address)");
		String user_loc = args[2];
		System.out.println(user_loc);
		
		//address to lon and lat coordinates
		Map<String, Double> coords;
		coords = OpenStreetMapUtils.getInstance().getCoordinates(user_loc);
		user_long = coords.get("lon");
		user_lat = coords.get("lat");
		
		// establish connection
		Connection con = DatabaseConnection_coord.Initialize();
		business_coord[] filtered = DatabaseConnection_coord.IndustryFilter(con, user_tag);
		Sort_coord.sort(user_lat, user_long, filtered);
		
		int[] name_index = name_search.search(user_name, filtered);
		
		print_name_searched(name_index, filtered);
		print(name_index, filtered);
	}
	
	public static void print(int[] index, business_coord[] filtered) {
		System.out.println("------------MATCHING INDUSTRY TAG---------------");
		int marker = 0;
		for (int e = 0; e < filtered.length; e++) {
			if (e != index[marker] || index[marker] == -1)
				filtered[e].printBusiness(user_lat, user_long);
			else
				marker++;
		}
		System.out.println("------------------------------------------------");
	}
	
	public static void print_name_searched(int[] index, business_coord[] filtered) {
		System.out.println("------------MATCHING BUSINESS NAMES-------------");
		for (int i = 0; i < index.length; i++) {
			if (index[i] != -1)
				filtered[index[i]].printBusiness(user_lat, user_long);
		}
	}
}