package com.helen.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.helen.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song,Long>{
    List<Song> findAll();//select * from songs
    List<Song> findByArtistContaining(String searchName);//search by artist name
	List<Song> findTop10ByOrderByRatingDesc();//top ten 
}
