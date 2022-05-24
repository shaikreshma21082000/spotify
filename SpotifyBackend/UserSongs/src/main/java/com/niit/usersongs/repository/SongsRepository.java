package com.niit.usersongs.repository;

import com.niit.usersongs.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SongsRepository extends MongoRepository<Song,String>{
    @Query("{'name' :?0}")
    Song findSongByName(String name);
}
