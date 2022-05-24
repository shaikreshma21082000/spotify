package com.niit.usersongs.repository;

import com.niit.usersongs.domain.Playlist;
import com.niit.usersongs.domain.PlaylistSongs;
import com.niit.usersongs.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface PlaylistSongsRepository extends MongoRepository<PlaylistSongs,String> {
//    @Query("{'playlistId' : {$in : [?0]}}")
//    List<Song> findByPlaylistId(String playlistId);
    @Query("{'playlistId' : {$in : [?0]}}")
    List<PlaylistSongs> findByPlaylistId(String PlaylistId);
}