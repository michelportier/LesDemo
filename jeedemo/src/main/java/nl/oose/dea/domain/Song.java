package nl.oose.dea.domain;

import java.util.Date;

public class Song {
    private String artist;
    private String name;
    private int lenghtInMs;
    private Date releaseDate;
    private String lyrics;
    private int id;

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name==null)
            return;
        this.name = name;
    }

    public int getLenghtInMs() {
        return lenghtInMs;
    }

    public void setLenghtInMs(int lenghtInMs) {
        this.lenghtInMs = lenghtInMs;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }



}
