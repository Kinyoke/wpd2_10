package net.wpd2_coursework_group10.ws;

import net.wpd2_coursework_group10.database.DatabaseConnector;
import net.wpd2_coursework_group10.model.Payload;
import net.wpd2_coursework_group10.model.User;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;


@Path("services")
public class MilestoneService extends ResourceConfig {


    private DatabaseConnector databaseConnector =  new DatabaseConnector();;
    private HashMap map;
    private JSONObject obj_1;
    private JSONObject obj_2;


    @Path("/account/login/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logIn(Payload payload){
        map = (HashMap) payload.getPAYLOAD_DATA();

        String email = (String) map.get("emailAddress");
        String password = (String) map.get("password");
        int val = databaseConnector.varifyUser(email, password);
        String session = new DatabaseConnector().getSessionId(email);
        obj_1 = new JSONObject();
        obj_2 = new JSONObject();

        switch (val){
            case 0: // do not have an account
                obj_2.put("status", "NOACC");
                obj_2.put("message", "Check your email or do not have an account, please sign up");
                obj_1.put("response", obj_2);
                break;
            case 1: // logged in successfully
                obj_2.put("status", "ACK");
                obj_2.put("user", email);
                obj_2.put("session", session);
                obj_2.put("message", "account verified");
                obj_1.put("response", obj_2);
                break;
            case 2: // already logged in
                obj_2.put("status", "ACTIVE");
                obj_2.put("message", "Already logged in!");
                obj_1.put("response", obj_2);
                break;
            case 3: // already logged in
                obj_2.put("status", "WPSWD");
                obj_2.put("message", "wrong password!");
                obj_1.put("response", obj_2);
                break;
        }

        return Response.ok().entity(obj_1.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
    }


    @Path("/account/logout/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logOut(Payload payload){
        map = (HashMap) payload.getPAYLOAD_DATA();
        String email = (String) map.get("emailAddress");
        String sessionid = (String) map.get("session");
        obj_1 = new JSONObject();
        obj_2 = new JSONObject();
        databaseConnector.updateLogStatus(email, sessionid);
        obj_2.put("status", "INACTIVE");
        obj_2.put("message", "logged out");
        obj_1.put("response", obj_2);
        return Response.ok().entity(obj_1.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
    }

    @Path("/account/signup/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(Payload payload){

        map = (HashMap) payload.getPAYLOAD_DATA();
        User newUser = new User();
        String value = "";

        value = (String) map.get("firstName");
        newUser.setFirstName(value);
        value = (String) map.get("middleName");
        newUser.setMiddleName(value);
        value = (String) map.get("lastName");
        newUser.setLastName(value);
        value = (String) map.get("emailAddress");
        newUser.setEmailAddres(value);
        value = (String) map.get("password");
        newUser.setPassword(value);

        System.out.println(newUser.toString());

        obj_1 = new JSONObject();
        obj_2 = new JSONObject();

        if (!databaseConnector.createUserAccount(newUser)){
            obj_2.put("status", "exist");
            obj_2.put("message", "Account already exist, please login!");
            obj_1.put("response", obj_2);
        }else{
            databaseConnector.varifyUser(newUser.getEmailAddres(), newUser.getPassword());
            String session = databaseConnector.getSessionId(newUser.getEmailAddres());
            obj_2.put("status", "success");
            obj_2.put("user", newUser.getEmailAddres());
            obj_2.put("session", session);
            obj_2.put("message", "Account crated successfully!");
            obj_1.put("response", obj_2);
        }

        return Response.ok().entity(obj_1.toString()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
    }


    @Path("/account/resetpassword")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response resetPassword(Payload payload){
        //implements password rest over an email link.
        return Response.ok().entity(payload).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
    }


    @Path("/milestone/list")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listMilestone(Payload payload){
        return Response.ok().entity(payload).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
    }

    @Path("/milestone/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMilestone(Payload payload){
        return Response.ok().entity(payload).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
    }

    @Path("/milestone/edit")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editMilestone(Payload payload){
        return Response.ok().entity(payload).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
    }

    @Path("/milestone/delete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMilestone(Payload payload){
        return Response.ok().entity(payload).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
    }


}
