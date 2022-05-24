package com.niit.usersongs.repository;

import com.niit.usersongs.domain.Playlist;
import com.niit.usersongs.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlaylistRepository extends MongoRepository<Playlist,String>{
    @Query("{'username' : {$in : [?0]}}")
    List<Playlist> findByUserName(String username);
}