package Restuarant.Reservation.App.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Restuarant.Reservation.App.model.Reservation;
import Restuarant.Reservation.App.util.DButil;



public class ReservationListDAO {

	public List<Reservation> getAll() throws Exception {
		List<Reservation> revList = new ArrayList<Reservation>();
		
		Connection conn = DButil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT reservation_code,name,date(date) as date,guests FROM reservation_details");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Reservation rev = new Reservation();
				
				rev.setReservation_code(rs.getInt("reservation_code"));
				rev.setName(rs.getString("name"));
				rev.setDate(rs.getString("date"));
				rev.setGuests(rs.getInt("guests"));
				
			revList.add(rev);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error in fetching records from database.", e.getCause());
		}
		finally {
			
			DButil.closeResources(ps, rs, conn);
			
		}
		
		return revList;
	}
	
	public Reservation getReservation(int reservationCode) throws Exception {
		Reservation rev = new Reservation();
		
		Connection con = DButil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT reservation_code,status,name,date(date) as date,time,guests,email,phone FROM reservation_details WHERE reservation_code=?");
			ps.setInt(1, reservationCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				rev.setReservation_code(rs.getInt("reservation_code"));
				rev.setStatus(rs.getString("status"));
				rev.setName(rs.getString("name"));
				rev.setDate(rs.getString("date"));
				rev.setTime(rs.getTimestamp("time"));
				rev.setGuests(rs.getInt("guests"));
				rev.setEmail(rs.getString("email"));
				rev.setPhone(rs.getString("phone"));
			}
			else {
				throw new Exception("Reservation with reservation code=" + reservationCode + " does not exist in the system.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error in fetching record from database.", e.getCause());
		}
		finally {
			DButil.closeResources(ps, rs, con);
		}
		
		return rev;
	}
	
public Reservation addReservation(Reservation rev) throws Exception {
		
		Connection con = DButil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("INSERT INTO reservation_details (name, date, time, guests, email, phone) VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, rev.getName());
			ps.setString(2, rev.getDate());
			ps.setTimestamp(3, rev.getTime());
			ps.setInt(4, rev.getGuests());
			ps.setString(5, rev.getEmail());
			ps.setString(6, rev.getPhone());
	

			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if(rs.next())
			{
				rev.setReservation_code(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error in adding employee to the database.", e.getCause());
		}
		finally {
			DButil.closeResources(ps, rs, con);
		}
		
		return rev;
	}
}


