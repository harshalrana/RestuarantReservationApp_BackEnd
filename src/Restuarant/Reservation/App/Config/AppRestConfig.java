package Restuarant.Reservation.App.Config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class AppRestConfig extends ResourceConfig{

	public AppRestConfig(){
		
		packages("Restuarant.Reservation.App.Rest");
	}
}
