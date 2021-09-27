package com.helen.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helen.lookify.models.Song;
import com.helen.lookify.services.SongService;

@RestController
@RequestMapping("/api/songs")
public class ApiSongController {
	@Autowired
	private SongService sService;
	
	//get all songs
	@GetMapping("")
	public List<Song> index() {
		return this.sService.allSongs();
	}

	//create a song
	@PostMapping("/create")
	public Song createSong(Song song) {
		return this.sService.createSong(song);
	}
	
	//update 
	@PutMapping("{id}/update") 
	 public Song update(@PathVariable("id") Long id, Song song) {
		 return this.sService.updateSong(song);
	 }
	
	//display a song
	@GetMapping("/{id}") 
	public Song getOneLang(@PathVariable("id") Long id) {
		return this.sService.getOne(id);
	}
	
	//delete a song
	 @DeleteMapping("/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		 return this.sService.deleteSong(id);
	 }
	 
	 //search artist
	@PostMapping("/search/{artistName}") 
	 public List<Song> songArtist(@PathVariable("artistName") String artist) {
		 return sService.songsContainingArtist(artist);
	 } 
	@GetMapping("/topten") 
	public List<Song> topTenByRaing() {
		return sService.topTenByRating();
	}
}
