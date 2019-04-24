package net.wpd2_coursework_group10.ws;

import net.wpd2_coursework_group10.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("services")
public class MilestoneService {

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getMessage() {
//        return "Rest Never Sleeps";
//    }

    @Path("/account/login/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> getUser(String payload){

        ArrayList<User> resList = new ArrayList<User>();
        User user_1 = new User();
        user_1.setFullName("Faisal Burhan ABdu");
        user_1.setEmailAddres("Ultraisman@gmail.com");
        user_1.setPassword("MyPassword");
        resList.add(user_1);
        User user_2 = new User();
        user_2.setFullName("Farid Burhan Abdu");
        user_2.setEmailAddres("fabdub@gmail.com");
        user_2.setPassword("password_pass");
        resList.add(user_2);

        return resList;

    }

//    @Path("{f}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response convertFtoCfromInput(@PathParam("f") float f){
//
////        JSONObject jsonObject = new JSONObject();
////        float celsius;
////        celsius = (f - 32) * 5 / 9;
////        jsonObject.put("F Value", f);
////        jsonObject.put("C Value", celsius);
////
////        String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
////        return Response.status(200).entity(result).build();
//    }

}