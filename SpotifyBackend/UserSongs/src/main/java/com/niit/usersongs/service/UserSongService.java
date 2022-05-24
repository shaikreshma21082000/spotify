package com.niit.usersongs.service;

import com.niit.usersongs.domain.Playlist;
import com.niit.usersongs.domain.PlaylistSongs;
import com.niit.usersongs.domain.Song;
import com.niit.usersongs.exception.SongNotFoundException;

import java.util.List;

public interface UserSongService {
    List<Song> getAllSongs();
    Song playSong(String name);
    Song stopSong();
    Song pause();
    Song restart();
    Song resume();

    Playlist createPlaylist(Playlist playlist);
    List<Playlist> retriveAllPlaylist();
    List<Playlist> findAllPlaylistOfUser(String username);
    void deletePlaylist(String playlistId);

    PlaylistSongs addSongToPlaylist(PlaylistSongs playlistSongs);
    List<PlaylistSongs> getAllSongsInPlaylist();
    void deleteSongFromPlaylist(String playlistSongId);

}
