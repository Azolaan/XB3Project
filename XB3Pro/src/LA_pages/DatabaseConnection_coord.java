package LA_pages;
import java.sql.*;
public class DatabaseConnection_coord {

	public static Connection Initialize() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "120800";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	public static business_coord[] IndustryFilter(Connection con, String search) throws SQLException {
		Statement stmt = null;
		String query = "SELECT * from test.testlist WHERE Industry_Tag LIKE '%" + search + "%'";
		business_coord[] BusinessArray = new business_coord[100];
		int count = 0;
		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			String name = rs.getString("owners_business_name");
			String number = rs.getString("Business_Address");
			String location = rs.getString("Phone1");
			String tag = rs.getString("Industry_Tag");
			String coord = rs.getString("Longitude");
			Double lon = Double.parseDouble((coord.split(","))[0].substring(2));
			Double lat = Double.parseDouble((coord.split(","))[1].substring(0,(coord.split(",").length - 3)));
			
			BusinessArray[count] = new business_coord(name, number, location, tag, lat, lon);
		}
		return BusinessArray;
	}
}
