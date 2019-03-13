package nl.oose.dea.dao;

import nl.oose.dea.domain.Song;

public class songDao implements ISongDao {
    @Override
    public Song retrieveSong(int id) {
        Song song = new Song();
        song.setArtist("The Prodigy");
        song.setName("No Good (Start The Dance)");
        return song;
    }
}
