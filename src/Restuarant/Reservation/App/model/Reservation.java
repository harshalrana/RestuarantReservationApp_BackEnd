package Restuarant.Reservation.App.model;

import java.sql.Timestamp;


public class Reservation {

	private int reservation_code;
	private String status;
	private String name;
	private String date;
	private Timestamp time;
	private int guests;
	private String email;
	private String phone;
	
	public int getReservation_code() {
		return reservation_code;
	}
	public void setReservation_code(int reservation_code) {
		this.reservation_code = reservation_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getGuests() {
		return guests;
	}
	public void setGuests(int guests) {
		this.guests = guests;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
		
	
	
}

