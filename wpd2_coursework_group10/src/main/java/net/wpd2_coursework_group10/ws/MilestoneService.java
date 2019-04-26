package net.wpd2_coursework_group10.ws;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.wpd2_coursework_group10.model.Payload;
import net.wpd2_coursework_group10.model.User;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@Path("services")
public class MilestoneService extends ResourceConfig {


    @Path("/account/login/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUser(Payload payload){

//        JSONObject obj = new JSONObject(payload);
        Payload mpayload = new Payload();
        mpayload = payload;
        System.out.println(" PAYLOAD : "+payload.toString());

//        ObjectMapper mapper = new ObjectMapper();
//        Payload mpayload = new Payload();
//        try {
//            mpayload = mapper.readValue(payload, Payload.class);
//            System.out.println("payload : "+mpayload.getACTION()); //John
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        User user_1 = new User();
        user_1.setFullName("Faisal Burhan ABdu");
        user_1.setEmailAddres("Ultraisman@gmail.com");
        user_1.setPassword("MyPassword");
        return Response.ok().entity(mpayload).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();


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