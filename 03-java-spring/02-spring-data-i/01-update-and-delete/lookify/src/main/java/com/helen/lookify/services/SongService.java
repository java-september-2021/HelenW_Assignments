package com.helen.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.helen.lookify.models.Song;
import com.helen.lookify.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository sRepo;
	//all songs
	public List<Song> allSongs() {
		return this.sRepo.findAll();
	
		
	}
	
	//create a new song
	public Song createSong(Song song) {
		return this.sRepo.save(song);
	}
	
	//update a song
	public Song updateSong(Song song) {
		return this.sRepo.save(song);
	}
	
	//retrieve a song
	public Song getOne(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	//delete a song
	public String deleteSong(Long id) {
		this.sRepo.deleteById(id);
		return "Song has been deleted";
	}
	//search by artist name
	public List<Song> songsContainingArtist(String artist) {
		return sRepo.findByArtistContaining(artist);
	}
	public List<Song> topTenByRating() {
		return sRepo.findTop10ByOrderByRatingDesc();
	}
}
