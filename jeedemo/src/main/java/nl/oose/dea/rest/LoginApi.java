package nl.oose.dea.rest;

import nl.oose.dea.dao.IUserDao;
import nl.oose.dea.rest.dto.TokenDTO;
import nl.oose.dea.rest.dto.UserDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/api/login")
public class LoginApi {

    @Inject
    private IUserDao userDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UserDTO userDTO) {
        String tokenString = userDao.login(userDTO.userName, userDTO.password);
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.userName = userDTO.userName;
        tokenDTO.token = tokenString;

        return Response.status(200).entity(tokenDTO).build();
    }




}
