package LA_pages;
import java.sql.*;

public class main_func {
	public static void main(String[] args) {
		System.out.println("Enter business tag of choice : ");
		String user_tag = args[0];
		System.out.println("Enter business name (optional))");
		String user_name = args[1];
		System.out.println("Enter current location (address)");
		String user_loc = args[2];
		
		csv_filter();
	}
}