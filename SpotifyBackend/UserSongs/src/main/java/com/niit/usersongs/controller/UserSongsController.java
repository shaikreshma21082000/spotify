package com.niit.usersongs.controller;

import com.niit.usersongs.domain.Playlist;
import com.niit.usersongs.domain.PlaylistSongs;
import com.niit.usersongs.domain.Song;
import com.niit.usersongs.service.UserSongService;
import com.niit.usersongs.service.UserSongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v2/")
@CrossOrigin(origins = "*")
public class UserSongsController {

    private ResponseEntity responseEntity;
    private UserSongService userSongService;

    @Autowired
    public UserSongsController(UserSongService userSongService) {
        this.userSongService = userSongService;
    }

    @GetMapping("songs")
    public ResponseEntity<?> getAllSongs() {
        responseEntity = new ResponseEntity(userSongService.getAllSongs(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("song/{name}")
    public ResponseEntity<?> playSong(@PathVariable String name) {
        responseEntity = new ResponseEntity(userSongService.playSong(name), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("song/stop")
    public ResponseEntity<?> stopSong() {
        responseEntity = new ResponseEntity(userSongService.stopSong(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("song/pause")
    public ResponseEntity<?> pauseSong() {
        responseEntity = new ResponseEntity(userSongService.pause(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("song/resume")
    public ResponseEntity<?> resumeSong() {
        responseEntity = new ResponseEntity(userSongService.resume(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("song/restart")
    public ResponseEntity<?> restartsong() {
        responseEntity = new ResponseEntity(userSongService.restart(), HttpStatus.OK);
        return responseEntity;
    }


    @PostMapping("addPlaylist")
    public ResponseEntity<?> createPlaylist(@RequestBody Playlist playlist) {
        responseEntity = new ResponseEntity(userSongService.createPlaylist(playlist), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("playlists")
    public ResponseEntity<?> getAllPlaylist() {
        responseEntity = new ResponseEntity(userSongService.retriveAllPlaylist(), HttpStatus.OK);
        return responseEntity;
    }


    @GetMapping("playlists/{username}")
    public ResponseEntity<?> getAllPlaylistsOfUser(@PathVariable String username) {
        responseEntity = new ResponseEntity(userSongService.findAllPlaylistOfUser(username), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("deletePlaylist/{playlistId}")
    public ResponseEntity<?> deletePlaylist(@PathVariable String playlistId) {
        userSongService.deletePlaylist(playlistId);
        responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

   @PostMapping("astp")
   public ResponseEntity<?> addSongToPlaylist(@RequestBody PlaylistSongs playlistSongs) {
       System.out.println("entered into astp controller");
       responseEntity = new ResponseEntity(userSongService.addSongToPlaylist(playlistSongs), HttpStatus.OK);
       return responseEntity;
   }


    @GetMapping("playlistSongs")
    public ResponseEntity<?> getAllSongsFromPlaylists() {
        responseEntity = new ResponseEntity(userSongService.getAllSongsInPlaylist(), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("dsfp/{playlistSongId}")
    public ResponseEntity<?> deleteSongFromPlaylist(@PathVariable String playlistSongId) {
        userSongService.deleteSongFromPlaylist(playlistSongId);
        responseEntity = new ResponseEntity( HttpStatus.OK);
        return responseEntity;
    }
}
