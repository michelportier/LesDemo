package nl.oose.dea.rest;

import nl.oose.dea.dao.ISongDao;
import nl.oose.dea.domain.Song;
import nl.oose.dea.rest.dto.SongDTO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api/song")
public class SongApi {

    @Inject
    private ISongDao songDao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSong(@PathParam("id") String id){

        Song song = songDao.retrieveSong(Integer.parseInt(id));
        SongDTO songDTO = new SongDTO();
        songDTO.name = song.getName();
        songDTO.artist = song.getArtist();

        return Response.status(200).entity(songDTO).build();


    }

    public void setSongDao(ISongDao songDao) {
        this.songDao = songDao;
    }
}
