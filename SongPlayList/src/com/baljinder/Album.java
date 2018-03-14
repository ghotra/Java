package com.baljinder;

import java.util.LinkedList;

/**
 * Created by bghotra on 7/11/2017.
 */
public class Album {
    private final String albumName;
    private final songDetail song;

    public Album(String albumName){
        this.albumName = albumName;
        song = new songDetail();
    }

    public String getAlbumName(){
        return this.albumName;
    }

    public void addSong(Song newSong){
        song.addSong(newSong);
    }

    public boolean querySong(String songName){
        return song.querySong(songName);
    }

    public void removeSong(String songName){
        song.removeSong(songName);
    }

    public LinkedList<Song> getSongList(){
        return song.getSongList();
    }

    private class songDetail{
        private final LinkedList<Song> songList;

        public songDetail(){
            this.songList = new LinkedList<>();
        }

        public void addSong(Song song){
            songList.add(song);
        }

        public boolean querySong(String songName){
            if(searchSong(songName) >=0){
                return true;
            }
            return false;
        }

        private int searchSong(String songName){
            for(int i=0; i<songList.size();i++){
                if(songList.get(i).getSongName().equalsIgnoreCase(songName)){
                    return i;
                }
            }return -1;
        }

        public void removeSong(String songName){
            for(int i=0; i<songList.size();i++){
                if(searchSong(songName) >=0){
                    songList.remove(searchSong(songName));
                    System.out.println("Song " + songName + " removed successfully");
                }else {
                    System.out.println("Song " + songName + " doesn't exist");
                }
            }
        }

        public LinkedList<Song> getSongList(){
            return this.songList;
        }

    }


}
