package nl.oose.dea.rest;

import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SongApiTest {

    @Test
    public void getSongTest(){
        SongApi songApi = new SongApi();
        Response response = songApi.getSong("150");
        assertEquals(200,response.getStatus());
    }
}
