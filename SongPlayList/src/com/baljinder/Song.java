package com.baljinder;

/**
 * Created by bghotra on 7/11/2017.
 */
public class Song {
    private String songName;
    private double songduration;

    public Song(String songName, double songduration){
        this.songName = songName;
        this.songduration = songduration;
    }

    public String getSongName(){
        return this.songName;
    }

    public double getSongduration(){
        return this.songduration;
    }
}
