package LA_pages;
import java.sql.*;

public class main_func_coord {
	public static void main(String[] args) throws SQLException {
		System.out.println("Enter business tag of choice : ");
		String user_tag = args[0];
		System.out.println("Enter business name (optional, enter 0 if no preference))");
		String user_name = args[1];
		
		System.out.println("Please enter longitude");
		double user_long = Double.parseDouble(args[2]);
		
		System.out.println("Please enter latitude");
		double user_lat = Double.parseDouble(args[3]);
		
		
		/**
		System.out.println("Enter current location (address)");
		String user_loc = args[2];
		*/
		
		// establish connection
		Connection con = DatabaseConnection.Initialize();
		
		// filter the data using the given industry tag
		business[] filtered = DatabaseConnection.IndustryFilter(con, user_tag);
		
		
		
	}
	
	public void print(business_coord[] filtered) {
		for (int e = 0; e < filtered.length; e++) {
			System.out.println("---------------------------------------\n");
			System.out.println("Business Name : " + filtered[e].get_name());
			System.out.println("Phone Number : " + filtered[e].get_number());
			System.out.println("Address : " + filtered[e].get_address());
			System.out.println();
		}
		System.out.println("\n---------------------------------------\n");
	}
}