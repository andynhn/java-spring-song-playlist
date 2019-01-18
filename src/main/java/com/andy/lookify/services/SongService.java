package com.andy.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andy.lookify.models.Song;
import com.andy.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	public Song createSong(Song s) {
		return songRepository.save(s);
	}
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	public void deleteSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			songRepository.deleteById(id);
		} else {
			System.out.println("Song does not exist.");
		}
	}
	public List<Song> searchForSong(String search) {
		return songRepository.findByArtistContaining(search);
	}
	public List<Song> findTopTen (){
		return songRepository.findTopTen();
	}
}
