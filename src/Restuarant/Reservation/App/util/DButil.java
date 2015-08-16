package Restuarant.Reservation.App.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {

	private final static String URL = "jdbc:mysql://localhost:3306/restuarantapp";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection connectToDB(){
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection is successful");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error establishing the connection: " + e.getMessage());
		}
		return conn; 
	}
	
	public static void closeResources (PreparedStatement ps, ResultSet rs, Connection conn) {
		try {
			if(ps != null)
			{
				ps.close();
			}
			if(rs != null)
			{
				rs.close();
			}
			if(conn != null)
			{
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		DButil.connectToDB();
	}
}

