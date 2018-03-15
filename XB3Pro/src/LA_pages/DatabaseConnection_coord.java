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
		business_coord[] BusinessArray = new business_coord[12];
		int count = 0;
		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			String name = rs.getString("doing_business_as");
			String number = rs.getString("Phone1");
			String location = rs.getString("Business_Address");
			String tag = rs.getString("Industry_Tag");
			String coord = rs.getString("Longitute");
			//System.out.println(coord);
			double lon = Double.parseDouble((coord.split(","))[0].substring(1));
			double lat = Double.parseDouble((coord.split(","))[1].substring(0,((coord.split(",")[1]).length() - 1)));
			//System.out.println(lon);
			//System.out.println(lat);
			business_coord temp = new business_coord(name, number, location, tag, lat, lon);
			BusinessArray[count] = temp;
			count++;
		}
		
		return BusinessArray;
	}
}
