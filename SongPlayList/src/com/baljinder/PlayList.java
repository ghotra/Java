package com.baljinder;

import java.util.LinkedList;

/**
 * Created by bghotra on 7/16/2017.
 */
public class PlayList {
    private String playListName;
    LinkedList<Song> songList;

    public PlayList(String playListName){
        this.playListName = playListName;
        this.songList = new LinkedList<>();
    }

    public void addSong(Song song){
        songList.add(song);
    }

    public String getPlayListName(){
        return this.playListName;
    }

    public LinkedList<Song> getSongList(){
        return this.songList;
    }
}
