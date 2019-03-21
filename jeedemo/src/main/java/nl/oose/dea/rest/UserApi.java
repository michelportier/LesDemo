package nl.oose.dea.rest;


import nl.oose.dea.dao.IUserDao;
import nl.oose.dea.domain.User;
import nl.oose.dea.rest.dto.UserDTO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/user")
public class UserApi {

    @Inject
    private IUserDao userDao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id) {

        int int_id = 0;
        try{
            int_id = Integer.parseInt(id);
        } catch (NumberFormatException nfe){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        User user = userDao.getUser(int_id);
        if (user==null){
            return Response.status(404).build();
        }
        UserDTO userDTO = new UserDTO();
        userDTO.password = user.getPassword();
        userDTO.userName = user.getUserName();
        userDTO.id = ""+user.getId();
        return Response.status(200).entity(userDTO).build();

    }


}
