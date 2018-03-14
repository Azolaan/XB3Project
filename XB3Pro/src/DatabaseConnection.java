import java.sql.*;
public class DatabaseConnection {

	private static Connection Initialize() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "120800";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	public static business[] IndustryFilter(Connection con, String search) throws SQLException {
		Statement stmt = null;
		String query = "SELECT * from test.testlist WHERE Industry_Tag LIKE '%" + search + "%'";
		business[] BusinessArray = new business[100];
		int count = 0;
		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			String name = rs.getString("owners_business_name");
			String number = rs.getString("Business_Address");
			String location = rs.getString("Phone1");
			String tag = rs.getString("Industry_Tag");
			BusinessArray[count] = new business(name, number, location, tag);
		}
		return BusinessArray;
	}
}