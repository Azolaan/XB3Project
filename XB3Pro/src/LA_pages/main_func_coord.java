package LA_pages;
import java.sql.*;
import java.util.Arrays;

public class main_func_coord {
	
	public static double user_long;
	public static double user_lat;
	
	public static void main(String[] args) throws SQLException {
		System.out.println("Enter business tag of choice : ");
		String user_tag = args[0];
		System.out.println("Enter business name (optional, enter 0 if no preference))");
		String user_name = args[1];
		
		System.out.println("Please enter longitude");
		user_long = Double.parseDouble(args[2]);
		
		System.out.println("Please enter latitude");
		user_lat = Double.parseDouble(args[3]);
		
		/**
		System.out.println("Enter current location (address)");
		String user_loc = args[2];
		*/
		
		// establish connection
		Connection con = DatabaseConnection_coord.Initialize();
		business_coord[] filtered = DatabaseConnection_coord.IndustryFilter(con, user_tag);
		Sort_coord.sort(user_lat, user_long, filtered);
		print(filtered);
		
	}
	
	public static void print(business_coord[] filtered) {
		for (int e = 0; e < filtered.length; e++) {
			System.out.println("---------------------------------------\n");
			System.out.println("Business Name : " + filtered[e].get_name());
			System.out.println("Phone Number : " + filtered[e].get_number());
			System.out.println("Address : " + filtered[e].get_address());
			System.out.println("Distance : " + Sort_coord.calculateDist(user_lat, user_long, filtered[e].get_lat(), filtered[e].get_long())+ " km.");
		}
		System.out.println("---------------------------------------\n");
	}
}