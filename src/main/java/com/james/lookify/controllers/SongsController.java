package com.james.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.james.lookify.models.Song;
import com.james.lookify.services.SongService;

@Controller
public class SongsController {
	private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String index(@ModelAttribute("song") Song song, Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	@RequestMapping("/song/{id}")
	public String displaySong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "newsong.jsp";
	}
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newsong.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteById(id);
		return "redirect:/dashboard";
	}
	@PostMapping("/search")
	public String search(@RequestParam("searchArtist") String searchArtist) {
		return "redirect:/search/" +searchArtist;
	}
	@GetMapping("/search/{searchArtist}")
	public String find(@PathVariable("searchArtist") String searchArtist, Model model) {
		List<Song> songs = songService.findByArtistContaining(searchArtist);
		model.addAttribute("songs", songs);
		System.out.println(songs.toString());
		return "results.jsp";
	}
	@GetMapping("/topten")
	public String topTen(Model model) {
		List<Song> songs = songService.findTopTen();
		model.addAttribute("songs", songs);
		return "results.jsp";
	}
	
	
}
