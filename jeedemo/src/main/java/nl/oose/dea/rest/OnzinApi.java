package nl.oose.dea.rest;

import nl.oose.dea.rest.dto.UserDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/onzin")
public class OnzinApi {

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id) {
        UserDTO userDTO = new UserDTO();
        userDTO.password = "Scrambled";
        userDTO.userName = "Michel";
        userDTO.id = id;
        return Response.status(200).entity(userDTO).build();

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "hallo! hallo!";
    }
}
