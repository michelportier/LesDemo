package nl.oose.dea.rest;

import nl.oose.dea.dao.ISongDao;
import nl.oose.dea.domain.Song;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SongApiTest {

    @Test
    public void getSongTest(){
        SongApi songApi = new SongApi();
        ISongDao songDao = mock(ISongDao.class);
        Song song = new Song();
        song.setArtist("The Prodigy");
        song.setName("Voodoo People");

        when(songDao.retrieveSong(150)).thenReturn(song);
        songApi.setSongDao(songDao);
        Response response = songApi.getSong("150");
        assertEquals(200,response.getStatus());
    }
}
