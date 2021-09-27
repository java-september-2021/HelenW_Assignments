package com.helen.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.helen.lookify.models.Song;
import com.helen.lookify.services.SongService;

@Controller
public class SongHomeController {
	@Autowired
	private SongService sService;
	
	//show all books
	@GetMapping("/dashboard")
	public String index(Model viewModel) {
		List<Song> songs = this.sService.allSongs();
		viewModel.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	//display a song
	@GetMapping("/songs/{id}") 
	public String display(@PathVariable("id") Long id, @ModelAttribute("song") Song song, Model viewModel) {
		viewModel.addAttribute("song", this.sService.getOne(id));
		return "show.jsp";
	}
	//delete a song
	@GetMapping("/songs/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id) {
		this.sService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	//add song
	@GetMapping("/songs/new") 
	public String add(@ModelAttribute("song") Song song) {
		return "add.jsp";
	}
	
	 @PostMapping("/songs/new")
	    //object with filled in data
	    public String createNewSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
	        if (result.hasErrors()) {
	            return "add.jsp";
	        } else {
	            this.sService.createSong(song);
	            return "redirect:/dashboard";
	        }
	 }
	 //search artist
	 @PostMapping("/songs/search")
		public String Search(@RequestParam("artist") String artist, Model model) {
			model.addAttribute("songs",	sService.songsContainingArtist(artist));
			model.addAttribute("artist", artist);
			return "searched.jsp";
	 }
	 //top ten
	 @GetMapping("/songs/topten")
	 public String topTen(Model viewModel) {
		 viewModel.addAttribute("songs", sService.topTenByRating());
		 return "topten.jsp";
	 }
}
