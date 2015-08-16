package Restuarant.Reservation.App.Rest;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Restuarant.Reservation.App.Dao.ProfileDetailsDAO;
import Restuarant.Reservation.App.model.profile;


	@Path("/profile")
	public class profileController {

		@GET
		@Path("/details")
		@Produces(MediaType.APPLICATION_JSON)
		public profile profileDetails() throws Exception{
			
			ProfileDetailsDAO dao = new ProfileDetailsDAO();
			profile profileDetails = dao.getAll();
			System.out.println("profile details");
			return profileDetails;
		}
	}

