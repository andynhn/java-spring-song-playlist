package com.andy.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andy.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	void deleteById(Long id);
//	List<Song> findAllByOrderTitleAsc();
	List<Song> findByArtistContaining(String search);
	@Query(value="SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery=true)
    List<Song> findTopTen();
}
