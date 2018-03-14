package com.baljinder;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Create a program that implements a playlist for songs
  A Song class having Title and Duration for a song.
  An Album class containing a list of songs. The albums will be stored in an ArrayList
  Songs from different albums can be added to the playlist and will appear in the list in the order
  they are added. Once the songs have been added to the playlist, create a menu of options to:-
  Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
 */
public class Main {
    private static ArrayList<Album> albumList = new ArrayList<>();
    private static ArrayList<PlayList> playList = new ArrayList<>();
    private static Album album;
    private static PlayList pList;
    private static Scanner scanner = new Scanner(System.in);
    private static Song song;

    public static void main(String args[]) {
        boolean quit = false;
        while (!quit) {
            printMenu();
            System.out.println("Enter the choice");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    addAlbum();
                    break;
                case 2:
                    addSong();
                    break;
                case 3:
                    showAlbumSong();
                    break;
                case 4:
                    removeAlbum();
                    break;
                case 5:
                    removeSong();
                    break;
                case 6:
                    createPlaylist();
                    break;
                case 7:
                    addSongtoPlayList();
                    break;
                case 8:
                    playPlayList();
                    break;
                case 9:
                    quit = true;
                    break;
            }

        }

    }

    public static void printMenu() {
        System.out.println("0 - to show Menu" +
                "\n1 - to add a new Album" +
                "\n2 - to add a song to the album" +
                "\n3 - to show album and songs" +
                "\n4 - to remove album" +
                "\n5 - to remove song" +
                "\n6 - to create a playlist" +
                "\n7 - to add song to playlist" +
                "\n8 - to play playlist" +
                "\n9 - to quit");
    }

    public static void addAlbum() {
        System.out.println("Enter the name of the album");
        String albumName = scanner.nextLine();
        album = new Album(albumName);
        if (searchAlbumList(albumName) >= 0) {
            System.out.println("Album exist already");
        } else {
            albumList.add(album);
            System.out.println("Album added successfully");
        }
    }

    public static void addSong() {
        album = null;
        System.out.println("Enter the name of the album where you want to add the song: ");
        String albumName = scanner.nextLine();
        if (searchAlbumList(albumName) >= 0) {
            album = albumList.get(searchAlbumList(albumName));
            System.out.println("Enter the name of the song: ");
            String songName = scanner.nextLine();
            if (album.querySong(songName)) {
                System.out.println("Song already exist");
            } else {
                System.out.println("Enter the duration of the song to add: ");
                double songDuration = scanner.nextDouble();
                scanner.nextLine();
                song = new Song(songName, songDuration);
                album.addSong(song);
                System.out.println("Song added successfully");
            }
        } else {
            System.out.println("Album doesn't exist");
        }
    }


    private static int searchAlbumList(String albumName) {
        for (int i = 0; i < albumList.size(); i++) {
            if (albumList.get(i).getAlbumName().equalsIgnoreCase(albumName)) {
                return i;
            }
        }
        return -1;
    }

    public static void removeAlbum() {
        System.out.println("Enter the album name you want to remove: ");
        String albumName = scanner.nextLine();
        if (searchAlbumList(albumName) >= 0) {
            albumList.remove(searchAlbumList(albumName));
            System.out.println("Album " + albumName + " removed successfully");
        } else {
            System.out.println("Album doesn't exist");
        }
    }

    public static void removeSong() {
        album = null;
        System.out.println("Enter the albumName from where you want to remove the song:");
        String albumName = scanner.nextLine();
        if (searchAlbumList(albumName) >= 0) {
            album = albumList.get(searchAlbumList(albumName));
        }
        if (album != null) {
            System.out.println("Enter the name of the song you want to remove: ");
            String songName = scanner.nextLine();
            album.removeSong(songName);
        }
    }

    public static void showAlbumSong() {
        album = null;
        for (int i = 0; i < albumList.size(); i++) {
            album = albumList.get(i);
            System.out.println("Album " + album.getAlbumName());
            ListIterator<Song> songList = album.getSongList().listIterator();
            while (songList.hasNext()) {
                Song songDetail = songList.next();
                System.out.println("Song Name -->" + songDetail.getSongName()
                        + " Duration-->" + songDetail.getSongduration());
            }
        }
    }

    public static void createPlaylist() {
        System.out.println("Enter the name of the playlist you want to add: ");
        String pName = scanner.nextLine();
        pList = new PlayList(pName);
        if (getPlayList(pName) > 0) {
            System.out.println("Playlist already exist");
        } else {
            playList.add(pList);
            System.out.println("Playlist added successfully");
        }
    }

    public static void addSongtoPlayList(){
        System.out.println("Enter the name of the playlist where you want to add: ");
        String pName = scanner.nextLine();
        pList = null;
        if (getPlayList(pName) >= 0) {
            pList = playList.get(getPlayList(pName));
            System.out.println("Enter the name of the song you want to add to the playlist:");
            String songName = scanner.nextLine();
                for (int i = 0; i < albumList.size(); i++) {
                    album = albumList.get(i);
                    ListIterator<Song> songList = album.getSongList().listIterator();
                    while (songList.hasNext()) {
                        Song songDetail = songList.next();
                        if (songDetail.getSongName().equalsIgnoreCase(songName)) {
                            pList.addSong(songDetail);
                            System.out.println("Song " + songName + " added successfully to " + pList.getPlayListName());
                        }
                    }
                }
        } else {
            System.out.println("playlist doesn't exist");
        }

    }

    public static void playPlayList(){
        System.out.println("Enter the name of the playlist you want to add: ");
        String pName = scanner.nextLine();
        pList = null;
        if (getPlayList(pName) >= 0) {
            pList = playList.get(getPlayList(pName));
            ListIterator<Song> songList = pList.getSongList().listIterator();
            printMenuOption();
            boolean quit = false;
            boolean forward = false;
            while (!quit) {
                System.out.println("Enter the choice");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        if (forward) {
                            songList.next();
                        }if (songList.hasNext()) {
                            System.out.println("Now playing " + songList.next().getSongName());
                            forward = false;
                        } else {
                            System.out.println("Reached to end of the list");
                            forward = false;
                            printMenuOption();
                        }
                        break;
                    case 1:
                        if (!forward) {
                            songList.previous();
                        }if (songList.hasPrevious()) {
                            System.out.println("Now playing " + songList.previous().getSongName());
                            forward = true;
                        } else {
                            System.out.println("Reached to front of the list");
                            forward = true;
                            printMenuOption();
                        }
                        break;
                    case 2:
                        String currentSong = null;
                        if (forward) {
                            currentSong = songList.next().getSongName();
                            System.out.println("Now playing " + currentSong);
                            currentSong = songList.previous().getSongName();
                        } else if (!forward) {
                            currentSong = songList.previous().getSongName();
                            System.out.println("Now playing " + currentSong);
                            currentSong = songList.next().getSongName();
                        }
                        break;
                    case 3:
                        quit = true;
                        break;
                }
            }
        } else {
            System.out.println("Playlist doesn't exist");
        }

    }

    public static int getPlayList(String playListName) {
        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).getPlayListName().equalsIgnoreCase(playListName)) {
                return i;
            }
        }
        return -1;
    }

    public static void printMenuOption() {
        System.out.println("0 - to forward song" +
                "\n1 - to reverse song" +
                "\n2 - to repeat song" +
                "\n3 - to quit");
    }
}
