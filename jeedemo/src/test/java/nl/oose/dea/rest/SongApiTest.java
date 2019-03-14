package nl.oose.dea.rest;

import nl.oose.dea.dao.ISongDao;
import nl.oose.dea.domain.Song;
import nl.oose.dea.rest.dto.SongDTO;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SongApiTest {

    @Test
    public void getSongTest(){
        String artist = "The Prodigy";
        String songName = "Voodoo People";
        SongApi songApi = new SongApi();
        ISongDao songDao = mock(ISongDao.class);
        Song song = new Song();
        song.setArtist(artist);
        song.setName(songName);

        when(songDao.retrieveSong(150)).thenReturn(song);
        songApi.setSongDao(songDao);
        Response response = songApi.getSong("150");
        SongDTO dto = (SongDTO) response.getEntity();

        assertEquals(artist,dto.artist);
        assertEquals(songName,dto.name);
        assertEquals(200,response.getStatus());
    }

    @Test
    public void getSongIdDoesNotExistTest(){
        SongApi songApi = new SongApi();
        ISongDao songDao = mock(ISongDao.class);
        songApi.setSongDao(songDao);

        Response response = songApi.getSong("-1");


        assertEquals(404,response.getStatus());
    }
}
