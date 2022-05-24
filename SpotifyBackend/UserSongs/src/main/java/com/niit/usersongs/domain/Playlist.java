package com.niit.usersongs.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Playlist {
    @Id
    private String playlistId;
    private String playlistName;
    private String username;

    public Playlist() {
    }

    public Playlist(String playlistId, String playlistName, String username) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.username = username;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId='" + playlistId + '\'' +
                ", playlistName='" + playlistName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
