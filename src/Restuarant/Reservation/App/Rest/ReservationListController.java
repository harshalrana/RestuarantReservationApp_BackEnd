package Restuarant.Reservation.App.Rest;





import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Restuarant.Reservation.App.Dao.ReservationListDAO;
import Restuarant.Reservation.App.model.Reservation;

@Path("/reservationlist")
public class ReservationListController {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> reservationlist() throws Exception{
		
		ReservationListDAO dao = new ReservationListDAO();
		List<Reservation> reservationlist = dao.getAll();
		System.out.println("reservationlist");
		return reservationlist;
	}
	
	
	
	@GET
	@Path("/get/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation getReservation(@PathParam("code") int reservationCode) throws Exception {


			ReservationListDAO dao = new ReservationListDAO();
			Reservation rdetails = dao.getReservation(reservationCode);
			try {
				rdetails = dao.getReservation(reservationCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		  return rdetails;
	}
		
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation addReservation(Reservation rev) {
		
		try {
			ReservationListDAO dao = new ReservationListDAO();
			rev = dao.addReservation(rev);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name= rev.getName();
		String date=rev.getDate();
		Timestamp time=rev.getTime();
		int guests=rev.getGuests();
		String email=rev.getEmail();
		String phone=rev.getPhone();
		
		System.out.println(name);
		System.out.println(date);
		System.out.println(time);
		System.out.println(guests);
		System.out.println(email);
		System.out.println(phone);
		
		return rev;
	}
}

