/**
 * @author Group 13
 * Functions for connecting to SQL database and executing queries
 */
package LA_pages;
import java.sql.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import geocoder.*;

public class DatabaseConnection_coord {

	/**
	 * connects to SQL database given url, username and password
	 * @param url - Server location
	 * @param username - Server username
	 * @param password - Server password
	 * @return - Connection
	 * @throws SQLException
	 */
	public static Connection Initialize(String url, String username, String password) throws SQLException {
		
		Connection connection = DriverManager.getConnection(url, username, password);
		if (connection != null)
			System.out.println("Connected");
		return connection;
	}
	
	/**
	 * Executes a query, extracting rows that match the search input and stores them in an array of type business
	 * @param con - SQL connection
	 * @param search - Industry tag to search for
	 * @return - array of businesses
	 * @throws SQLException
	 */
	public static business_coord[] IndustryFilter(Connection con, String search) throws SQLException {
		Statement stmt1 = null;
		Statement stmt2 = null;
		//SQL select query
		String query = "SELECT * from business_schema.listing_of_active_businesses WHERE PRIMARY_NAICS_DESCRIPTION LIKE '%" + search + "%' AND PRIMARY_NAICS_DESCRIPTION IS NOT NULL";
		//SQL count query
		String count_query = "SELECT COUNT(*) from business_schema.listing_of_active_businesses WHERE PRIMARY_NAICS_DESCRIPTION LIKE '%" + search + "%' AND PRIMARY_NAICS_DESCRIPTION IS NOT NULL";
		
		//initialize array
		stmt2 = con.createStatement();
		ResultSet nRows = stmt2.executeQuery(count_query);
		nRows.next();
		business_coord[] BusinessArray = new business_coord[nRows.getInt("COUNT(*)")];
		
		//get rows
		stmt1 = con.createStatement();
		ResultSet rs = stmt1.executeQuery(query);
		int count = 0;
		while(rs.next()) {
			
			String name = rs.getString("BUSINESS_NAME");
			String number = rs.getString("ZIP_CODE");
			String location = rs.getString("STREET_ADDRESS");
			String coord = rs.getString("LOCATION");
			String tag = rs.getString("NAICS");
			
			//longitude and latitude
			Map<String, Double> coords;
			double lat = Double.parseDouble((coord.split(","))[0].substring(1));
			double lon = Double.parseDouble((coord.split(","))[1].substring(0,((coord.split(",")[1]).length() - 1)));
			
	        //store in business array
			business_coord temp = new business_coord(name, number, location, tag, lat, lon);
			BusinessArray[count] = temp;
			count++;
		}
		
		return BusinessArray;
	}
}
