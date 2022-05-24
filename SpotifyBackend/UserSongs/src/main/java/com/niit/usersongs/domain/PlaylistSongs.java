package com.niit.usersongs.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PlaylistSongs {
    @Id
    private String playlistSongId;
    private String playlistId;
    private Song song;

    public PlaylistSongs() {
    }

    public PlaylistSongs(String playlistSongId, String playlistId, Song song) {
        this.playlistSongId = playlistSongId;
        this.playlistId = playlistId;
        this.song = song;
    }

    public String getPlaylistSongId() {
        return playlistSongId;
    }

    public void setPlaylistSongId(String playlistSongId) {
        this.playlistSongId = playlistSongId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "PlaylistSongs{" +
                "playlistSongId=" + playlistSongId +
                ", playlistId='" + playlistId + '\'' +
                ", song=" + song +
                '}';
    }
}
