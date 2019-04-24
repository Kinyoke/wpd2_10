package net.wpd2_coursework_group10.ws;



import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/helloworld")
public class testingwsAPI{

    @GET
//    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "Rest Never Sleeps";
    }
}