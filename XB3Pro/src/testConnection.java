import java.sql.*;
public class testConnection {

	private static Connection Initialize() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath", e);
		}
		
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "120800";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	public static void viewTable(Connection con, String dbName) throws SQLException {
		Statement stmt = null;
		String query = "SELECT * from test.testlist WHERE Industry_Tag LIKE '%art%'";
		
		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			String buisnessName = rs.getString("owners_business_name");
			String address = rs.getString("Business_Address");
			String tag = rs.getString("Industry_Tag");
			System.out.println(buisnessName + " " + address + " " + tag);
				
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection con = Initialize();
		String dbName = "test";
		viewTable(con, dbName);
	}
}
