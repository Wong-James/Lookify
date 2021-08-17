package com.james.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.james.lookify.models.Song;
import com.james.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	//Create a song
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
	//Get all Songs
	public List<Song> allSongs(){
		return songRepository.findAll();
	}
	//Get song by ID
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	//Edit a Song
	public Song updateSong(Song song) {
		return songRepository.save(song);
	}
	//Delete a Song
	public void deleteById(Long id) {
		songRepository.deleteById(id);
	}
	public List<Song> findByArtistContaining(String searchArtist) {
		return songRepository.findByArtistContaining(searchArtist);
		
	}
	public List<Song> findTopTen(){
		List<Song> songs = songRepository.findTop10ByOrderByRatingDesc();
		return songs;
	}
	
	

}
