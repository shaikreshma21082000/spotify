package com.niit.usersongs.service;

import com.niit.usersongs.domain.Playlist;
import com.niit.usersongs.domain.PlaylistSongs;
import com.niit.usersongs.domain.Song;
import com.niit.usersongs.exception.PlaylistAlreadyExsistException;
import com.niit.usersongs.repository.PlaylistSongsRepository;
import com.niit.usersongs.repository.SongsRepository;
import com.niit.usersongs.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSongServiceImpl implements UserSongService {
    private PlaylistRepository playlistRepository;
    private SongsRepository songsRepository;
    private PlaylistSongsRepository playlistSongsRepository;

    @Autowired
    public UserSongServiceImpl(PlaylistRepository playlistRepository, SongsRepository songsRepository,PlaylistSongsRepository playlistSongsRepository) {
        this.playlistRepository = playlistRepository;
        this.songsRepository=songsRepository;
        this.playlistSongsRepository=playlistSongsRepository;
    }
    AudioPlayer audioPlayer=new AudioPlayer();
    Song mainSong;
    @Override
    public List<Song> getAllSongs() {
        return songsRepository.findAll();
    }

    @Override
    public Song playSong(String name) {
        name=name.replace("_"," ");
        System.out.println(name+" after replacement");
        Song song=songsRepository.findSongByName(name);
        mainSong=songsRepository.findSongByName(name);
        System.out.println(song.toString()+"\n"+song.getLocation());
        audioPlayer.playMusic(song.getLocation());
         System.out.println(song.toString());
        return song;
    }

    @Override
    public Song pause() {
        audioPlayer.pause();
        return mainSong ;
    }

    @Override
    public Song stopSong() {
        audioPlayer.stop();
        return mainSong;
    }

    @Override
    public Song restart() {
        audioPlayer.restart();
        return mainSong;
    }

    @Override
    public Song resume() {
         audioPlayer.resume();
         return mainSong;
    }

    @Override
    public Playlist createPlaylist(Playlist playlist){
        System.out.println("entered into astp service method");
        return playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> retriveAllPlaylist() {
        return playlistRepository.findAll();
    }

    @Override
    public List<Playlist> findAllPlaylistOfUser(String username) {
        return playlistRepository.findByUserName(username);
    }

    @Override
    public void deletePlaylist(String playlistId) {
        if(playlistRepository.existsById(playlistId)) {
            playlistRepository.deleteById(playlistId);
        }
    }


    @Override
    public PlaylistSongs addSongToPlaylist(PlaylistSongs playlistSongs) {
        return playlistSongsRepository.save(playlistSongs);
    }

    @Override
    public List<PlaylistSongs> getAllSongsInPlaylist() {
        return playlistSongsRepository.findAll();
    }

    @Override
    public void deleteSongFromPlaylist(String playlistSongId) {
        if(playlistSongsRepository.existsById(playlistSongId)){
            playlistSongsRepository.deleteById(playlistSongId);
        }
    }


}


