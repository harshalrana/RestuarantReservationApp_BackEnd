package Restuarant.Reservation.App.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import Restuarant.Reservation.App.model.profile;
import Restuarant.Reservation.App.util.DButil;

public class ProfileDetailsDAO {

	public profile getAll() throws Exception {
		profile proList = new profile();
		
		Connection conn = DButil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM profile_details");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			
				proList.setName(rs.getString("name"));
				proList.setContact(rs.getString("contact"));
				proList.setEmail(rs.getString("email"));
				proList.setAddress(rs.getString("address"));
		
				
			}
			else
			{
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error in fetching records from database.", e.getCause());
		}
		finally {
			
			DButil.closeResources(ps, rs, conn);
			
		}
		
		return proList;
	}
}
